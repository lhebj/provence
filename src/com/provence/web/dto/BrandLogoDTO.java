package com.provence.web.dto;

public class BrandLogoDTO {
	private Long idBrd;
	private String nameBrd;
	private String logoPath;

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

	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}
	
}
