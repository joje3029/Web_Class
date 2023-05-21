package bam.service;

import java.util.List;

import bam.container.Container;
import bam.dao.ArticleDao;
import bam.dto.Article;

public class ArticleService {
	
	private ArticleDao articleDao;
	
	public ArticleService() {
		articleDao = Container.articleDao;
	}

	public int setArticleId() {
		return articleDao.setLastId();
		
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
