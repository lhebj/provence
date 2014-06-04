package com.provence.springextend.acegi.ui;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.acegisecurity.AccessDeniedException;
import org.acegisecurity.AcegiSecurityException;
import org.acegisecurity.AuthenticationException;
import org.acegisecurity.AuthenticationTrustResolver;
import org.acegisecurity.AuthenticationTrustResolverImpl;
import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.ui.AbstractProcessingFilter;
import org.acegisecurity.ui.AccessDeniedHandler;
import org.acegisecurity.ui.AccessDeniedHandlerImpl;
import org.acegisecurity.ui.AuthenticationEntryPoint;
import org.acegisecurity.ui.savedrequest.SavedRequest;
import org.acegisecurity.util.PortResolver;
import org.acegisecurity.util.PortResolverImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;

import com.provence.springextend.acegi.util.ThrowableAnalyzer;
import com.provence.springextend.acegi.util.ThrowableCauseExtractor;
import com.provence.web.util.FailReasonUtil;

public class ExceptionTranslationFilter implements Filter, InitializingBean {

	private static final class DefaultThrowableAnalyzer extends ThrowableAnalyzer {

		@Override
		protected void initExtractorMap() {
			super.initExtractorMap();

			registerExtractor(ServletException.class, new ThrowableCauseExtractor() {
				public Throwable extractCause(Throwable throwable) {
					ThrowableAnalyzer.verifyThrowableHierarchy(throwable, ServletException.class);
					return ((ServletException) throwable).getRootCause();
				}
			});
		}
	}

	private static final Log logger = LogFactory.getLog(ExceptionTranslationFilter.class);

	private String notAuthorizedURL;

	private String accessDeniedURL;

	private AccessDeniedHandler accessDeniedHandler;

	private AuthenticationEntryPoint authenticationEntryPoint;

	private List<String> redirectURLs;

	private AuthenticationTrustResolver authenticationTrustResolver = new AuthenticationTrustResolverImpl();

	private PortResolver portResolver = new PortResolverImpl();

	private boolean createSessionAllowed = true;

	private ThrowableAnalyzer throwableAnalyzer = new DefaultThrowableAnalyzer();

	private boolean isRedirectingURL(String url) {
		boolean isRedirectURL = false;
		for (String redirecturl : redirectURLs) {
			if (url.toLowerCase().indexOf(redirecturl) >= 0) {
				isRedirectURL = true;
				break;
			}
		}
		return isRedirectURL;
	}

	// ~ Methods
	// ========================================================================================================

	public void afterPropertiesSet() throws Exception {
		Assert.notNull(authenticationEntryPoint, "authenticationEntryPoint must be specified");
		Assert.notNull(portResolver, "portResolver must be specified");
		Assert.notNull(authenticationTrustResolver, "authenticationTrustResolver must be specified");
		Assert.notNull(throwableAnalyzer, "throwableAnalyzer must be specified");
	}

	private void autoDetectAnyAccessDeniedHandlerAndUseIt(ApplicationContext applicationContext) {
		Map map = applicationContext.getBeansOfType(AccessDeniedHandler.class);
		if (map.size() > 1) {
			throw new IllegalArgumentException("More than one AccessDeniedHandler beans detected please refer to the one using " + " [ accessDeniedBeanRef  ] " + "attribute");
		} else if (map.size() == 1) {
			AccessDeniedHandler handler = (AccessDeniedHandlerImpl) map.values().iterator().next();
			setAccessDeniedHandler(handler);
		} else {
			// create and use the default one specified as an instance variable.
			accessDeniedHandler = new AccessDeniedHandlerImpl();
		}

	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if (!(request instanceof HttpServletRequest)) {
			throw new ServletException("HttpServletRequest required");
		}

		if (!(response instanceof HttpServletResponse)) {
			throw new ServletException("HttpServletResponse required");
		}

		try {
			chain.doFilter(request, response);

			if (logger.isDebugEnabled()) {
				logger.debug("Chain processed normally");
			}
		} catch (IOException ex) {
			throw ex;
		} catch (Exception ex) {

			// Try to extract an AcegiSecurityException from the stacktrace
			Throwable[] causeChain = this.throwableAnalyzer.determineCauseChain(ex);
			AcegiSecurityException ase = (AcegiSecurityException) this.throwableAnalyzer.getFirstThrowableOfType(AcegiSecurityException.class, causeChain);

			if (ase != null) {
				handleException(request, response, chain, ase);
			} else {
				// Rethrow ServletExceptions and RuntimeExceptions as-is
				if (ex instanceof ServletException) {
					throw (ServletException) ex;
				} else if (ex instanceof RuntimeException) {
					throw (RuntimeException) ex;
				} else if (ex instanceof AccessDeniedException) {
					logger.debug(ex.getMessage());
				} else {
					// Wrap other Exceptions. These are not expected to happen
					throw new RuntimeException(ex);
				}
			}
		}
	}

	public AuthenticationEntryPoint getAuthenticationEntryPoint() {
		return authenticationEntryPoint;
	}

	public AuthenticationTrustResolver getAuthenticationTrustResolver() {
		return authenticationTrustResolver;
	}

	public PortResolver getPortResolver() {
		return portResolver;
	}

