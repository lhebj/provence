package com.provence.web.dto;

import java.util.List;

public class BrandDTO {
	
	private Long idBrd;
	private String nameBrd;
	private List<CategoryDTO> categoryDTOList;
	public Long getIdBrd() {
		return idBrd;
	}
	public void setIdBrd(Long idBrd) {
		this.idBrd = idBrd;
	}
	public String getNameBrd() {
		return nameBrd;
	}
	public void setNameBrd(String nameBrd) {
		this.nameBrd = nameBrd;
	}
	public List<CategoryDTO> getCategoryDTOList() {
		return categoryDTOList;
	}
	public void setCategoryDTOList(List<CategoryDTO> categoryDTOList) {
		this.categoryDTOList = categoryDTOList;
	}

}
