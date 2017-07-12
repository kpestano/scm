package com.sofgen.scm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author tpenarubia
 *
 */
@Entity
@Table(name="TBL_FILE")
public class File extends BaseModel{

	@Column(name = "NAME", unique = true, nullable = false)
	private String filename;
	
	@Column(name = "PATH")
	private String filepath;
	
	@Column(name = "VERSION")
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "File [id=" + getId() + ", filename=" + filename + ", filepath=" + filepath + ", version=" + version + "]";
	}
	
}
