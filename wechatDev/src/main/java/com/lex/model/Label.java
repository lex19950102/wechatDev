package com.lex.model;
// default package

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;




/**
 * Label entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="label"
    ,catalog="jiuqian"
)

public class Label  implements java.io.Serializable {


    // Fields    

     private Integer labelId;
     private String lableName;
//     private Integer roomId;
  	private Room room;

    // Constructors
    @JsonBackReference
    @ManyToOne(cascade={CascadeType.ALL})           
    @JoinColumn(name="roomId")    
     public Room getRoom() {
		return room;
	}


	public void setRoom(Room room) {
		this.room = room;
	}


	/** default constructor */
    public Label() {
    }

    
    /** full constructor */
    public Label(String lableName) {
        this.lableName = lableName;
//        this.roomId = roomId;
    }

   
    // Property accessors
    @Id @GeneratedValue
    
    @Column(name="label_id", unique=true, nullable=false)

    public Integer getLabelId() {
        return this.labelId;
    }
    
    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }
    
    @Column(name="lable_name")

    public String getLableName() {
        return this.lableName;
    }
    
    public void setLableName(String lableName) {
        this.lableName = lableName;
    }
    
//    @Column(name="room_id")

//    public Integer getRoomId() {
//        return this.roomId;
//    }
//    
//    public void setRoomId(Integer roomId) {
//        this.roomId = roomId;
//    }
   







}