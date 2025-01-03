<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<script language="JavaScript" type="text/JavaScript">
	function linkToOpener(URL) {
		if (window.opener && !window.opener.closed)
			window.opener.location = URL;
		window.close();
	}
</script>
<head>
<style>
h3 {
	text-align: center;
}

h5 {
	text-align: center;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원가입 성공!</h3>
	<%
	String contextPath = request.getContextPath();
	%>
	<h5>
		<a href="javascript:linkToOpener('login.jsp');">로그인 하러가기</a>
	</h5>
</body>
</html>