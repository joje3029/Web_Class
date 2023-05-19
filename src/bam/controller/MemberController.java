package bam.controller;

import java.util.Scanner;

import bam.dto.Member;
import bam.service.MemberService;
import bam.util.Util;

public class MemberController extends Controller {
	private Scanner sc;
	private MemberService memberSevice;
	
	public MemberController(Scanner sc) {
		memberSevice = new MemberService();
		this.sc = sc;
	}
	
	public void doAction(String cmd, String methodName) {
		switch (methodName) {
		case "join":
			doJoin();
			break;
		case "login":
			doLogin();
			break;
		case "logout":
			doLogOut();
			break;	
		default:
			System.out.println("명령어를 확인해주세요");
			break;
		}
	}
	
	private void doJoin() {
		if(loginedMember != null) {
			System.out.println("로그아웃 후 이용해주세요");
			return;
		}
		int id = memberSevice.setMemberId();
		String logId = null;
		
		while(true) {
			
		System.out.printf("로그인 아이디 : ");
		logId = sc.nextLine();
		
		 if(memberSevice.getMemberByID(logId) != null) {
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
		
		Member member = new Member(id, Util.getDateStr(), logId, logPw, name);
		memberSevice.add(member);
		

}
	private void doLogin() {

		if(loginedMember != null) {
			System.out.println("로그아웃 후 이용해주세요");
			return;
		}
			
		System.out.printf("로그인 아이디 : ");
		String logId = sc.nextLine();
		
		 if(memberSevice.getMemberByID(logId) == null) {
			 System.out.println("일치하는 회원이 없습니다.");
			 return;
		 }
		
		String logPw = null;
		 while(true) {
		System.out.printf("로그인 비밀번호 : ");
		logPw = sc.nextLine();
		System.out.printf("로그인 비밀번호 확인 : ");
		String logPwck = sc.nextLine();

		if(!logPw.equals(logPwck)) {
			System.out.println("비밀번호를 확인해 주세요");
			continue;
		}
		break;
		 }
		
		 System.out.printf("%s 회원님이 로그인되었습니다.\n", logId);
		 
		 loginedMember =memberSevice.getMemberByID(logId);
	}
	
	private void doLogOut() {
		if(loginedMember != null) {
			loginedMember = null;
			System.out.println("로그인 아웃되었습니다.");
			return;
		}
		System.out.println("로그인 상태가 아닙니다.");
	}
	
	public void makeTestData(){
		System.out.println("테스트용 회원 데이터 3개 생성");
		memberSevice.makeTestData();
	}
	

}
