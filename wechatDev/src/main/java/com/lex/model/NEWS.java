package com.lex.model;

import javax.persistence.Entity;
import javax.persistence.Table;

public class NEWS {
@Override
	public String toString() {
		return "NEWS [Title=" + Title + ", Description=" + Description
				+ ", PicUrl=" + PicUrl + ", Url=" + Url + "]";
	}
public String Title;
public String Description;
public String PicUrl;
public NEWS(String title, String description, String picUrl, String url) {
	super();
	Title = title;
	Description = description;
	PicUrl = picUrl;
	Url = url;
}
public String getTitle() {
	return Title;
}
public void setTitle(String title) {
	Title = title;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
public String getPicUrl() {
	return PicUrl;
}
public NEWS() {
	super();
}
public void setPicUrl(String picUrl) {
	PicUrl = picUrl;
}
public String getUrl() {
	return Url;
}
public void setUrl(String url) {
	Url = url;
}
public String Url;

}
