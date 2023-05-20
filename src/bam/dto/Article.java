package bam.dto;

import java.util.ArrayList;
import java.util.List;

public class Article {
	public int id;
	public String regDate;
	public String title;
	public String body;
	public int memberId;

	public Article(int id, String regDate, String title, String body, int memberId) {	
		this.id = id;
		this.regDate = regDate;
		this.title = title;
		this.body = body;
		this.memberId = memberId;
	}

	public Article getArticleByID() {
		for (Article article : articles) {
			if (article.id == id) {
				return article;
			}
		}
		return null;
	}

	public List<Article> getArticles() {
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
