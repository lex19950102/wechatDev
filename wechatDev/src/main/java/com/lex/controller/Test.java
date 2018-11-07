package com.lex.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lex.model.NEWS;
import com.lex.model.TextMessage;
import com.lex.model.UNpayOrder;
import com.lex.service.NewsService;
import com.lex.service.WechatInterface;
import com.lex.util.AuthUtils;
import com.lex.util.CallBackServlet;
import com.lex.util.CheckSignature;
import com.lex.util.LoginServlet;
import com.lex.util.TokenSingleton;
import com.lex.util.WXpayUtils;
import com.lex.util.WeChatUtils;
import com.lex.util.XmlToMap;

@Controller
@RequestMapping("wechat")
public class Test {

	@Resource(name = "wechat")
	WechatInterface wechatImp;
	@Resource(name = "newsImp")
	NewsService newsService;

	@RequestMapping(value = "signature", method = RequestMethod.GET)
	public void hello(String signature, String timestamp, String nonce,
			String echostr, HttpServletResponse httpServletResponse)
			throws Exception {
		if (CheckSignature.checkSignature(signature, timestamp, nonce, echostr)) {
			httpServletResponse.getWriter().print(echostr);
		}
	}

	@RequestMapping(value = "testc")
	@ResponseBody
	public Object testc() {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("testmsg", "dsasdas");
		data.put("code", "1000");
		return data;
	}

	// 公众号入口
	@RequestMapping(value = "signature", method = RequestMethod.POST)
	public void getMessage(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		httpServletRequest.setCharacterEncoding("UTF-8");
		httpServletResponse.setCharacterEncoding("UTF-8");
		PrintWriter printWriter = httpServletResponse.getWriter();
		try {
			Map<String, String> map = XmlToMap.XmlToMap(httpServletRequest);
			String fromUserName = map.get("FromUserName");
			String toUserName = map.get("ToUserName");
			String msgType = map.get("MsgType");
			String content = map.get("Content");
			System.err.println("content=" + content);
			String message = null;
			if ("text".equals(msgType)) {
				if ("1".equals(content)) {
					message = XmlToMap.Init(toUserName, fromUserName, "自行体会");
				} else if ("2".equals(content)) {
					message = XmlToMap.Init(toUserName, fromUserName,
							"加我的qq:274164963或扫描下方二维码");
				} else if ("3".equals(content)) {
					message = XmlToMap.Init(toUserName, fromUserName,
							"红红火火还好还好呵呵呵呵还好还好\n其余面议");

				} else if ("？".equals(content) || "?".equals(content)) {
					message = XmlToMap.Init(toUserName, fromUserName,
							"回复？查看菜单回复？");
				} else if ("news".equals(content) || "News".equals(content)) {

					// message=XmlToMap.InitNewsMessage(toUserName,
					// fromUserName,content);
				} else if ("jpg".equals(content)) {
					message = XmlToMap.InitImageMessage(toUserName,
							fromUserName, "http://www.akjiuqian.com/yue");
					//
				} else if (content.equals("新闻列表")) {
					System.out.println("into1");
					List<NEWS> newslist = newsService.findNews(content);
					message = XmlToMap.InitNewsMessage(toUserName,
							fromUserName, newslist);
				} else {
					TextMessage textmessage = new TextMessage();
					textmessage.setFromUserName(toUserName);
					textmessage.setToUserName(fromUserName);
					textmessage.setMsgType("text");
					textmessage.setCreateTime(new Date().getTime());
					textmessage.setContent("你发送的信息成功" + content);
					message = XmlToMap.textMessageToXml(textmessage);
				}
			} else if (XmlToMap.MESSAGE_EVENT.equals(msgType)) {
				String eventType = map.get("Event");
				if (XmlToMap.MESSAGE_SUB.equals(eventType)) {
					message = XmlToMap.Init(toUserName, fromUserName,
							XmlToMap.menuText());
				} else if (XmlToMap.MESSAGE_CLICK.equals(eventType)) {
					message = XmlToMap.Init(toUserName, fromUserName,
							XmlToMap.menuText());
				} else if (XmlToMap.MESSAGE_VIEW.equals(eventType)) {
					String url = map.get("EventKey");
					message = XmlToMap.Init(toUserName, fromUserName, url);
				} else if (XmlToMap.MESSAGE_SCANCODE.equals(eventType)) {
					String key = map.get("EventKey");
					message = XmlToMap.Init(toUserName, fromUserName, key);
				}
			} else if (XmlToMap.MESSAGE_LOCATION.equals(msgType)) {
				String Label = map.get("Label");
				System.out.println("lable==============" + Label);
				message = XmlToMap.Init(toUserName, fromUserName, Label);
			}

			System.out.println(message);

			printWriter.print(message);

		} catch (Exception e) {
			// TODO: handle exception
		} finally {

			printWriter.close();
		}

	}

