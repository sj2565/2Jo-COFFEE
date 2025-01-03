package myCafe.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import myCafe.common.SuperClass;
import myCafe.dao.CafeDao;
import myCafe.memu.controller.MenuListController;
import myCafe.model.Cafe;

public class LoginController extends SuperClass {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("로그인");

		String gotopage = "/login/login.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(gotopage);
		dispatcher.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 아이디와 비번을 이용하여 존재 유무를 체크
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		CafeDao dao = new CafeDao();
		Cafe bean = dao.GetCustomerInfo(id, password);

		if (bean != null) {
			// 존재하면 Member 객체를 session 영역에 바인딩
			HttpSession session = request.getSession();

			// "loginfo"는 로그인 한 사람의 세션 영역에 있는 키
			session.setAttribute("loginfo", bean);
			System.out.println("로그인 정보를 세션 영역에 바인딩");

			new MenuListController().doGet(request, response);
		} else {
			// 존재하지 않으면, 로그인 페이지로 다시 이동
			System.out.println("존재하지 않는 회원");

			// errmsg에 대한 경고창은 common.jsp 파일의 하단에 있음
			request.setAttribute("errmsg", "로그인에 실패하였습니다.");

			String gotopage = "/login/login.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(gotopage);
			dispatcher.forward(request, response);
		}
	}
}
