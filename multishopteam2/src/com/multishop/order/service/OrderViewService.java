package com.multishop.order.service;

import com.multishop.main.service.Service;
import com.multishop.order.dao.OrderDAO;
import com.multishop.order.vo.OrderVO;

public class OrderViewService implements Service {

	@Override
	public OrderVO service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		
		return new OrderDAO().view((Long) obj);
	}

}
