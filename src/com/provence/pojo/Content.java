package com.provence.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ProContentCon entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pro_content_con", catalog = "provencedb")
public class Content implements java.io.Serializable {

	public static String SRC_CON_INDEX = "index";
	public static String SRC_CON_BANNER = "banner";
	public static String SRC_CON_NEWS = "news";
	public static String SRC_CON_BRAND = "brand";
	public static String SRC_CON_PRODUCT = "product";
	public static String SRC_CON_INTOPROVENCE = "intoprovence";
	// Fields

	/**
	 * TODO
	 */
	private static final long serialVersionUID = 6192069263278114811L;
	private Long idCon;
	private String originalFilenameCon;
	private String filenameCon;
	private Long filesizeCon;
	private String mimetypeCon;
	private String encodingCon;
	private String filepathCon;
	private Date dateCreateCon;
	private String srcCon;

	// Constructors

	/** default constructor */
	public Content() {
	}

	/** full constructor */
	public Content(String originalFilenameCon,String filenameCon, Long filesizeCon, String mimetypeCon, String encodingCon, String filepathCon, Date dateCreateCon,String srcCon) {
		this.originalFilenameCon = originalFilenameCon;
		this.filenameCon = filenameCon;
		this.filesizeCon = filesizeCon;
		this.mimetypeCon = mimetypeCon;
		this.encodingCon = encodingCon;
		this.filepathCon = filepathCon;
		this.dateCreateCon = dateCreateCon;
		this.srcCon = srcCon;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id_con", unique = true, nullable = false)
	public Long getIdCon() {
		return this.idCon;
	}

	public void setIdCon(Long idCon) {
		this.idCon = idCon;
	}

	@Column(name = "original_filename_con", length = 128)
	public String getOriginalFilenameCon() {
		return originalFilenameCon;
	}

	public void setOriginalFilenameCon(String originalFilenameCon) {
		this.originalFilenameCon = originalFilenameCon;
	}

	@Column(name = "filename_con", length = 128)
	public String getFilenameCon() {
		return this.filenameCon;
	}

	public void setFilenameCon(String filenameCon) {
		this.filenameCon = filenameCon;
	}

	@Column(name = "filesize_con")
	public Long getFilesizeCon() {
		return this.filesizeCon;
	}

	public void setFilesizeCon(Long filesizeCon) {
		this.filesizeCon = filesizeCon;
	}

	@Column(name = "mimetype_con", length = 32)
	public String getMimetypeCon() {
		return this.mimetypeCon;
	}

	public void setMimetypeCon(String mimetypeCon) {
		this.mimetypeCon = mimetypeCon;
	}

	@Column(name = "encoding_con", length = 16)
	public String getEncodingCon() {
		return this.encodingCon;
	}

	public void setEncodingCon(String encodingCon) {
		this.encodingCon = encodingCon;
	}

	@Column(name = "filepath_con", length = 256)
	public String getFilepathCon() {
		return this.filepathCon;
	}

	public void setFilepathCon(String filepathCon) {
		this.filepathCon = filepathCon;
	}


	@Column(name = "date_create_con", length = 19)
	public Date getDateCreateCon() {
		return dateCreateCon;
	}

	public void setDateCreateCon(Date dateCreateCon) {
		this.dateCreateCon = dateCreateCon;
	}

	@Column(name = "src_con", length = 32)
	public String getSrcCon() {
		return this.srcCon;
	}

	public void setSrcCon(String srcCon) {
		this.srcCon = srcCon;
	}

}