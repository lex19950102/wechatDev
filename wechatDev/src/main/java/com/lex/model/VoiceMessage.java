package com.lex.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="audiomsg")
public class VoiceMessage extends BaseMessage{
	@Id
	private int audioId;
	public int getAudioId() {
		return audioId;
	}
	public void setAudioId(int audioId) {
		this.audioId = audioId;
	}
	private String Format;
	private String MediaId;
	private String MsgID;
	public String getFormat() {
		return Format;
	}
	public void setFormat(String format) {
		Format = format;
	}
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getMsgID() {
		return MsgID;
	}
	public void setMsgID(String msgID) {
		MsgID = msgID;
	}

}
