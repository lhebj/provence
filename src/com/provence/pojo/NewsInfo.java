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

import com.provence.web.dto.NewsInfoDTO;
import com.provence.web.upload.UploadFileUtil;
import com.provence.web.util.DateUtil;

/**
 * ProNewsinfoNsi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pro_newsinfo_nsi", catalog = "provencedb")
public class NewsInfo implements java.io.Serializable {

	// Fields

	/**
	 * TODO
	 */
	private static final long serialVersionUID = 8988379939580947623L;
	private Long idNsi;
	private String titleNsi;
	private String contentNsi;
	private Content pic;
	private Date dateCreateNsi;

	// Constructors

	/** default constructor */
	public NewsInfo() {
	}

	/** full constructor */
	public NewsInfo(String titleNsi, String contentNsi, Content pic, Date dateCreateNsi) {
		this.titleNsi = titleNsi;
		this.contentNsi = contentNsi;
		this.pic = pic;
		this.dateCreateNsi = dateCreateNsi;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id_nsi", unique = true, nullable = false)
	public Long getIdNsi() {
		return this.idNsi;
	}

	public void setIdNsi(Long idNsi) {
		this.idNsi = idNsi;
	}

	@Column(name = "title_nsi", length = 128)
	public String getTitleNsi() {
		return this.titleNsi;
	}

	public void setTitleNsi(String titleNsi) {
		this.titleNsi = titleNsi;
	}

	@Column(name = "content_nsi", length = 65535)
	public String getContentNsi() {
		return this.contentNsi;
	}

	public void setContentNsi(String contentNsi) {
		this.contentNsi = contentNsi;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idpic_nsi")
	public Content getPic() {
		return this.pic;
	}

	public void setPic(Content pic) {
		this.pic = pic;
	}

	
	@Column(name = "date_create_nsi", length = 19)
	public Date getDateCreateNsi() {
		return this.dateCreateNsi;
	}

	public void setDateCreateNsi(Date dateCreateNsi) {
		this.dateCreateNsi = dateCreateNsi;
	}
	
	public NewsInfoDTO toDTO(){
		NewsInfoDTO dto = new NewsInfoDTO();
		dto.setIdNsi(idNsi);
		dto.setTitleNsi(titleNsi);
		dto.setContentNsi(contentNsi);
		if(getPic() != null){
			dto.setPath(UploadFileUtil.getContentPath(getPic()));
		}	
		dto.setDateCreateNsi(DateUtil.format(dateCreateNsi, DateUtil.DEFAULT_DATETIME_FORMAT));
		return dto;
	}

}