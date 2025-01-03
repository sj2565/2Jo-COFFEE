package myCafe.common.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myCafe.common.SuperClass;
import myCafe.dao.CafeDao;
import myCafe.model.Cafe;

public class MyPageController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");

		CafeDao dao = new CafeDao();
		Cafe bean = dao.GetDataById(id);

		// 마이 페이지로 이동.
		String gotopage = null;

		if (bean != null) {
			// request 영역에 bean을 바인딩함
			request.setAttribute("bean", bean);
			gotopage = "/common/myPage.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(gotopage);
			dispatcher.forward(request, response);
		} else {
			new ListController().doGet(request, response);
		}
	}
}
