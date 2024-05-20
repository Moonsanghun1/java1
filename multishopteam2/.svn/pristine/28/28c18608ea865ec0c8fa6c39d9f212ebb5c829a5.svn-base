package com.multishop.product.service;

import com.multishop.main.service.Service;
import com.multishop.product.dao.ProductDAO;
import com.multishop.product.vo.ProductVO;


public class ProductDeleteService implements Service {

	public Integer service(Object obj) throws Exception { 
		
		return new ProductDAO().delete((ProductVO) obj); //obj를 받음.
	}

}
