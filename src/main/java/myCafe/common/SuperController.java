package myCafe.common;

import java.io.IOException;

import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 컨트롤러 인터페이스 : 모든 컨트롤러의 최상위 개념
// 요청이 들어오면 특정한 컨트롤러를 수행해주는 인터페이스
public interface SuperController {
	// 할 일을 추상 메소드로 구현해 둡니다.
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
