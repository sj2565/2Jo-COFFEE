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

public class MenuUpdateController extends SuperClass {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cid = Integer.parseInt(request.getParameter("cid"));

		MenuDao dao = new MenuDao();
		Cafe bean = dao.GetDataById(cid);

		if (bean != null) {
			request.setAttribute("bean", bean);

			String gotopage = "/menu/menuUpdateForm.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(gotopage);
			dispatcher.forward(request, response);
		} else {
			new MenuListController().doGet(request, response);
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 멀티 파트 객체를 이용하여 파라미터를 가져 와야 합니다.
		MultipartRequest multi = (MultipartRequest) request.getAttribute("multi");
		System.out.println("MultipartRequest 정보");
		System.out.println(multi);

		// 폼양식에서 넘어온 파라미터를 챙깁니다.
		Cafe bean = new Cafe();

		bean.setCid(Integer.parseInt(multi.getParameter("cid")));
		bean.setCname(multi.getParameter("cname"));
		bean.setImage(multi.getFilesystemName("image"));
		bean.setPrice(Integer.parseInt(multi.getParameter("price")));
		bean.setKcal(Integer.parseInt(multi.getParameter("kcal")));

		System.out.println(bean.toString());

		// 다오를 이용하여 해당 Bean 객체를 넘겨서 수정합니다.
		MenuDao dao = new MenuDao();
		int cnt = -9999; // 업데이트 된 행개수
		cnt = dao.UpdateData(bean);

		// 다시 게시물 목록 페이지로 이동합니다.
		new MenuListController().doGet(request, response);
	}
}
