package com.provence.filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.util.WebUtils;

import com.provence.web.util.CommonStaticConst;
import com.provence.web.util.CountOnlineUser;
import com.provence.web.util.StringUtil;

public class LocaleFilter implements Filter {
	public static final Log log = LogFactory.getLog(LocaleFilter.class);

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		httpServletRequest.getSession().setAttribute("locale", "zh");
		if (WebUtils.getSessionAttribute(httpServletRequest, CommonStaticConst.REGISTER_IP) == null) {
			String referer = httpServletRequest.getHeader("Referer");
			String ip = StringUtil.getRequestIp(httpServletRequest);
			WebUtils.setSessionAttribute(httpServletRequest, CommonStaticConst.REFERRING_SOURCE, referer);
			WebUtils.setSessionAttribute(httpServletRequest, CommonStaticConst.REGISTER_IP, ip);
			log.info("New session: sessionId=" + httpServletRequest.getSession().getId() + ", the session number is increased to " + CountOnlineUser.getSessionCount() + ", ip=" + ip + ", referer=" + referer);
		}

		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
