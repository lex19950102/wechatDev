package com.lex.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;

public class AuthUtils {
	
	//授权登录配置
	public static JSONObject doGetJson(String url) throws ClientProtocolException, IOException{
		JSONObject jsonObject =null;
		DefaultHttpClient client =new DefaultHttpClient();
		HttpGet httpGet =new HttpGet(url);
		CloseableHttpResponse execute = client.execute(httpGet);
		HttpEntity entity = execute.getEntity();
		if (entity!=null) {
			String result=EntityUtils.toString(entity,"UTF-8");
      jsonObject = JSONObject.fromObject(result);	
		}
		httpGet.releaseConnection();
		return jsonObject;
	}
//POST请求
	@SuppressWarnings({ "deprecation", "resource" })
	public static JSONObject doPOSTStr(String url,String outStr){
	DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
	HttpPost post = new HttpPost(url);
	JSONObject jsonObject=null;

	try {
	post.setEntity(new StringEntity(outStr,"UTF-8"));
	HttpResponse httpResponse = defaultHttpClient.execute(post);
	String result=EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
	jsonObject = JSONObject.fromObject(result);
		
	} catch (ClientProtocolException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return jsonObject;
	}
}
