package bam.dto;

public class Member {
	public int id;
	public String regDate;
	public String logId;
	public String logPw;
	public String name;

	public Member(int id, String regDate, String logId, String logPw, String name) {
		this.id = id;
		this.regDate = regDate;
		this.logId = logId;
		this.logPw = logPw;
		this.name = name;
	}
}
