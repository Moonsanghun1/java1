package com.multishop.product.service;

import com.multishop.main.service.Service;
import com.multishop.product.dao.ProductDAO;

//import java.util.List;

public class ProductWriteService implements Service {

	public Integer service(Object obj) throws Exception { 
		
		return new ProductDAO().write((ProductDAO) obj); //obj를 받음.
	}

}
