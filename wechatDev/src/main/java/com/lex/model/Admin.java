package com.lex.model;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "admin", catalog = "huoguodian")
public class Admin implements java.io.Serializable {

	// Fields

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", EMail=" + EMail + ", password="
				+ password + ", adminName=" + adminName + ", adminAuth="
				+ adminAuth + "]";
	}

	private Integer adminId;
	private String EMail;
	private String password;
	private String adminName;
	private Integer adminAuth;

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** full constructor */
	public Admin(String EMail, String password, String adminName,
			Integer adminAuth) {
		this.EMail = EMail;
		this.password = password;
		this.adminName = adminName;
		this.adminAuth = adminAuth;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "admin_id", unique = true, nullable = false)
	public Integer getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	@Column(name = "e_mail")
	public String getEMail() {
		return this.EMail;
	}

	public void setEMail(String EMail) {
		this.EMail = EMail;
	}

	@Column(name = "password", length = 500)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "admin_name")
	public String getAdminName() {
		return this.adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	@Column(name = "admin_auth")
	public Integer getAdminAuth() {
		return this.adminAuth;
	}

	public void setAdminAuth(Integer adminAuth) {
		this.adminAuth = adminAuth;
	}

}