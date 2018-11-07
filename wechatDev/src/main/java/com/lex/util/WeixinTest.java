package com.lex.util;

import net.sf.json.JSONObject;

import com.lex.model.AccessToken;

public class WeixinTest {
	public static void main(String[] args) {

		// try {
		AccessToken accessToken = WeChatUtils.getAccessToken();
		System.out.println(accessToken.getToken());

		// 生成微信菜单
		String menu = JSONObject.fromObject(WeChatUtils.initMenu()).toString();
		int result = WeChatUtils.createMenu(accessToken.getToken(), menu);
		System.out.println(result);
		System.out.println("accessToken" + accessToken.getToken());
		System.out.println("返回时间" + accessToken.getExpiresIn());
		// String imgpath="D:/笑脸.jpg";
		// String medalId;
		// try {
		// medalId = WeChatUtils.upload(imgpath,
		// accessToken.getToken(),"image");
		// System.out.println("--------------------"+medalId);
		// } catch (KeyManagementException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (NoSuchAlgorithmException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (NoSuchProviderException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// } catch (KeyManagementException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (NoSuchAlgorithmException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (NoSuchProviderException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// }

		// try {
		// JSONObject jsonObject =
		// WeChatUtils.deleteMenu(accessToken.getToken());
		// System.out.println(jsonObject.toString());
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}
}