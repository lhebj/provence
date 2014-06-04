package com.provence.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.provence.web.dto.BannerDTO;
import com.provence.web.upload.UploadFileUtil;

/**
 * ProBannerBa entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pro_banner_ba", catalog = "provencedb")
public class Banner implements java.io.Serializable {

	// Fields


	/**
	 * TODO
	 */
	private static final long serialVersionUID = -1420568287844378922L;
	private Long idBa;
	private Content pic;
	private Date dateCreateBa;

	// Constructors

	/** default constructor */
	public Banner() {
	}

	/** full constructor */
	public Banner(Content pic, Date dateCreateBa) {
		this.pic = pic;
		this.dateCreateBa = dateCreateBa;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id_ba", unique = true, nullable = false)
	public Long getIdBa() {
		return this.idBa;
	}

	public void setIdBa(Long idBa) {
		this.idBa = idBa;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idpic_ba")
	public Content getPic() {
		return this.pic;
	}

	public void setPic(Content pic) {
		this.pic = pic;
	}


	@Column(name = "date_create_ba", length = 19)
	public Date getDateCreateBa() {
		return this.dateCreateBa;
	}

	public void setDateCreateBa(Date dateCreateBa) {
		this.dateCreateBa = dateCreateBa;
	}
	
	
	public BannerDTO toDTO(){
		BannerDTO dto = new BannerDTO();
		dto.setIdBa(idBa);
		if(getPic() != null){
			dto.setPath(UploadFileUtil.getContentPath(getPic()));
		}		
		return dto;
	}

}