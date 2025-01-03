package myCafe.memu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myCafe.common.SuperClass;
import myCafe.dao.MenuDao;

public class MenuDeleteController extends SuperClass {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cid = Integer.parseInt(request.getParameter("cid"));

		MenuDao dao = new MenuDao();
		int cnt = -9999;
		cnt = dao.DeleteData(cid);

		new MenuListController().doGet(request, response);
	}
}