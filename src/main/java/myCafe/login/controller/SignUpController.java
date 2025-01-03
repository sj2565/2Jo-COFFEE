package myCafe.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myCafe.common.SuperClass;
import myCafe.dao.CafeDao;
import myCafe.model.Cafe;

public class SignUpController extends SuperClass {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("회원가입");

		String gotopage = "/login/signUp.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(gotopage);
		dispatcher.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("회원가입 Post");
		// 우선 파라미터 챙기자
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String hphone = request.getParameter("hphone");
		int balance = Integer.parseInt(request.getParameter("balance"));

		// Member 클래스로부터 객체를 생성하여 setting하기
		Cafe bean = new Cafe();
		bean.setId(id);
		bean.setName(name);
		bean.setPassword(password);
		bean.setHphone(hphone);
		bean.setBalance(balance);

		// MemberDao 클래스에게 메소드로 던져 준 다음 응답값을 리턴 받음
		CafeDao dao = new CafeDao();
		int cnt = -99999; // 부정의 의미를 담고 있는 임의의 숫자

		cnt = dao.InsertData(bean);

		// 가고자 하는 페이지(로그인)로 이동
		String gotopage = "/login/login.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(gotopage);
		dispatcher.forward(request, response);
	}
}
