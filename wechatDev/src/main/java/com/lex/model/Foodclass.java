package com.lex.model;
// default package

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;



/**
 * Foodclass entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "foodclass", catalog = "huoguodian")
public class Foodclass implements java.io.Serializable {

	// Fields

	private Integer classId;
	private String className;
	private String shopId;
	private Set<Food> foods;

	
    @OneToMany(cascade=CascadeType.ALL,mappedBy="foodclass") 
	public Set<Food> getFoods() {
		return foods;
	}

	public void setFoods(Set<Food> foods) {
		this.foods = foods;
	}

	/** default constructor */
	public Foodclass() {
	}

	/** full constructor */
	public Foodclass(String className, String shopId) {
		this.className = className;
		this.shopId = shopId;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "class_id", unique = true, nullable = false)
	public Integer getClassId() {
		return this.classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}



	@Column(name = "class_name")
	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Column(name = "shop_Id")
	public String getShopId() {
		return this.shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

}