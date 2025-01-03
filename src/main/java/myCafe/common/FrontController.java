package myCafe.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import utility.MyUtility;

/*
 *  todolist.txt : 커맨드 목록을 저장하고 있는 파일 
 *  superController : 모든 컨트롤러들의 상위 개념인 인터페이스
 *  superClass : superCOntroller를 상속 받는 클래스
 *  일반Controller : superClass를 상속 받는 일반 컨트롤러 클래스
 */
@WebServlet(urlPatterns = { "/Web" }, initParams = {
		@WebInitParam(name = "todolist", value = "/WEB-INF/todolist.txt") })

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServletContext application = null;
	
	// 파틸 업로드가 되는 실제 웹 서버 경로
	private String uploadedPath = null;

	// maplist 변수 : todolist 내에 들어있는 모든 항목들을 저장하고 있는 맵 구조
	private Map<String, SuperController> maplist = new HashMap<String, SuperController>();

	public void init(ServletConfig config) throws ServletException {
		// 초기화 메소드
		String todolist = config.getInitParameter("todolist");
		System.out.println("todolist : " + todolist);

		this.application = config.getServletContext();

		// configFileaPath 변수 : 실제 웹 서버 상의 경로
		String configFileaPath = this.application.getRealPath(todolist);
		System.out.println("configFileaPate : " + configFileaPath);

		this.maplist = MyUtility.getMapList(configFileaPath);
//		System.out.println("커맨드 갯수 : " + this.maplist.size());

		// 업로드가 될 실제 경로 구하기
		this.uploadedPath = this.application.getRealPath("/upload");

		this.application.setAttribute("uploadedPath", uploadedPath);
		System.out.println("파일 업로드 경로");
		System.out.println(uploadedPath);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter("command");
		System.out.println(command);

		if (command == null) {
			System.out.println("파일 업로드를 수행합니다.");
			MultipartRequest multi = MyUtility.getMultiPartReqeust(request, uploadedPath);

			System.out.println("multi == null");
			System.out.println(multi == null);

			if (multi != null) {
				command = multi.getParameter("command");

				request.setAttribute("multi", multi); // 업로드 객체를 바인딩
			}
		}

		SuperController controller = this.maplist.get(command);

		if (controller != null) {
			String method = request.getMethod().toLowerCase();

			if (method.equals("get")) {
				System.out.println(controller.toString() + " get 호출됨");
				controller.doGet(request, response);

			} else {
				System.out.println(controller.toString() + " post 호출됨");
				controller.doPost(request, response);
			}
		} else {
			System.out.println("요청하신 커맨드는 존재하지 않습니다");
		}
	}

}
