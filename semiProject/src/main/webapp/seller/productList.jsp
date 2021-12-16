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
	
	<div id="productlist"></div>
		<table id = "table">		
			<c:forEach var="productList" items="${requestScope.productList }">			
					<th>${productList.pi_name }
					<th>${productList.pi_num }
					<th>${productList.pd_size }
					<th>${productList.pd_color }
					<th>${productList.pd_count }
					<th>${productList.pi_price }원
				
			</c:forEach>
		</table>
	<hr>
</body>
</html>