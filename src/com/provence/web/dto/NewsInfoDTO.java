package com.provence.web.dto;



public class NewsInfoDTO {
	private Long idNsi;
	private String titleNsi;
	private String contentNsi;
	private String path;
	private String dateCreateNsi;
	public Long getIdNsi() {
		return idNsi;
	}
	public void setIdNsi(Long idNsi) {
		this.idNsi = idNsi;
	}
	public String getTitleNsi() {
		return titleNsi;
	}
	public void setTitleNsi(String titleNsi) {
		this.titleNsi = titleNsi;
	}
	public String getContentNsi() {
		return contentNsi;
	}
	public void setContentNsi(String contentNsi) {
		this.contentNsi = contentNsi;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getDateCreateNsi() {
		return dateCreateNsi;
	}
	public void setDateCreateNsi(String dateCreateNsi) {
		this.dateCreateNsi = dateCreateNsi;
	}
	
	
}
