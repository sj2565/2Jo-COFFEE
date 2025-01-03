package myCafe.order.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myCafe.common.SuperClass;
import myCafe.dao.OrderDao;
import myCafe.model.CafeMiniBean;

public class OrderPageController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = "";
		if (session.getAttribute("id") == null) {
			id = request.getParameter("id");
		} else {
			id = (String) session.getAttribute("id");
		}
		OrderDao dao = new OrderDao();
		List<CafeMiniBean> lists = dao.SelectDataList(id);
		System.out.println(id);

		request.setAttribute("lists", lists);
		System.out.println("주문 목록 : " + lists.size());

		String gotopage = "/order/order.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(gotopage);
		dispatcher.forward(request, response);

	}
}
