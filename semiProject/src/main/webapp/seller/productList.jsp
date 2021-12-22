<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<form method="post" action="${pageContext.request.contextPath }/seller/productList">
	<div id="productlist"></div>
	<c:forEach var="productList" items="${requestScope.productList }">
		<img src="../upload/${productList.pp_title }">
		상품이름: <th>${productList.pi_name }
		상품 번호: <th>${productList.pi_num }
		상품 사이즈: <th>${productList.pd_size }
		상품 색상: <th>${productList.pd_color }
		분류: <th>${productList.pi_category }
		재고수: <th>${productList.pd_count }
		상품 가격: <th>${productList.pi_price }원
		상품 등록일: <th>${productList.pi_regdate }
		
	</c:forEach>
	<input type="button" value="수정">
	<input type="button" value="삭제" onclick="delProduct()">
	<hr>
</form>
