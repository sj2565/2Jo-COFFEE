package myCafe.memu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import myCafe.common.SuperClass;
import myCafe.dao.MenuDao;
import myCafe.model.Cafe;

public class MenuInsertController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("메뉴 등록");

		String gotopage = "/menu/menuInsert.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(gotopage);
		dispatcher.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MultipartRequest multi = (MultipartRequest) request.getAttribute("multi");

		System.out.println("멀티 객체 정보");
		System.out.println(multi);

		// 업로드를 위하여 넘겨진 파라미터를 챙김
		String cname = multi.getParameter("cname");
		String image = multi.getFilesystemName("image");
		int price = Integer.parseInt(multi.getParameter("price"));
		int kcal = Integer.parseInt(multi.getParameter("kcal"));

		// 빈(Board) 객체에 데이터를 세팅함
		Cafe bean = new Cafe();
		bean.setCname(cname);
		bean.setImage(image);
		bean.setPrice(price);
		bean.setKcal(kcal);

		// 다오 객체를 이용하여 데이터베이스에 추가
		MenuDao dao = new MenuDao();
		int cnt = -99999;
		cnt = dao.InsertData(bean);

		// 게시물 목록 페이지로 이동
		new MenuListController().doGet(request, response);

	}
}
