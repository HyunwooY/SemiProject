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
			<div class="col-md-2">
				<h3>${list.pi_name }</h3>	
				<p>${list.pi_num }
				<p>${list.pd_size }
				<p>${list.pd_color }
				<p>${list.pd_count }
				<p>${list.pi_price }원	
			</div>
		</c:forEach>
	</div>
	<hr>
</body>
</html>