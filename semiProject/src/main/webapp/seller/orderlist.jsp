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
	<c:set var="cp" value="${pageContext.request.contextPath }"/>
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
	
		<c:forEach var="vo" items="${list }">
			<tr align="center">
				<td>${vo.pi_num }</td>
				<td>${vo.pd_size }</td>
				<td>${vo.pd_count }</td>
				<td>${vo.pi_name }</td>
				<td><fmt:formatDate value="${vo.ph_regdate}" pattern="yyyy년 MM월 dd일"></fmt:formatDate>
				<td><fmt:formatNumber type="currency" value="${vo.pi_price}"></fmt:formatNumber>
				<td style="background-color:${vo.pd_color }">${vo.pd_color }</td>
				<td>${vo.ph_type }</td>
		</tr>
		</c:forEach>
	</table>
	<div>
		<c:if test="${requestScope.startPage>10 }">
			<a href="${cp }/seller/inquiryList?pageNum=${requestScope.startPage-1}">[이전 페이지]</a>
		</c:if>		
		<c:forEach var="i" begin="${requestScope.startPage }" end="${requestScope.endPage }">
			<c:choose>
				<c:when test="${requestScope.pageNum == i }">
					<a href="${cp }/seller/inquiryList.jsp?pageNum=${i}"><span style="color:req">${i }</span></a>			
				</c:when>
				<c:otherwise>
					<a href="${cp }/seller/inquiryList?pageNum=${i}"><span style="color:gray">${i }</span></a>			
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${requestScope.endPage < requestScope.pageCount }">
			<a href="${cp }/seller/inquiryList?pageNum=${requestScope.endPage+1}">[다음 페이지]</a>
		</c:if>
	</div>
</body>
</html>