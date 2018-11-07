package com.lex.model;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Food entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "food", catalog = "huoguodian")
public class Foodlist implements java.io.Serializable {

	public Foodlist() {
		super();
	}

	// Fields

	private Integer foodId;
	private String foodName;
	private String foodBanner;
	private Integer foodPrice;
	private Integer shopId;
	@Override
	public String toString() {
		return "Foodlist [foodId=" + foodId + ", foodName=" + foodName
				+ ", foodBanner=" + foodBanner + ", foodPrice=" + foodPrice
				+ ", shopId=" + shopId + ", classId=" + classId + "]";
	}

	private String classId;

	// Constructors

	/** default constructor */


	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "food_id", unique = true, nullable = false)
	public Integer getFoodId() {
		return this.foodId;
	}

	public Foodlist(Integer foodId, String foodName, String foodBanner,
			Integer foodPrice, Integer shopId, String classId) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodBanner = foodBanner;
		this.foodPrice = foodPrice;
		this.shopId = shopId;
		this.classId = classId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	@Column(name = "food_name")
	public String getFoodName() {
		return this.foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	@Column(name = "food_banner")
	public String getFoodBanner() {
		return this.foodBanner;
	}

	public void setFoodBanner(String foodBanner) {
		this.foodBanner = foodBanner;
	}

	@Column(name = "food_price")
	public Integer getFoodPrice() {
		return this.foodPrice;
	}

	public void setFoodPrice(Integer foodPrice) {
		this.foodPrice = foodPrice;
	}

	@Column(name = "shop_id")
	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	@Column(name = "class_id")
	public String getClassId() {
		return this.classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

}