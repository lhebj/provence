package com.provence.filter;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.acegisecurity.providers.dao.DaoAuthenticationProvider;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.provence.web.util.FailReasonUtil;
import com.provence.web.util.ParamUtils;
import com.provence.web.util.RunAsAdminManager;
import com.provence.web.util.StringUtil;
import com.provence.web.util.WebUtil;

public class AcegiAjaxFilter extends OncePerRequestFilter {
	private static final String ACCOUNTSERVICE_BEANID = "accountService";
	private static final String DAOAUTHENTICATIONPROVIDER_BEANID = "daoAuthenticationProvider";
	private final static Log log = LogFactory.getLog(AcegiAjaxFilter.class.getName());

	private String getRedirectPage(HttpServletRequest request) {
		String redirectUrl = ParamUtils.getParameter(request, "fromurl");
		return redirectUrl == null? null: redirectUrl.substring(redirectUrl.lastIndexOf("/") + 1);
	}

	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		JSONObject jsonObject = new JSONObject();
		// get spring contain and fetch accountService bean;
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());

		DaoAuthenticationProvider daoAuthenticationProvider = (DaoAuthenticationProvider) webApplicationContext.getBean(DAOAUTHENTICATIONPROVIDER_BEANID);
		String serverState = "0";
		boolean isPopUp = ParamUtils.getBooleanParameter(request, "isPopUp", true);
		RedirectResponseWrapper redirectResponseWrapper = new RedirectResponseWrapper(response);
		filterChain.doFilter(request, redirectResponseWrapper);
		try {
			if (!hasAjaxParameter(request)) {
				if(WebUtil.isGuest()){
					response.sendRedirect("pLogin.do?type=fail");
					return;
				}
				String fromUrl = request.getParameter("fromurl");
				String redirectURL = redirectResponseWrapper.getRedirect();
				if (redirectURL.indexOf("failedLoginController") == -1) {
					String redirectPage = getRedirectPage(request);
					if (redirectPage == null || redirectPage.equals("") || redirectPage.equals("null")){
						response.sendRedirect("admin.do?action=home");
					}
					else{
						response.sendRedirect(redirectPage);
					}

				} else {
					response.sendRedirect("pLogin.do?fromurl=" + URLEncoder.encode(fromUrl, "UTF-8"));
				}
				return;
			}
			// Cancel verify code
			// if (!VerifyCodeGenerator.getInstance().check(request)) {
//			if (false) {
//				jsonObject.put("success", true);
//				jsonObject.put("authorized", false);
//				jsonObject.put("reason", "Identifying code errors");
//				serverState = FailReasonUtil.VERIFY_CODE_ERROR;
//
//			}
			// response.getOutputStream().write(jsonObject.toString().getBytes());
			if (serverState.equalsIgnoreCase("0")) {
				log.info(request.getParameter("j_username") + " logins in provence by ip " + StringUtil.getRequestIp(request));
			}
			String callback = "loginCallback(" + serverState + "," + isPopUp + ");";
			response.getOutputStream().write(callback.getBytes());
			response.getOutputStream().close();
		} catch (Exception exc) {
			exc.printStackTrace();
			try {
				RunAsAdminManager.authenticationAsGuest(daoAuthenticationProvider);
				jsonObject.put("authorized", false);
				jsonObject.put("reason", exc.getMessage());
				serverState = FailReasonUtil.ACCESS_DENIED;
				String callback = "loginCallback(" + serverState + "," + isPopUp + ");";
				response.getOutputStream().write(callback.getBytes());
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
		}
	}

	private boolean hasAjaxParameter(HttpServletRequest request) {
		return request.getParameter("ajax") != null;
	}

}
