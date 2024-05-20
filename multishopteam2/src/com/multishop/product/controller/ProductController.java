package com.multishop.product.controller;

import com.multishop.util.io.In;

//import java.util.List;

//import com.webjjang.util.io.In;


public class ProductController {

public void execute() { //new
	// 게시판 기능 무한 반복. 5가지
	while(true) {
		// 모듈 이름 출력. 에외발생 안됨.
		System.out.println();
		System.out.println("<<-------- Multi Shop ------->>");
		//메뉴 출력 - 리스트, 상세보기, 글 등록, 글 수정, 글 삭제
		System.out.println("==============================================");
		System.out.println("====  1. 상품 목록, 2. 상품 보기, 3. 상품 등록    ====");
		System.out.println("====  4. 상품 수정, 5. 상품 삭제, 0. 이전 메뉴    ====");
		System.out.println("==============================================");
		
		// 메뉴 입력
		String menu = In.getStr("원하시는 menu를 선택하세요.");
		
//		Object result = null;
//		
//		//입력 받는 데이터 선언
//		Long no= 0L; 
		
	try {
		
		// 메뉴 처리 : CRUD BD 처리 - Controller - Service(여러 개.execute 메서드) - DAO
		switch (menu) {
		case "1":
			
			System.out.println("1. 상품 목록");
//			result = Execute.execute(new Board3ListService(), null);
//			new BoardPrint().print((List<Board3VO>) result);
			
			break;
		case "2":
			System.out.println("2. 상품 보기");
			
			break;
		case "3":
			System.out.println("3. 상품 등록");
			
			
			break;
		case "4":
			System.out.println("4. 상품 수정");
			
			
		case "5":
			System.out.println("5. 상품 삭제");	
			break;
		
		case "0" : 
			return; //전 페이지로 돌아감.

		default:
			System.out.println("###################################");
			System.out.println("### 잘못된 메뉴를 선택하셨습니다. ##########");
			System.out.println("### [1~5, 0] 중에서 입력하셔야합니다!#####");
			System.out.println("###################################");
			break;
		}
		

	} catch (Exception e) {  //예외 발생시 catch로 감.
	e.printStackTrace(); //사용자에게 보여줄 수는 없
		System.out.println();
		System.out.println("$%@$%@$%@$%@$$%@$%@$%@$%@$%@$%@$%@$%@$%@$%@$%");
		System.out.println("$%@$$%@$%@$% << 오류 출력 >> @$%@$%@$%@$%%@$%@$%");
		System.out.println("$%@$ 타입  : " + e.getClass().getSimpleName());
		System.out.println("$%@$ 내용  : " + e.getMessage());
		System.out.println("$%@$ 조치 : 데이터를 확인 후 다시 실행해주세요.");
		System.out.println("$%@$    : 계속 오류가 나면 전산 담당자에게 연락하세요.");
		System.out.println("$%@$%@$%@$%@$$%@$%@$%@$%@$%@$%@$%@$%@$%@$%@$%"); 

		}
	}
  }
}
