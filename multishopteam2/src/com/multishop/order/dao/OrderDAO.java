package com.multishop.order.dao;

import java.util.ArrayList;
import java.util.List;

import com.multishop.main.controller.Main;
import com.multishop.main.dao.DAO;
import com.multishop.order.vo.OrderVO;
import com.multishop.util.db.DB;

public class OrderDAO extends DAO {
	
	// 1. 주문 리스트 작성
	public List<OrderVO> list(String id) throws Exception {

		List<OrderVO> list = null;

		try {
			// 1. 드라이버 확인
			// 2. 연결
			con = DB.getConnection();
			// 3. sql문
			// 4. 실행 객체 생성
			pstmt = con.prepareStatement(LIST);
			pstmt.setString(1, id);
			// 5. 실행
			rs = pstmt.executeQuery();
			// 6. 표기 및 담기
			if (rs != null) {
				while (rs.next()) {
					if (list == null)
						list = new ArrayList<OrderVO>();
					OrderVO vo = new OrderVO();
					vo.setOno(rs.getLong("ono"));
					vo.setProductName(rs.getString("product_name"));
					vo.setProductCnt(rs.getLong("productcnt"));
					vo.setTotalPrice(rs.getLong("totalprice"));
					vo.setOrderDate(rs.getString("orderDate"));
					vo.setStatus(rs.getString("status"));

					list.add(vo);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		} finally {
			DB.close(con, pstmt, rs);
		}
		return list;
	}

	// 1-1. 관리자 전용 주문 리스트 작성
		public List<OrderVO> list1() throws Exception {

			List<OrderVO> list = null;

			try {
				// 1. 드라이버 확인
				// 2. 연결
				con = DB.getConnection();
				// 3. sql문
				// 4. 실행 객체 생성
				pstmt = con.prepareStatement(LIST1);
			
				// 5. 실행
				rs = pstmt.executeQuery();
				// 6. 표기 및 담기
				if (rs != null) {
					while (rs.next()) {
						if (list == null)
							list = new ArrayList<OrderVO>();
						OrderVO vo = new OrderVO();
						vo.setOno(rs.getLong("ono"));
						vo.setId(rs.getString("Id"));
						vo.setProductName(rs.getString("product_name"));
						vo.setProductCnt(rs.getLong("productcnt"));
						vo.setTotalPrice(rs.getLong("totalprice"));
						vo.setOrderDate(rs.getString("orderDate"));
						vo.setStatus(rs.getString("status"));

						list.add(vo);
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
				throw e;

			} finally {
				DB.close(con, pstmt, rs);
			}
			return list;
		}

	
	// 2. 주문 리스트 작성
	public OrderVO view(Long ono) throws Exception {

		OrderVO vo = null;

		try {
			// 1. 드라이버 확인
			// 2. 연결
			con = DB.getConnection();
			// 3. sql문
			// 4. 실행 객체 생성
			pstmt = con.prepareStatement(VIEW);
			pstmt.setLong(1, ono);
			// 5. 실행
			rs = pstmt.executeQuery();
			// 6. 표기 및 담기
			if (rs != null && rs.next()) {

				vo = new OrderVO();
				vo.setOno(rs.getLong("ono"));
				vo.setProductName(rs.getString("product_name"));
				vo.setProductCnt(rs.getLong("productcnt"));
				vo.setTotalPrice(rs.getLong("totalprice"));
				vo.setOrderDate(rs.getString("orderDate"));
				vo.setAddr(rs.getString("addr"));
				vo.setRequest(rs.getString("request"));
				vo.setPayment(rs.getString("payment"));
				vo.setStatus(rs.getString("status"));

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		} finally {
			DB.close(con, pstmt, rs);
		}
		return vo;
	}

	
	// 3. 주문 정보 수정
		public int update(OrderVO vo) throws Exception {

			int result = 0;
			
			try {
				// 1. 드라이버 확인
				// 2. 연결
				con = DB.getConnection();
				// 3. sql문
				// 4. 실행 객체 생성
				pstmt = con.prepareStatement(UPDATE);
				pstmt.setString(1, vo.getStatus());
				pstmt.setLong(2, vo.getOno());
				// 5. 실행
				result = pstmt.executeUpdate();
				// 6. 표기 및 담기
				if (result == 0) { // 글번호가 존재하지 않는다. -> 예외로 처리한다.
					throw new Exception("예외 발생 : 정보를 확인해 주세요");

				}

			} catch (Exception e) {
				e.printStackTrace();
				if (e.getMessage().indexOf("예외 발생") >= 0)
					throw e;
				else
					throw new Exception("예외 발생 : 회원정보 수정 DB 처리 중 예외가 발생했습니다.");
			} finally {
				// 7. 닫기
				DB.close(con, pstmt);
				
			}
			// 결과 데이터를 리턴해준다.
			return result;
		}// end of Update()
	final String LIST = "select o.ono, p.product_name, c.productcnt, c.totalprice, to_char(o.orderdate, 'yyyy-mm-dd') orderdate, o.status from cart c, orders o , product p, member m "
			+ " where o.id = ? and (o.PRODUCT_NO = p.PRODUCT_NO) and (o.id = m.id) and (o.cartno = c.no) order by ono";
	final String LIST1 = "select o.ono, m.id ,p.product_name, c.productcnt, c.totalprice, to_char(o.orderdate, 'yyyy-mm-dd') orderdate, o.status from cart c, orders o , product p, member m"
			+ " where (o.PRODUCT_NO = p.PRODUCT_NO) and (o.cartno = c.no) and (m.id = o.id) order by ono ";
	final String VIEW = "select o.ono, p.product_name, c.productcnt, c.totalprice, to_char(o.orderdate, 'yyyy-mm-dd') orderdate, o.Addr, o.request, o.Payment ,o.status  from cart c, orders o , product p "
			+ " where ono = ? and (o.PRODUCT_NO = p.PRODUCT_NO) and (o.PRODUCT_NO = c.PRODUCTNO) and (o.cartno = c.no)";
	final String UPDATE = "Update orders set status = ? where ono = ? " ;
} // end of class
