<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	<fieldset style="border:none;">
		<form method="get" action="${cp }/search/search">
			<select name="CATEGORY">
				<option value="0">상품분류 선택</option>
				<option value="1">상의</option>
				<option value="2">하의</option>
				<option value="3">원피스</option>
				<option value="4">아우터</option>
				<option value="5">악세사리</option>
				<option value="6">검색</option>
			</section> 
				<input type="text" name="keyword" value="${keyword }"><br>
			<select name="sort">
				<option value="7">:::기준선택:::</option>
				<option value="8">신상품 순</option>
				<option value="9">인기상품 순</option>
			</section><br>
			<input type="submit" value="SEARCH"> 
		</form>
	</fieldset>
</div>
<div id="searchResult" style="width: 500px; height: 100px;"> <!-- 조회된 갯수 출력 -->
	<div style="width: 300px; height: 50px;text-align: center;">
		<!-- ${total} --> ITEMS
	</div>
</div>
<div id="searchProducts"> <!-- 조회된 제품들 -->
	<c:forEach var="vo" items="${requestScope.list }">
		상품사진 : ${vo.pp_title }
		상품명 : ${vo.pi_name } 
		가격: ${vo.pi_price }
		색상 : ${vo.pd_color }
		태그 : ${vo.t_name }
		<br>
	</c:forEach>
</div>
