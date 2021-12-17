<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<div id="productlist"></div>
<c:forEach var="productList" items="${requestScope.productList }">
	<img src="../upload/${productList.pp_title }">
	<th>${productList.pi_name }
	<th>${productList.pi_num }
	<th>${productList.pd_size }
	<th>${productList.pd_color }
	<th>${productList.pd_count }
	<th>${productList.pi_price }원
</c:forEach>
<input type="button" value="수정">
<input type="button" value="삭제" onclick="delProduct()">
<hr>
