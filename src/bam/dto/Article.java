package bam.dto;

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

}
