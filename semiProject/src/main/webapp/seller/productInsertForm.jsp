<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력</title>
</head>
<body>

<form method="post" action="${pageContext.request.contextPath }/seller/insert">
	이미지 <br>
	<input type="file" name="img"><br>
	상품번호<br>
	<input type="text" name="pi_num"><br>	
	상품명<br>
	<input type="text" name="pi_name"><br>
	가격<br>
	<input type="text" name="pi_price"><br>
	색상<br>
	<input type="text" name="pd_color"><br>
	사이즈<br>
	<input type="text" name="pd_size"><br>
	
	<select id="category" name="category">
		<option value="1">상품분류 선택</option>
		<option value="상의">상의</option>
		<option value="하의">하의</option>
		<option value="원피스">원피스</option>
		<option value="아우터">아우터</option>
		<option value="악세사리">악세사리</option>		
	</select><br><br>
	<input type="submit" value="등록">
	<input type="reset" value="취소"><br>
</form>
</body>
</html>