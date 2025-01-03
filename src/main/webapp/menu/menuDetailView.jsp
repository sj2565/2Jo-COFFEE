<%@ page import="myCafe.model.Cafe"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<%
Cafe bean = (Cafe) request.getAttribute("bean");
%>

<%

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
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
	<div class="container">
		<br>
		<div class="panel">
			<div class="panel-heading" style="background-color: #c35d1d; color: white;">
				<h3>메뉴 상세 보기</h3>
			</div>
			<div class="panel-body">
				<div class="col-sm-3">
					<table>
						<tr>
							<td>
								<%
								if (bean.getImage() == null) {
								%> <img alt="no-image" class="img-rounded"
								src="<%=contextPath%>/image/noImage.png" width="240"
								height="180"> <%
 } else {
 %> <img alt="" class="img-rounded"
								src="<%=uploadedPath%>/<%=bean.getImage()%>" width="240"
								height="180"> <%
 }
 %>
							</td>
						</tr>
					</table>
				</div>
				<div class="col-sm-9">
					<table class="table table-hover">
						<tr>
							<th>메뉴 번호</th>
							<td><%=bean.getCid()%></td>
						</tr>
						<tr>
							<th>이름</th>
							<td><%=bean.getCname()%></td>
						</tr>
						<tr>
							<th>가격</th>
							<td><%=bean.getPrice()%>원</td>
						</tr>
						<tr>
							<th>칼로리</th>
							<td><%=bean.getKcal()%>Kcal</td>
						</tr>
					</table>
					<%
					if (loginfo.getId().equals("admin")) {
					%>
					<a href="<%=NoForm%>menuUpdate&cid=<%=bean.getCid()%>"
						class="btn" style="background-color: #c35d1d; color: white;"> <span
						class="glyphicon glyphicon-pencil"></span>수정
					</a> 
					<a href="<%=NoForm%>menuDelete&cid=<%=bean.getCid()%>"
						class="btn" style="background-color: #c35d1d; color: white;"> <span
						class="glyphicon glyphicon-trash"></span>삭제
					</a>
					<%
					} else {
					%>
					<button
						onclick="document.location='<%=contextPath%>/Web?command=orderInsert&cid=<%=bean.getCid()%>&id=<%=loginfo.getId()%>'"
						class="btn" style="background-color: #c35d1d; color: white;">
						<span class="glyphicon glyphicon-shopping-cart"></span>담기
					</button>
					<%
					}
					%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>