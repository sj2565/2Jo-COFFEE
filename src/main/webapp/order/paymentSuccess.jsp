<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<style>
h3 {
	text-align: center;
}

p {
	text-align: center;
}

div {
	text-align: center;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>결제 완료!</h3>
	<hr />
	<p>
		<a href="<%=NoForm%>orderDeleteAll&id=<%=loginfo.getId()%>">메뉴
			화면으로 돌아가기</a>
	</p>
</body>
</html>