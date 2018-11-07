package com.lex.model.singleGoods;

// default package

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Wxuser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wxuser", catalog = "secondhandcarservice")
public class Wxuser implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String openid;
	private String nickName;
	private String headimgurl;
	private Integer sex;
	private String country;
	private String province;
	private String city;
	private Timestamp createTime;
	private Set<Collection> collections = new HashSet<Collection>(0);
	private Set<Viewhistory> viewhistories = new HashSet<Viewhistory>(0);
	private Set<Comment> comments = new HashSet<Comment>(0);

	// Constructors

	/** default constructor */
	public Wxuser() {
	}

	/** full constructor */
	public Wxuser(String openid, String nickName, String headimgurl,
			Integer sex, String country, String province, String city,
			Timestamp createTime, Set<Collection> collections,
			Set<Viewhistory> viewhistories, Set<Comment> comments) {
		this.openid = openid;
		this.nickName = nickName;
		this.headimgurl = headimgurl;
		this.sex = sex;
		this.country = country;
		this.province = province;
		this.city = city;
		this.createTime = createTime;
		this.collections = collections;
		this.viewhistories = viewhistories;
		this.comments = comments;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "userId", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "openid", length = 500)
	public String getOpenid() {
		return this.openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	@Column(name = "nick_name")
	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Column(name = "headimgurl", length = 500)
	public String getHeadimgurl() {
		return this.headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	@Column(name = "sex")
	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	@Column(name = "country")
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "province")
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "city")
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wxuser")
	public Set<Collection> getCollections() {
		return this.collections;
	}

	public void setCollections(Set<Collection> collections) {
		this.collections = collections;
	}

	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wxuser")
	public Set<Viewhistory> getViewhistories() {
		return this.viewhistories;
	}

	public void setViewhistories(Set<Viewhistory> viewhistories) {
		this.viewhistories = viewhistories;
	}

	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wxuser")
	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

}