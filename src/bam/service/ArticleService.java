package bam.service;

import java.util.ArrayList;
import java.util.List;

import bam.dao.ArticleDao;
import bam.dao.MemberDao;
import bam.dto.Article;
import bam.util.Util;

public class ArticleService {
	
	private ArticleDao articleDao;
	
	public ArticleService() {
		articleDao = new ArticleDao();
	}

	public int setArticleId() {
		return articleDao.setArticleId();
		
	}

	public void makeTestData() {
		articleDao.maketestData();
		
		
	}

	public void add(Article article) {
		articleDao.add(article);
	}
	

	public Article getArticleByID(int id) {
		return articleDao.getArticleByID(id);
		
	}

	public void remove(Article foundArticle) {
		articleDao.remove(foundArticle);
		
	}

	public List<Article> getArticles(String searchKeyword) {
		return articleDao.getArticles(searchKeyword);
		
	}
}
