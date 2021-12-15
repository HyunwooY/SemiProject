<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 상품 목록</title>
</head>
<body>
	<h1>상품 목록</h1>	
	<c:forEach var="list" items="${requestScope.list }">
		<td>${list.pi_name }</td>		
		<td>${list.pi_price }</td>		
		<td>${list.pd_color }</td>
	</c:forEach>
</body>
</html>

