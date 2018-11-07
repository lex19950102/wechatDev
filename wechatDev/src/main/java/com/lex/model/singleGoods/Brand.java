package com.lex.model.singleGoods;

// default package

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
 * Brand entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "brand", catalog = "secondhandcarservice")
public class Brand implements java.io.Serializable {

	// Fields

	private Integer brandId;
	private String brandname;
	private Integer carType;
	private Set<Goods> goodses = new HashSet<Goods>(0);

	// Constructors

	/** default constructor */
	public Brand() {
	}

	/** minimal constructor */
	public Brand(Integer brandId) {
		this.brandId = brandId;
	}

	/** full constructor */
	public Brand(Integer brandId, String brandname, Integer carType,
			Set<Goods> goodses) {
		this.brandId = brandId;
		this.brandname = brandname;
		this.carType = carType;
		this.goodses = goodses;
	}

	// Property accessors
	@Id
	@Column(name = "brandId", unique = true, nullable = false)
	public Integer getBrandId() {
		return this.brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	@Column(name = "brandname")
	public String getBrandname() {
		return this.brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	@Column(name = "carType")
	public Integer getCarType() {
		return this.carType;
	}

	public void setCarType(Integer carType) {
		this.carType = carType;
	}

	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "brand")
	public Set<Goods> getGoodses() {
		return this.goodses;
	}

	public void setGoodses(Set<Goods> goodses) {
		this.goodses = goodses;
	}

}