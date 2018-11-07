package com.lex.util;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.http.client.ClientProtocolException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CallBackServlet {
public static final String  Authorlog="https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
//	@RequestMapping(value="callback",method = RequestMethod.GET)
//	@ResponseBody
//	public void callBack(HttpServletRequest request,HttpServletResponse response) throws ClientProtocolException, IOException {
//		String code = request.getParameter("code");
//		CallBackServlet.Authorlog.replace("APPID", WeChatUtils.APPID);
//		CallBackServlet.Authorlog.replace("SECRET", WeChatUtils.APP_SECRET);
////		CallBackServlet.Authorlog.replace("REDIRECT_URI", URLEncoder.encode(backUrl));
//		CallBackServlet.Authorlog.replace("code", code);
//		CallBackServlet.Authorlog.replace("SCOPE", "snsapi_base");
//		JSONObject doGetJson = AuthUtils.doGetJson(Authorlog);
//		
//		String openid = doGetJson.getString("openid");
//		System.out.println("openid"+openid);
//		String access_token = doGetJson.getString("access_token");
//	}
	
}
