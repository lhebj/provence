package com.provence.controller.user;

import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.provence.pojo.User;
import com.provence.service.user.IUserService;
import com.provence.web.util.JSONHelperUtil;
import com.provence.web.util.LocalizationUtil;
import com.provence.web.util.ParamUtils;

@Controller
@RequestMapping("/userAdmin.do")
public class UserAdminController {


	@Resource(name = "userService")
	private IUserService userService;
	
	@RequestMapping(params = "action=delete")
	public String delete(HttpServletRequest request, HttpServletResponse response) {
		String username = ParamUtils.getParameter(request, "username");
		try {
			if (username == null) {
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}
			User user = userService.findUserByUsername(username);
			user.setIsEnabledU(false);
			userService.saveOrUpdateUser(user);
//			userService.deleteUserById(id);						
		} catch (Exception e) {
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "Delete false!", response);
			e.printStackTrace();
		}
		return "redirect:/admin.do?action=manageUsers";
	}
}
