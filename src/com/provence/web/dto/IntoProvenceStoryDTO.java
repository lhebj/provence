package com.provence.web.dto;

import com.provence.pojo.IntoProvence;

public class IntoProvenceStoryDTO {
	private Long idInps;
	private String storyInps;
	
	/**
	 * @see IntoProvence.TYPE
	 */
	private String typeInps;

	public Long getIdInps() {
		return idInps;
	}

	public void setIdInps(Long idInps) {
		this.idInps = idInps;
	}

	public String getStoryInps() {
		return storyInps;
	}

	public void setStoryInps(String storyInps) {
		this.storyInps = storyInps;
	}

	public String getTypeInps() {
		return typeInps;
	}

	public void setTypeInps(String typeInps) {
		this.typeInps = typeInps;
	}
}
