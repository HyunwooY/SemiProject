<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<style>
	table {
		word-break: break-all;
	}
</style>   
    
<form action="${pageContext.request.contextPath }/seller/orderListAll" method="post">
	<table border="1" width="1500">
		<tr>
			<th>구매번호</th>
			<th>구매자ID</th>
			<th>결제방법</th>
			<th>주문상태</th>
			<th>주문날짜</th>
			<th>주소</th>
			<th>전화번호</th>
			<th>수령인</th>
			<th>상품상세번호</th>
			<th>상품사이즈</th>
			<th>상품색상</th>
			<th>상품번호</th>
			<th>상품명</th>
			<th>상품가격</th>
			<th>분류</th>
		</tr>
		<c:forEach var="listAll" items="${requestScope.listAll }">
		<tr>
			<td>${listAll.ph_num }<td>
			<td>${listAll.mi_id }</td>
			<td>${listAll.ph_type }</td>
			<td>${listAll.ph_state }</td>
			<td>${listAll.ph_regdate }</td>
			<td>${listAll.ph_addr }</td>
			<td>${listAll.ph_phone }</td>
			<td>${listAll.ph_name }</td>			
			<td>${listAll.pd_num }</td>
			<td>${listAll.pd_size }</td>
			<td>${listAll.pd_color }</td>
			<td>${listAll.pi_num }</td>
			<td>${listAll.pi_name }</td>
			<td><fmt:formatNumber value="${listAll.pi_price }" pattern="#,###"/>원</td>
			<td>${listAll.pi_category }</td>
		</tr>
		</c:forEach>
	</table>
</form>