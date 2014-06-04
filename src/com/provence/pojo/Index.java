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

import com.provence.web.dto.IndexDTO;
import com.provence.web.upload.UploadFileUtil;

/**
 * ProIndexIdx entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pro_index_idx", catalog = "provencedb")
public class Index implements java.io.Serializable {
	
	/**
	 * TODO
	 */
	private static final long serialVersionUID = 1499058990401346294L;
	public static String TYPE_PIC = "pic";
	public static String TYPE_VIDEO = "video";

	// Fields

	private Long idIdx;
	private Content pic;
	private String typeIdx;
	private String playcodeIdx;
	private Date dateCreateIdx;

	// Constructors

	/** default constructor */
	public Index() {
	}

	/** full constructor */
	public Index(Content pic, String typeIdx, String playcodeIdx, Date dateCreateIdx) {
		this.pic = pic;
		this.typeIdx = typeIdx;
		this.playcodeIdx = playcodeIdx;
		this.dateCreateIdx = dateCreateIdx;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id_idx", unique = true, nullable = false)
	public Long getIdIdx() {
		return this.idIdx;
	}

	public void setIdIdx(Long idIdx) {
		this.idIdx = idIdx;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idpic_idx")
	public Content getPic() {
		return this.pic;
	}

	public void setPic(Content pic) {
		this.pic = pic;
	}

	@Column(name = "type_idx", length = 160)
	public String getTypeIdx() {
		return this.typeIdx;
	}

	public void setTypeIdx(String typeIdx) {
		this.typeIdx = typeIdx;
	}

	@Column(name = "playcode_idx", length = 1024)
	public String getPlaycodeIdx() {
		return this.playcodeIdx;
	}

	public void setPlaycodeIdx(String playcodeIdx) {
		this.playcodeIdx = playcodeIdx;
	}


	@Column(name = "date_create_idx", length = 19)
	public Date getDateCreateIdx() {
		return this.dateCreateIdx;
	}

	public void setDateCreateIdx(Date dateCreateIdx) {
		this.dateCreateIdx = dateCreateIdx;
	}
	
	public IndexDTO toDTO(){
		IndexDTO dto = new IndexDTO();
		dto.setIdIdx(idIdx);
		if(getPic() != null){
			dto.setPath(UploadFileUtil.getContentPath(getPic()));
		}		
		dto.setTypeIdx(typeIdx);
		dto.setPlaycodeIdx(playcodeIdx);
		return dto;
	}

}