package myCafe.order.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myCafe.common.SuperClass;
import myCafe.dao.OrderDao;
import myCafe.memu.controller.MenuListController;

public class OrderDeleteAllController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");

		OrderDao dao = new OrderDao();
		int cnt = -99999;
		cnt = dao.DeleteDataAll(id);

		new MenuListController().doGet(request, response);
	}
}
