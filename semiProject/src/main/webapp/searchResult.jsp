<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="get" action="detailSearch.jsp">
	<select name="field1">
		<option value="1">상의</option>
		<option value="2">하의</option>
		<option value="3">원피스</option>
		<option value="4">아우터</option>
		<option value="5">악세사리</option>
		<option value="6">검색</option>
	</section>
	<br>
<c:choose>
		
		<c:when test="">
			<input type="text" value="">
		</c:when>
		<c:otherwise>
			<input type="text" value="">
		</c:otherwise>
</c:choose>
	<br>
	<select name="field2">
		<option value="7">신상품 순</option>
		<option value="8">인기상품 순</option>
	</section>
	<input type="button" value="SEARCH"> 
</form>
<div> <!-- 검색값 출력 -->
	<c:forEach var="vo" items="">
	</c:forEach>
</div>
</body>
</html>