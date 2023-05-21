package bam.service;

import bam.container.Container;
import bam.dao.MemberDao;
import bam.dto.Member;

public class MemberService {
	
	private MemberDao memberDao;
	
	public MemberService(){
		memberDao = Container.memberDao; 
	}

	public int setMemberId() {
		return memberDao.setLastId();
	}
	
	public void add(Member member) {
		memberDao.add(member);
	}
	
	public Member getMemberByID(String logId){
		return memberDao.getMemberByID(logId);
	}
	
	public void makeTestData() {
		memberDao.makeTestData();
		
	}

}

