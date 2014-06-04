package com.provence.web.dto;


public class ProductDetailDTO {

	private Long idPrdd;
	private ProductDTO productDTO;
	private String descriptionPrd;
	private String ingredientsPrd;
	private String instructionsPrd;
	private String bigPicPath;
	private String smallPic1Path;
	private String smallPic2Path;
	private String smallPic3Path;
	private String dateCreatePrd;
	private BrandDTO brandDTO;
	private CategoryDTO categoryDTO;
	public Long getIdPrdd() {
		return idPrdd;
	}
	public void setIdPrdd(Long idPrdd) {
		this.idPrdd = idPrdd;
	}
	public ProductDTO getProductDTO() {
		return productDTO;
	}
	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}
	public String getDescriptionPrd() {
		return descriptionPrd;
	}
	public void setDescriptionPrd(String descriptionPrd) {
		this.descriptionPrd = descriptionPrd;
	}
	public String getIngredientsPrd() {
		return ingredientsPrd;
	}
	public void setIngredientsPrd(String ingredientsPrd) {
		this.ingredientsPrd = ingredientsPrd;
	}
	public String getInstructionsPrd() {
		return instructionsPrd;
	}
	public void setInstructionsPrd(String instructionsPrd) {
		this.instructionsPrd = instructionsPrd;
	}
	public String getBigPicPath() {
		return bigPicPath;
	}
	public void setBigPicPath(String bigPicPath) {
		this.bigPicPath = bigPicPath;
	}
	public String getSmallPic1Path() {
		return smallPic1Path;
	}
	public void setSmallPic1Path(String smallPic1Path) {
		this.smallPic1Path = smallPic1Path;
	}
	public String getSmallPic2Path() {
		return smallPic2Path;
	}
	public void setSmallPic2Path(String smallPic2Path) {
		this.smallPic2Path = smallPic2Path;
	}
	public String getSmallPic3Path() {
		return smallPic3Path;
	}
	public void setSmallPic3Path(String smallPic3Path) {
		this.smallPic3Path = smallPic3Path;
	}
	public String getDateCreatePrd() {
		return dateCreatePrd;
	}
	public void setDateCreatePrd(String dateCreatePrd) {
		this.dateCreatePrd = dateCreatePrd;
	}
	public BrandDTO getBrandDTO() {
		return brandDTO;
	}
	public void setBrandDTO(BrandDTO brandDTO) {
		this.brandDTO = brandDTO;
	}
	public CategoryDTO getCategoryDTO() {
		return categoryDTO;
	}
	public void setCategoryDTO(CategoryDTO categoryDTO) {
		this.categoryDTO = categoryDTO;
	}
}
