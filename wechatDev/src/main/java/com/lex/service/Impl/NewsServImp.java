package com.lex.service.Impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.lex.dao.BaseServiceSupport;
import com.lex.model.NEWS;
import com.lex.model.coreModel.MyNews;
import com.lex.service.NewsService;

@Service("newsImp")
public class NewsServImp extends BaseServiceSupport implements NewsService {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	SessionFactory sessionFactory;

	public List<NEWS> findNews(String content) throws Exception {
		// TODO Auto-generated method stub
		List<NEWS> listnewsallList = new ArrayList<NEWS>();
		System.out.println("into2");
		List<MyNews> listnews = (List<MyNews>) sessionFactory
				.getCurrentSession().createQuery(" from MyNews ").list();
		for (Iterator iterator = listnews.iterator(); iterator.hasNext();) {
			MyNews news = (MyNews) iterator.next();
			NEWS news2 = new NEWS(news.getTitle(), news.getDescription(),
					news.getPicUrl(), news.getUrl());
			listnewsallList.add(news2);
		}
		System.out.println(listnews);
		System.out.println(listnewsallList);
		return listnewsallList;
	}

	public List<NEWS> getAllNews(String content) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	// public List<NEWS> getAllNews(String content) throws Exception {
	// // TODO Auto-generated method stub
	// String getALLnews = "selete * from news";
	// List<Map<String, Object>> newsList = jdbcTemplate
	// .queryForList(getALLnews);
	// return newsList;
	// }

}
