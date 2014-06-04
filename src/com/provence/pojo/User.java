package com.provence.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.provence.web.dto.UserDTO;
import com.provence.web.util.DateUtil;

/**
 * ProUserU entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pro_user_u", catalog = "provencedb", uniqueConstraints = @UniqueConstraint(columnNames = "username_u"))
public class User implements java.io.Serializable {

	public static String ADMIN = "admin";
	// Fields

	/**
	 * TODO
	 */
	private static final long serialVersionUID = -8630376714467683152L;
	private Long idU;
	private String usernameU;
	private String passwordU;
	private String saltU;
	private String emailU;
	private String sexU;
	private Date dateBirthdayU;
	private String mobileU;
	private String addressU;
	private String cityU;
	private String countryU;
	private String zipcodeU;
	private Date dateRegisterU;
	private String ipU;
	private String refererU;
	private Boolean isEnabledU;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String usernameU, String passwordU, String saltU, String emailU, String sexU, Date dateBirthdayU, String mobileU, String addressU, String cityU, String countryU, String zipcodeU, Date dateRegisterU, String ipU,String refererU, Boolean isEnabledU) {
		this.usernameU = usernameU;
		this.passwordU = passwordU;
		this.saltU = saltU;
		this.emailU = emailU;
		this.sexU = sexU;
		this.dateBirthdayU = dateBirthdayU;
		this.mobileU = mobileU;
		this.addressU = addressU;
		this.cityU = cityU;
		this.countryU = countryU;
		this.zipcodeU = zipcodeU;
		this.dateRegisterU = dateRegisterU;
		this.ipU = ipU;
		this.refererU = refererU;
		this.isEnabledU=isEnabledU;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id_u", unique = true, nullable = false)
	public Long getIdU() {
		return this.idU;
	}

	public void setIdU(Long idU) {
		this.idU = idU;
	}

	@Column(name = "username_u", unique = true, length = 64)
	public String getUsernameU() {
		return this.usernameU;
	}

	public void setUsernameU(String usernameU) {
		this.usernameU = usernameU;
	}

	@Column(name = "password_u", length = 64)
	public String getPasswordU() {
		return this.passwordU;
	}

	public void setPasswordU(String passwordU) {
		this.passwordU = passwordU;
	}

	@Column(name = "salt_u", length = 8)
	public String getSaltU() {
		return this.saltU;
	}

	public void setSaltU(String saltU) {
		this.saltU = saltU;
	}

	@Column(name = "email_u", length = 128)
	public String getEmailU() {
		return this.emailU;
	}

	public void setEmailU(String emailU) {
		this.emailU = emailU;
	}

	@Column(name = "sex_u", length = 6)
	public String getSexU() {
		return this.sexU;
	}

	public void setSexU(String sexU) {
		this.sexU = sexU;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_birthday_u", length = 10)
	public Date getDateBirthdayU() {
		return this.dateBirthdayU;
	}

	public void setDateBirthdayU(Date dateBirthdayU) {
		this.dateBirthdayU = dateBirthdayU;
	}

	@Column(name = "mobile_u", length = 16)
	public String getMobileU() {
		return this.mobileU;
	}

	public void setMobileU(String mobileU) {
		this.mobileU = mobileU;
	}

	@Column(name = "address_u", length = 256)
	public String getAddressU() {
		return this.addressU;
	}

	public void setAddressU(String addressU) {
		this.addressU = addressU;
	}

	@Column(name = "city_u", length = 32)
	public String getCityU() {
		return this.cityU;
	}

	public void setCityU(String cityU) {
		this.cityU = cityU;
	}

	@Column(name = "country_u", length = 32)
	public String getCountryU() {
		return this.countryU;
	}

	public void setCountryU(String countryU) {
		this.countryU = countryU;
	}

	@Column(name = "zipcode_u", length = 8)
	public String getZipcodeU() {
		return this.zipcodeU;
	}

	public void setZipcodeU(String zipcodeU) {
		this.zipcodeU = zipcodeU;
	}

	@Column(name = "date_register_u", length = 19)
	public Date getDateRegisterU() {
		return this.dateRegisterU;
	}

	public void setDateRegisterU(Date dateRegisterU) {
		this.dateRegisterU = dateRegisterU;
	}

	@Column(name = "ip_u", length = 16)
	public String getIpU() {
		return this.ipU;
	}

	public void setIpU(String ipU) {
		this.ipU = ipU;
	}

	@Column(name = "referer_u", length = 512)
	public String getRefererU() {
		return refererU;
	}

	public void setRefererU(String refererU) {
		this.refererU = refererU;
	}

	@Column(name = "is_enabled_u", nullable = false)
	public Boolean getIsEnabledU() {
		return isEnabledU;
	}

	public void setIsEnabledU(Boolean isEnabledU) {
		this.isEnabledU = isEnabledU;
	}
	
	public enum sexEnum {
		male, female
	}
	
	public UserDTO toDTO(){
		UserDTO dto = new UserDTO();
		dto.setUsernameU(usernameU);
		dto.setEmailU(emailU);
		dto.setSexU(sexU);
		dto.setAddressU(addressU);
		dto.setCityU(cityU);
		dto.setCountryU(countryU);
		dto.setZipcodeU(zipcodeU);
		dto.setDateBirthdayU(DateUtil.format(dateBirthdayU, DateUtil.DEFAULT_DATE_FORMAT));
		dto.setDateRegisterU(DateUtil.format(dateRegisterU, DateUtil.DEFAULT_DATETIME_FORMAT));
		dto.setMobileU(mobileU);
		dto.setIpU(ipU);
		dto.setIsEnabledU(isEnabledU);
		return dto;
	}

}