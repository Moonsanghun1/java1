package com.multishop.cart.dao;

import com.multishop.cart.vo.CartVO;
import com.multishop.main.dao.DAO;
import com.multishop.util.db.DB;

public class CartDAO extends DAO {

	// List
	public CartVO list(String id) throws Exception {

		CartVO vo = null;

		try {
			// 1. 드라이브 확인
			// 2. 연결
			con = DB.getConnection();

			// 3. sql

			// 4. 실행 객체 생성
			pstmt = con.prepareStatement(LIST);
			pstmt.setString(1, id);

			// 5. 실행
			rs = pstmt.executeQuery();

			// 6. 표시 & 담기
			if (rs != null && rs.next()) {
				vo = new CartVO();
				vo.setNo(rs.getLong("no"));
				vo.setProductNo(rs.getLong("productNo"));
				vo.setProductCnt(rs.getLong("productCnt"));
				vo.setProductCnt(rs.getLong("totalPrice"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		} finally {
			try {
				DB.close(con, pstmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return vo;
	}

	// Insert
	public int insert(CartVO vo) throws Exception {

		int result = 0;

		try {
			// 1. 드라이브 확인
			// 2. 연결
			con = DB.getConnection();

			// 3. sql

			// 4. 실행 객체 생성
			pstmt = con.prepareStatement(INSERT);
			pstmt.setLong(1, vo.getProductNo());
			pstmt.setLong(2, vo.getProductCnt());
			pstmt.setLong(3, vo.getTotalPrice());

			// 5. 실행
			rs = pstmt.executeQuery();
			
			// 6. 데이터 담기
			if (result == 0) { // 글번호가 존재하지 않는다
				throw new Exception(" 장바구니 등록에 실패 하였습니다. ");
			} else {
				System.out.println("장바구니 등록이 정상처리 되었습니다.");
			}


		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("예외 발생 : 장바구니 등록 DB처리중 예외가 발생 했습니다.");

		} finally {
			try {
				DB.close(con, pstmt);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	// Update
	public int update(CartVO vo) throws Exception {

		int result = 0;

		try {
			// 1. 드라이브 확인
			// 2. 연결
			con = DB.getConnection();

			// 3. sql

			// 4. 실행 객체 생성
			pstmt = con.prepareStatement(UPDATE);
			pstmt.setLong(1, vo.getProductCnt());
			pstmt.setString(2, vo.getId());

			// 5. 실행
			rs = pstmt.executeQuery();
			
			// 6. 데이터 담기
			if (result == 0) { // 글번호가 존재하지 않는다
				throw new Exception(" 장바구니 수량 변경에 실패 하였습니다. ");
			} else {
				System.out.println("장바구니 수량 변경이 정상처리 되었습니다.");
			}


		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("예외 발생 : 장바구니 수량변경 DB처리중 예외가 발생 했습니다.");

		} finally {
			try {
				DB.close(con, pstmt);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	// Delete
	public int delete(CartVO vo) throws Exception {

		int result = 0;

		try {
			// 1. 드라이브 확인
			// 2. 연결
			con = DB.getConnection();

			// 3. sql

			// 4. 실행 객체 생성
			pstmt = con.prepareStatement(DELETE);
			pstmt.setLong(1, vo.getNo());
			pstmt.setString(2, vo.getId());

			// 5. 실행
			rs = pstmt.executeQuery();
			
			// 6. 데이터 담기
			if (result == 0) { // 글번호가 존재하지 않는다
				throw new Exception(" 장바구니 목록 삭제 에 실패 하였습니다. ");
			} else {
				System.out.println("장바구니 목록 삭제가 정상처리 되었습니다.");
			}


		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("예외 발생 : 장바구니 목록 삭제 DB처리중 예외가 발생 했습니다.");

		} finally {
			try {
				DB.close(con, pstmt);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	
	
	final String LIST = "select c.no, c.productNo, c.productCnt, c.totalPrice, p.delivery"
			+ " from cart c"
			+ " join product p ON c.productNo = p.no";


	final String INSERT = "insert into cart(no, productNo, productCnt, totalPrice, id)"
			+ "values(cart_seq.nextval, product_seq.currval, ?, ?, ?)";
	
	final String UPDATE = "update cart set productCnt = ? "
						+ "where no = ? " ;
	
	final String DELETE = "delete from cart where no = ? and id =?";
	
}
