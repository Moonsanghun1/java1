package com.multishop.product.service;

import com.multishop.main.service.Service;
import com.multishop.product.dao.ProductDAO;
import com.multishop.product.vo.ProductVO;

//import java.util.List;

public class ProductViewService implements Service {

	@Override //변수 이름이 같아도 매개변수가 다르면 
	public ProductVO service(Object obj) throws Exception {  
		// 넘어오는 데이터의 구조 obj - Long[]의 배열. : obj[0] - no, obj[1] - increase
				Long[] objs = (Long[]) obj; // 데이터를 넣을 대 long[]로 저장했어야만 한다.
				Long no = objs[0]; //obj의 0번째가 no
				Long inc = objs[1]; //obj의 첫번째가 increase
				//시작하는 번호가 3이라서 실행할 때 3-2-3으로.
				
				// DB Board에서 조회수 1 증가하고 글보기 데이터 가져와서 리턴
				ProductDAO dao = new ProductDAO();
				// 1. 조회수 1증가 : inc가 1일 때
				if(inc == 1) dao.increase(no);

				return dao.view(no); 
	}

}
