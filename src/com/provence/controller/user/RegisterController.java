package com.provence.controller.user;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.WebUtils;

import com.provence.messagefactory.MailBody;
import com.provence.pojo.ContactUs;
import com.provence.pojo.User;
import com.provence.service.contactus.IContactUsService;
import com.provence.service.user.IUserService;
import com.provence.web.util.CommonStaticConst;
import com.provence.web.util.DateUtil;
import com.provence.web.util.JSONHelperUtil;
import com.provence.web.util.MailSenderUtil;
import com.provence.web.util.ParamUtils;
import com.provence.web.util.ProvenceConfig;
import com.provence.web.util.StringUtil;

@Controller
@RequestMapping("/")
public class RegisterController {
	
	@Resource
	private IUserService userService;
	
	@Resource
	private IContactUsService contactUsService;

	@RequestMapping("/register.do")
	public void regist(HttpServletRequest request, HttpServletResponse response, Model model) {
		String username = ParamUtils.getParameter(request, "username");
		String email = ParamUtils.getParameter(request, "email");
		String sex = ParamUtils.getParameter(request, "sex");
		String dateBirthday = ParamUtils.getParameter(request, "dateBirthday");
		String mobile = ParamUtils.getParameter(request, "mobile");
		String address = ParamUtils.getParameter(request, "address");
		String city = ParamUtils.getParameter(request, "city");
		String country = ParamUtils.getParameter(request, "country");
		String zipcode = ParamUtils.getParameter(request, "zipcode");
		
		if(username == null){
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "username error!", response);
			return;
		}
		//email
		if(!StringUtil.isEmail(email)){
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "email error!", response);
			return;
		}
		//sex
		if(sex == null || !Arrays.asList(User.sexEnum.values()).contains(User.sexEnum.valueOf(sex))){
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "sex error!", response);
			return ;
		}
		//mobile, 不检查，国外手机不一样
