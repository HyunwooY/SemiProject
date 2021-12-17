<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
	<c:when test="${requestScope.productCode=='fail' || requestScope.productCode==null}">
		<div id="result">
			<p>실패!
		<a href="${pageContext.request.contextPath }/layout">메인페이지로</a>
		</div>
	</c:when>
	<c:when test="${requestScope.productCode=='success' }">
		<div id="result">
			<p>등록되었습니다.
		<a href="${pageContext.request.contextPath }/layout">메인페이지로</a>
		</div>
	</c:when>	
</c:choose>
