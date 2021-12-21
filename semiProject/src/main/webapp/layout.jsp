<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#keyword {
		width : 200px; height: 20px;
		position: absolute; 
		left: 1100px;
		top: 200px;
	}
</style>
<script type="text/javascript">
	window.onload=function () {
		var keyword=document.getElementById("keyword");
		hideText();
		if(${requestScope.lcode==false}){
			alert('아이디 혹은 비밀번호가 맞지 않습니다.')
		}
// 		window.open("${pageContext.request.contextPath}/seller/noticepopup.jsp","_blank","width=500,height=700");
		
	}
	function showText(e) {
		var keyword=document.getElementById("keyword");
		keyword.style.display="block";
	}
	function hideText(e) {
		var keyword=document.getElementById("keyword");
		keyword.style.display="none";
	}
	
	function search(e) {
		if(e.keyCode==13){	// 엔터키를 누른경우
			var keyword=e.target.value;
			if(keyword==""){
				alert('검색어를 입력해주세요');
			}else {
				window.location.href = '${pageContext.request.contextPath}/search/search?keyword='+e.target.value;
			}
		}	
	}
</script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/css.css">
<style type="text/css">
@import url(//fonts.googleapis.com/earlyaccess/kopubbatang.css);
h1{font-family: 'KoPub Batang', serif;font-size:2.5em}
</style>
</head>
<body>
<c:set var="cp" value="${pageContext.request.contextPath }"/>
<div id="wrap">
<div id="ac">
<ul id="account">
	<c:choose>
		<c:when test="${sessionScope.id==null}">
			<li><a href="${pageContext.request.contextPath }/joinlayout">회원가입</a></li>
			<li><a href="${pageContext.request.contextPath }/member/login">로그인</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="${pageContext.request.contextPath }/member/logout">로그아웃</a></li>
			<c:choose>
				<c:when test="${sessionScope.radio=='일반사용자' }">
					<li><a href="${pageContext.request.contextPath }/member/memberDetail">마이페이지</a></li>
				</c:when>
				<c:when test="${sessionScope.radio=='판매사업자' }">
					<li><a href="${pageContext.request.contextPath }/seller/sellerpage">마이페이지</a></li>
				</c:when>
			</c:choose>
			<li><a href="${pageContext.request.contextPath }/member/cartlist">장바구니</a></li>
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
	<li><a href="${cp }/seller/notice" >공지사항 </a></li>
	<li id="search"  onmouseover="showText(event)" onmouseout="hideText(event)">
		<a href="${cp }/search/search" >검색 </a></li>
</ul>
	<input type="text" id="keyword" onkeypress="search(event)">
</div>
<div id="main">
	<jsp:include page="${requestScope.main }"/> 	
</div>
<div id="footer">
</div>
</div>
</body>
</html>