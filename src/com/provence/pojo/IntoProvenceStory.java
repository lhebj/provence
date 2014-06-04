package com.provence.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.provence.web.dto.IntoProvenceStoryDTO;

/**
 * ProIntoprovenceStoryInps entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pro_intoprovence_story_inps", catalog = "provencedb")
public class IntoProvenceStory implements java.io.Serializable {

	// Fields

	/**
	 * TODO
	 */
	private static final long serialVersionUID = 3217212445308347043L;
	private Long idInps;
	private String storyInps;
	
	/**
	 * @see IntoProvence.TYPE
	 */
	private String typeInps;

	// Constructors

	/** default constructor */
	public IntoProvenceStory() {
	}

	/** full constructor */
	public IntoProvenceStory(String storyInps, String typeInps) {
		this.storyInps = storyInps;
		this.typeInps = typeInps;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id_inps", unique = true, nullable = false)
	public Long getIdInps() {
		return this.idInps;
	}

	public void setIdInps(Long idInps) {
		this.idInps = idInps;
	}

	@Column(name = "story_inps", length = 16777215)
	public String getStoryInps() {
		return this.storyInps;
	}

	public void setStoryInps(String storyInps) {
		this.storyInps = storyInps;
	}

	@Column(name = "type_inps", length = 7)
	public String getTypeInps() {
		return this.typeInps;
	}

	public void setTypeInps(String typeInps) {
		this.typeInps = typeInps;
	}
	
	public IntoProvenceStoryDTO toDTO(){
		IntoProvenceStoryDTO intoProvenceStoryDTO = new IntoProvenceStoryDTO();
		intoProvenceStoryDTO.setIdInps(idInps);
		intoProvenceStoryDTO.setStoryInps(storyInps);
		intoProvenceStoryDTO.setTypeInps(typeInps);
		return intoProvenceStoryDTO;
	}

}