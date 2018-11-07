package com.lex.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lex.dao.BaseServiceSupport;
import com.lex.service.WechatInterface;
import com.lex.util.Sha1;
import com.lex.util.TokenSingleton;

@Service("wechat")
public class WechatImp extends BaseServiceSupport implements WechatInterface {

	@Autowired
	JdbcTemplate jdbcTemplate;
	public static final String SIGN_STR = "jsapi_ticket=JS_TICKET&noncestr=NONCE_STR&timestamp=TIME_STAMP&url=URL";

	public Object getConfig(String URL) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(URL);
		// String accesstoken= WeChatUtils.getAccessToken().getToken();
		// String
		// url="https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
		// String ticketurl=url.replace("ACCESS_TOKEN", accesstoken);
		// JSONObject jsonObject= WeChatUtils.doGetStr(ticketurl);
		Map<String, String> data = TokenSingleton.getMap();
		String Datestamp = Long.toString(System.currentTimeMillis() / 1000);
		String ticket = data.get("jsapi_ticket");
		System.out.println(ticket.toString());
		// String nonceStr=RandomMathSalution.getRandomStringByLength(31);
		String nonceStr = UUID.randomUUID().toString();
		System.out.println("nonceStr=" + nonceStr);
		System.out.println("ticket=" + ticket);
		System.out.println("URL=" + URL);
		System.out.println("Datestamp=" + Datestamp);
		String String1 = SIGN_STR.replace("JS_TICKET", ticket.toString())
				.replace("NONCE_STR", nonceStr)
				.replace("TIME_STAMP", Datestamp + "").replace("URL", URL);
		// String
		// String1="jsapi_ticket=HoagFKDcsGMVCIY2vOjf9mtk6Ema-6_5FRtNK-D7VewE6bQ0teMociXyiCKCzYPZoOm69GqFIUIZtippDFFrlA&noncestr=kcfR7zjYaJxz622nzFCFnFx7HN5trYMJ&timestamp=1512117000&url=http://atlwb.tunnel.echomod.cn/微信支付WEB手机版/phonepay.html"
		System.out.println(String1);
		String signature = Sha1.getSha1(String1);
		System.out.println(signature);
		Map<String, Object> datamap = new HashMap<String, Object>();
		// datamap.put("accesstoken", accesstoken);
		datamap.put("ticket", ticket);
		datamap.put("nonceStr", nonceStr);
		datamap.put("Datestamp", Datestamp);
		datamap.put("signature", signature);
		return datamap;
	}

	public Object getRoom() {
		// TODO Auto-generated method stub
		return getSession().createQuery(" from Room where isDelete=0");
	}

	@Transactional
	public Object testHibernate(String id) throws Exception {
		// TODO Auto-generated method stub

		Session openSession = getSession();
		Query createQuery = openSession.createQuery("from Wxuser");
		List list = createQuery.list();

		return list;
	}

	public Object testJdbctemplate(String id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForList("select * from wxuser");
	}
}
