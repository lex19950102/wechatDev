package com.lex.model.coreModel;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MyNews entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "my_news", catalog = "akprogramer")
public class MyNews implements java.io.Serializable {

	// Fields

	private Integer newsId;
	private String Title;
	private String Description;
	private String PicUrl;
	private String Url;

	// Constructors

	/** default constructor */
	public MyNews() {
	}

	/** full constructor */
	public MyNews(String Title, String Description, String PicUrl, String Url) {
		this.Title = Title;
		this.Description = Description;
		this.PicUrl = PicUrl;
		this.Url = Url;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "newsId", unique = true, nullable = false)
	public Integer getNewsId() {
		return this.newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	@Column(name = "Title")
	public String getTitle() {
		return this.Title;
	}

	public void setTitle(String Title) {
		this.Title = Title;
	}

	@Column(name = "Description")
	public String getDescription() {
		return this.Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}

	@Column(name = "PicUrl", length = 2000)
	public String getPicUrl() {
		return this.PicUrl;
	}

	public void setPicUrl(String PicUrl) {
		this.PicUrl = PicUrl;
	}

	@Column(name = "Url", length = 2000)
	public String getUrl() {
		return this.Url;
	}

	public void setUrl(String Url) {
		this.Url = Url;
	}

}