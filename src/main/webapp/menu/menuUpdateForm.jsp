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
			<div class="panel-heading" style="background-color: #c35d1d; color: white;">
				<h3>메뉴 수정</h3>
			</div>
			<div class="panel-body">
				<form class="form-horizontal" action="<%=YesForm%>" method="post"
					enctype="multipart/form-data">
					<input type="hidden" name="command" value="menuUpdate">

					<!-- no 컬럼은 보여 주되 읽기 전용으로 보여 줌 -->
					<!-- 읽기 전용은 파라미터 값이 넘겨지지 않습니다.  -->
					<div class="form-group">
						<label class="control-label col-sm-2" for="cid">메뉴 번호</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="fakecid"
								name="fakecid" disabled="disabled" value="<%=bean.getCid()%>">
							<input type="hidden" name="cid" value="<%=bean.getCid()%>">
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-2" for="cname ">이름</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="cname"
								name="cname" value="<%=bean.getCname()%>">
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-2" for="image">이미지</label>
						<div class="col-sm-10">
							<input type="file" class="form-control" id="image" name="image">
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-2" for="price">가격</label>
						<div class="col-sm-10">
							<input type="number" class="form-control" id="price" name="price"
								value="<%=bean.getPrice()%>">
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-2" for="kcal">칼로리</label>
						<div class="col-sm-10">
							<input type="number" class="form-control" id="kcal" name="kcal"
								value="<%=bean.getKcal()%>">
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn" style="background-color: #c35d1d; color: white;">
								<span class="glyphicon glyphicon-pencil"></span>수정
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
