<%@page import="chaneloper.vo.ProductVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/css.css">
<style>
	.prod{float:legt}
</style>

	<hr>
<form action="${pagecontext.request.contextPath }/seller/">
	<div id="prod" class="row" align="center">
		<c:forEach var="list" items="${requestScope.list }">
			<!-- 이미지 클릭 시 상세페이지로 이동해야 함 -->
			<img src="../upload/${list.pp_title }" onclick="location.href='https://www.naver.com'">
			<h3>${list.pi_name }</h3>
			<p>${list.pi_price }원
			<p>${list.pd_color }			
			<p>${list.t_name }<br>
		</c:forEach>
	</div>
</form>
	<hr>


