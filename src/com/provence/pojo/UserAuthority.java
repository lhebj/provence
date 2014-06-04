package com.provence.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ProUserAuthorityUut entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pro_user_authority_uaut", catalog = "provencedb")
public class UserAuthority implements java.io.Serializable {

	// Fields

	/**
	 * TODO
	 */
	private static final long serialVersionUID = 4869557875742327500L;
	private Long idUaut;
	private Long iduUaut;
	private Long idautUaut;

	// Constructors

	/** default constructor */
	public UserAuthority() {
	}

	/** full constructor */
	public UserAuthority(Long iduUut, Long idautUut) {
		this.iduUaut = iduUut;
		this.idautUaut = idautUut;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id_uaut", unique = true, nullable = false)
	public Long getIdUaut() {
		return this.idUaut;
	}

	public void setIdUaut(Long idUaut) {
		this.idUaut = idUaut;
	}

	@Column(name = "idu_uaut")
	public Long getIduUaut() {
		return this.iduUaut;
	}

	public void setIduUaut(Long iduUaut) {
		this.iduUaut = iduUaut;
	}

	@Column(name = "idaut_uaut")
	public Long getIdautUaut() {
		return this.idautUaut;
	}

	public void setIdautUaut(Long idautUaut) {
		this.idautUaut = idautUaut;
	}

}