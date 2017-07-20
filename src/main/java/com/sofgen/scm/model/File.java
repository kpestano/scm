package com.sofgen.scm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author tpenarubia
 *
 */
@Entity
@Table(name="TBL_FILE")
public class File extends BaseModel{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="file_id")
	private Long id;

	@Column(name = "filename", unique = true, nullable = false)
	private String filename;
	
	@Column(name = "path")
	private String filepath;
	
	@Column(name = "version")
	private String version;


	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * @return the filepath
	 */
	public String getFilepath() {
		return filepath;
	}

	/**
	 * @param filepath the filepath to set
	 */
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

}
