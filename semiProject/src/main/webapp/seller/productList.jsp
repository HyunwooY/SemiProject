<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
	table {align: center;}
</style>

<form method="post" action="${pageContext.request.contextPath }/seller/sellerProductList">
<table border="1" width="1000">
	<tr>
		<th>상품사진</th>
		<th>상품이름</th>
		<th>상품번호</th>
		<th>상품사이즈</th>
		<th>상품색상</th>
		<th>상품분류</th>
		<th>재고수</th>
		<th>상품가격</th>
		<th>상품등록일</th>
		<th>수정</th>
		<th>삭제</th>
	</tr>
	<c:forEach var="productList" items="${requestScope.productList }">
		
	<tr>
	<th><img src="${pageContext.request.contextPath }/upload/${productList.pp_title }"></th>
		<td>${productList.pi_name }</td>
		<td>${productList.pi_num }</td>
		<td>${productList.pd_size }</td>
		<td>${productList.pd_color }</td>
		<td>${productList.pi_category }</td>
		<td>${productList.pd_count }</td>
		<td>${productList.pi_price }원</td>
		<td>${productList.pi_date }</td>
		<td><a href="${pageContext.request.contextPath }/seller/productUpdate?pi_num=${productList.pi_num}">수정</a></td>
		<td><a href="${pageContext.request.contextPath }/seller/productDelete?pi_num=${productList.pi_num}">수정</a></td>
	</tr>
	</c:forEach>

</table>
</form>