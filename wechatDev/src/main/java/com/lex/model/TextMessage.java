package com.lex.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "textmsg", catalog = "wechatdevolopment")
public class TextMessage extends BaseMessage{
@Id
@GeneratedValue
@Column(name = "textId", unique = true, nullable = false)
private int textId;
	
private String Content;
private String MsgId;

@Column(name = "content", nullable = false)
public String getContent() {
	return Content;
}
public void setContent(String content) {
	Content = content;
}
@Column(name = "MsgId", nullable = false)
public String getMsgId() {
	return MsgId;
}
public int getTextId() {
	return textId;
}
public void setTextId(int textId) {
	this.textId = textId;
}
public void setMsgId(String msgId) {
	MsgId = msgId;
}

}
