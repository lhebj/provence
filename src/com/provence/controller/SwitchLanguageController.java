package com.provence.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.provence.web.util.LocalizationUtil;
import com.provence.web.util.ParamUtils;

@Controller
@RequestMapping("/")
public class SwitchLanguageController {

	
	@RequestMapping("/switchLan.do")
	public String switchLanguage(HttpServletRequest request, HttpServletResponse response, Model model) {
		String language = ParamUtils.getParameter(request, LocalizationUtil.LANGUAGE);
		LocalizationUtil.addCookie(response, LocalizationUtil.COOKIE_LOCALE, language, 365 * 24 * 3600);
		String referer = request.getHeader("Referer");
		if(referer != null){
			try {
				response.sendRedirect(referer);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		return "redirect:/index.do";
	}
}
