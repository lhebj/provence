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

import com.provence.web.dto.IntoProvenceDTO;
import com.provence.web.upload.UploadFileUtil;
import com.provence.web.util.DateUtil;

/**
 * ProIntoprovenceInp entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pro_intoprovence_inp", catalog = "provencedb")
public class IntoProvence implements java.io.Serializable {

	/**
	 * TODO
	 */
	private static final long serialVersionUID = -5216743518084453247L;
	// Fields

	private Long idInp;
	private String contentInp;
	private Content pic;
	private String typeInp;
	private Date dateCreateInp;

	// Constructors

	/** default constructor */
	public IntoProvence() {
	}

	/** full constructor */
	public IntoProvence(String contentInp, Content pic, String typeInp, Date dateCreateInp) {
		this.contentInp = contentInp;
		this.pic = pic;
		this.typeInp = typeInp;
		this.dateCreateInp = dateCreateInp;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id_inp", unique = true, nullable = false)
	public Long getIdInp() {
		return this.idInp;
	}

	public void setIdInp(Long idInp) {
		this.idInp = idInp;
	}

	@Column(name = "content_inp", length = 16777215)
	public String getContentInp() {
		return this.contentInp;
	}

	public void setContentInp(String contentInp) {
		this.contentInp = contentInp;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idpic_inp")
	public Content getPic() {
		return this.pic;
	}

	public void setPic(Content pic) {
		this.pic = pic;
	}

	@Column(name = "type_inp", length = 7)
	public String getTypeInp() {
		return this.typeInp;
	}

	public void setTypeInp(String typeInp) {
		this.typeInp = typeInp;
	}

	
	@Column(name = "date_create_inp", length = 19)
	public Date getDateCreateInp() {
		return this.dateCreateInp;
	}

	public void setDateCreateInp(Date dateCreateInp) {
		this.dateCreateInp = dateCreateInp;
	}
	
	public enum typeInpEnum {
		intro,color,smell,taste,quality
	}
	
	public IntoProvenceDTO toDTO(){
		IntoProvenceDTO dto = new IntoProvenceDTO();
		dto.setContentInp(contentInp);
		dto.setIdInp(idInp);
		dto.setTypeInp(typeInp);
		if(getPic() != null){
			dto.setPath(UploadFileUtil.getContentPath(getPic()));
		}		
		dto.setDateCreateInp(DateUtil.format(dateCreateInp, DateUtil.DEFAULT_DATETIME_FORMAT));
		return dto;
	}

}