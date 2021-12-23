<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CHANELOPER입니다.</title>
<style type="text/css">
	*{margin:0px;padding:0px}
	#wrap{width:1500px;height:auto;background-color:yellow;margin:auto;border:1px solid black;}
	#wrap {position:relative;}
	#ac{width:100%;height:60px;background-color:white;}
	#header{width:100%;height:140px;background-color:white;text-align:center}
	#header h1{position:relative;margin:auto;top:10px;margin-bottom:5px}
	#ac #account li{display:inline;position:relative;right:60px;float:right;margin-right:15px;top:5px}
	a{color:black;text-decoration:none}
	#header #menu li{display:inline;position:relative;top:50px;font-size:1.2em;margin:40px}
	#main{width:100%;overflow:hidden;background-color:#BDBDBD;text-align:center;} /* 혹시 text-align 주신분...?*/
	#footer{width:100%;height:10%;background-color:gray}
	#footer #foot{text-align:center;padding-top:10px;padding-bottom:10px}
	#footer #foot h3{margin-bottom:10px}
	#com1, #com2, #com3{margin-bottom:10px}
	#keyword {
		width : 160px; height: 20px;
		position: absolute; 
		left: 1200px;
		top: 200px;
	}
</style>
<script type="text/javascript">
	window.onload=function () {
		var keyword=document.getElementById("keyword");
		hideText();
		if(${requestScope.lcode==false}){
			alert('${errMsg}')
		}

//		window.open("${pageContext.request.contextPath}/seller/noticepopup.jsp","_blank","width=500,height=700");

	function showText() {
		var keyword=document.getElementById("keyword");
		keyword.style.display="block";
	}
	function delayText() {
		setTimeout(hideText,100);		
	}
	function hideText() {
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
<%--<link rel="stylesheet" href="${pageContext.request.contextPath }/css/css.css"> --%>
<style type="text/css">
@import url(//fonts.googleapis.com/earlyaccess/kopubbatang.css);
#mainTitle{font-family: 'KoPub Batang', serif;font-size:2.5em}
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
					<li><a href="${pageContext.request.contextPath }/member/showorder">마이페이지</a></li>
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
<a href="${cp }/layout"><span id="mainTitle">CHANELOPER</span></a>
<ul id="menu">
	<li><a href="${cp }/search/category?CATEGORY=상의&keyword=&sort=&pageNum=1">상의</a></li>
	<li><a href="${cp }/search/category?CATEGORY=하의&keyword=&sort=&pageNum=1">하의</a></li>
	<li><a href="${cp }/search/category?CATEGORY=원피스&keyword=&sort=&pageNum=1">원피스</a></li>
	<li><a href="${cp }/search/category?CATEGORY=아우터&keyword=&sort=&pageNum=1">아우터</a></li>
	<li><a href="${cp }/search/category?CATEGORY=악세사리&keyword=&sort=&pageNum=1">악세서리</a></li>
	<li><a href="${cp }/seller/notice" >공지사항 </a></li>
	<li id="search"  onmouseover="showText()" >
		<a href="${cp }/search/search" >검색 </a></li>
</ul>
	<input type="text" id="keyword" onkeypress="search(event)" onmouseout="delayText()">
</div>
<div id="main">
	<jsp:include page="${requestScope.main }"/> 	
</div>
<div id="footer">
	<div id="foot">
		<h3>CHANELOPER(주)</h3>
		<p id="com1">서울특별시 종로구 율곡로10길 105 디아망 4F(봉익동 10-1 디아망 4F) TEL : 070-8240-3211~3 FAX : 02-777-5407</p>
		<p id="com2">사업자등록번호 : 104-81-59383 통신판매업신고번호 : 중구 065325 중앙HTA㈜</p><br>
		<p id="com3">COPYRIGHT(C) HTA CO., LTD. ALL RIGHTS RESERVED.</p>
	</div>
</div>
</div>
</body>
</html>