package com.provence.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.provence.web.dto.MessageDTO;
import com.provence.web.util.DateUtil;

/**
 * ProMessageMsg entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pro_message_msg", catalog = "provencedb")
public class Message implements java.io.Serializable {

	// Fields

	/**
	 * TODO
	 */
	private static final long serialVersionUID = 9059404522220519517L;
	private Long idMsg;
	private String nameMsg;
	private String sexMgs;
	private String cityMsg;
	private String addressMsg;
	private String phoneMsg;
	private String emailMsg;
	private String messageMsg;
	private Date dateCreateMsg;
	private String ipMsg;

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** full constructor */
	public Message(String nameMsg, String sexMgs, String cityMsg, String addressMsg, String phoneMsg, String emailMsg, String messageMsg, Date dateCreateMsg, String ipMsg) {
		this.nameMsg = nameMsg;
		this.sexMgs = sexMgs;
		this.cityMsg = cityMsg;
		this.addressMsg = addressMsg;
		this.phoneMsg = phoneMsg;
		this.emailMsg = emailMsg;
		this.messageMsg = messageMsg;
		this.dateCreateMsg = dateCreateMsg;
		this.ipMsg = ipMsg;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id_msg", unique = true, nullable = false)
	public Long getIdMsg() {
		return this.idMsg;
	}

	public void setIdMsg(Long idMsg) {
		this.idMsg = idMsg;
	}

	@Column(name = "name_msg", length = 128)
	public String getNameMsg() {
		return this.nameMsg;
	}

	public void setNameMsg(String nameMsg) {
		this.nameMsg = nameMsg;
	}

	@Column(name = "sex_mgs", length = 6)
	public String getSexMgs() {
		return this.sexMgs;
	}

	public void setSexMgs(String sexMgs) {
		this.sexMgs = sexMgs;
	}

	@Column(name = "city_msg", length = 32)
	public String getCityMsg() {
		return this.cityMsg;
	}

	public void setCityMsg(String cityMsg) {
		this.cityMsg = cityMsg;
	}

	@Column(name = "address_msg", length = 256)
	public String getAddressMsg() {
		return this.addressMsg;
	}

	public void setAddressMsg(String addressMsg) {
		this.addressMsg = addressMsg;
	}

	@Column(name = "phone_msg", length = 16)
	public String getPhoneMsg() {
		return this.phoneMsg;
	}

	public void setPhoneMsg(String phoneMsg) {
		this.phoneMsg = phoneMsg;
	}

	@Column(name = "email_msg", length = 128)
	public String getEmailMsg() {
		return this.emailMsg;
	}

	public void setEmailMsg(String emailMsg) {
		this.emailMsg = emailMsg;
	}

	@Column(name = "message_msg", length = 8192)
	public String getMessageMsg() {
		return this.messageMsg;
	}

	public void setMessageMsg(String messageMsg) {
		this.messageMsg = messageMsg;
	}

	
	@Column(name = "date_create_msg", length = 19)
	public Date getDateCreateMsg() {
		return this.dateCreateMsg;
	}

	public void setDateCreateMsg(Date dateCreateMsg) {
		this.dateCreateMsg = dateCreateMsg;
	}

	@Column(name = "ip_msg", length = 16)
	public String getIpMsg() {
		return this.ipMsg;
	}

	public void setIpMsg(String ipMsg) {
		this.ipMsg = ipMsg;
	}
	
	public MessageDTO toDTO(){
		MessageDTO dto  = new MessageDTO();
		dto.setIdMsg(idMsg);
		dto.setCityMsg(cityMsg);
		dto.setAddressMsg(addressMsg);
		dto.setEmailMsg(emailMsg);
		dto.setNameMsg(nameMsg);
		dto.setPhoneMsg(phoneMsg);
		dto.setSexMgs(sexMgs);
		dto.setIpMsg(ipMsg);
		dto.setDateCreateMsg(DateUtil.format(dateCreateMsg, DateUtil.DEFAULT_DATETIME_FORMAT));
		dto.setMessageMsg(messageMsg);
		return dto;
	}

}