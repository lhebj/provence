package com.provence.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.provence.web.util.ParamUtils;


@Controller
@RequestMapping("/error.do")
public class ErrorController {

	@RequestMapping(params = "action=404")
	public String e404(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "error/404";
	}
	
	@RequestMapping(params = "action=500")
	public String e500(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "error/500";
	}
	
	/**
	 * 
	  * 参数错误
	  *
	  * @param request
	  * @param response
	  * @param model
	  * @return    
	  * @return String
	 */
	@RequestMapping(params = "action=1")
	public String e1(HttpServletRequest request, HttpServletResponse response, Model model) {
		String message = ParamUtils.getParameter(request, "message");
		model.addAttribute("message", message);	
		return "error/error-message";
	}
}
