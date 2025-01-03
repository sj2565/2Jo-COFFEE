<%@page import="myCafe.model.Cafe"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<%
Cafe bean = (Cafe) request.getAttribute("bean");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<br />
		<div class="panel">
			<div class="panel-heading"
				style="background-color: #c35d1d; color: white;">
				<h3>회원 상세 보기</h3>
			</div>
			<div class="panel-body">
				<div>
					<table class="table table-hover">
						<tr>
							<th>아이디</th>
							<td><%=bean.getId()%></td>
						</tr>
						<tr>
							<th>이름</th>
							<td><%=bean.getName()%></td>
						</tr>
						<tr>
							<th>휴대폰 번호</th>
							<td><%=bean.getHphone()%></td>
						</tr>
						<tr>
							<th>잔액</th>
							<td><%=bean.getBalance()%></td>
						</tr>
						<tr>
						</tr>
					</table>
					<div align="center">
						<%
						if (loginfo.getId().equals(bean.getId())) {
						%>
						<a href="<%=NoForm%>meUpdate&id=<%=bean.getId()%>" class="btn"
							style="background-color: #c35d1d; color: white;">수정</a>
						<%
						}
						%>
						<%
						if (loginfo.getId().equals(bean.getId())) {
						%>
						<a href="<%=NoForm%>meDelete&id=<%=bean.getId()%>" class="btn"
							style="background-color: #c35d1d; color: white;">회원 탈퇴</a>
						<%
						} else if (whologin == 2) {
						%>
						<a href="<%=NoForm%>meDelete&id=<%=bean.getId()%>" class="btn"
							style="background-color: #c35d1d; color: white;">회원 삭제</a>
						<%
						}
						%>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>