package com.lex.model;
// default package

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "order", catalog = "huoguodian")
public class Order implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private Integer userId;
	private String orderInfo;
	private Integer orderStatus;
	private Integer orderPriceSum;
	private Timestamp orderTime;
	private String orderMark;

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** full constructor */
	public Order(Integer userId, String orderInfo, Integer orderStatus,
			Integer orderPriceSum, Timestamp orderTime, String orderMark) {
		this.userId = userId;
		this.orderInfo = orderInfo;
		this.orderStatus = orderStatus;
		this.orderPriceSum = orderPriceSum;
		this.orderTime = orderTime;
		this.orderMark = orderMark;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "order_id", unique = true, nullable = false)
	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@Column(name = "user_id")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "order_info", length = 1000)
	public String getOrderInfo() {
		return this.orderInfo;
	}

	public void setOrderInfo(String orderInfo) {
		this.orderInfo = orderInfo;
	}

	@Column(name = "order_status")
	public Integer getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Column(name = "order_price_sum")
	public Integer getOrderPriceSum() {
		return this.orderPriceSum;
	}

	public void setOrderPriceSum(Integer orderPriceSum) {
		this.orderPriceSum = orderPriceSum;
	}

	@Column(name = "order_time", length = 19)
	public Timestamp getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}

	@Column(name = "order_mark")
	public String getOrderMark() {
		return this.orderMark;
	}

	public void setOrderMark(String orderMark) {
		this.orderMark = orderMark;
	}

}