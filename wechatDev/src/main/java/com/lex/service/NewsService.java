package com.lex.service;

import java.util.List;

import com.lex.model.NEWS;

public interface NewsService {
	List<NEWS> findNews(String content) throws Exception;

	List<NEWS> getAllNews(String content) throws Exception;
}
