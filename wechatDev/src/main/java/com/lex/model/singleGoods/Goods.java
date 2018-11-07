package com.lex.model.singleGoods;

// default package

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Goods entity. @author MyEclipse Persistence Tools
 */
@Entity(name = "singleGoods")
@Table(name = "goods", catalog = "secondhandcarservice")
public class Goods implements java.io.Serializable {

	// Fields

	private Integer goodsId;
	private Cartype cartype;
	private Brand brand;
	private String goodsName;
	private Integer publishUserId;
	private String publishContent;
	private Integer adsId;
	private Integer viewSum;
	private Integer subscribeSum;
	private Timestamp publishTime;
	private Set<Carimg> carimgs = new HashSet<Carimg>(0);
	private Set<Collection> collections = new HashSet<Collection>(0);
	private Set<Viewhistory> viewhistories = new HashSet<Viewhistory>(0);
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
	public Goods(Integer goodsId, Cartype cartype, Brand brand,
			String goodsName, Integer publishUserId, String publishContent,
			Integer adsId, Integer viewSum, Integer subscribeSum,
			Timestamp publishTime, Set<Carimg> carimgs,
			Set<Collection> collections, Set<Viewhistory> viewhistories,
			Set<Comment> comments) {
		this.goodsId = goodsId;
		this.cartype = cartype;
		this.brand = brand;
		this.goodsName = goodsName;
		this.publishUserId = publishUserId;
		this.publishContent = publishContent;
		this.adsId = adsId;
		this.viewSum = viewSum;
		this.subscribeSum = subscribeSum;
		this.publishTime = publishTime;
		this.carimgs = carimgs;
		this.collections = collections;
		this.viewhistories = viewhistories;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "typeId")
	public Cartype getCartype() {
		return this.cartype;
	}

	public void setCartype(Cartype cartype) {
		this.cartype = cartype;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "brandId")
	public Brand getBrand() {
		return this.brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "goods")
	public Set<Carimg> getCarimgs() {
		return this.carimgs;
	}

	public void setCarimgs(Set<Carimg> carimgs) {
		this.carimgs = carimgs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "goods")
	public Set<Collection> getCollections() {
		return this.collections;
	}

	public void setCollections(Set<Collection> collections) {
		this.collections = collections;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "goods")
	public Set<Viewhistory> getViewhistories() {
		return this.viewhistories;
	}

	public void setViewhistories(Set<Viewhistory> viewhistories) {
		this.viewhistories = viewhistories;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "goods")
	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

}