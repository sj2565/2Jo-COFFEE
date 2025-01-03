package myCafe.memu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myCafe.common.SuperClass;
import myCafe.dao.MenuDao;
import myCafe.model.Cafe;

public class MenuDetailViewController extends SuperClass {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 해당 게시물의 파라미터 글번호를 챙깁니다.
		int cid = Integer.parseInt(request.getParameter("cid"));

		// 다오 객체에 해당 글번호를 넘겨서 글에 대한 정보를 Bean으로 반환 받습니다.
		MenuDao dao = new MenuDao();
		Cafe bean = dao.GetDataById(cid);

		// 상세 보기 페이지로 이동합니다.

		String gotopage = null;

		if (bean != null) {
			// request 영역에 Bean을 바인딩합니다.
			request.setAttribute("bean", bean);
			gotopage = "/menu/menuDetailView.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(gotopage);
			dispatcher.forward(request, response);

		} else {
			new MenuListController().doGet(request, response);
		}
	}
}
