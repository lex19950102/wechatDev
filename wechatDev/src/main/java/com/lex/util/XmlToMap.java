package com.lex.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Controller;

import com.lex.model.Image;
import com.lex.model.ImageMessage;
import com.lex.model.NEWS;
import com.lex.model.NewsMessage;
import com.lex.model.TextMessage;
import com.thoughtworks.xstream.XStream;

@Controller
public class XmlToMap {

	public static final String MESSAGE_TEXT = "text";
	public static final String MESSAGE_IMAGE = "image";
	public static final String MESSAGE_VOICE = "voice";
	public static final String MESSAGE_LINK = "link";
	public static final String MESSAGE_VIDEO = "video";
	public static final String MESSAGE_LOCATION = "location";
	public static final String MESSAGE_EVENT = "event";
	public static final String MESSAGE_SUB = "subscribe";
	public static final String MESSAGE_UNSUB = "unsubscribe";
	public static final String MESSAGE_CLICK = "CLICK";
	public static final String MESSAGE_VIEW = "VIEW";
	public static final String MESSAGE_NEWS = "news";
	public static final String MESSAGE_SCANCODE = "scancode_push";

	/*
	 * XML转Map
	 */
	public static Map<String, String> XmlToMap(
			HttpServletRequest httpServletRequest) throws IOException,
			DocumentException {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		SAXReader saxReader = new SAXReader();
		InputStream inputStream = httpServletRequest.getInputStream();
		Document doc = saxReader.read(inputStream);
		Element rootElement = doc.getRootElement();
		List<Element> list = rootElement.elements();
		for (Element element : list) {
			hashMap.put(element.getName(), element.getText());
		}
		inputStream.close();
		return hashMap;
	}

	public static String textMessageToXml(TextMessage message) {
		// TODO Auto-generated method stub
		XStream xStream = new XStream();
		xStream.alias("xml", message.getClass());
		return xStream.toXML(message);
	}

	public static String Init(String toUserName, String fromUserName,
			String content) {
		TextMessage message = new TextMessage();
		message.setFromUserName(toUserName);
		message.setToUserName(fromUserName);
		message.setMsgType(MESSAGE_TEXT);
		message.setCreateTime(new Date().getTime());
		message.setContent(content);

		return XmlToMap.textMessageToXml(message);
	}

	public static String menuText() {
		StringBuffer sbBuffer = new StringBuffer();
		sbBuffer.append("欢迎你的关注，请操作：\n\n");
		sbBuffer.append("1.功能介绍\n\n");
		sbBuffer.append("2.与我联系\n\n");
		sbBuffer.append("3.帮助开发\n\n");
		sbBuffer.append("?.回复序号调出菜单\n\n");
		return sbBuffer.toString();
	}

	// 图文消息MAP转Xml \
	public static String newsMessageToXml(NewsMessage newsMessage) {
		// TODO Auto-generated method stub
		XStream xStream = new XStream();
		xStream.alias("xml", newsMessage.getClass());
		xStream.alias("item", new NEWS().getClass());
		return xStream.toXML(newsMessage);
	}

	// 图文消息的组装
	public static String InitNewsMessage(String toUserName,
			String fromUserName, List<NEWS> newslist) {
		String message = null;

		NewsMessage newsMessage = new NewsMessage();
		// NEWS news = new NEWS();
		// String NewsUrl="https://user.qzone.qq.com/274164963/infocenter";
		// if (null!=content&&""!=content) {
		// NewsUrl+="?NewsId="+content;
		// }
		// news.setTitle("newstest");
		// news.setDescription("just for test news message");
		// news.setPicUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1503897656865&di=210c6a47a33d580458d3b896474b6879&imgtype=0&src=http%3A%2F%2Fimg2.niutuku.com%2Fdesk%2F1212%2F2236%2F2236-ntk35334.jpg");
		// news.setUrl(NewsUrl);

		// newslist.add(news);

		newsMessage.setToUserName(fromUserName);
		newsMessage.setFromUserName(toUserName);
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(MESSAGE_NEWS);
		newsMessage.setArticles(newslist);
		newsMessage.setArticleCount(newslist.size());
		message = newsMessageToXml(newsMessage);
		System.out.println(message.toString());
		return message;
	}

	// 图片消息组装
	public static String InitImageMessage(String toUserName,
			String fromUserName, String Picurl) {
		String message = null;
		Image image = new Image();

		ImageMessage imageMessage = new ImageMessage();
		imageMessage
				.setMediaId("leZNbWEmZLsBuL-93PcFp_Izhs6UAtDY4wA_sVa86z6onIqiJCNzCaXu1P2-v38g");
		imageMessage.setFromUserName(toUserName);
		imageMessage.setToUserName(fromUserName);
		imageMessage.setMsgType(MESSAGE_IMAGE);
		imageMessage.setCreateTime(new Date().getTime());
		imageMessage.setPicUrl(Picurl);
		imageMessage.setMsgId(1);
		message = imageMessageToXml(imageMessage);
		return message;
	}

	// 图片消息转XML
	public static String imageMessageToXml(ImageMessage message) {
		// TODO Auto-generated method stub
		XStream xStream = new XStream();
		xStream.alias("xml", message.getClass());
		return xStream.toXML(message);
	}

}
