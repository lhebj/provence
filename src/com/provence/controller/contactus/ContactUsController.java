package com.provence.controller.contactus;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.provence.pojo.ContactUs;
import com.provence.service.banner.IBannerService;
import com.provence.service.contactus.IContactUsService;
import com.provence.web.dto.ContactUsDTO;

@Controller
@RequestMapping("/")
public class ContactUsController {

	@Resource
	private IContactUsService contactUsService;
	
	@Resource
	private IBannerService bannerService;
	
	@RequestMapping("/contactus.do")
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		List<ContactUsDTO> dtoList = contactUsService.getContactUsList(3);
		for(ContactUsDTO dto : dtoList){
			if(ContactUs.TYPE_CONTACT.equals(dto.getTypeCtu())){
				model.addAttribute(ContactUs.TYPE_CONTACT, dto);
			}
			if(ContactUs.TYPE_HR.equals(dto.getTypeCtu())){
				model.addAttribute(ContactUs.TYPE_HR, dto);
			}
			if(ContactUs.TYPE_STORES.equals(dto.getTypeCtu())){
				model.addAttribute(ContactUs.TYPE_STORES, dto);
			}
		}
		
		model.addAttribute("bannerDtoList", bannerService.getRandomBannerList(5));
		return "contactus";
	}
}
