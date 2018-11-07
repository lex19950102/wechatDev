package com.lex.model;
// default package

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;

/**
 * Food entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "food", catalog = "huoguodian")
public class Food implements java.io.Serializable {

	// Fields



	private Integer foodId;
	private String foodName;
	private String foodBanner;
	private Integer foodPrice;
	private Integer shopId;
	private Foodclass foodclass;

	// Constructors

	/** default constructor */
	public Food() {
	}

//	/** full constructor */
//	public Food(String foodName, String foodBanner, Integer foodPrice,
//			Integer shopId, String classId) {
//		this.foodName = foodName;
//		this.foodBanner = foodBanner;
//		this.foodPrice = foodPrice;
//		this.shopId = shopId;
//	
//	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "food_id", unique = true, nullable = false)
	public Integer getFoodId() {
		return this.foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}
	@JsonBackReference
    @ManyToOne(cascade={CascadeType.ALL})           
    @JoinColumn(name="class_id")     //Food类中对应外键的属性：class_id   
	public Foodclass getFoodclass() {
		return foodclass;
	}

	public void setFoodclass(Foodclass foodclass) {
		this.foodclass = foodclass;
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

	

}