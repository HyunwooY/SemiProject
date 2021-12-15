
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
		<td>${list.pi_num }</td>
		<td>${list.si_id }</td>
		<td>${list.pi_name }</td>
		<td>${list.pi_price }</td>
		<td>${list.pi_count }</td>
		<td>${list.pi_date }</td>
		<td>${list.pi_category }</td>
		<td>${list.pp_title }</td>
		<td>${list.pd_num }</td>
		<td>${list.pd_size }</td>
		<td>${list.pd_color }</td>
		<td>${list.pd_count }</td>
	</c:forEach>
</body>
</html>
