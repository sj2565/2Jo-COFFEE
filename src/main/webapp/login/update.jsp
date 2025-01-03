<%@ page import="myCafe.model.Cafe"%>
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
				<h2>회원 정보 수정</h2>
			</div>
			<div class="panel-body">
				<form class="form-horizontal" action="<%=YesForm%>" method="post">
					<input type="hidden" name="command" value="meUpdate">
					<div class="form-group">
						<label class="control-label col-sm-2" for="id">아이디</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="fakeid" name="fakeid"
								disabled="disabled" value="<%=bean.getId()%>"> <input
								type="hidden" name="id" value="<%=bean.getId()%>">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="name">이름</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="name" name="name"
								value="<%=bean.getName()%>">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="password">비밀번호</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="password"
								name="password" value="<%=bean.getPassword()%>">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="hphone">휴대폰 번호</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="hphone" name="hphone"
								value="<%=bean.getHphone()%>">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="balance">잔액</label>
						<div class="col-sm-10">
							<input type="number" class="form-control" id="balance"
								name="balance" value="<%=bean.getBalance()%>">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn" style="background-color: #c35d1d; color: white;">수정</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>