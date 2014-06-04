package com.provence.web.dto;


public class ProductDTO {

	private Long idPrd;
	private String namePrd;
	private String coverPath;
	public Long getIdPrd() {
		return idPrd;
	}
	public void setIdPrd(Long idPrd) {
		this.idPrd = idPrd;
	}
	public String getNamePrd() {
		return namePrd;
	}
	public void setNamePrd(String namePrd) {
		this.namePrd = namePrd;
	}
	public String getCoverPath() {
		return coverPath;
	}
	public void setCoverPath(String coverPath) {
		this.coverPath = coverPath;
	}
	
}
