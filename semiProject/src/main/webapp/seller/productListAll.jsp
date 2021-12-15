<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<title>상품 리스트</title>
	<h1 class="display-3">상품 목록</h1>
	<c:forEach var="pr" items="${requestScope.list }">
		<div id="listAll">
			<tr>
				<td>${requestScope.pr.pi_num }</td>
				<td>${requestScope.pr.si_num }</td>
				<td>${requestScope.pr.pi_name }</td>
				<td>${requestScope.pr.pi_price }</td>
				<td>${requestScope.pr.pi_count }</td>
				<td>${requestScope.pr.pi_date }</td>
				<td>${requestScope.pr.pi_category }</td>
				<td>${requestScope.pr.pd_num }</td>
				<td>${requestScope.pr.pd_size }</td>			
				<td>${requestScope.pr.pd_color }</td>
				<td>${requestScope.pr.pd_count }</td>
			</tr>
		</div>		
	</c:forEach>
