package com.lex.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.lex.model.AccessToken;
import com.lex.model.Button;
import com.lex.model.ClickButton;
import com.lex.model.Menu;
import com.lex.model.ViewButton;

public class WeChatUtils {
	public static final String APPID = "wxf55b966de8098c1f";
	// 服务商账号
	// public static final String APPID="wx98be4b18b13b18b6";
	public static final String APP_SECRET = "3578a648a860645cd597ac60443d9bd3";
	// 服务商密匙
	// public static final String APP_SECRET="1308688632a3db3387abaeb0bef49fd6";
	public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	private static final String UPLOAD_URL = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";

	private static final String MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	// 自定义菜单查询接口
	private static final String MENU_SEARCH = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	// 自定义菜单的删除
	private static final String MENU_DELETE = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	private static final String UnifiedOrder = "https://api.mch.weixin.qq.com/pay/unifiedorder";

	@SuppressWarnings("deprecation")
	public static JSONObject doGetStr(String url) throws Exception {

		DefaultHttpClient defaultHttpClient = new DefaultHttpClient();

		JSONObject jsonObject = null;
		try {
			HttpGet httpGet = new HttpGet(url);
			HttpResponse httpResponse = defaultHttpClient.execute(httpGet);
			HttpEntity entity = httpResponse.getEntity();
			if (entity != null) {
				String result = EntityUtils.toString(entity);
				jsonObject = JSONObject.fromObject(result);
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonObject;
	}

	// post请求处理方式、

	@SuppressWarnings({ "deprecation", "resource" })
	public static JSONObject doPOSTStr(String url, String outStr) {
		DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		JSONObject jsonObject = null;

		try {
			post.setEntity(new StringEntity(outStr, "UTF-8"));
			HttpResponse httpResponse = defaultHttpClient.execute(post);
			String result = EntityUtils.toString(httpResponse.getEntity(),
					"UTF-8");
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

	@SuppressWarnings({ "deprecation", "resource" })
	public static String doPOSTStrtoString(String url, String outStr) {
		DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		String result = null;

		try {
			post.setEntity(new StringEntity(outStr, "UTF-8"));
			HttpResponse httpResponse = defaultHttpClient.execute(post);
			result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
			// jsonArray = JSONArray.fromObject(result);

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public static AccessToken getAccessToken() {
		AccessToken accessToken = new AccessToken();
		String url = ACCESS_TOKEN_URL.replace("APPID", APPID).replace(
				"APPSECRET", APP_SECRET);
		JSONObject jsonObject;
		try {
			jsonObject = doGetStr(url);

			if (jsonObject != null) {
				accessToken.setToken(jsonObject.getString("access_token"));
				accessToken.setExpiresIn(jsonObject.getInt("expires_in"));

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accessToken;
	}

	public static String upload(String filePath, String accessToken, String type)
			throws IOException, NoSuchAlgorithmException,
			NoSuchProviderException, KeyManagementException {
		File file = new File(filePath);
		if (!file.exists() || !file.isFile()) {
			throw new IOException("文件不存在");
		}

		String url = UPLOAD_URL.replace("ACCESS_TOKEN", accessToken).replace(
				"TYPE", type);

		URL urlObj = new URL(url);
		// 连接
		HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();

		con.setRequestMethod("POST");
		con.setDoInput(true);
		con.setDoOutput(true);
		con.setUseCaches(false);

		// 设置请求头信息
		con.setRequestProperty("Connection", "Keep-Alive");
		con.setRequestProperty("Charset", "UTF-8");

		// 设置边界
		String BOUNDARY = "----------" + System.currentTimeMillis();
		con.setRequestProperty("Content-Type", "multipart/form-data; boundary="
				+ BOUNDARY);

		StringBuilder sb = new StringBuilder();
		sb.append("--");
		sb.append(BOUNDARY);
		sb.append("\r\n");
		sb.append("Content-Disposition: form-data;name=\"file\";filename=\""
				+ file.getName() + "\"\r\n");
		sb.append("Content-Type:application/octet-stream\r\n\r\n");

		byte[] head = sb.toString().getBytes("utf-8");

		// 获得输出流
		OutputStream out = new DataOutputStream(con.getOutputStream());
		// 输出表头
		out.write(head);

		// 文件正文部分
		// 把文件已流文件的方式 推入到url中
		DataInputStream in = new DataInputStream(new FileInputStream(file));
		int bytes = 0;
		byte[] bufferOut = new byte[1024];
		while ((bytes = in.read(bufferOut)) != -1) {
			out.write(bufferOut, 0, bytes);
		}
		in.close();

		// 结尾部分
		byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线

		out.write(foot);

		out.flush();
		out.close();

		StringBuffer buffer = new StringBuffer();
		BufferedReader reader = null;
		String result = null;
		try {
			// 定义BufferedReader输入流来读取URL的响应
			reader = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			if (result == null) {
				result = buffer.toString();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
		}

		JSONObject jsonObj = JSONObject.fromObject(result);
		System.out.println(jsonObj);
		String typeName = "media_id";
		if (!"image".equals(type)) {
			typeName = type + "_media_id";
		}
		String mediaId = jsonObj.getString(typeName);
		return mediaId;
	}

	// 生产菜单
	public static Menu initMenu() {
		Menu menu = new Menu();

		ClickButton clickButton11 = new ClickButton();
		clickButton11.setName("热门二手车");
		clickButton11.setType("click");
		clickButton11.setKey("11");

		ViewButton viewButton21 = new ViewButton();
		viewButton21.setName("最新上架");
		viewButton21.setType("view");
		viewButton21.setUrl("http://atlwb.tunnel.echomod.cn/经典款/phonepay.html");

		ClickButton clickButton31 = new ClickButton();
		clickButton31.setName("我要出售");
		clickButton31.setType("click");
		clickButton31.setKey("31");

		ClickButton clickButton32 = new ClickButton();
		clickButton32.setName("位置");
		clickButton32.setType("location_select");
		clickButton32.setKey("32");

		Button button3 = new Button();
		button3.setName("菜单");
		button3.setSub_button(new Button[] { clickButton31, clickButton32 });
		menu.setButton(new Button[] { clickButton11, viewButton21, button3 });
		return menu;
	}

	public static int createMenu(String token, String menu) {
		int result = 0;
		String url = MENU_URL.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = doPOSTStr(url, menu);
		if (jsonObject != null) {
			result = jsonObject.getInt("errcode");
		}

		return result;

	}

	public static JSONObject queryMenu(String token) throws Exception {
		String url = MENU_SEARCH.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = doGetStr(url);
		return jsonObject;
	}

	public static JSONObject deleteMenu(String token) throws Exception {
		String url = MENU_DELETE.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = doGetStr(url);
		return jsonObject;
	}
}
