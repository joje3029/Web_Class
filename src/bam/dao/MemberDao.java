package bam.dao;

import java.util.ArrayList;
import java.util.List;

import bam.dto.Member;
import bam.util.Util;

public class MemberDao extends Dao {
	private List<Member> members;
	
	
	public MemberDao() {
		this.members = new ArrayList<>();
		
	}

	public void add(Member member) {
		members.add(member);
		lastId++;
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
		
		for (int i = 1; i <= 3; i++) {
			
			int id = setLastId();
			
			String logId = "test" + i;
			String logPw = "test" + i;
			String name = "사용자" + i;
			
			Member member = new Member(id, Util.getDateStr(), logId, logPw, name );
			add(member);
	}
}

	public String getWriterName(int memberId) {
		
		for(Member member : members) {
			if(memberId == member.id) {
				return member.name;
			}
		}
		return null;
	}

}