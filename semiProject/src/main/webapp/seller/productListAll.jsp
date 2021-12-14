
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
	<h1 class="display-3">상품 목록</h1>
	<c:forEach var="vo" items="${list }">	
		<p>${vo.pi_num }</p>
		<p>${vo.si_id }</p>
		<p>${vo.pi_name }</p>
		<p>${vo.pi_price }</p>
		<p>${vo.pi_count }</p>
		<p>${vo.pi_date }</p>
		<p>${vo.pi_category }</p>
		<p>${vo.pp_title }</p>
		<p>${vo.pd_num }</p>
		<p>${vo.pd_size }</p>
		<p>${vo.pd_color }</p>
		<p>${vo.pd_count }</p>		
	</c:forEach>
</body>
</html>
