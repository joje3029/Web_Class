package bam.dao;

import java.util.ArrayList;
import java.util.List;

import bam.dto.Member;
import bam.util.Util;

public class MemberDao {
	private List<Member> members;
	private int lastMemberId;
	
	public MemberDao() {
		this.members = new ArrayList<>();
		this.lastMemberId = 0;
	}

	public int setMemberId() {
		int id = lastMemberId + 1;
		lastMemberId = id;
		return id;
	}

	public void add(Member member) {
		members.add(member);
	}

	public Member getMemberByID(String logId) {
		for(Member member : members) {
			if(member.logId.equals(logId)) {
				return member;
			}
		}
		return null;
	}

	public void makeTestData() {
		System.out.println("테스트용 회원 데이터 3개 생성");
		
		for (int i = 1; i <= 3; i++) {
			
			int id = setMemberId();
			
			String logId = "test" + i;
			String logPw = "test" + i;
			String name = "사용자" + i;
			
			Member member = new Member(id, Util.getDateStr(), logId, logPw, name );
			members.add(member);
	}
}
}