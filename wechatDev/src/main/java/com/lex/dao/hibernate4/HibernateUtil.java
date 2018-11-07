package com.lex.dao.hibernate4;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.lex.dao.SpringContext;

public class HibernateUtil {

	public HibernateUtil() {
		super();
	}

	public static SessionFactory getSessionFactory() {
		return SpringContext.getBean("sessionFactory");
	}

	public static Session getSession() {
		return getSessionFactory().getCurrentSession();
	}

	public static Session openSession() {
		return getSessionFactory().openSession();
	}

	public static Criteria getCriteria(Class<?> cls, Boolean... queryCache) {
		Criteria criteria = getSession().createCriteria(cls);
		// 设置查询缓存
		if (queryCache.length > 0 ? queryCache[0] : true) {
			criteria.setCacheable(true);
		}
		return criteria;
	}

}
