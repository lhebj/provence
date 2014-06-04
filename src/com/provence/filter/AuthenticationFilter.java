package com.provence.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.acegisecurity.providers.dao.DaoAuthenticationProvider;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import com.provence.pojo.User;
import com.provence.service.user.IUserService;
import com.provence.web.util.BeanFactoryUtil;
import com.provence.web.util.RunAsAdminManager;
import com.provence.web.util.StringUtil;

/**
 * 当访问login.do时进入此过滤器，进行ACEGI授权
 */
public class AuthenticationFilter extends OncePerRequestFilter {
	public static final String AuthenticationFail = "authenticationFail";
	private static final String DAOAUTHENTICATIONPROVIDER_BEANID = "daoAuthenticationProvider";
	private final static Log log = LogFactory.getLog(AuthenticationFilter.class.getName());
	private static IUserService userService;
	private static DaoAuthenticationProvider daoAuthenticationProvider;

	static {
		daoAuthenticationProvider = (DaoAuthenticationProvider) BeanFactoryUtil.getBean(DAOAUTHENTICATIONPROVIDER_BEANID);
		userService = (IUserService) BeanFactoryUtil.getBean("userService");
	}

	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		// rawUsername可能是用户名，手机或者邮箱
		String rawUsername = request.getParameter("j_username");// 支持邮箱和用户名两种登录方式
		String username = null;
		String password = request.getParameter("j_password");
		User account = null;

		String ip = StringUtil.getRequestIp(request);

		try {
			if (rawUsername == null || password == null) {
				RunAsAdminManager.authenticationAsGuest(daoAuthenticationProvider);
				filterChain.doFilter(request, response);
				return;
			}
			// 支持邮箱和用户名两种登录方式
			if (rawUsername.indexOf("@") > -1) {
				account = userService.findUserByEmail(rawUsername);
			} else if (StringUtil.checkMobilePhone(rawUsername)) {
				// AccountMobile accountMobile =
				// userService.getAccountMobileByMobile(rawUsername);
				// if(accountMobile != null &&
				// !StringUtil.isNull(accountMobile.getUsername())) {
				// account =
				// userService.findAccountByName(accountMobile.getUsername());
				// }
			} else {
				account = userService.findUserByUsername(rawUsername);
			}
			if (account == null) {
				RunAsAdminManager.authenticationAsGuest(daoAuthenticationProvider);
				filterChain.doFilter(request, response);
				return;
			}
			username = account.getUsernameU(); // 支持邮箱和用户名两种登录方式

			if (account != null && account.getPasswordU().equalsIgnoreCase(password)) {
				RunAsAdminManager.authenticationRestore(daoAuthenticationProvider, account);
			} else {
				RunAsAdminManager.authenticationAsGuest(daoAuthenticationProvider);
				request.setAttribute("authenticationFail", true);
				filterChain.doFilter(request, response);
				return;
			}

		} catch (Exception exc) {
			exc.printStackTrace();
			try {
				RunAsAdminManager.authenticationAsGuest(daoAuthenticationProvider);
				filterChain.doFilter(request, response);
				return;
			} catch (Exception e) {
				log.error(e.getMessage());
			}
			log.error(exc.getMessage());
			
		}
		/**
		 * 实现remember me 机制
		 */
		try {
			//TODO
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		filterChain.doFilter(request, response);
	}
}
