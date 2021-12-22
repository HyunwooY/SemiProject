<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	table{width:990px}
</style>
	<c:set var = "cp" value = "${pageContext.request.contextPath }"/>
	<!-- <h1>공지 사항</h1> -->
	<table>
		<tr>
			<th>작성번호</th>
			<th>내용</th>
		</tr>	
		<tr>
	<c:forEach var="vo" items="${list }" >
		<tr>
			<td>${vo.n_num }</td>
			<td>${vo.n_context}</td>
			
		</tr>
	</c:forEach>
	<hr>
	</table>
	<form name="notice" method="post" action="${pageContext.request.contextPath }/seller/noticeForm.jsp">
	<input type="submit" value="글쓰기">
		<c:if test="${result0==null }">
	<c:if test="${ }"></c:if>
	</form>
	<!-- 페이징 처리 -->
  	<div>
		<c:if test="${requestScope.startPage>10 }">
			<a href="${cp }/seller/notice?pageNum=${requestScope.startPage-1}">[이전 페이지]</a>
		</c:if>		
		<c:forEach var="i" begin="${requestScope.startPage }" end="${requestScope.endPage }">
			<c:choose>
				<c:when test="${requestScope.pageNum == i }">
					<a href="${cp }/seller/notice.jsp?pageNum=${i}"><span style="color:req">${i }</span></a>			
				</c:when>
				<c:otherwise>
					<a href="${cp }/seller/notice?pageNum=${i}"><span style="color:gray">${i }</span></a>			
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${requestScope.endPage < requestScope.pageCount }">
			<a href="${cp }/seller/notice?pageNum=${requestScope.endPage+1}">[다음 페이지]</a>
		</c:if>
	</div> 