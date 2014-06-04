package com.provence.controller.user;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.provence.pojo.User;
import com.provence.service.user.IUserService;
import com.provence.web.util.JSONHelperUtil;
import com.provence.web.util.ParamUtils;

@Controller
@RequestMapping("/userCheck.do")
public class UserCheckController {
	@Resource
	private IUserService userService;

	@RequestMapping(params = "action=username")
	public void username(HttpServletRequest request, HttpServletResponse response, Model model) {
		String username = ParamUtils.getParameter(request, "username");
		if(username == null){
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "username error!", response);
			return;
		}
		User user = userService.findUserByUsername(username);
		if(user !=null){
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "username is exist", response);
			return ;
		}
		JSONHelperUtil.outputOperationResultAsJSON(Boolean.TRUE, "", response);
	}
	
	@RequestMapping(params = "action=email")
	public void email(HttpServletRequest request, HttpServletResponse response, Model model) {
		String email = ParamUtils.getParameter(request, "email");
		if(email == null){
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "email error!", response);
			return;
		}
		User user = userService.findUserByEmail(email);
		if(user !=null){
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "email is exist", response);
			return ;
		}
		JSONHelperUtil.outputOperationResultAsJSON(Boolean.TRUE, "", response);
	}
}
