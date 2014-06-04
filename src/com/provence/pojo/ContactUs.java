package com.provence.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.provence.web.dto.ContactUsDTO;

/**
 * ProContactusCtu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pro_contactus_ctu", catalog = "provencedb")
public class ContactUs implements java.io.Serializable {

	/**
	 * TODO
	 */
	private static final long serialVersionUID = -6721129581710870220L;
	public static String TYPE_CONTACT = "contact";
	public static String TYPE_HR = "hr";
	public static String TYPE_STORES = "stores";
	public static String TYPE_CONPON = "coupon";
	// Fields

	private Long idCtu;
	private String contentCtu;
	/**
	 * 'contact','hr','stores' comment '类型：联系方式，招聘信息，新门店'
	 */
	private String typeCtu;

	// Constructors

	/** default constructor */
	public ContactUs() {
	}

	/** full constructor */
	public ContactUs(String contentCtu, String typeCtu) {
		this.contentCtu = contentCtu;
		this.typeCtu = typeCtu;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id_ctu", unique = true, nullable = false)
	public Long getIdCtu() {
		return this.idCtu;
	}

	public void setIdCtu(Long idCtu) {
		this.idCtu = idCtu;
	}

	@Column(name = "content_ctu", length = 16777215)
	public String getContentCtu() {
		return this.contentCtu;
	}

	public void setContentCtu(String contentCtu) {
		this.contentCtu = contentCtu;
	}

	@Column(name = "type_ctu", length = 8)
	public String getTypeCtu() {
		return this.typeCtu;
	}

	public void setTypeCtu(String typeCtu) {
		this.typeCtu = typeCtu;
	}
	
	public ContactUsDTO toDTO(){
		ContactUsDTO dto = new ContactUsDTO();
		dto.setIdCtu(idCtu);
		dto.setContentCtu(contentCtu);
		dto.setTypeCtu(typeCtu);
		return dto;
	}

}