//		if(mobile!=null && !StringUtil.isPhoneNumber(mobile)){
//			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "mobile error!", response);
//			return;
//		}
		try {
			User user = userService.findUserByEmail(email);
			if(user !=null){
				JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "email is exist", response);
				return ;
			}
			
			user = userService.findUserByUsername(username);
			if(user !=null){
				JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "username is exist", response);
				return ;
			}
			
			user = new User();
			user.setUsernameU(username);
			user.setEmailU(email);
			user.setSexU(sex);
			user.setDateBirthdayU(DateUtil.parse(dateBirthday, DateUtil.DEFAULT_DATE_FORMAT));
			user.setMobileU(mobile);
			user.setAddressU(address);
			user.setCityU(city);
			user.setCountryU(country);
			user.setZipcodeU(zipcode);
			user.setDateRegisterU(new Date());
			user.setIpU(StringUtil.getRequestIp(request));
			user.setRefererU((String)WebUtils.getSessionAttribute(request,  CommonStaticConst.REFERRING_SOURCE));
			user.setIsEnabledU(true);
			userService.saveOrUpdateUser(user);
			this.sendEmailToAdmin(user);
			this.sendEmailToUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "saveOrUpdate false!", response);
		}
		JSONHelperUtil.outputOperationResultAsJSON(Boolean.TRUE, "saveOrUpdate false!", response);
		return;
	}
	
	private void sendEmailToAdmin(User user){
		MailBody mailbody = new MailBody();
		mailbody.setFrom(ProvenceConfig.MAIL_USERNAME);
		mailbody.setPersonal("阳光普罗旺斯");
		mailbody.setTo(ProvenceConfig.EMAIL_RECIPIENT);
		mailbody.setSubject("用户注册");
		mailbody.setText("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"></head><body>" +
				"<table> " +
				"<tr><td>姓名：</td><td>"+user.getUsernameU()+"</td></tr>" +
				"<tr><td>性别：</td><td>"+(user.getSexU()!=null?user.getSexU():"")+"</td></tr>" +
				"<tr><td>Email：</td><td>"+user.getEmailU()+"</td></tr>" +
				"<tr><td>生日：</td><td>"+DateUtil.format(user.getDateBirthdayU(), DateUtil.DEFAULT_DATE_FORMAT)+"</td></tr>" +
				"<tr><td>手机：</td><td>"+(user.getMobileU()!=null?user.getMobileU():"")+"</td></tr>" +
				"<tr><td>地址：</td><td>"+(user.getAddressU()!=null?user.getAddressU():"")+"</td></tr>" +
				"<tr><td>邮编：</td><td>"+(user.getZipcodeU()!=null?user.getZipcodeU():"")+"</td></tr>" +
				"<tr><td>城市：</td><td>"+(user.getCityU()!=null?user.getCityU():"")+"</td></tr>" +
				"<tr><td>国家：</td><td>"+(user.getCountryU()!=null?user.getCountryU():"")+"</td></tr>" +
				"</table>" +
				"</body></html>");
		mailbody.setActivated(true);
		mailbody.setWillSend(true);
		MailSenderUtil.sendMimeMail(mailbody);
		System.out.println("sendEmailToAdmin " + mailbody.getTo());
	}
	
	private void sendEmailToUser(User user){
		ContactUs contactUs = contactUsService.findContactUsByType(ContactUs.TYPE_CONPON);
		String[] couponArray = contactUs.getContentCtu().split("，");
		
		MailBody mailbody = new MailBody();
		mailbody.setFrom(ProvenceConfig.MAIL_USERNAME);
		mailbody.setPersonal("阳光普罗旺斯");
		mailbody.setTo(user.getEmailU());
		mailbody.setSubject("用户注册");
		mailbody.setText("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"></head><body>" +
				"<p>亲爱的"+user.getUsernameU()+"</p>"+
				"<p>恭喜您成为阳光普罗旺斯会员，感谢您对我们的关注。</p>"+
				"<p>以下是您的注册信息：</p>"+
				"<table> " +
				"<tr><td>姓名：</td><td>"+user.getUsernameU()+"</td></tr>" +
				"<tr><td>性别：</td><td>"+(user.getSexU()!=null?user.getSexU():"")+"</td></tr>" +
				"<tr><td>Email：</td><td>"+user.getEmailU()+"</td></tr>" +
				"<tr><td>生日：</td><td>"+DateUtil.format(user.getDateBirthdayU(), DateUtil.DEFAULT_DATE_FORMAT)+"</td></tr>" +
				"<tr><td>手机：</td><td>"+(user.getMobileU()!=null?user.getMobileU():"")+"</td></tr>" +
				"<tr><td>地址：</td><td>"+(user.getAddressU()!=null?user.getAddressU():"")+"</td></tr>" +
				"<tr><td>邮编：</td><td>"+(user.getZipcodeU()!=null?user.getZipcodeU():"")+"</td></tr>" +
				"<tr><td>城市：</td><td>"+(user.getCityU()!=null?user.getCityU():"")+"</td></tr>" +
				"<tr><td>国家：</td><td>"+(user.getCountryU()!=null?user.getCountryU():"")+"</td></tr>" +
				"</table>" +
				"<p>同时您会收到一组优惠代码，请在网店购物时输入优惠代码获得相关优惠。</p>"+
				"<p>您的优惠代码为："+couponArray[new Random().nextInt(couponArray.length)]+"</p>"+
				"<p>如果您喜欢法国普罗旺斯，或者有一天愿意前往探索旅游，您还可以关注我们的官网、微信公众号以及我们的官方微博。</p>"+
				"<p><img src='http://www.aimebio.com/images/gzzh.png' /></p>"+
				"<p>这是一封系统自动来信，请不要回复此信。</p>"+
				"<p>再次感谢您的关注！</p>"+
				"<p>AimeBio Team</p>"+
				"</body></html>");
		mailbody.setActivated(true);
		mailbody.setWillSend(true);
		MailSenderUtil.sendMimeMail(mailbody);
		System.out.println("sendEmailToUser " + mailbody.getTo());
	}
}
