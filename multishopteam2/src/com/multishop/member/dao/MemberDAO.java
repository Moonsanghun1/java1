package com.multishop.member.dao;

import java.util.List;

import com.multishop.main.dao.DAO;
// DAO 상속
import com.multishop.member.vo.MemberVO;
import com.multishop.util.db.DB;

public class MemberDAO extends DAO {

	// 로그인 처리
	public MemberVO login(MemberVO memberVO) throws Exception {

		// 결과를 저장할 수 있는 변수의 선언.
		MemberVO vo = null;

		// 처리 시작
		try {

			// 1. 드라이버 확인 과 2. 연결을 DB로 처리
			con = DB.getConnection();

			// 3. 실행문(sql)을 하단에 기입하여 4. 실행객체 생성 및 데이터 수집
			pstmt = con.prepareStatement(LOGIN);
			pstmt.setString(1, memberVO.getId());
			pstmt.setString(2, memberVO.getPw());

			// 5. 실행
			rs = pstmt.executeQuery();

			// 6. 표시 또는 담기
			if (rs != null && rs.next()) {

				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setGradeNo(rs.getInt("gradeNo"));
				vo.setGradeName(rs.getString("gradeName"));
			}

			if (vo == null) {
				// vo가 null 값 = 아이디와 비밀번호가 맞지않아 예외발생
				throw new Exception("예외 발생 : 아이디나 비밀번호가 맞지 않습니다.");
			}

		} catch (Exception e) {
			if (e.getMessage().indexOf("예외 발생") >= 0)
				throw e;
			// 처리 중 나타나는 오류에 대해서 사용자가 볼 수 있는 예외로 만들어 전달한다.

		} finally {

			// 닫기
			DB.close(con, pstmt, rs);

		} // end of try ~ catch ~ finally

		// 결과 데이터의 리턴
		return vo;

	} // end of login()

	// 회원 가입 처리
	public int write(MemberVO vo) throws Exception {

		// 결과를 저장할 변수의 선언
		int result = 0;

		// 처리 시작
		try {
			// 드라이버 확인과 연결
			con = DB.getConnection();
			// 실행문(sql)은 하부에 작성, 실행 객체의 생성과 데이터 세팅
			pstmt = con.prepareStatement(WRITE);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getGender());
			pstmt.setString(5, vo.getBirth());
			pstmt.setString(6, vo.getTel());
			pstmt.setString(7, vo.getEmail());
			// 실행 - 결과는 0과 1로 출력 때문에 int 사용
			result = pstmt.executeUpdate();
			// 표시 또는 담기
			System.out.println();
			System.out.println("<<<--- 회원가입이 완료 되었습니다. --->>>");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("예외 발생 : 회원가입 DB 처리중 예외가 발생하였습니다.");
		} finally {
			DB.close(con, pstmt);
		}
		// 결과 데이터값 리턴
		return result;
	} // end of write

	final String LOGIN = "select m.id, m.name, m.gradeNo, g.gradeName" + " from member m, grade g"
			+ " where (id = ? and pw = ? and status = '정상') and (g.gradeNo = m.gradeNo)";
	final String WRITE = "insert into member " + " (id, pw, name, gender, birth, tel, email) "
			+ " values(?, ?, ?, ?, ?, ?, ?)";
} // end of class(DAO)
