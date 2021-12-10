<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정</title>
</head>
<body>
	<h1>상품 정보 수정</h1>
	<form action="${pageContext.request.contextPath }/seller/update">
		상품번호<br>
		<input type="text" name="pi_num" value=${requestScope.vo.pi_num }" ><br>
		
	</form>
</body>
</html>