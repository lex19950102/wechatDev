package com.lex.model.userComment;

// default package

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;

/**
 * Goods entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "goods", catalog = "secondhandcarservice")
public class Goods implements java.io.Serializable {

	// Fields

	private Integer goodsId;
	private String goodsName;
	private Integer publishUserId;
	private String publishContent;
	private Integer adsId;
	private Integer viewSum;
	private Integer subscribeSum;
	private Timestamp publishTime;
	private Set<Comment> comments = new HashSet<Comment>(0);

	// Constructors

	/** default constructor */
	public Goods() {
	}

	/** minimal constructor */
	public Goods(Integer goodsId) {
		this.goodsId = goodsId;
	}

	/** full constructor */
	public Goods(Integer goodsId, String goodsName, Integer publishUserId,
			String publishContent, Integer adsId, Integer viewSum,
			Integer subscribeSum, Timestamp publishTime, Set<Comment> comments) {
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.publishUserId = publishUserId;
		this.publishContent = publishContent;
		this.adsId = adsId;
		this.viewSum = viewSum;
		this.subscribeSum = subscribeSum;
		this.publishTime = publishTime;
		this.comments = comments;
	}

	// Property accessors
	@Id
	@Column(name = "goodsID", unique = true, nullable = false)
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name = "goodsName")
	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	@Column(name = "publishUserId")
	public Integer getPublishUserId() {
		return this.publishUserId;
	}

	public void setPublishUserId(Integer publishUserId) {
		this.publishUserId = publishUserId;
	}

	@Column(name = "publishContent", length = 2000)
	public String getPublishContent() {
		return this.publishContent;
	}

	public void setPublishContent(String publishContent) {
		this.publishContent = publishContent;
	}

	@Column(name = "adsId")
	public Integer getAdsId() {
		return this.adsId;
	}

	public void setAdsId(Integer adsId) {
		this.adsId = adsId;
	}

	@Column(name = "viewSum")
	public Integer getViewSum() {
		return this.viewSum;
	}

	public void setViewSum(Integer viewSum) {
		this.viewSum = viewSum;
	}

	@Column(name = "subscribeSum")
	public Integer getSubscribeSum() {
		return this.subscribeSum;
	}

	public void setSubscribeSum(Integer subscribeSum) {
		this.subscribeSum = subscribeSum;
	}

	@Column(name = "publishTime", length = 19)
	public Timestamp getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}

	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "goods")
	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

}