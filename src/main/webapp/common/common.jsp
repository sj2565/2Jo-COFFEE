<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// 이 파일은 여러 파일에서 참조하는 공용 파일입니다.
String contextPath = request.getContextPath(); // 프로젝트 이름
String mappingName = "/Web"; // 서블릿에 정의되어 있음.

// YesForm :  일반적인 폼에서 사용할 변수
String YesForm = contextPath + mappingName;

// NoForm : <a> 태그에서 사용할 변수 이름
String NoForm = contextPath + mappingName + "?command=";

//out.print("YesForm : " + YesForm + "<br>") ;
%>

<%@page import="myCafe.model.Cafe"%>

<%
//로그인 상태를 저장하고 있는 변수
// 미로그인(0), 일반 사용자(1), 관리자 로그인(0)
// 관리자의 아이디는 "admin"이라고 가정합니다.
int whologin = 0;

Cafe loginfo = (Cafe) session.getAttribute("loginfo");

if (loginfo != null) {
	//out.println("누군가 로그인했음" + "<br>") ;
	if (loginfo.getId().equals("admin")) {
		whologin = 2;
	} else {
		whologin = 1;
	}
} else {
	//out.println("미 로그인 상태" + "<br>") ;
}
//out.println("whologin : " + whologin + "<br>") ;
%>

<%
String uploadedPath = (String) application.getAttribute("uploadedPath");
//out.println("업로드될 경로 : " + uploadedPath + "<br>") ;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>

body {
	background-color: #F2ECDA;
}
</style>
</head>
<body>
	<nav class="navbar navbar-default" style="background-color: #C35D1D;">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#"> <img
					src="<%=contextPath%>/image/logo2.png" width="110"></a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="<%=NoForm%>menuList"
					style="color: white">Home</a></li>

				<li><a href="#" class="dropdown-toggle"> <font
						color="white"> <%
 if (whologin == 0) {
 %> <%
 } else {
 %> <%=loginfo.getName()%>(<%=loginfo.getId()%>)님 <%
 }
 %>
					</font>
				</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li>
					<%
					if (whologin == 0) {
					%> <a href="<%=NoForm%>meSignUp" style="color: white"> <span
						class="glyphicon glyphicon-edit" style="color: white"></span> 회원가입
				</a> <%
 }
 %>
				</li>
				<li>
					<%
					if (whologin == 2) {
					%> <a href="<%=NoForm%>meList" style="color: white"> <span
						class="glyphicon glyphicon-tasks" style="color: white"></span>
						회원정보 확인
				</a> <%
 }
 %>
				</li>
				<li>
					<%
					if (whologin == 2) {
					%> <a href="<%=NoForm%>menuInsert" style="color: white"> <span
						class="glyphicon glyphicon-list-alt" style="color: white"></span>
						메뉴 등록
				</a> <%
 }
 %>
				</li>
				<li>
					<%
					if (whologin == 1) {
					%> <a href="<%=NoForm%>myPage&id=<%=loginfo.getId()%>"
					style="color: white"> <span class="glyphicon glyphicon-user"
						style="color: white"></span> 마이페이지
				</a> <%
 }
 %>
				</li>

				<li>
					<%
					if (whologin == 0) {
					%> <a href="<%=NoForm%>meLogin" style="color: white"> <span
						class="glyphicon glyphicon-log-in" style="color: white"></span>
						로그인
				</a> <%
 }
 %>
				</li>
				<li>
					<%
					if (whologin != 0) {
					%> <a href="<%=NoForm%>meLogout" style="color: white"> <span
						class="glyphicon glyphicon-log-out" style="color: white"></span>
						로그 아웃
				</a> <%
 }
 %>
				</li>
			</ul>
		</div>
	</nav>
	<%
	String errmsg = (String) request.getAttribute("errmsg");
	if (errmsg != null) {
	%>
	<div class="alert alert-danger alert-dismissible">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">닫기</a>
		<strong><%=errmsg%></strong>
	</div>
	<%
	}
	request.removeAttribute("errmsg");
	%>
</body>
</html>
