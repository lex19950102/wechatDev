package com.lex.model.userComment;

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
 * Comment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "comment", catalog = "secondhandcarservice")
public class Comment implements java.io.Serializable {

	// Fields

	private Integer commentId;
	private Goods goods;
	private Wxuser wxuser;
	private String commentContent;
	private Integer comentSubscribe;
	private Integer isSecond;

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** minimal constructor */
	public Comment(Integer commentId) {
		this.commentId = commentId;
	}

	/** full constructor */
	public Comment(Integer commentId, Goods goods, Wxuser wxuser,
			String commentContent, Integer comentSubscribe, Integer isSecond) {
		this.commentId = commentId;
		this.goods = goods;
		this.wxuser = wxuser;
		this.commentContent = commentContent;
		this.comentSubscribe = comentSubscribe;
		this.isSecond = isSecond;
	}

	// Property accessors
	@Id
	@Column(name = "commentId", unique = true, nullable = false)
	public Integer getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "goodsId")
	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	public Wxuser getWxuser() {
		return this.wxuser;
	}

	public void setWxuser(Wxuser wxuser) {
		this.wxuser = wxuser;
	}

	@Column(name = "commentContent")
	public String getCommentContent() {
		return this.commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	@Column(name = "comentSubscribe")
	public Integer getComentSubscribe() {
		return this.comentSubscribe;
	}

	public void setComentSubscribe(Integer comentSubscribe) {
		this.comentSubscribe = comentSubscribe;
	}

	@Column(name = "IsSecond")
	public Integer getIsSecond() {
		return this.isSecond;
	}

	public void setIsSecond(Integer isSecond) {
		this.isSecond = isSecond;
	}

}