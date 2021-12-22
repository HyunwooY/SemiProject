<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form method="post" action="${pageContext.request.contextPath }/seller/sellerProductList">
<table border="1" width="1000">
	<tr>
		<th>상품이름</th>
		<th>상품번호</th>
		<th>상품사이즈</th>
		<th>상품색상</th>
		<th>상품분류</th>
		<th>재고수</th>
		<th>상품가격</th>
		<th>상품등록일</th>
	</tr>
	<c:forEach var="productList" items="${requestScope.productList }">
		<img src="../upload/${productList.pp_title }">
		<tr>
			<th>${productList.pi_name }
			<th>${productList.pi_num }
			<th>${productList.pd_size }
			<th>${productList.pd_color }
			<th>${productList.pi_category }
			<th>${productList.pd_count }
			<th>${productList.pi_price }원
			<th>${productList.pi_regdate }		
<%-- 			<td><a href="${pageContext.request.contextPath }/productUpdate?pi_num=${productList.pi_num}">수정</a></td> --%>
		</tr>
	</c:forEach>

	<hr>
</table>
</form>