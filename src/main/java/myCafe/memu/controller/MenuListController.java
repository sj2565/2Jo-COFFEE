package myCafe.memu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myCafe.common.SuperClass;
import myCafe.dao.MenuDao;
import myCafe.model.Cafe;

public class MenuListController extends SuperClass {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시물 목록을 읽어 와서 컬렉션에 저장합니다.
		MenuDao dao = new MenuDao();

		List<Cafe> lists = dao.SelectDataList();
		request.setAttribute("lists", lists);

		System.out.println("메뉴 건수 : " + lists.size());

		// 게시물 목록 페이지로 이동합니다.
		String gotopage = "/menu/menu.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(gotopage);
		dispatcher.forward(request, response);

	}
}
