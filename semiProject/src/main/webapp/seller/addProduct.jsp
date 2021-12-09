<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
</head>
<body>
	<h1>상품 등록</h1>
	<form method="post"	action="${pageContext.request.contextPath }/seller/insert">		
		상품 번호<br>
		<input type="text" name="pi_num"><br>
		상품명<br>
		<input type="text" name="pi_name"><br>
		가격<br>
		<input type="text" name="pi_price"><br>
		판매수<br>
		<input type="text" name="pi_sales"><br>
		조회수<br>
		<input type="submit" value="등록">
	</form>
	
</body>
</html>