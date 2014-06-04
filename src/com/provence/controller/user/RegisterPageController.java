package com.provence.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class RegisterPageController {

	@RequestMapping("/registerPage.do")
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		return "registerPage";
	}
}
