package myCafe.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myCafe.common.SuperClass;

public class LogoutController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션 영역에 있는 모든 정보 삭제
		HttpSession session = request.getSession();
		session.invalidate();

		// 로그인 페이지로 이동
		String gotopage = "/login/login.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(gotopage);
		dispatcher.forward(request, response);
	}
}
