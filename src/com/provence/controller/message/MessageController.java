package com.provence.controller.message;

import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.provence.messagefactory.MailBody;
import com.provence.pojo.Message;
import com.provence.pojo.User;
import com.provence.service.message.IMessageService;
import com.provence.web.util.DateUtil;
import com.provence.web.util.LocalizationUtil;
import com.provence.web.util.MailSenderUtil;
import com.provence.web.util.ParamUtils;
import com.provence.web.util.ProvenceConfig;
import com.provence.web.util.StringUtil;

@Controller
@RequestMapping("/message.do")
public class MessageController {


	@Resource(name = "messageService")
	private IMessageService messageService;
	
	@RequestMapping(params = "action=save")
	public String save(HttpServletRequest request, HttpServletResponse response) {
		String name = ParamUtils.getParameter(request, "name");
		String sex = ParamUtils.getParameter(request, "sex");
		String city = ParamUtils.getParameter(request, "city");
		String address = ParamUtils.getParameter(request, "address");
		String phone = ParamUtils.getParameter(request, "phone");
		String email = ParamUtils.getParameter(request, "email");
		String message = ParamUtils.getParameter(request, "message");
		
		try {
			if (name == null) {
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}

			if (message == null) {
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}

			//email
			if(!StringUtil.isEmail(email)){
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}
			//sex
			if(sex == null || !Arrays.asList(User.sexEnum.values()).contains(User.sexEnum.valueOf(sex))){
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}

			Message msg = new Message();
			msg.setNameMsg(name);
			msg.setSexMgs(sex);
			msg.setCityMsg(city);
			msg.setAddressMsg(address);
			msg.setPhoneMsg(phone);
			msg.setEmailMsg(email);
			msg.setMessageMsg(message);
			msg.setDateCreateMsg(new Date());
			msg.setIpMsg(StringUtil.getRequestIp(request));
			messageService.saveOrUpdateMessage(msg);
			this.sendEmail(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/contactus.do";
	}
	
	private void sendEmail(Message msg){
		
		MailBody mailbody = new MailBody();
		mailbody.setFrom(ProvenceConfig.MAIL_USERNAME);
		mailbody.setPersonal("阳光普罗旺斯");
		mailbody.setTo(ProvenceConfig.EMAIL_RECIPIENT);
		mailbody.setSubject("用户留言");
		mailbody.setText("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"></head><body>" +
				"<table> " +
				"<tr><td>姓名、公司名称：</td><td>"+(msg.getNameMsg()!=null?msg.getNameMsg():"")+"</td></tr>" +
				"<tr><td>性别：</td><td>"+(msg.getSexMgs()!=null?msg.getSexMgs():"")+"</td></tr>" +
				"<tr><td>城市：</td><td>"+(msg.getCityMsg()!=null?msg.getCityMsg():"")+"</td></tr>" +
				"<tr><td>地址：</td><td>"+(msg.getAddressMsg()!=null?msg.getAddressMsg():"")+"</td></tr>" +
				"<tr><td>电话：</td><td>"+(msg.getPhoneMsg()!=null?msg.getPhoneMsg():"")+"</td></tr>" +
				"<tr><td>E-mail：</td><td>"+(msg.getEmailMsg()!=null?msg.getEmailMsg():"")+"</td></tr>" +
				"<tr><td>用户IP：</td><td>"+(msg.getIpMsg()!=null?msg.getIpMsg():"")+"</td></tr>" +
				"<tr><td>时间：</td><td>"+DateUtil.format(msg.getDateCreateMsg(), DateUtil.DEFAULT_DATETIME_FORMAT)+"</td></tr>" +
				"<tr><td>信息：</td><td>"+(msg.getMessageMsg()!=null?msg.getMessageMsg():"")+"</td></tr>" +
				"</table>" +
				"</body></html>");
		mailbody.setActivated(true);
		mailbody.setWillSend(true);
		MailSenderUtil.sendMimeMail(mailbody);
	}
}
