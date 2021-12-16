<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매자 상품 목록</title>
</head>
<body>
	<div class="row" align="center">
		<h1>판매자 상품 목록</h1>
		<c:forEach var="productList" items="${requestScope.productList }">
			<div class="col-md-2">
				<h3>${productList.pi_name }</h3>
				<p>${productList.pi_num }
				<p>${productList.pd_size }
				<p>${productList.pd_color }
				<p>${productList.pd_count }
				<p>${productList.pi_price }원
			</div>
		</c:forEach>
	</div>
	<hr>
</body>
</html>