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
	상품번호<br>
	<input type="text" name="pi_num"><br>
	사업자<br>
	<input type="text" name="si_id"><br>		
	상품명<br>
	<input type="text" name="pi_name"><br>
	가격<br>
	<input type="text" name="pi_price"><br>
	판매수인데잘못넣음<br>
	<input type="text" name="pi_count"><br>
	분류<br>
	<input type="text" name="pi_category"><br>
	
	
	<input type="submit" value="등록">
	<input type="reset" value="취소"><br>
</form>
</body>
</html>