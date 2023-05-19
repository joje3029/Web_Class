package bam.service;

import java.util.ArrayList;
import java.util.List;

import bam.dto.Article;
import bam.util.Util;

public class ArticleService {
	private int lastArticleId;
	private List<Article> articles;
	
	public ArticleService() {
		this.lastArticleId = 0;
		this.articles = new ArrayList<>();
	}

	public int setArticleId() {
		int id = lastArticleId + 1;
		lastArticleId = id;
		return id;
	}

	public void makeTestData() {
		for (int i = 1; i <= 5; i++) {
			
			int id = lastArticleId + 1;
			lastArticleId = id;
			
			String title = "제목" + i;
			String body = "내용" + i;
			
			Article article = new Article(id, Util.getDateStr(), title, body, 2);
			articles.add(article);
		}
	}

	public void add(Article article) {
		articles.add(article);
	}
	

	public Article getArticleByID(int id) {
		for (Article article : articles) {
			if (article.id == id) {
				return article;
			}
		}
		return null;
	}

	public void remove(Article foundArticle) {
		articles.remove(foundArticle);
	}

	public List<Article> getArticles(String searchKeyword) {
		if(searchKeyword.length() > 0) {
			System.out.println("검색어 : " + searchKeyword);
			
			List<Article> printArticles = new ArrayList<>();
			
			for(Article article : articles) {
				if(article.title.contains(searchKeyword)) {
					printArticles.add(article);
				}
			}
			return printArticles;
		}
		return articles;
	}
}
