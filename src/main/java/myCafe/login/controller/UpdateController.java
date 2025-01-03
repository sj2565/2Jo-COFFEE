package myCafe.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import myCafe.common.SuperClass;
import myCafe.common.controller.ListController;
import myCafe.common.controller.MyPageController;
import myCafe.dao.CafeDao;
import myCafe.model.Cafe;

public class UpdateController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");

		CafeDao dao = new CafeDao();
		Cafe bean = dao.GetDataById(id);

		String gotopage = null;

		if (bean != null) {
			request.setAttribute("bean", bean);
			gotopage = "/login/update.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(gotopage);
			dispatcher.forward(request, response);
		} else {
			new ListController().doGet(request, response);
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 폼 양식에서 넘어온 파라미터를 챙김
		Cafe bean = new Cafe();

		bean.setId(request.getParameter("id"));
		bean.setName(request.getParameter("name"));
		bean.setPassword(request.getParameter("password"));
		bean.setHphone(request.getParameter("hphone"));
		bean.setBalance(Integer.parseInt(request.getParameter("balance")));

		System.out.println(bean.toString());

		// 다오를 이용하여 해당 Bean 객체를 넘겨서 수정
		CafeDao dao = new CafeDao();
		int cnt = -99999; // 업데이트 된 행개수
		cnt = dao.UpdateData(bean);

		// 다시 게시물 목록 페이지로 이동
		new MyPageController().doGet(request, response);
	}
}
