<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/searchResult.css">
<c:choose>
	<c:when test="${empty requestScope.keyword }"> <!-- 검색탭으로 들어온경우 -->
		<c:set var="keyword" value=""/>
	</c:when>
	<c:otherwise>
		<c:set var="keyword" value="${keyword }"/><!-- 검색키워드로 들어온경우 --><br>
	</c:otherwise>
</c:choose>
<c:set var="cp" value="${pageContext.request.contextPath }"/>
<div id="searchbox">
	<fieldset>
		<form method="get" action="${cp }/search/search">
			<div id="items">
				<select id="CATEGORY" name="CATEGORY">
					<option value="1" <c:if test="${CATEGORY=='1' }">selected</c:if>>상품분류 선택</option>
					<option value="상의" <c:if test="${CATEGORY=='상의' }">selected</c:if>>상의</option>
					<option value="하의" <c:if test="${CATEGORY=='하의' }">selected</c:if>>하의</option>
					<option value="원피스" <c:if test="${CATEGORY=='원피스' }">selected</c:if>>원피스</option>
					<option value="아우터" <c:if test="${CATEGORY=='아우터' }">selected</c:if>>아우터</option>
					<option value="악세사리" <c:if test="${CATEGORY=='악세사리' }">selected</c:if>>악세사리</option>
				</select> 
			</div>
			<div id="items">
				<input type="text" id="keyword" name="keyword" value="${keyword }"><br>
			</div>
			<div id="items">
				<select id="sort" name="sort">
					<option value="1" <c:if test="${CATEGORY=='1' }">selected</c:if>>:::기준선택:::</option>
					<option value="pi_date" <c:if test="${sort=='신상품 순' }">selected</c:if>>신상품 순</option>
					<option value="pi_count" <c:if test="${sort=='인기상품 순' }">selected</c:if>>인기상품 순</option>
				</select><br>
			</div>

			<input type="submit" value="SEARCH" id="searchBar">
		</form>
	</fieldset>
</div>
<div id="searchResult" > <!-- 조회된 갯수 출력 -->
	<div style= "text-align: center;">
		<!-- ${total} --> ITEMS
	</div>
</div>
<div id="searchProducts"> <!-- 조회된 제품들 -->
<ul class="list">
	<c:forEach var="vo" items="${requestScope.list }">
	<li class="item">
		<div class="box">
			<p class="Img">
				<a href="#"> <img src=""> </a>
			</p>
			<div class="prdInfo">
				<p class="name">${vo.pi_name }</p>
				<p class="price">${vo.pi_price }</p>
				<p class="tag"></p>
				<p class="color">${vo.pd_color } </p>				
			</div>
		</div>
	</li>
	</c:forEach>

</ul>

</div>