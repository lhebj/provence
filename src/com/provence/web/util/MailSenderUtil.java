
package com.provence.web.util;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import com.provence.messagefactory.MailBody;

/**
 * 
 */
public class MailSenderUtil {
	private static JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	public static final Log log = LogFactory.getLog(MailSenderUtil.class);
	static {
		Properties javaMailProperties = new Properties();
		javaMailProperties.setProperty("mail.smtp.auth", ProvenceConfig.MAIL_SMTP_AUTH);
		javaMailProperties.setProperty("mail.smtp.timeout", ProvenceConfig.MAIL_SMTP_TIMEOUT);
		
//		javaMailProperties.setProperty("mail.smtp.auth", "true");
//		javaMailProperties.setProperty("mail.smtp.timeout", "30000");		
		//for gmail
//		javaMailProperties.setProperty("mail.smtp.starttls.enable", "true");
//		javaMailProperties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");		
//		mailSender.setHost("smtp.gmail.com");
//		mailSender.setPort(465);
		
//		mailSender.setHost("smtp.aimebio.com");
//		mailSender.setPort(25);
//		mailSender.setUsername("chloe@aimebio.com");
//		mailSender.setPassword("plws20140414");
		
		mailSender.setHost(ProvenceConfig.MAIL_HOST);
		mailSender.setPort(Integer.parseInt(ProvenceConfig.MAIL_PORT));
		mailSender.setUsername(ProvenceConfig.MAIL_USERNAME);
		mailSender.setPassword(ProvenceConfig.MAIL_PASSWORD);
		mailSender.setJavaMailProperties(javaMailProperties);

	}

	/**
	 * send one email per 5 minutes
	 * 
	 * @param list
	 */
	public static void sendBatchMimeEmail(final List<MailBody> list) {
		new Thread() {
			@Override
			public void run() {
				try {
					int i = 0;
					while (i < list.size()) {
						sendMimeMail(list.get(i), null);
						i++;
						Thread.sleep(300000);
					}

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
				}
			}
		}.start();
	}


	public static void sendPlainMail(MailBody mailbody) {
		try {
			
			String[] to = mailbody.getTo().split(",");
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(to);
			message.setFrom(mailbody.getFrom());
			message.setSubject(mailbody.getSubject());
			message.setText(mailbody.getText());
			mailSender.send(message);
		} catch (MailException e) {
			// e.printStackTrace();
			log.error(e.getMessage());
		}
	}

	public static void sendMimeMail(final MailBody mailbody) {
		new Thread() {
			@Override
			public void run() {
				try {
					sendMimeMail(mailbody, null);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
				}
			}
		}.start();
	}

	public static void sendMimeMail(final MailBody mailbody, final Map<String, InputStreamSource> attachMap) {
		try {
			
			if (mailbody == null) {
				log.error("mail is null");
				return;
			}
			if (mailbody.getTo() == null) {
				log.error("This mail's receiver is null.\n  " + mailbody.getTo());
				return;
			}
			if (!mailbody.isActivated()) {
				log.error("This mail's receiver's email is not activated.\n  " + mailbody.getTo());
				return;
			}
			if (!mailbody.isWillSend()) {
				log.error("The receiver do not want to receiver this message.\n" + mailbody.getTo());
				return;
			}
			MimeMessagePreparator mimeMessagePreparator = new MimeMessagePreparator() {
				public void prepare(MimeMessage mimeMessage) throws MessagingException {
					// MimeMessageHelper message = new
					// MimeMessageHelper(mimeMessage, "utf-8");
					MimeMessageHelper message;
					if (attachMap != null) {
						message = new MimeMessageHelper(mimeMessage, true, "GBK");
						for (String key : attachMap.keySet()) {
							message.addAttachment(key, attachMap.get(key));
						}
					} else {
						message = new MimeMessageHelper(mimeMessage, "GBK");
					}
					if (mailbody.getPersonal() != null) {
						try {
							message.setFrom(mailbody.getFrom(), mailbody.getPersonal());
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						message.setFrom(mailbody.getFrom());
					}
					message.setTo(mailbody.getTo().split(","));
					message.setSubject(mailbody.getSubject());
					message.setText(mailbody.getText(), true);
					// mimeMessage.addHeader("Content-Transfer-Encoding","base64");
					mimeMessage.addHeader("Content-Transfer-Encoding", "quoted-printable");
				}
			};

			mailSender.send(mimeMessagePreparator);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {

		MailBody mailbody = new MailBody();
		mailbody.setFrom("aimebio2014@163.com");
		mailbody.setPersonal("he");
		mailbody.setTo("623220938@qq.com");
		mailbody.setSubject("测试邮件");
		mailbody.setText("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\"></head><body><h1>好好好!</h1></body></html>");
		mailbody.setActivated(true);
		mailbody.setWillSend(true);
		sendMimeMail(mailbody);
		
		
	}
}
