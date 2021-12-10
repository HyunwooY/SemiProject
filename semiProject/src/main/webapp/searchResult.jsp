<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath }"/>
<div>
	<form method="post" action="${cp }/search/search">
		<select name="CATEGORY">
			<option value="1">상의</option>
			<option value="2">하의</option>
			<option value="3">원피스</option>
			<option value="4">아우터</option>
			<option value="5">악세사리</option>
			<option value="6">검색</option>
		</section>
	<c:choose>
		<c:when test="${empty requestScope.keyword }"> <!-- 검색탭으로 들어온경우 -->
			<input type="text" value=""><br>
		</c:when>
		<c:otherwise>
			<input type="text" value="${keyword }"><!-- 검색키워드로 들어온경우 --><br>
		</c:otherwise>
	</c:choose>
		<select name="sort">
			<option value="7">신상품 순</option>
			<option value="8">인기상품 순</option>
		</section><br>
		<input type="button" value="SEARCH"> 
	</form>
</div>
<div> <!-- 검색값 출력 -->
	<c:forEach var="vo" items="${requestScope.list }">
		${vo.pi_num }
		${vo.pi_name }
		${vo.pi_price }
		${vo.pd_color }
		${vo.pp_title }
		${vo.t_name }
	</c:forEach>
</div>
