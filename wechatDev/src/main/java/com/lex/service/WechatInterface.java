package com.lex.service;

public interface WechatInterface {

	Object getConfig(String URL) throws Exception;

	Object getRoom();

	Object testHibernate(String id) throws Exception;

	Object testJdbctemplate(String id);
}
