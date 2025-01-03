package myCafe.order.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myCafe.common.SuperClass;
import myCafe.dao.OrderDao;

public class OrderDeleteController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cid = Integer.parseInt(request.getParameter("cid"));
		String id = request.getParameter("id");

		OrderDao dao = new OrderDao();
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		int cnt = -99999;
		cnt = dao.DeleteData(cid);

		new OrderPageController().doGet(request, response);
	}
}
