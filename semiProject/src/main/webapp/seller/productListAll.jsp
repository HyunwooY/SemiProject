<%@page import="chaneloper.vo.ProductVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet"
	href="https:/maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<body>	
		<div id="" class="row" align="center">
			<c:forEach var="list" items="${requestScope.list }">
				<div class="col-md-4">
					<h3>${list.pi_name }</h3>				
					<p>${list.pi_price }원	
					<p>${list.pd_color }
					<p>${list.pi_date }<br>
					<a href="#" class="btn btn-secondary" role="button">상세 정보</a>
				</div>
		</c:forEach>
		</div>
	<hr>


