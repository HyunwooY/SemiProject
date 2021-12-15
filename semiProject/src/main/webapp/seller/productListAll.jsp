<%@page import="chaneloper.vo.ProductVo"%>
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
	<div class="row" align="center">
		<c:forEach var="list" items="${requestScope.list }">
			<h3>${list.pi_name }</h3>
			<img src="D:/2107/SemiProject/semiProject/src/main/webapp/images/" ${requestScope.list.pp_title} "style="width: 100%">
		</c:forEach>
		
		<div class="col-md-4">
			<c:forEach var="list" items="${requestScope.list }">				
				<p>${list.pi_price }원	
				<p>${list.pd_color }
			</c:forEach>
		</div>
	</div>
	<hr>
</body>
</html>

