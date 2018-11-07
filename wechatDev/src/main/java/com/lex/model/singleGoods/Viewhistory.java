package com.lex.model.singleGoods;

// default package

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;

/**
 * Viewhistory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "viewhistory", catalog = "secondhandcarservice")
public class Viewhistory implements java.io.Serializable {

	// Fields

	private Integer viewId;
	private Goods goods;
	private Wxuser wxuser;

	// Constructors

	/** default constructor */
	public Viewhistory() {
	}

	/** full constructor */
	public Viewhistory(Goods goods, Wxuser wxuser) {
		this.goods = goods;
		this.wxuser = wxuser;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "viewId", unique = true, nullable = false)
	public Integer getViewId() {
		return this.viewId;
	}

	public void setViewId(Integer viewId) {
		this.viewId = viewId;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	public Wxuser getWxuser() {
		return this.wxuser;
	}

	public void setWxuser(Wxuser wxuser) {
		this.wxuser = wxuser;
	}

}