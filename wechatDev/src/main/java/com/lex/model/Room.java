package com.lex.model;
// default package

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



/**
 * Room entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "room", catalog = "jiuqian")
public class Room implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer wxappid;
	private Integer hotelId;
	private String guestId;
	private String floor;
	private String area;
	private String live;
	private Integer price;
	private Integer number;
	private Integer isWindow;
	private Integer isWifi;
	private Integer isState;
	private Integer isDelete;
	private Integer isTj;
	private String img;
	private Set<Label> labels;
	// Constructors

	/** default constructor */
	public Room() {
	}
	
    @OneToMany(cascade=CascadeType.ALL,mappedBy="room") 
	public Set<Label> getLabels() {
		return labels;
	}

	public void setLabels(Set<Label> labels) {
		this.labels = labels;
	}

	/** minimal constructor */
	public Room(Integer isDelete) {
		this.isDelete = isDelete;
	}

	/** full constructor */


	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public Room(Integer id, Integer wxappid, Integer hotelId, String guestId,
			String floor, String area, String live, Integer price,
			Integer number, Integer isWindow, Integer isWifi, Integer isState,
			Integer isDelete, Integer isTj, String img, Set<Label> labels) {
		super();
		this.id = id;
		this.wxappid = wxappid;
		this.hotelId = hotelId;
		this.guestId = guestId;
		this.floor = floor;
		this.area = area;
		this.live = live;
		this.price = price;
		this.number = number;
		this.isWindow = isWindow;
		this.isWifi = isWifi;
		this.isState = isState;
		this.isDelete = isDelete;
		this.isTj = isTj;
		this.img = img;
		this.labels = labels;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "wxappid")
	public Integer getWxappid() {
		return this.wxappid;
	}

	public void setWxappid(Integer wxappid) {
		this.wxappid = wxappid;
	}

	@Column(name = "hotel_id")
	public Integer getHotelId() {
		return this.hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	@Column(name = "guest_id")
	public String getGuestId() {
		return this.guestId;
	}

	public void setGuestId(String guestId) {
		this.guestId = guestId;
	}

	@Column(name = "floor")
	public String getFloor() {
		return this.floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	@Column(name = "area")
	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Column(name = "live")
	public String getLive() {
		return this.live;
	}

	public void setLive(String live) {
		this.live = live;
	}

	@Column(name = "price")
	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Column(name = "number")
	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@Column(name = "is_window")
	public Integer getIsWindow() {
		return this.isWindow;
	}

	public void setIsWindow(Integer isWindow) {
		this.isWindow = isWindow;
	}

	@Column(name = "is_wifi")
	public Integer getIsWifi() {
		return this.isWifi;
	}

	public void setIsWifi(Integer isWifi) {
		this.isWifi = isWifi;
	}

	@Column(name = "is_state")
	public Integer getIsState() {
		return this.isState;
	}

	public void setIsState(Integer isState) {
		this.isState = isState;
	}

	@Column(name = "is_delete", nullable = false)
	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	@Column(name = "is_tj")
	public Integer getIsTj() {
		return this.isTj;
	}

	public void setIsTj(Integer isTj) {
		this.isTj = isTj;
	}

	@Column(name = "img", length = 500)
	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}