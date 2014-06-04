package com.provence.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.provence.web.dto.BrandDTO;

/**
 * ProBrandBrd entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pro_brand_brd", catalog = "provencedb")
public class Brand implements java.io.Serializable {

	// Fields


	/**
	 * TODO
	 */
	private static final long serialVersionUID = -7772854383720536922L;
	private Long idBrd;
	private String nameBrd;

	// Constructors

	/** default constructor */
	public Brand() {
	}

	/** full constructor */
	public Brand(String nameBrd) {
		this.nameBrd = nameBrd;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id_brd", unique = true, nullable = false)
	public Long getIdBrd() {
		return this.idBrd;
	}

	public void setIdBrd(Long idBrd) {
		this.idBrd = idBrd;
	}

	@Column(name = "name_brd", length = 128)
	public String getNameBrd() {
		return this.nameBrd;
	}

	public void setNameBrd(String nameBrd) {
		this.nameBrd = nameBrd;
	}
	
	public BrandDTO toDTO(){
		BrandDTO dto = new BrandDTO();
		dto.setIdBrd(idBrd);
		dto.setNameBrd(nameBrd);
		return dto;
	}

}