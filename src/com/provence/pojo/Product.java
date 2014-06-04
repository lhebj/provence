package com.provence.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.provence.web.dto.ProductDTO;
import com.provence.web.upload.UploadFileUtil;

/**
 * ProProductPrd entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pro_product_prd", catalog = "provencedb")
public class Product implements java.io.Serializable {

	public static String FILE_COVER = "cover";
	public static String FILE_BIGPIC = "bigPic";
	public static String FILE_SMALLPIC1 = "smallPic1";
	public static String FILE_SMALLPIC2 = "smallPic2";
	public static String FILE_SMALLPIC3 = "smallPic3";
	// Fields

	/**
	 * TODO
	 */
	private static final long serialVersionUID = 6444076279034623148L;
	private Long idPrd;
	private Brand brand;
	private Category category;
	private String namePrd;
	private Content cover;


	// Constructors

	/** default constructor */
	public Product() {
	}

	/** full constructor */
	public Product(Brand brand, Category category, String namePrd,Content cover) {
		this.brand = brand;
		this.category = category;
		this.namePrd = namePrd;
		this.cover = cover;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id_prd", unique = true, nullable = false)
	public Long getIdPrd() {
		return this.idPrd;
	}

	public void setIdPrd(Long idPrd) {
		this.idPrd = idPrd;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idbrd_prd")
	public Brand getBrand() {
		return this.brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcat_prd")
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "name_prd", length = 128)
	public String getNamePrd() {
		return this.namePrd;
	}

	public void setNamePrd(String namePrd) {
		this.namePrd = namePrd;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcover_prd")
	public Content getCover() {
		return cover;
	}

	public void setCover(Content cover) {
		this.cover = cover;
	}
	
	public ProductDTO toDTO(){
		ProductDTO dto = new ProductDTO();
		dto.setIdPrd(idPrd);
		dto.setNamePrd(namePrd);
		if(getCover() != null){
			dto.setCoverPath(UploadFileUtil.getContentPath(getCover()));
		}	
		return dto;
	}

}