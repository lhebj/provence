package com.provence.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.provence.web.dto.CategoryDTO;

/**
 * ProCategoryCat entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pro_category_cat", catalog = "provencedb")
public class Category implements java.io.Serializable {

	// Fields

	/**
	 * TODO
	 */
	private static final long serialVersionUID = 1775458560804889636L;
	

	private Long idCat;
	private Brand brand;
	
	private String nameCat;

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** full constructor */
	public Category(Brand brand, String nameCat) {
		this.brand = brand;
		this.nameCat = nameCat;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_cat", unique = true, nullable = false)
	public Long getIdCat() {
		return this.idCat;
	}

	public void setIdCat(Long idCat) {
		this.idCat = idCat;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idbrd_cat")
	public Brand getBrand() {
		return this.brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@Column(name = "name_cat", length = 128)
	public String getNameCat() {
		return this.nameCat;
	}

	public void setNameCat(String nameCat) {
		this.nameCat = nameCat;
	}
	
	public CategoryDTO toDTO(){
		CategoryDTO dto = new CategoryDTO();
		dto.setIdCat(idCat);
		dto.setNameCat(nameCat);
		return dto;
	}

}