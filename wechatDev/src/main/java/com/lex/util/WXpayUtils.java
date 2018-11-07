package com.lex.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.lex.model.UNpayOrder;
import com.thoughtworks.xstream.XStream;

public class WXpayUtils {
	public static final String UNIFIEORDERUrl = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	private static final String MCH_ID = "1480401662";
	private static final String SUB_MCH_ID = "1493119132";

	// 对象转XML格式
	public static String UNpayOrderToXml(UNpayOrder order) {
		// TODO Auto-generated method stub
		XStream xStream = new XStream();
		xStream.alias("xml", order.getClass());
		return xStream.toXML(order).replace("__", "_");
	}

	// public static void main(String[] args) {
	// UNpayOrder uNpayOrder = new UNpayOrder("wx2421b1c4370ec43b","支付测试",
	// "JSAPI支付测试", "10000100", "iphone6s_16G",
	// "1add1a30ac87aa2db72f57a2375d8fec",
	// "http://wxpay.wxutil.com/pub_v2/pay/notify.v2.php",
	// "oUpF8uMuAJO_M2pxb1Q9zNjWeS6o", "1415659990", "14.23.150.211", "1",
	// "JSAPI", "0CB01533B8C1EF103065174F50BCA001");
	// String XML=UNpayOrderToXml(uNpayOrder);
	// String xml=XML.replace("__","_");
	// System.out.println(xml);
	// }
	// 普通商户
	public static final String OrderTemp = "appid=APPID&attach=ATTACH&body=BODY&detail=DETAILS&mch_id=MCH_ID&nonce_str=NONCE_STR&notify_url=NOTIFY_URL&openid=OPENID&out_trade_no=OUTTRADENUM&spbill_create_ip=SPBILL_CREATE_IP&sub_mch_id=SUBMCHID&total_fee=TOTAL_FEE&trade_type=JSAPI";

	// 子商户商户
	// public static final String
	// OrderTemp="appid=APPID&attach=ATTACH&body=BODY&detail=DETAILS&mch_id=MCH_ID&nonce_str=NONCE_STR&notify_url=NOTIFY_URL&openid=OPENID&out_trade_no=OUTTRADENUM&spbill_create_ip=SPBILL_CREATE_IP&sub_mch_id=SUBMCHID&total_fee=TOTAL_FEE&trade_type=JSAPI";
	// 下单
	public static Object PreOrder(UNpayOrder order, String openid, String cost,
			HttpServletRequest httpServletRequest) throws Exception {
		// String outtradenum =new Date().getTime()+"ODR"+ Math.random();
		String nonce_str = RandomMathSalution.getRandomStringByLength(31);
		String outtradenum = RandomMathSalution.getRandomStringByLength(31);

		// 获取下单的ip
		String realUploadIp = httpServletRequest.getHeader("x-forwarded-for");
		// 获取sign
		String realOrder = OrderTemp.replace("APPID", WeChatUtils.APPID)
				.replace("ATTACH", "说明").replace("BODY", "JSAPI支付测试")
				.replace("DETAILS", "iphone6s").replace("MCH_ID", MCH_ID)
				.replace("NONCE_STR", nonce_str)
				.replace("NOTIFY_URL", "www.akjiuqian.com")
				.replace("OPENID", openid).replace("OUTTRADENUM", outtradenum)
				.replace("SPBILL_CREATE_IP", "192.168.0.1")
				.replace("TOTAL_FEE", "100").replace("SUBMCHID", SUB_MCH_ID);
		if (cost != "") {
			realOrder = OrderTemp.replace("APPID", WeChatUtils.APPID)
					.replace("ATTACH", "说明").replace("BODY", "JSAPI支付测试")
					.replace("DETAILS", "iphone6s").replace("MCH_ID", MCH_ID)
					.replace("NONCE_STR", nonce_str)
					.replace("NOTIFY_URL", "www.akjiuqian.com")
					.replace("OPENID", openid)
					.replace("OUTTRADENUM", outtradenum)
					.replace("SPBILL_CREATE_IP", "192.168.0.1")
					.replace("TOTAL_FEE", cost).replace("SUBMCHID", SUB_MCH_ID);
		}
		String stringSignTemp = realOrder
				+ "&key=q1n2k3j4d7f9dk4mg5kd8rlf9d03mfir";
		System.out.println("---------" + stringSignTemp
				+ "----------------------");
		String sign = WXPayUtil.MD5(stringSignTemp);
		// String sign=DecriptUtil.MD5(stringSignTemp).toUpperCase();
		System.err.println("sign");
		System.err.println(sign);
		// Order转XML格式1
		order.setOpenid(openid);
		order.setAppid(WeChatUtils.APPID);
		order.setAttach("说明");
		order.setBody("JSAPI支付测试");
		order.setDetail("iphone6s");
		order.setMch_id(MCH_ID);
		order.setSub_mch_id(SUB_MCH_ID);
		order.setNonce_str(nonce_str);
		order.setNotify_url("www.akjiuqian.com");
		order.setOpenid(openid);
		order.setOut_trade_no(outtradenum);
		order.setSpbill_create_ip("192.168.0.1");
		order.setTotal_fee("100");
		if (cost != "") {
			order.setTotal_fee(cost);
		}
		order.setTrade_type("JSAPI");
		order.setSign(sign);
		System.out.println("用户签名为" + sign);
		String orderXMLData = UNpayOrderToXml(order);
		System.out.println(orderXMLData);
		String propareOrder = WeChatUtils.doPOSTStrtoString(UNIFIEORDERUrl,
				orderXMLData);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("propareOrder", propareOrder);
		data.put("APPID", WeChatUtils.APPID);
		data.put("KEY", "q1n2k3j4d7f9dk4mg5kd8rlf9d03mfir");

		System.out.println(propareOrder);
		return data;
	}
}
