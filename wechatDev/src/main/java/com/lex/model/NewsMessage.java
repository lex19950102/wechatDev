package com.lex.model;

import java.util.List;

public class NewsMessage extends BaseMessage{
	private int ArticleCount;
	private List<NEWS> Articles;
	public int getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
	public List<NEWS> getArticles() {
		return Articles;
	}
	public void setArticles(List<NEWS> articles) {
		Articles = articles;
	}
	
}
