package com.multishop.util.io;

import java.util.List;

import com.multishop.order.vo.OrderVO;

public class OrderPrint {

	public void print(List<OrderVO> list) {

		System.out.println();
		System.out.println("+------------------------------------------------+");
		System.out.println(" 주문번호 / 상품명 / 상품 수량 / 총주문금액 / 주문일자 / 주문상태 ");
		System.out.println("+------------------------------------------------+");

		if (list == null) {
			System.out.println("데이터가 존재 하지 않습니다");
		} else {
			for (OrderVO vo : list) {

				System.out.print(" " + vo.getOno());
				System.out.print(" / " + vo.getProductName());
				System.out.print(" / " + vo.getProductCnt());
				System.out.print(" / " + vo.getTotalPrice());
				System.out.print(" / " + vo.getOrderDate());
				System.out.print(" / " + vo.getStatus());
				System.out.println();
			}
		}

	}

	public void print(OrderVO vo) {

		System.out.println();
		System.out.println("<<<----- 주문 상세 내역 ----->>>");
		System.out.println("+---------------------------------------------+");
		System.out.println("+ 주문번호 : " + vo.getOno());
		System.out.println("+ 상품명 : " + vo.getProductName());
		System.out.println("+ 상품 수량 : " + vo.getProductCnt());
		System.out.println("+ 총주문금액 : " + vo.getTotalPrice());
		System.out.println("+ 주소 : " + vo.getAddr());
		System.out.println("+ 배송요청사항  : " + vo.getRequest());
		System.out.println("+ 결제수단 : " + vo.getPayment());
		System.out.println("+ 주문상태  : " + vo.getStatus());
		System.out.println("+---------------------------------------------+");

	}

}
