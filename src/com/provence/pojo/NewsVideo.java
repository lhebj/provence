package com.provence.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.provence.web.dto.NewsVideoDTO;
import com.provence.web.util.DateUtil;

/**
 * ProNewsvideoNsv entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pro_newsvideo_nsv", catalog = "provencedb")
public class NewsVideo implements java.io.Serializable {

	// Fields

	/**
	 * TODO
	 */
	private static final long serialVersionUID = -1888852146737401283L;
	private Long idNsv;
	private String titleNsv;
	private String playcodeNsv;
	private Date dateCreateNsv;

	// Constructors

	/** default constructor */
	public NewsVideo() {
	}

	/** full constructor */
	public NewsVideo(String titleNsv, String playcodeNsv, Date dateCreateNsv) {
		this.titleNsv = titleNsv;
		this.playcodeNsv = playcodeNsv;
		this.dateCreateNsv = dateCreateNsv;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id_nsv", unique = true, nullable = false)
	public Long getIdNsv() {
		return this.idNsv;
	}

	public void setIdNsv(Long idNsv) {
		this.idNsv = idNsv;
	}

	@Column(name = "title_nsv", length = 128)
	public String getTitleNsv() {
		return this.titleNsv;
	}

	public void setTitleNsv(String titleNsv) {
		this.titleNsv = titleNsv;
	}

	@Column(name = "playcode_nsv", length = 1024)
	public String getPlaycodeNsv() {
		return this.playcodeNsv;
	}

	public void setPlaycodeNsv(String playcodeNsv) {
		this.playcodeNsv = playcodeNsv;
	}

	
	@Column(name = "date_create_nsv", length = 19)
	public Date getDateCreateNsv() {
		return this.dateCreateNsv;
	}

	public void setDateCreateNsv(Date dateCreateNsv) {
		this.dateCreateNsv = dateCreateNsv;
	}
	
	public NewsVideoDTO toDTO(){
		NewsVideoDTO dto = new NewsVideoDTO();
		dto.setIdNsv(idNsv);
		dto.setTitleNsv(titleNsv);
		dto.setPlaycodeNsv(playcodeNsv);
		dto.setDateCreateNsv(DateUtil.format(dateCreateNsv, DateUtil.DEFAULT_DATETIME_FORMAT));
		return dto;
	}

}