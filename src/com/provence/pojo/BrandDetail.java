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

import com.provence.web.dto.BrandDetailDTO;
import com.provence.web.dto.BrandLogoDTO;
import com.provence.web.upload.UploadFileUtil;

/**
 * ProBrandDetailBrdd entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pro_brand_detail_brdd", catalog = "provencedb")
public class BrandDetail implements java.io.Serializable {

	// Fields
	
	public static String FILE_LOGO = "logo";
	public static String FILE_NEWPRODUCTPIC1 = "newProductPic1";
	public static String FILE_NEWPRODUCTPIC2 = "newProductPic2";

	/**
	 * TODO
	 */
	private static final long serialVersionUID = 5656377642089746457L;
	private Long idBrdd;
	private String introductionBrdd;	
	private Content logo;
	private Date dateCreateBrdd;
	private String newproductnameBrdd;
	private Content newProductPic1;
	private Content newProductPic2;
	private Brand brand;

	// Constructors

	/** default constructor */
	public BrandDetail() {
	}

	/** full constructor */
	public BrandDetail(String introductionBrdd, Content logo, Date dateCreateBrdd, String newproductnameBrdd,  Content newProductPic1,  Content newProductPic2, Brand brand) {
		this.introductionBrdd = introductionBrdd;
		this.logo = logo;
		this.dateCreateBrdd = dateCreateBrdd;
		this.newproductnameBrdd = newproductnameBrdd;
		this.newProductPic1 = newProductPic1;
		this.newProductPic2 = newProductPic2;
		this.brand = brand;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id_brdd", unique = true, nullable = false)
	public Long getIdBrdd() {
		return this.idBrdd;
	}

	public void setIdBrdd(Long idBrdd) {
		this.idBrdd = idBrdd;
	}

	@Column(name = "introduction_brdd", length = 65535)
	public String getIntroductionBrdd() {
		return this.introductionBrdd;
	}

	public void setIntroductionBrdd(String introductionBrdd) {
		this.introductionBrdd = introductionBrdd;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idlogo_brdd")
	public Content getLogo() {
		return this.logo;
	}

	public void setLogo(Content logo) {
		this.logo = logo;
	}

	
	@Column(name = "date_create_brdd", length = 19)
	public Date getDateCreateBrdd() {
		return this.dateCreateBrdd;
	}

	public void setDateCreateBrdd(Date dateCreateBrdd) {
		this.dateCreateBrdd = dateCreateBrdd;
	}

	@Column(name = "newproductname_brdd", length = 128)
	public String getNewproductnameBrdd() {
		return this.newproductnameBrdd;
	}

	public void setNewproductnameBrdd(String newproductnameBrdd) {
		this.newproductnameBrdd = newproductnameBrdd;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idnewproductpic1_brdd")
	public Content getNewProductPic1() {
		return this.newProductPic1;
	}

	public void setNewProductPic1(Content newProductPic1) {
		this.newProductPic1 = newProductPic1;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idnewproductpic2_brdd")
	public Content getNewProductPic2() {
		return this.newProductPic2;
	}

	public void setNewProductPic2(Content newProductPic2) {
		this.newProductPic2 = newProductPic2;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idbrd_brdd")  	
	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public BrandDetailDTO toDTO(){
		BrandDetailDTO dto = new BrandDetailDTO();
		dto.setIntroductionBrdd(introductionBrdd);
		dto.setNewproductnameBrdd(newproductnameBrdd);
		dto.setIdBrd(brand.getIdBrd());
		dto.setNameBrd(brand.getNameBrd());
		if(getLogo() != null){
			dto.setLogoPath(UploadFileUtil.getContentPath(getLogo()));
		}		
		if(getNewProductPic1() != null){
			dto.setNewProductPic1Path(UploadFileUtil.getContentPath(getNewProductPic1()));
		}		
		if(getNewProductPic2() != null){
			dto.setNewProductPic2Path(UploadFileUtil.getContentPath(getNewProductPic2()));
		}
		
		return dto;
	}
	
	public BrandLogoDTO toBrandLogoDTO(){
		BrandLogoDTO dto = new BrandLogoDTO();
		dto.setIdBrd(brand.getIdBrd());
		dto.setNameBrd(brand.getNameBrd());
		if(getLogo() != null){
			dto.setLogoPath(UploadFileUtil.getContentPath(getLogo()));
		}	
		return dto;
	}

}