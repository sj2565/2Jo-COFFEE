package myCafe.order.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myCafe.common.SuperClass;
import myCafe.dao.OrderDao;
import myCafe.memu.controller.MenuListController;
import myCafe.model.Cafe;

public class OrderInsertController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int cid = Integer.parseInt(request.getParameter("cid"));

		Cafe bean = new Cafe();

		bean.setId(id);
		bean.setCid(cid);

		OrderDao dao = new OrderDao();
		int cnt = -9999;
		cnt = dao.InsertOrder(bean);

		new MenuListController().doGet(request, response);
	}
}
