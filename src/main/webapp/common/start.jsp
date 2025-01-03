<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
html, body {
	height: 100%;
}

body {
	text-align: center;
}

body:before {
	content: '';
	height: 100%;
	display: inline-block;
	vertical-align: middle;
}

button {
	background: #C35D1D;
	color: #fff;
	border: none;
	border-radius: 5px;
	position: relative;
	height: 60px;
	font-size: 1.6em;
	padding: 0 4em;
	cursor: pointer;
	transition: 800ms ease all;
	outline: none;
}

button:hover {
	background: #fff;
	color: #FF8D3A;
}

button:before, button:after {
	content: '';
	position: absolute;
	top: 0;
	right: 0;
	height: 2px;
	width: 0;
	background: #FF8D3A;
	transition: 400ms ease all;
}

button:after {
	right: inherit;
	top: inherit;
	left: 0;
	bottom: 0;
}

button:hover:before, button:hover:after {
	width: 100%;
	transition: 800ms ease all;
}
</style>
<body>
	<%
	String contextPath = request.getContextPath();
	%>
	<button
		onclick="document.location='<%=contextPath%>/Web?command=meLogin'">회원</button>
	<button
		onclick="document.location='<%=contextPath%>/Web?command=meSignUp'">비회원</button>
</body>
</html>