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

import com.provence.web.dto.ProductDetailDTO;
import com.provence.web.upload.UploadFileUtil;
import com.provence.web.util.DateUtil;

/**
 * ProProductDetailPrdd entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pro_product_detail_prdd", catalog = "provencedb")
public class ProductDetail implements java.io.Serializable {

	// Fields

	/**
	 * TODO
	 */
	private static final long serialVersionUID = 2125756406416667640L;
	private Long idPrdd;
	private Product product;
	private String descriptionPrd;
	private String ingredientsPrd;
	private String instructionsPrd;
	private Content bigPic;
	private Content smallPic1;
	private Content smallPic2;
	private Content smallPic3;
	private Date dateCreatePrd;

	// Constructors

	/** default constructor */
	public ProductDetail() {
	}

	/** full constructor */
	public ProductDetail(Product product, String descriptionPrd, String ingredientsPrd, String instructionsPrd, Content bigPic, Content smallPic1, Content smallPic2, Content smallPic3, Date dateCreatePrd) {
		this.product = product;
		this.descriptionPrd = descriptionPrd;
		this.ingredientsPrd = ingredientsPrd;
		this.instructionsPrd = instructionsPrd;
		this.bigPic = bigPic;
		this.smallPic1 = smallPic1;
		this.smallPic2 = smallPic2;
		this.smallPic3 = smallPic3;
		this.dateCreatePrd = dateCreatePrd;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id_prdd", unique = true, nullable = false)
	public Long getIdPrdd() {
		return this.idPrdd;
	}

	public void setIdPrdd(Long idPrdd) {
		this.idPrdd = idPrdd;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idprd_prdd")
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name = "description_prd", length = 16777215)
	public String getDescriptionPrd() {
		return this.descriptionPrd;
	}

	public void setDescriptionPrd(String descriptionPrd) {
		this.descriptionPrd = descriptionPrd;
	}

	@Column(name = "ingredients_prd", length = 16777215)
	public String getIngredientsPrd() {
		return this.ingredientsPrd;
	}

	public void setIngredientsPrd(String ingredientsPrd) {
		this.ingredientsPrd = ingredientsPrd;
	}

	@Column(name = "instructions_prd", length = 16777215)
	public String getInstructionsPrd() {
		return this.instructionsPrd;
	}

	public void setInstructionsPrd(String instructionsPrd) {
		this.instructionsPrd = instructionsPrd;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idbigpic_prd")
	public Content getBigPic() {
		return this.bigPic;
	}

	public void setBigPic(Content bigPic) {
		this.bigPic = bigPic;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idsmallpic1_prd")
	public Content getSmallPic1() {
		return this.smallPic1;
	}

	public void setSmallPic1(Content smallPic1) {
		this.smallPic1 = smallPic1;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idsmallpic2_prd")
	public Content getSmallPic2() {
		return this.smallPic2;
	}

	public void setSmallPic2(Content smallPic2) {
		this.smallPic2 = smallPic2;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idsmallpic3_prd")
	public Content getSmallPic3() {
		return this.smallPic3;
	}

	public void setSmallPic3(Content smallPic3) {
		this.smallPic3 = smallPic3;
	}

	
	@Column(name = "date_create_prd", length = 19)
	public Date getDateCreatePrd() {
		return this.dateCreatePrd;
	}

	public void setDateCreatePrd(Date dateCreatePrd) {
		this.dateCreatePrd = dateCreatePrd;
	}
	
	public ProductDetailDTO toDTO(){
		ProductDetailDTO dto = new ProductDetailDTO();
		dto.setIdPrdd(idPrdd);
		dto.setIngredientsPrd(ingredientsPrd);
		dto.setDescriptionPrd(descriptionPrd);
		dto.setInstructionsPrd(instructionsPrd);
		dto.setProductDTO(product.toDTO());
		dto.setBrandDTO(product.getBrand().toDTO());
		dto.setCategoryDTO(product.getCategory().toDTO());
		dto.setDateCreatePrd(DateUtil.format(dateCreatePrd, DateUtil.DEFAULT_DATETIME_FORMAT));
		if(getBigPic() != null){
			dto.setBigPicPath(UploadFileUtil.getContentPath(getBigPic()));
		}
		if(getSmallPic1() != null){
			dto.setSmallPic1Path(UploadFileUtil.getContentPath(getSmallPic1()));
		}
		if(getSmallPic2() != null){
			dto.setSmallPic2Path(UploadFileUtil.getContentPath(getSmallPic2()));
		}
		if(getSmallPic3() != null){
			dto.setSmallPic3Path(UploadFileUtil.getContentPath(getSmallPic3()));
		}
		
		return dto;
	}

}