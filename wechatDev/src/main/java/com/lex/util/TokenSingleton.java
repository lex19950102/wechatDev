package com.lex.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenSingleton {
    //缓存accessToken 的Map  ,map中包含 一个accessToken 和 缓存的时间戳
    //当然也可以分开成两个属性咯

    public final static String weixin_jssdk_ticket_url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";

    private static Map<String, String> map = new HashMap<String, String>();

    private TokenSingleton() {
    }

    private static TokenSingleton single = null;

    // 静态工厂方法
    public static TokenSingleton getInstance() {
        if (single == null) {
            single = new TokenSingleton();
        }
        return single;
    }

    public static  Map<String, String> getMap() throws Exception {
        String time = map.get("time");
        String accessToken = map.get("access_token");
        Long nowDate = new Date().getTime();
        
        if (accessToken != null && time != null && nowDate - Long.parseLong(time) < 3000 * 1000) {
//            result = accessToken;
            System.out.println("accessToken存在，且没有超时 ， 返回单例");
        } else {
            System.out.println("accessToken 超时 ， 或者不存在 ， 重新获取");
//            System.out.println("weixinAccountService : " + weixinAccountService);
            String access_token=WeChatUtils.getAccessToken().getToken();
                    //"这里是直接调用微信的API去直接获取 accessToken 和Jsapi_ticket 获取";
            String jsapi_ticket = getJsapiToken(access_token);
                    //"获取jsapi_token";
            map.put("time", nowDate + "");
            map.put("access_token", access_token);
            map.put("jsapi_ticket", jsapi_ticket);
//            result = access_token;
        }
        
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public static TokenSingleton getSingle() {
        return single;
    }

    public static void setSingle(TokenSingleton single) {
        TokenSingleton.single = single;
    }
    
    
    public static  String getJsapiToken(String accessToken) throws Exception{
        //获取jsapi_ticket
        System.out.println("获取jsapi_ticket");
        String jsapi_Url = weixin_jssdk_ticket_url.replace("ACCESS_TOKEN", accessToken);
        String jsapi_ticket = null;
        net.sf.json.JSONObject jsonObject = WeChatUtils.doGetStr(jsapi_Url);  
        
        System.out.println("请求返回数据： " + jsonObject);
        
        // 如果请求成功   
        if (null != jsonObject) {  
            System.out.println("jsapi_ticket  :  "+jsonObject);
            jsapi_ticket=jsonObject.getString("ticket");  
        }
        
        return jsapi_ticket;
    }
    
    
}