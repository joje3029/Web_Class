package bam.controller;

import java.util.List;
import java.util.Scanner;

import bam.dto.Member;

public class MemberController {
	
	private List<Member> members;
	private Scanner sc;
	public MemberController(List<Member> members, Scanner sc) {
		this.members = members;
		this.sc = sc;
	}
	public void doJoin() {
		String logId = null;
		while(true) {
		System.out.printf("로그인 아이디 : ");
		logId = sc.nextLine();
		
		 if(getMemberByID(logId) != null) {
			 System.out.println("이미 존재하는 아이디 입니다.");
			 continue;
		 }
		 break;
		}
		
		String logPw = null;
		 while(true) {
		System.out.printf("로그인 비밀번호 : ");
		logPw = sc.nextLine();
		System.out.printf("로그인 비밀번호 확인 : ");
		String logPwck = sc.nextLine();

		if(!logPw.equals(logPwck)) {
			System.out.println("로그인 비밀번호를 확인해 주세요");
			continue;
		}
		break;
		 }
		System.out.printf("이름 : ");
		String name = sc.nextLine();
		
		System.out.printf("%s 회원님이 가입되었습니다.\n", name);
		
		Member member = new Member(logId, logPw, name);

		members.add(member);
		

}
	private Member getMemberByID(String logId){
		for(Member member : members) {
			if(member.logId.equals(logId)) {
				return member;
			}
		}
		return null;
	}
}
