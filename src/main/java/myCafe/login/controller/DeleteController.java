package myCafe.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myCafe.common.SuperClass;
import myCafe.common.controller.ListController;
import myCafe.dao.CafeDao;

public class DeleteController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
//		String nowId = request.getParameter("nowId");

		CafeDao dao = new CafeDao();
		int cnt = -99999;
		cnt = dao.DeleteData(id);

//		if (!nowId.equals("admin")) {
			// 회원이 탈퇴하므로, 세션 정보를 클리어 하고, 로그인 페이지로 이동
			HttpSession session = request.getSession();
			session.invalidate();

			new LoginController().doGet(request, response);
//		} else {
//			new ListController().doGet(request, response);
//		}
	}
}
