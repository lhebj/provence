package com.provence.controller.contactus;

import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.provence.pojo.ContactUs;
import com.provence.service.contactus.IContactUsService;
import com.provence.web.util.JSONHelperUtil;
import com.provence.web.util.LocalizationUtil;
import com.provence.web.util.LogUtil;
import com.provence.web.util.ParamUtils;
import com.provence.web.util.StringUtil;
import com.provence.web.util.WebUtil;

@Controller
@RequestMapping("/contactUsAdmin.do")
public class ContactUsAdminController {


	@Resource
	private IContactUsService contactUsService;
	
	
	@RequestMapping(params = "action=save")
	public String save(HttpServletRequest request, HttpServletResponse response) {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		String type = ParamUtils.getParameter(request, "type");
		String contentCtu = ParamUtils.getParameter(request, "contentCtu");
		try {
			if (id == 0 || type == null || contentCtu == null) {
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}
			ContactUs contactUs = contactUsService.findContactUsByType(type);
			if (contactUs == null) {
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}
			contactUs.setContentCtu(StringUtil.filterWordFormatAndSomeHTML(contentCtu));
			contactUsService.saveOrUpdateContactUs(contactUs);
			LogUtil.log.info(WebUtil.getUserId(request) + " saves contactUs, type is " + contactUs.getTypeCtu());

		} catch (Exception e) {
			e.printStackTrace();
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "saveOrUpdate false!", response);
		}
		return "redirect:/admin.do?action=manageContactUs";
	}
}
