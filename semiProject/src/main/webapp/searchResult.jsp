<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="css.searchResult.css">
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
				<option value="0" <c:if test="${CATEGORY=='0' }">selected</c:if>>상품분류 선택</option>
				<option value="1" <c:if test="${CATEGORY=='1' }">selected</c:if>>상의</option>
				<option value="2" <c:if test="${CATEGORY=='2' }">selected</c:if>>하의</option>
				<option value="3" <c:if test="${CATEGORY=='3' }">selected</c:if>>원피스</option>
				<option value="4" <c:if test="${CATEGORY=='4' }">selected</c:if>>아우터</option>
				<option value="5" <c:if test="${CATEGORY=='5' }">selected</c:if>>악세사리</option>
				<option value="6" <c:if test="${CATEGORY=='6' }">selected</c:if>>검색</option>
			</section> 
				<input type="text" name="keyword" value="${keyword }" placeholder="상품명"><br>
			<select name="sort">
				<option value="7" <c:if test="${sort=='7' }">selected</c:if>>:::기준선택:::</option>
				<option value="8" <c:if test="${sort=='8' }">selected</c:if>>신상품 순</option>
				<option value="9" <c:if test="${sort=='9' }">selected</c:if>>인기상품 순</option>
			</section><br>
			<input type="submit" value="SEARCH">
			<input type="reset" value="초기화"> 
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
