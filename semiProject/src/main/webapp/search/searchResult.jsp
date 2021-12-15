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
<div class="searchbox">
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
					<option value="pi_date" <c:if test="${sort=='pi_date' }">selected</c:if>>신상품 순</option>
					<option value="pi_count" <c:if test="${sort=='pi_count' }">selected</c:if>>인기상품 순</option>
				</select><br>
			</div>
			<input type="submit" value="SEARCH" id="searchBar">
		</form>
	</fieldset>
</div>
<div id="searchProducts"> <!-- 조회된 제품들 -->
	<c:forEach var="vo" items="${requestScope.list }">
	<ul class="list" >
		<li class="item"> <!-- 상품 1 -->
			<div class="box"> <!-- 상품1 안에 제일 큰 박스 -->
				<p class="Img"> <!-- 이미지 -->
					<a href="${cp }/search/searchdetail?pi_num=${vo.pi_num }">
					<img src="${vo.pp_title }">
					</a>
				</p>
				<div class="prdInfo"> <!-- 상품 세부정보 -->
					<p class="name">
						<a href="${cp }/search/searchdetail?pi_num=${vo.pi_num }">
						<span>${vo.pi_name }</span>
						</a>
					</p>
					<p class="price">${vo.pi_price }</p>
					<p class="tag">샤넬로퍼 추천</p>
					<div class="color"> <!-- 색상 div -->
						<div class="colorchip">
							<ul>
								<li style="background-color:green;" class="chips"> </li>
								<li style="background-color:red" class="chips"> </li>
							</ul>
						</div>
					</div> 				
				</div>
			</div>
		</li>
	</ul>
	</c:forEach>
</div>