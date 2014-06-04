package com.provence.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ProAuthorityAut entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pro_authority_aut", catalog = "provencedb")
public class Authority implements java.io.Serializable {

	// Fields

	/**
	 * TODO
	 */
	private static final long serialVersionUID = 9145769324135955152L;
	private Long idAut;
	private String authorityAut;
	private String typeAut;
	private String protectedresAut;
	private String displayAut;

	// Constructors

	/** default constructor */
	public Authority() {
	}

	/** full constructor */
	public Authority(String authorityAut, String typeAut, String protectedresAut, String displayAut) {
		this.authorityAut = authorityAut;
		this.typeAut = typeAut;
		this.protectedresAut = protectedresAut;
		this.displayAut = displayAut;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id_aut", unique = true, nullable = false)
	public Long getIdAut() {
		return this.idAut;
	}

	public void setIdAut(Long idAut) {
		this.idAut = idAut;
	}

	@Column(name = "authority_aut", length = 64)
	public String getAuthorityAut() {
		return this.authorityAut;
	}

	public void setAuthorityAut(String authorityAut) {
		this.authorityAut = authorityAut;
	}

	@Column(name = "type_aut", length = 32)
	public String getTypeAut() {
		return this.typeAut;
	}

	public void setTypeAut(String typeAut) {
		this.typeAut = typeAut;
	}

	@Column(name = "protectedres_aut", length = 64)
	public String getProtectedresAut() {
		return this.protectedresAut;
	}

	public void setProtectedresAut(String protectedresAut) {
		this.protectedresAut = protectedresAut;
	}

	@Column(name = "display_aut", length = 64)
	public String getDisplayAut() {
		return this.displayAut;
	}

	public void setDisplayAut(String displayAut) {
		this.displayAut = displayAut;
	}

}