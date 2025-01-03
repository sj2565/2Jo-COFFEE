package myCafe.order.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myCafe.common.SuperClass;
import myCafe.dao.OrderDao;
import myCafe.model.Cafe;

public class OrderPaymentController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("결제");
		String id = request.getParameter("id");
		int total = Integer.parseInt(request.getParameter("total"));
		int balance = Integer.parseInt(request.getParameter("balance"));

		if (balance >= total) {
			Cafe bean = new Cafe();

			bean.setBalance(balance);
			bean.setId(id);
			bean.setTotal(total);

			OrderDao dao = new OrderDao();
			bean = dao.GetDataById(id, total, balance);

			String gotopage = "/order/paymentSuccess.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(gotopage);
			dispatcher.forward(request, response);
		} else {
			// 존재하지 않으면, 로그인 페이지로 다시 이동
			System.out.println("잔액부족");

			// errmsg에 대한 경고창은 common.jsp 파일의 하단에 있음
			request.setAttribute("errmsg", "잔액이 부족합니다.");

			new OrderPageController().doGet(request, response);

		}
	}
}
