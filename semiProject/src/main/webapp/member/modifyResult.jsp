<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${requestScope.result=='success' }">
		<h1>회원님의 정보가 수정되었습니다.</h1>
	</c:when>
	<c:otherwise>
		<h1>회원님의 정보를 수정하지 못하였습니다.</h1>
	</c:otherwise>
</c:choose>
<a href="<%=request.getContextPath()%>/member/login.jsp">로그인</a>
