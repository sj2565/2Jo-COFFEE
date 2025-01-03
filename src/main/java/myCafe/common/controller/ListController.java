package myCafe.common.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myCafe.common.SuperClass;
import myCafe.dao.CafeDao;
import myCafe.model.Cafe;

public class ListController extends SuperClass {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CafeDao dao = new CafeDao();
		List<Cafe> lists = dao.SelectDataList();

		// request 영역에 데이터를 바인딩한다.
		request.setAttribute("lists", lists);
		System.out.println("회원 목록 개수 : " + lists.size());

		// 메뉴
		String gotopage = "/common/lists.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(gotopage);
		dispatcher.forward(request, response);
	}
}
