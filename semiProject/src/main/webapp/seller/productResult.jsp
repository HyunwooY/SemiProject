<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
	<c:when test="${requestScope.productCode=='fail' || requestScope.productCode==null}">
		<div id="result">
			<h1>실패</h1>
		<a href="${pageContext.request.contextPath }/layout">메인페이지로</a>
		</div>
	</c:when>
	<c:when test="${requestScope.productCode=='success' }">
		<div id="result">
			<h1>등록되었습니다.</h1>	
		<a href="${pageContext.request.contextPath }/layout">메인페이지로</a>
		</div>
	</c:when>	
</c:choose>
