package com.multishop.product.service;

import java.util.List;

import com.multishop.main.service.Service;
import com.multishop.product.dao.ProductDAO;
import com.multishop.product.vo.ProductVO;

public class ProductListService implements Service {

	public List<ProductVO> service(Object obj) throws Exception {  
		
		return new ProductDAO().list();
	}

}
