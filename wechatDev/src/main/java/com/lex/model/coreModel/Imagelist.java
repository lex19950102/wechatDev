package com.lex.model.coreModel;
// default package

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Imagelist entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "imagelist", catalog = "huoguodian")
public class Imagelist implements java.io.Serializable {

	// Fields

	private Integer imageId;
	private String imageName;
	private String imagePath;
	private Timestamp uploadTime;

	// Constructors

	/** default constructor */
	public Imagelist() {
	}

	/** full constructor */
	public Imagelist(String imageName, String imagePath, Timestamp uploadTime) {
		this.imageName = imageName;
		this.imagePath = imagePath;
		this.uploadTime = uploadTime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "imageID", unique = true, nullable = false)
	public Integer getImageId() {
		return this.imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	@Column(name = "imageName")
	public String getImageName() {
		return this.imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	@Column(name = "imagePath", length = 1000)
	public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Column(name = "upload_time", length = 19)
	public Timestamp getUploadTime() {
		return this.uploadTime;
	}

	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}

}