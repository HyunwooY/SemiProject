<%@page import="chaneloper.vo.ProductVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/css.css">
<body>	
	<hr>
		<div id="" class="row" align="center">
			<c:forEach var="list" items="${requestScope.list }">
				<div class="col-md-2">
					<img src="../upload/${list.pp_title }">
					<h3>${list.pi_name }</h3>
					<p>${list.pi_price }원
					<p>${list.pd_color }
					<p>${list.pi_date }<br>
					<a href="" class="btn btn-secondary" role="button">상세 정보</a>
				</div>
		</c:forEach>
		</div>
	<hr>


