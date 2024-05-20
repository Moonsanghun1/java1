package com.multishop.main.controller;

import com.multishop.member.controller.MemberController;
import com.multishop.member.vo.MemberVO;
import com.multishop.order.controller.OrderController;
import com.multishop.util.io.In;

public class Main {
	
	public static MemberVO login = null;
	   
	   public static void loginInfo() {
	      System.out.println();
	      System.out.println("**************************************");
	      System.out.println("<<<<<----- login infomation ----->>>>>");
	      System.out.println("**************************************");
	      
	      if (login == null) {
	         System.out.println("<<<--- 로그인이 되어있지 않습니다. --->>>");
	      } else {
	         System.out.println("<<<--- " + login.getName() + "(" + login.getId() + ") 님 반갑습니다.");
	         System.out.println("<<<--- 현재 " + login.getGradeName() + " 으로 접속하셨습니다.");
	   
	      }
	      System.out.println("**************************************");
	   }

	// 프로젝트의 시작되는 지점.
	public static void main(String[] args) throws Exception {
		// 인사
		System.out.println("===============================================");
		System.out.println("== 웹짱 닷컴에 오신 것을 환영 합니다. 좋은 시간 보내세요. ==");
		System.out.println("===============================================");
		
		// 드라이버 확인 -> DB 관련 static 프로그램이 로딩된다. 
		Class.forName("com.multishop.util.db.DB");
		
		// 무한 반복 - 메뉴
		while(true) {
			System.out.println();
			System.out.println("<<<-----[ Main Menu ]----->");
			// 메뉴 출력 - 회원관리, 상품 페이지, 일반 게시판, 사진 게시판, 회원관리
			System.out.println("*************************************");
			System.out.println("** 1. 회원관리, 2. 상품 페이지, 3. 장바구니 **");
			System.out.println("** 4. 구매 내역, 0. 종료   **");
			System.out.println("*************************************");
			// 메뉴 선택 입력
			String menu = In.getStr("메뉴");
			// 메뉴 처리 -> BoardController 로 이동. execute() 호출
			// - 0을 입력하면 종료 인사 -> 종료
			switch (menu) {
			case "1": 
				System.out.println("1. 회원관리");
				// 생성하고 호출한다.
				new MemberController().execute();
				break;
				
			case "2": 
				System.out.println("2. 상품 페이지");
				break;
			case "3": 
				System.out.println("3. 장바구니");
				// 생성하고 호출한다. - 1번만 실행한다. : 변수 사용하지 않아도 된다. new하고 바로 실행
				break;
			case "4": 
				System.out.println("4. 구매 내역");
				if(Main.login == null) throw new Exception("로그인이 필요합니다.");
				 
				new OrderController().execute();
				break;
				
			case "0": 
				System.out.println("0. 종료");
				// 종료 인사.
				System.out.println("===================================================");
				System.out.println("== 좋은 시간 되셨나요. 불편사항이 있으면 게시판에 등록해 주세요. ==");
				System.out.println("== 시스템을 종료합니다. Bye~! Bye~!                    ==");
				System.out.println("====================================================");
				System.exit(0);
			default:
				System.out.println("####################################");;
				System.out.println("## 잘못된 메뉴를 선택하셨습니다.          ##");;
				System.out.println("## [0~5, 0] 중에서 입력하셔야 합니다.    ##");;
				System.out.println("####################################");;
			}
		}
	}
	
}

