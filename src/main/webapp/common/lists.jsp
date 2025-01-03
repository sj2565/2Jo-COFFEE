<%@page import="myCafe.model.Cafe"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="./../common/common.jsp"%>

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
			<div class="panel-heading" style="background-color: #c35d1d; color: white;">
				<h3>회원 목록</h3>
			</div>
			<div class="panel-body">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>아이디</th>
							<th>이름</th>
						</tr>
					</thead>
					<tbody>
						<%
						List<Cafe> lists = (List<Cafe>) request.getAttribute("lists");
						%>
						<%
						for (Cafe bean : lists) {
						%>
						<tr>
							<td>
								<%
								if (loginfo.getId().equals(bean.getId()) || whologin == 2) {
								%> <a href="<%=NoForm%>myPage&id=<%=bean.getId()%>"><%=bean.getId()%></a>
								<%
								} else {
								%> <%=bean.getId()%> <%
 }
 %>
							</td>
							<td><%=bean.getName()%></td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>