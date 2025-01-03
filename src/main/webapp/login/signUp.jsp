<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
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
h3 {
	text-align: center;
}

h4 {
	text-align: center;
}

body {
	background-color: #F2ECDA;
}

/* 네모박스  */
form {
	width: 400px;
	height: 740px;
	margin: 60px auto;
	background: #ECE5DA;
	padding: 50px 120px 50px 120px;
	text-align: center;
	-webkit-box-shadow: 2px 2px 3px rgba(0, 0, 0, 0.1);
	box-shadow: 2px 2px 3px rgba(0, 0, 0, 0.1);
}

.input {
	width: 120;
	padding: 10px;
	background: transparent;
	border: none;
	outline: none;
}

/* 로그인 밑줄 부분 */
.line-box {
	position: relative;
	width: 100%;
	height: 2px;
	background: #BCBCBC;
}

.line {
	position: absolute;
	width: 0%;
	height: 2px;
	top: 0px;
	left: 50%;
	transform: translateX(-50%);
	background: #FBB94B;
	transition: ease .6s;
}

.input:focus+.line-box .line {
	width: 100%;
}

.label-active {
	top: -3em;
}
</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">

		<form class="form-horizontal" action="<%=YesForm%>" method="post">
			<input type="hidden" name="command" value="meSignUp"> <img
				src="<%=contextPath%>/image/logo2.png" width="200"
				style="padding-bottom: 40px">

			<!-- 아이디 -->
			<div class="form-group">
				<label for="id" style="color: #6E6E6E">ID<input type="text"
					class="input" id="id" name="id">
					<div class="line-box">
						<div class="line"></div>
					</div>
				</label>
			</div>

			<!-- 비밀번호 -->
			<div class="form-group">
				<label for="password" style="color: #6E6E6E; padding-top: 20px">PASSWORD<input
					type="password" class="input" id="password" name="password">
					<div class="line-box">
						<div class="line"></div>
					</div>
				</label>
			</div>

			<!-- 이름 -->
			<div class="form-group">
				<label for="name" style="color: #6E6E6E; padding-top: 20px">NAME<input
					type="text" class="input" id="name" name="name">
					<div class="line-box">
						<div class="line"></div>
					</div>
				</label>
			</div>

			<!-- 폰번호 -->
			<div class="form-group">
				<label for="hphone" style="color: #6E6E6E; padding-top: 20px">PHONE
					NUMBERS<input type="text" class="input" id="hphone" name="hphone">
					<div class="line-box">
						<div class="line"></div>
					</div>
				</label>
			</div>

			<!-- 현재 잔액 -->
			<div class="form-group">
				<label for="balance"
					style="color: #6E6E6E; padding-top: 20px; padding-bottom: 20px">현재
					잔액 <input type="text" class="input" id="balance" name="balance">
					<div class="line-box">
						<div class="line"></div>
					</div>
				</label>
			</div>

			<button type="submit" class="btn">가입하기</button>
		</form>


	</div>
</body>
</html>