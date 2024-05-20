package com.multishop.order.service;

import java.util.List;

import com.multishop.main.service.Service;
import com.multishop.order.dao.OrderDAO;
import com.multishop.order.vo.OrderVO;

public class OrderList1Service implements Service {

	@Override
	public List<OrderVO> service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		
		return new OrderDAO().list1();
	}

}
