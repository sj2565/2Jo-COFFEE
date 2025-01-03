<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="./../common/common.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
@import url(//fonts.googleapis.com/earlyaccess/jejugothic.css);

h2 {
	font-family: "jg";
}
</style>
</head>
<body>
	<div class="container">
		<br />
		<div class="panel">
			<div class="panel-heading" style="background-color: #c35d1d; color: white;">
				<h3>메뉴 등록</h3>
			</div>
			<div class="panel-body">
				<form class="form-horizontal" action="<%=YesForm%>" method="post"
					enctype="multipart/form-data">
					<input type="hidden" name="command" value="menuInsert">
					<!-- no 컬럼은 만들지 않아도 시퀀스가 자동으로 만들어 줌 -->
					<div class="form-group">
						<label class="control-label col-sm-2" for="cname">메뉴 이름</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="cname" name="cname">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="image">이미지 :</label>
						<div class="col-sm-10">
							<input type="file" class="form-control" id="image" name="image">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="price">가격</label>
						<div class="col-sm-10">
							<input type="number" class="form-control" id="price" name="price">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="kcal">칼로리 :</label>
						<div class="col-sm-10">
							<input type="number" class="form-control" id="kcal" name="kcal">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn" style="background-color: #c35d1d; color: white;">
								<span class="glyphicon glyphicon-send"></span> 전송
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>