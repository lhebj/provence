package com.provence.web.dto;

public class ContactUsDTO {
	private Long idCtu;
	private String contentCtu;
	/**
	 * 'contact','hr','stores' comment '类型：联系方式，招聘信息，新门店'
	 */
	private String typeCtu;
	public Long getIdCtu() {
		return idCtu;
	}
	public void setIdCtu(Long idCtu) {
		this.idCtu = idCtu;
	}
	public String getContentCtu() {
		return contentCtu;
	}
	public void setContentCtu(String contentCtu) {
		this.contentCtu = contentCtu;
	}
	public String getTypeCtu() {
		return typeCtu;
	}
	public void setTypeCtu(String typeCtu) {
		this.typeCtu = typeCtu;
	}
}
