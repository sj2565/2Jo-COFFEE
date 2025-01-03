<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>

<%@page import="java.util.List"%>
<%@page import="myCafe.model.CafeMiniBean"%>

<%
List<CafeMiniBean> lists = (List<CafeMiniBean>) request.getAttribute("lists");
%>
<%
Cafe bean1 = (Cafe) request.getAttribute("bean");
int total = 0;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<br>
		<div class="panel">
			<div class="panel-heading" style="background-color: #c35d1d; color: white;">
				<h3>주문내역</h3>
			</div>
			<div class="panel-body">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>메뉴</th>
							<th>수량</th>
							<th>가격</th>
						</tr>
					</thead>
					<tbody>
						<%
						for (CafeMiniBean bean : lists) {
						%>
						<tr>
							<td><%=bean.getName()%></td>
							<td><%=bean.getCnt()%></td>
							<td><%=bean.getAmount()%></td>
							<td><a
								href="<%=NoForm%>orderDelete&cid=<%=bean.getCid()%>&id=<%=loginfo.getId()%>"><img
									alt="" class="img-rounded" src="<%=contextPath%>/image/취소.jpeg"
									width="20" height="15"></a></td>
						</tr>
						<%
						total += bean.getAmount();
						}
						%>
					</tbody>
				</table>
				총액 :
				<%=total%>
				<a
					href="<%=NoForm%>orderPayment&id=<%=loginfo.getId()%>&total=<%=total%>&balance=<%=loginfo.getBalance()%>"
					class="btn" style="background-color: #c35d1d; color: white;"><span class="glyphicon glyphicon-credit-card"></span>결제하기</a>
				<a href="<%=NoForm%>orderDeleteAll&id=<%=loginfo.getId()%>"class="btn" style="background-color: #c35d1d; color: white;">
				<span class="glyphicon glyphicon-trash"></span>취소</a>

			</div>
		</div>
	</div>
</body>
</html>