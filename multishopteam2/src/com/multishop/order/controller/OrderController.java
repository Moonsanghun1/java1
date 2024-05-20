package com.multishop.order.controller;

import java.util.List;

import com.multishop.main.controller.Main;
import com.multishop.order.service.OrderList1Service;
import com.multishop.order.service.OrderListService;
import com.multishop.order.service.OrderUpdateService;
import com.multishop.order.service.OrderViewService;
import com.multishop.order.vo.OrderVO;
import com.multishop.util.exe.Execute;
import com.multishop.util.io.In;
import com.multishop.util.io.OrderPrint;

public class OrderController {

	public void execute() {

		while (true) {
			System.out.println();
			System.out.println("<<--------- 주문 관리 --------->>");
			// 메뉴 출력 - 리스트, 글보기, 글등록, 글수정, 굴삭제
			System.out.println("=============================");
			System.out.println("==1. 주문 리스트, 2. 주문 상세보기, 3. 주문 상태 변경==");
			System.out.println("==4. 결재,      5. 뭐를 더 넣을까 0. 이전       ==");
			System.out.println("=============================");

			String menu = In.getStr("메뉴");

			Object result = null;
			
			Long ono = null;
			try { // 정상처리

				// 메뉴 처리 : CRUD DB처리 - controller - service - DAO
				switch (menu) {

				case "1":
					//[OrderController] - (Excute) - OrderListService - OrderDAO.list()
					System.out.println("1. 주문리스트");
					
					
					if(Main.login.getGradeNo() == 9) {
						result = Execute.execute(new OrderList1Service(), null);
						new OrderPrint().print((List<OrderVO>)result);
					}else{
					String id = Main.login.getId();
					result = Execute.execute(new OrderListService(), id);
					new OrderPrint().print((List<OrderVO>)result);
					}
					break;

				case "2":
					System.out.println("2. 주문 상세보기");
					
					ono = In.getLong("번호");
					
					result = Execute.execute(new OrderViewService(), ono);
					
					new OrderPrint().print((OrderVO)result);
					break;
				case "3":
					System.out.println("3. 주문 상태 변경");
					
					ono = In.getLong("번호");
					
					if(Main.login.getGradeNo() == 9) {
					OrderVO updateVO = (OrderVO) Execute.execute(new OrderViewService(), ono);
					new OrderPrint().print(updateVO);
					System.out.println("---------------------------------------");
					System.out.println("      1. 배송중     /     2. 배송완료     ");
					System.out.println("---------------------------------------");	
					updateVO.setStatus(In.getStr("상태 입력"));
					Execute.execute(new OrderUpdateService(), updateVO);
					new OrderPrint().print(updateVO);
					}else{
						OrderVO updateVO = (OrderVO) Execute.execute(new OrderViewService(), ono);
						new OrderPrint().print(updateVO);
						System.out.println("---------------------------------------");
						System.out.println("       구매확정      /      환불신청      ");
						System.out.println("---------------------------------------");	
						updateVO.setStatus(In.getStr("상태 입력"));
						Execute.execute(new OrderUpdateService(), updateVO);
						new OrderPrint().print(updateVO);
					}
					break;
				case "4":
					System.out.println("4. 결제 ");
					break;
				case "0":

					System.out.println("0. 이전 ");
					return;
				default:
					System.out.println("================================");
					System.out.println("==    잘못된 메뉴를 입력하셨습니다.   ==");
					System.out.println("== [1~5,0] 중에서 입력하셔야 합니다. ==");
					System.out.println("================================");
					break;
				} // end of switch

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} // end of try ~ catch
		} // end of while
	}// end of execute()
}// end of class
