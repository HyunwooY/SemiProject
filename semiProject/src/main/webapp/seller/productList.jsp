<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매자 상품 목록</title>
</head>
<body>
	<div class="row" align="center">
		<h1>판매자 상품 목록</h1>
		<c:forEach var="list" items="${requestScope.list }">
			<h3>${list.pi_name }</h3>
		</c:forEach>
		
		<div class="col-md-4">
			<c:forEach var="list" items="${requestScope.list }">
				상품번호: <p>${list.pi_num }
				사이즈: <p>${list.pd_size }
				색상: <p>${list.pd_color }
				재고수: <p>${list.pd_count }
				가격: <p>${list.pi_price }원	
			</c:forEach>
		</div>
	</div>
	<hr>
</body>
</html>