	private void handleException(ServletRequest request, ServletResponse response, FilterChain chain, AcegiSecurityException exception) throws IOException, ServletException {
		JSONObject jsonObject = new JSONObject();
		boolean isSuccess = false;
		String reason = "";
		OutputStream output = response.getOutputStream();
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		boolean isRedirectUrl = isRedirectingURL(httpRequest.getRequestURI());
		if (exception instanceof AuthenticationException) {
			sendStartAuthentication(request, response, chain, (AuthenticationException) exception);
		} else if (exception instanceof AccessDeniedException) {
			if (authenticationTrustResolver.isAnonymous(SecurityContextHolder.getContext().getAuthentication())) {
				if (!isRedirectUrl) {
					reason = FailReasonUtil.NOT_LOGIN;
					try {
						jsonObject.put("success", isSuccess);
						jsonObject.put("reason", reason);
						output.write(jsonObject.toString().getBytes());
					} catch (JSONException e) {
						e.printStackTrace();
					}
				} else {
					HttpServletRequest hRequest = (HttpServletRequest) request;
					HttpServletResponse hResponse = (HttpServletResponse) response;
					StringBuffer buffer = new StringBuffer("");
					if (hRequest.getRequestURI() != null) {
						buffer.append("?fromurl=");
						buffer.append(URLEncoder.encode(hRequest.getRequestURI(), "UTF-8"));
					}
					if (hRequest.getQueryString() != null) {
						buffer.append("?");
						buffer.append(URLEncoder.encode(hRequest.getQueryString(), "UTF-8"));
					}
					hResponse.sendRedirect("pLogin.do" + buffer);
				}
				return;
			} else {
				// sendStartAuthentication(request, response, chain, new
				// InsufficientAuthenticationException("Full authentication is
				// required to access this resource"));
				if (!isRedirectUrl) {
					reason = FailReasonUtil.ACCESS_DENIED;
					try {
						jsonObject.put("success", isSuccess);
						jsonObject.put("reason", reason);
						output.write(jsonObject.toString().getBytes());
					} catch (JSONException e) {
						e.printStackTrace();
					}
				} else {
					// SecurityContextHolder.getContext().setAuthentication(null);
					HttpServletResponse hResponse = (HttpServletResponse) response;
					hResponse.sendRedirect(accessDeniedURL);
				}
				return;
			}
		} else {
			if (logger.isDebugEnabled()) {
				logger.debug("Access is denied (user is not anonymous); delegating to AccessDeniedHandler", exception);
			}
			if (!isRedirectUrl) {
				reason = FailReasonUtil.ACCESS_DENIED;
				try {
					jsonObject.put("success", isSuccess);
					jsonObject.put("reason", reason);
					output.write(jsonObject.toString().getBytes());
				} catch (JSONException e) {
					e.printStackTrace();
				}
			} else {
				HttpServletResponse hResponse = (HttpServletResponse) response;
				hResponse.sendRedirect(accessDeniedURL);
			}
			return;
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public boolean isCreateSessionAllowed() {
		return createSessionAllowed;
	}

	protected void sendStartAuthentication(ServletRequest request, ServletResponse response, FilterChain chain, AuthenticationException reason) throws ServletException, IOException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		SavedRequest savedRequest = new SavedRequest(httpRequest, portResolver);

		if (logger.isDebugEnabled()) {
			logger.debug("Authentication entry point being called; SavedRequest added to Session: " + savedRequest);
		}

		if (createSessionAllowed) {
			// Store the HTTP request itself. Used by AbstractProcessingFilter
			// for redirection after successful authentication (SEC-29)
			httpRequest.getSession().setAttribute(AbstractProcessingFilter.ACEGI_SAVED_REQUEST_KEY, savedRequest);
		}

		// SEC-112: Clear the SecurityContextHolder's Authentication, as the
		// existing Authentication is no longer considered valid
		SecurityContextHolder.getContext().setAuthentication(null);

		authenticationEntryPoint.commence(httpRequest, (HttpServletResponse) response, reason);
	}

	public void setAccessDeniedHandler(AccessDeniedHandler accessDeniedHandler) {
		Assert.notNull(accessDeniedHandler, "AccessDeniedHandler required");
		this.accessDeniedHandler = accessDeniedHandler;
	}

	public void setAuthenticationEntryPoint(AuthenticationEntryPoint authenticationEntryPoint) {
		this.authenticationEntryPoint = authenticationEntryPoint;
	}

	public void setAuthenticationTrustResolver(AuthenticationTrustResolver authenticationTrustResolver) {
		this.authenticationTrustResolver = authenticationTrustResolver;
	}

	public void setCreateSessionAllowed(boolean createSessionAllowed) {
		this.createSessionAllowed = createSessionAllowed;
	}

	public void setPortResolver(PortResolver portResolver) {
		this.portResolver = portResolver;
	}

	public void setThrowableAnalyzer(ThrowableAnalyzer throwableAnalyzer) {
		this.throwableAnalyzer = throwableAnalyzer;
	}

	public void setRedirectURLs(List redirectURLs) {
		this.redirectURLs = redirectURLs;
	}

	public void setNotAuthorizedURL(String notAuthorizedURL) {
		this.notAuthorizedURL = notAuthorizedURL;
	}

	public void setAccessDeniedURL(String accessDeniedURL) {
		this.accessDeniedURL = accessDeniedURL;
	}
}
