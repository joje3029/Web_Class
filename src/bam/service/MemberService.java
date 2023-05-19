package bam.service;

import bam.dao.MemberDao;
import bam.dto.Member;

public class MemberService {
	
	private MemberDao memberDao;
	
	public MemberService(){
		memberDao = new MemberDao(); 
	}

	public int setMemberId() {
		return memberDao.setMemberId();
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

