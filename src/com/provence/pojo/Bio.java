package com.provence.pojo;

import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;

import com.provence.web.dto.BioDTO;
import com.provence.web.dto.BioFullDTO;
import com.provence.web.upload.UploadFileUtil;
import com.provence.web.util.DateUtil;
import com.provence.web.util.LocalizationUtil;

/**
 * ProBio entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pro_bio", catalog = "provencedb")
public class Bio implements java.io.Serializable {
	

	// Fields

	/**
	 * TODO
	 */
	private static final long serialVersionUID = -2673146225578583549L;
	private Long idBio;
	private String titleBio;
	private String titleEnBio;
	private String titleFrBio;
	private String contentBio;
	private String contentEnBio;
	private String contentFrBio;
	private Content pic;
	private String typeBio;
	private String picPlaceBio;
	private Date dateCreateBio;

	// Constructors

	/** default constructor */
	public Bio() {
	}

	/** full constructor */
	public Bio(String titleBio, String titleEnBio, String titleFrBio, String contentBio, String contentEnBio, String contentFrBio, Content pic, String typeBio, Date dateCreateBio) {
		this.titleBio = titleBio;
		this.titleEnBio = titleEnBio;
		this.titleFrBio = titleFrBio;
		this.contentBio = contentBio;
		this.contentEnBio = contentEnBio;
		this.contentFrBio =  contentFrBio;
		this.pic = pic;
		this.typeBio = typeBio;
		this.dateCreateBio = dateCreateBio;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id_bio", unique = true, nullable = false)
	public Long getIdBio() {
		return this.idBio;
	}

	public void setIdBio(Long idBio) {
		this.idBio = idBio;
	}

	@Column(name = "title_bio", length = 1024)
	public String getTitleBio() {
		return this.titleBio;
	}

	public void setTitleBio(String titleBio) {
		this.titleBio = titleBio;
	}

	@Column(name = "content_bio", length = 16777215)
	public String getContentBio() {
		return this.contentBio;
	}

	public void setContentBio(String contentBio) {
		this.contentBio = contentBio;
	}

	@Column(name = "title_en_bio", length = 2048)
	public String getTitleEnBio() {
		return titleEnBio;
	}

	public void setTitleEnBio(String titleEnBio) {
		this.titleEnBio = titleEnBio;
	}

	@Column(name = "title_fr_bio", length = 2048)
	public String getTitleFrBio() {
		return titleFrBio;
	}

	public void setTitleFrBio(String titleFrBio) {
		this.titleFrBio = titleFrBio;
	}

	@Column(name = "content_en_bio", length = 16777215)
	public String getContentEnBio() {
		return contentEnBio;
	}

	public void setContentEnBio(String contentEnBio) {
		this.contentEnBio = contentEnBio;
	}

	@Column(name = "content_fr_bio", length = 16777215)
	public String getContentFrBio() {
		return contentFrBio;
	}

	public void setContentFrBio(String contentFrBio) {
		this.contentFrBio = contentFrBio;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idpic_bio")
	public Content getPic() {
		return this.pic;
	}

	public void setPic(Content pic) {
		this.pic = pic;
	}

	@Column(name = "type_bio", length = 10)
	public String getTypeBio() {
		return this.typeBio;
	}

	public void setTypeBio(String typeBio) {
		this.typeBio = typeBio;
	}

	@Column(name = "pic_place_bio", length = 5)
	public String getPicPlaceBio() {
		return picPlaceBio;
	}

	public void setPicPlaceBio(String picPlaceBio) {
		this.picPlaceBio = picPlaceBio;
	}

	@Column(name = "date_create_bio", length = 19)
	public Date getDateCreateBio() {
		return this.dateCreateBio;
	}

	public void setDateCreateBio(Date dateCreateBio) {
		this.dateCreateBio = dateCreateBio;
	}
	
	public enum BioType {
		AimeBio, FraBioAuth
	}
	
	public enum PicPlace {
		left, right
	}

	public BioDTO toDTO(HttpServletRequest request){
		Locale locale = LocalizationUtil.getLocale(request);
		BioDTO dto = new BioDTO();
		dto.setIdBio(idBio);
		if (locale.equals(Locale.US) || locale.equals(Locale.CANADA) || locale.equals(Locale.ENGLISH) || locale.equals(Locale.UK)){
			dto.setContentBio(contentEnBio);
			dto.setTitleBio(titleEnBio);
		} else if (locale.equals(Locale.FRANCE) || locale.equals(Locale.FRENCH) || locale.equals(Locale.CANADA_FRENCH)){
			dto.setContentBio(contentFrBio);
			dto.setTitleBio(titleFrBio);
		}else{
			dto.setContentBio(contentBio);
			dto.setTitleBio(titleBio);
		}
		
		
		if(getPic() != null){
			dto.setPath(UploadFileUtil.getContentPath(getPic()));
		}		
		dto.setPicPlaceBio(picPlaceBio);
		dto.setDateCreateBio(DateUtil.format(dateCreateBio, DateUtil.DEFAULT_DATETIME_FORMAT));
		return dto;
	}
	
	public BioFullDTO toFullDTO(){
		BioFullDTO dto = new BioFullDTO();
		dto.setIdBio(idBio);
		dto.setContentEnBio(contentEnBio);
		dto.setTitleEnBio(titleEnBio);
		dto.setContentFrBio(contentFrBio);
		dto.setTitleFrBio(titleFrBio);
		dto.setContentBio(contentBio);
		dto.setTitleBio(titleBio);
		if(getPic() != null){
			dto.setPath(UploadFileUtil.getContentPath(getPic()));
		}		
		dto.setPicPlaceBio(picPlaceBio);
		dto.setDateCreateBio(DateUtil.format(dateCreateBio, DateUtil.DEFAULT_DATETIME_FORMAT));
		return dto;
	}
}