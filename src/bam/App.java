package bam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bam.controller.ArticleController;
import bam.controller.MemberController;
import bam.dto.Article;
import bam.dto.Member;
import bam.util.Util;

public class App {
	private List<Article> articles;
	private int lastArticleId;
	private List<Member> members;

	public App() {
		articles = new ArrayList<>();
		members = new ArrayList<>();
		lastArticleId = 0;
		
	}

	public void run() {
		System.out.println("== 프로그램 시작 ==");
		
		Scanner sc = new Scanner(System.in);

		MemberController memberController = new MemberController(members, sc);
		ArticleController articleController = new ArticleController(articles, sc);
	
		articleController.makeTestData();
		
		while (true) {
			System.out.printf("명령어) ");
			String cmd = sc.nextLine();

			if (cmd.equals("exit")) {
				break;
			}
			
			if(cmd.equals("member join")) {
				memberController.doJoin();
				
			}else if (cmd.equals("article write")) {
				articleController.doWrite();
				
			} else if (cmd.startsWith("article list")) {
				articleController.showList(cmd);
				
			} else if (cmd.startsWith("article detail ")) {
				articleController.showdetail(cmd);
				
				
			} else if (cmd.startsWith("article modify ")) {
				articleController.domodify(cmd);
				
			} else if (cmd.startsWith("article delete ")) {
				articleController.dodelete(cmd);
				
			} else {
				System.out.println("존재하지 않는 명령어 입니다");
			}
		}

		sc.close();

		System.out.println("== 프로그램 끝 ==");
	}

}


