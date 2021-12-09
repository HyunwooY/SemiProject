<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>


<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/css.css">
<style type="text/css">
@import url(//fonts.googleapis.com/earlyaccess/kopubbatang.css);
h1{font-family: 'KoPub Batang', serif;font-size:2.5em}
</style>
</head>
<body>
<div id="wrap">
<div id="ac">
<ul id="account">
	<c:choose>
		<c:when test="${requestScope.code=='fail' || requestScope.code==null}">
			<li><a href="${pageContext.request.contextPath }/joinlayout">회원가입</a></li>
			<li><a href="${pageContext.request.contextPath }/member/login">로그인</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="">로그아웃</a></li>
			<li><a href="">마이페이지</a></li>
			<li><a href="">장바구니</a></li>
			<li>${sessionScope.id }님 반갑습니다</li>
		</c:otherwise>
	</c:choose>
</ul>
</div>
<div id="header">
<h1>CHANELOPER</h1>
<ul id="menu">
	<li><a href="">상의</a></li>
	<li><a href="">하의</a></li>
	<li><a href="">원피스</a></li>
	<li><a href="">아우터</a></li>
	<li><a href="">악세서리</a></li>
	<li><a href="">검색</a></li>
</ul>
</div>
<div id="main">
	<jsp:include page="${requestScope.main }"/>
</div>
<div id="footer">
</div>
</div>
</body>
</html>