<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
  table {
    width: 1100px;
    height: 100px;
    margin-left: auto;
    margin-right: auto;
  }
</style>
    
<form method="post" action="${pageContext.request.contextPath }/seller/productInfoList">
<table border="1" width="1000">

	<tr>
		<th>상품사진</th>
		<th>상품이름</th>
		<th>상품번호</th>
		<th>상품등록일</th>
		<th>상세정보보기</th>
	</tr>
	<c:forEach var="list" items="${requestScope.list }">		
	<tr>
	<th><img src="${pageContext.request.contextPath }/upload/${list.pp_title }" alt="" width="100px" height="100px"></th>
		<td>${list.pi_name }</td>
		<td>${list.pi_num }</td>
		<td>${list.pi_date }</td>
		<td><a href="${pageContext.request.contextPath }/seller/producDetailtList?pi_num=${list.pi_num}">상세정보보기</a>
	</tr>
	</c:forEach>

</table>
</form>