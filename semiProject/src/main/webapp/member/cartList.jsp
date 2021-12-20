<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="cartlist">
	<table>
		<c:forEach var="so" items="${Cookielist }">
			<c:if test="${so.name !='JSESSIONID'}">${so.value }</c:if>
		</c:forEach>
		<c:forEach var="vo" items="${list}">
			<c:if test="${vo.si_name!=siname}">
				<c:set var="siname" value="${vo.si_name }"/>
				<tr>
					<th colspan="4">${siname }</th>
				</tr>
				<tr>
					<th>사진</th>
					<th>상품명</th>
					<th>색상</th>
					<th>사이즈</th>
					<th>구매수량</th>
					<th>가격</th>
				</tr>
			</c:if>
				<tr>
					<td width="140px"><img src="${pageContext.request.contextPath}/upload/${vo.pp_title}" class="imgs"></td>
					<td>${vo.pi_name }</td>
					<td>${vo.pd_color }</td>
					<td>${vo.pd_size }</td>		
					<td>${vo.purchase_count}</td>
					<td>${vo.pi_price * vo.purchase_count}</td>
				</tr>
		</c:forEach>
	</table>
</div>