<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 문의 내역</title>
</head>
<body>
	<c:set var = "cp" value = "${pageContext.request.contextPath }"/>
	<h1>문의 내역</h1>
	<table>
		<tr>
			<th>문의번호</th>
			<th>작성자</th>
			<th>제목</th>
		</tr>	
	<c:forEach var="vo" items="${list }" >
		<tr>
			<td>${vo.ih_num }</td>
			<td>${vo.mi_id }</td>
			<td>
			<a href=""></a>	
			</td>
		</tr>
	</c:forEach>
	</table>
	
	<!-- 페이징 처리 -->
	<div>
		<c:if test="${startPage>10 }">
			<a href="${cp }/seller/inquiryList?pageNum=${startPage-1}">[이전 페이지]</a>
		</c:if>
		
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:when test="${pageNum == i }">
				<a href="${cp }/seller/inquiryList.jsp?pageNum=${i}"><span style="color:req">${i }</span></a>			
			</c:when>
			<c:otherwise>
				<a href="${cp }/seller/inquiryList?pageNum=${i}"><span style="color:gray">${i }</span></a>			
			</c:otherwise>
		</c:forEach>
		<c:if test="${endPage<pageCount }">
			<a href="${cp }/seller/inquiryList?pageNum=${endPage+1}">[다음 페이지]</a>
		</c:if>
	</div>
</body>
</html>