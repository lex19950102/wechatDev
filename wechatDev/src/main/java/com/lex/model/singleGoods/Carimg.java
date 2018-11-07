package com.lex.model.singleGoods;

// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;

/**
 * Carimg entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "carimg", catalog = "secondhandcarservice")
public class Carimg implements java.io.Serializable {

	// Fields

	private Integer carImgId;
	private Goods goods;
	private String imgsrc;
	private String imgUrl;

	// Constructors

	/** default constructor */
	public Carimg() {
	}

	/** minimal constructor */
	public Carimg(Integer carImgId) {
		this.carImgId = carImgId;
	}

	/** full constructor */
	public Carimg(Integer carImgId, Goods goods, String imgsrc, String imgUrl) {
		this.carImgId = carImgId;
		this.goods = goods;
		this.imgsrc = imgsrc;
		this.imgUrl = imgUrl;
	}

	// Property accessors
	@Id
	@Column(name = "carImgId", unique = true, nullable = false)
	public Integer getCarImgId() {
		return this.carImgId;
	}

	public void setCarImgId(Integer carImgId) {
		this.carImgId = carImgId;
	}

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "goodsId")
	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	@Column(name = "Imgsrc", length = 500)
	public String getImgsrc() {
		return this.imgsrc;
	}

	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}

	@Column(name = "ImgUrl", length = 500)
	public String getImgUrl() {
		return this.imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

}