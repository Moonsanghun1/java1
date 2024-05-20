package com.multishop.order.service;

import com.multishop.main.service.Service;
import com.multishop.order.dao.OrderDAO;
import com.multishop.order.vo.OrderVO;

public class OrderUpdateService implements Service {

	@Override
	public Integer service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		
		return new OrderDAO().update((OrderVO)obj);
	}

}
