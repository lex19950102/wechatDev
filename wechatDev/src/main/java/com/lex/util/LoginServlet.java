package com.lex.util;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginServlet {
	public static final String AuthURL="https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
	
//	@RequestMapping(value="authLogin",method = RequestMethod.GET)
//	@ResponseBody
//	public void authLogin(HttpServletRequest request,HttpServletResponse response) throws IOException{
//		String backUrl="/WxAuth/callback";
//		LoginServlet.AuthURL.replace("APPID", WeChatUtils.APPID);
//		LoginServlet.AuthURL.replace("REDIRECT_URI", URLEncoder.encode(backUrl));
////		LoginServlet.AuthURL.replace("code", token);
//		LoginServlet.AuthURL.replace("SCOPE", "snsapi_base");
//		
//	
////		LoginServlet.AuthURL.replace("REDIRECT_URI", token);
//		response.sendRedirect(LoginServlet.AuthURL);
//		
//	}
}
