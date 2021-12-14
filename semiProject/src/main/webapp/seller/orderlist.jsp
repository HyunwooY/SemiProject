<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>상품번호</th>
			<th>사이즈</th>
			<th>수량</th>
			<th>상품명</th>
			<th>결제일</th>
			<th>가격</th>
			<th>색상</th>
			<th>결제방법</th>
		</tr>
		<c:forEach var="d" items="${list }">
			<tr align="center">
				<td>${d.pi_num }</td>
				<td>${d.pd_size }</td>
				<td>${d.pd_count }</td>
				<td>${d.pi_name }</td>
				<td><fmt:formatDate value="${d.ph_regdate}" pattern="yyyy년 MM월 dd일"></fmt:formatDate>
				<td><fmt:formatNumber type="currency" value="${d.pi_price}"></fmt:formatNumber>
				<td style="background-color:${d.pd_color }">${d.pd_color }</td>
				<td>${d.ph_type }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>