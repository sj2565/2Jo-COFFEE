<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="./../common/common.jsp"%>
<%
request.setCharacterEncoding("UTF-8");

String menu = (String) request.getAttribute("menu");
String price = (String) request.getAttribute("price");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Page</title>


<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.js"
	integrity="sha512-n/4gHW3atM3QqRcbCn6ewmpxcLAHGaDjpEBu4xZd47N0W2oQ+6q7oc3PXstrJYXcbNU1OHdQ1T7pAP+gi5Yu8g=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<script type="text/javascript">
	
</script>

<style>
p {
	text-align: center;
}

body {
	background-color: #F2ECDA;
}

.container {
	min-height: 50vh;
	display: flex;
	flex-direction: row;
}

.order_container {
	position: relative;
	width: 100%;
	display: flex;
	flex-flow: wrap;
	justify-content: space-around;
	align-items: center;
	margin-top: 50px;
}

.orderbox {
	padding-bottom: 100px;
	left: 100px
}
</style>
</head>
<body>
	<p>
		<img src="<%=contextPath%>/image/menulogo.png" width="200"
			style="padding-bottom: 25px; padding-top: 30px;">
	</p>

	<div class="container">
		<div class="order_container">
			<%@page import="java.util.List"%>
			<%@page import="myCafe.model.Cafe"%>

			<%
			List<Cafe> lists = (List<Cafe>) request.getAttribute("lists");
			%>

			<%
			for (Cafe bean : lists) {
			%>
			<div>
				<a href="<%=NoForm%>menuDetailView&cid=<%=bean.getCid()%>"> <%
 if (bean.getImage() == null) {
 %> <img alt="no-image" class="img-rounded"
					src="<%=contextPath%>/image/noImage.png" width="200" height="150">
					<%
					} else {
					%> <img alt="" class="img-rounded"
					src="<%=uploadedPath%>/<%=bean.getImage()%>" width="200"
					height="150"> <%
 }
 %>
				</a>
				<div
					style="margin-top: 5px; margin-bottom: 10px; text-align: center;"><%=bean.getCname()%></div>
				<div
					style="margin-top: 5px; margin-bottom: 5px; text-align: center;"><%=bean.getPrice()%>원
				</div>
			</div>
			<%
			}
			%>
			<div class="container">
				<div class="order_container">
					<%
					if (!loginfo.getId().equals("admin")) {
					%>
					<div class="orderbox">
						<a
							href="<%=contextPath%>/Web?command=orderPage&id=<%=loginfo.getId()%>">
							<img alt="no-image" class="img-rounded"
							src="<%=contextPath%>/image/주문하기.png" width="120" height="120">
						</a>
					</div>
					<%
					}
					%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>