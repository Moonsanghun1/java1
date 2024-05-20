package com.multishop.member.controller;

import com.multishop.main.controller.Main;
import com.multishop.member.service.MemberLoginService;
import com.multishop.member.service.MemberWriteService;
import com.multishop.member.vo.MemberVO;
import com.multishop.util.exe.Execute;
import com.multishop.util.io.In;

public class MemberController {

	public void execute() {

		// 게시판 기능의 반복처리
		while (true) {

			// 로그인 여부 출력 - 완성후 도입예정
			Main.loginInfo();

			// 모듈 이름 출력
			System.out.println();
			System.out.println("<<<<<------ 회원 관리 ----->>>>>");
			System.out.println();

			// 메뉴 출력
			System.out.println("******************************");
			System.out.println("*** 1. " + ((Main.login == null) ? "로그인" : "로그아웃") + " 2. 회원가입 3. 아이디,비밀번호 찾기/변경 ***");
			System.out.println("*** 4. 마이페이지 5. 관리자기능 0. 이전메뉴");
			System.out.println("******************************");

			// 스캐너를 이용한 입력/선택
			String menu = In.getStr("번호 입력");

			// 아래에 사용될 변수 생성

			// 처리 시작
			try {

				// 항목별 처리
				switch (menu) {
				case "1":
					// 로그인,로그아웃 처리
					System.out.println("로그인 / 로그아웃");

					// 로그인이 안되어 있을시 실행 = 로그인 시행
					if (Main.login == null) {

						// 데이터 수집
						String id = In.getStr("ID를 입력해 주세요.");
						String pw = In.getStr("비밀번호를 입력해 주세요");
						MemberVO membervo = new MemberVO();
						membervo.setId(id);
						membervo.setPw(pw);

						// DB 처리
						Main.login = (MemberVO) Execute.execute(new MemberLoginService(), membervo);
						System.out.println("***********************************");
						System.out.println("<<<--- 로그인이 정상 처리되었습니다. --->>>");
						System.out.println("***********************************");

					} else {
						// null 값이 아닌경우 - 이미 로그인이 되어있는 경우 : 로그아웃 처리
						Main.login = null;
						System.out.println("*******************************");
						System.out.println("<<<--- 로그아웃 처리되었습니다. --->>>");
						System.out.println("*******************************");
					}

					break;

				case "2":
					// 회원 가입
					System.out.println("2. 회원가입");
					// 가입에 필요한 데이터 = 아이디, 비밀번호, 이름, 성별, 생년월일, 연락처, 이메일
					String id = In.getStr("id");
					String pw = In.getStr("pw");
					String name = In.getStr("이름");
					String gender = In.getStr("성별");
					String birth = In.getStr("생년월일");
					String tel = In.getStr("연락처");
					String email = In.getStr("이메일");
					// 입력한 변수를 MemberVO에 저장하고 Service로 이동
					MemberVO vo = new MemberVO();
					vo.setId(id);
					vo.setPw(pw);
					vo.setName(name);
					vo.setGender(gender);
					vo.setBirth(birth);
					vo.setTel(tel);
					vo.setEmail(email);
					
					// 이동한 데이터를 바탕으로 service실행
					Execute.execute(new MemberWriteService(), vo);

					break;
				case "3":
					// 아이디,비밀번호 찾기/변경
					// new MemberSearchController.execute();
					break;
				case "4":
					// 마이페이지
					// new MemberMypageController.execute();
					break;
				case "5":
					// 관리자기능
					// new MemberAdminController.execute();
					break;
				case "0":
					// 이전메뉴

					return;
				}

			} catch (Exception e) {

			}
		} // end of while

	} // end of execute()

} // end of class(MemberController)