	// 回调地址
	@RequestMapping(value = "callback", method = RequestMethod.GET)
	@ResponseBody
	public void callBack(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String code = request.getParameter("code");
		System.out.println("进入回调");
		String AuthLog = "";
		AuthLog = CallBackServlet.Authorlog.replace("APPID", WeChatUtils.APPID)
				.replace("SECRET", WeChatUtils.APP_SECRET)
				.replace("CODE", code);

		JSONObject doGetJson = AuthUtils.doGetJson(AuthLog);

		String openid = doGetJson.getString("openid");

		System.out.println("openid" + openid);
		// String access_token =WeChatUtils.getAccessToken().getToken();
		String access_token = TokenSingleton.getMap().get("access_token");
		String baseUrlString = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
		String baseUrl = baseUrlString.replace("ACCESS_TOKEN", access_token)
				.replace("OPENID", openid);
		JSONObject userInfo = AuthUtils.doGetJson(baseUrl);

		System.out.println(userInfo);

		// finalopenid=openid;
		request.setAttribute("openid", openid);
		response.sendRedirect("http://www.akjiuqian.com/wxjssdk/index.html?openid="
				+ openid);

	}

	// 授权地址
	@RequestMapping(value = "authLogin", method = RequestMethod.GET)
	@ResponseBody
	public void authLogin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		System.out.println("进入授权");
		String backUrl = "http://www.akjiuqian.com/wechatPS/wechat/callback";
		// String backUrl="/wechatPS/wechat/callback";
		String authurl = "";
		authurl = LoginServlet.AuthURL.replace("APPID", WeChatUtils.APPID)
				.replace("REDIRECT_URI", URLEncoder.encode(backUrl))
				.replace("SCOPE", "snsapi_userinfo");
		authurl = LoginServlet.AuthURL.replace("APPID", WeChatUtils.APPID)
				.replace("REDIRECT_URI", URLEncoder.encode(backUrl))
				.replace("SCOPE", "snsapi_base");
		System.out.println(authurl);
		// LoginServlet.AuthURL.replace("REDIRECT_URI", token);
		response.sendRedirect(authurl);
		// return finalopenid;
		// return request.getAttribute("openid");
	}

	// 统一下单
	@RequestMapping(value = "unifiedorder", method = RequestMethod.POST)
	@ResponseBody
	public Object unifiedorder(String openid, String cost,
			HttpServletRequest httpServletRequest, UNpayOrder uNpayOrder)
			throws Exception {
		System.out.println(openid + "++++++++openid");
		System.out.println(cost + "++++++++cost");
		UNpayOrder order = new UNpayOrder();
		return WXpayUtils.PreOrder(order, openid, cost, httpServletRequest);
	}

	// 获取JS签名
	@RequestMapping(value = "getWXConfig", method = RequestMethod.POST)
	@ResponseBody
	public Object getWXConfig(String URL) throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("data", wechatImp.getConfig(URL));
		return data;
	}

	// 获取房间
	@ResponseBody
	@RequestMapping(value = "getRoom")
	public Object getRoom() throws Exception {
		Map<String, Object> map = new java.util.HashMap<String, Object>();
		map.put("data", wechatImp.getRoom());
		return map;
	}

	@ResponseBody
	@RequestMapping("testHibernate")
	public Object testHibernate(String Id) throws Exception {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("testdata", wechatImp.testHibernate(Id));
		return data;
	}

	@ResponseBody
	@RequestMapping("testJdbctemplate")
	public Object testJdbctemplate(String Id) throws Exception {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("testdata", wechatImp.testJdbctemplate(Id));
		return data;
	}
}
