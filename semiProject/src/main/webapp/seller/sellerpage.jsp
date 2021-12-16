<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<style>
*{margin:0px;padding:0px}
#mdetail{position:relative;top:50px;width:80%;height:1000px;margin:0px;padding:0px;text-align:left;margin:auto}
#mdetail div{position:relative;}
#mdetail h3{height:40px}
#info{width:100%;height:80px;float:left;border-bottom:0.5px black solid}
#info span{margin:20px}
#info #short{top:20px}
.r{float:right;position:relative;top:-20px}
#detailmain{width:100%;height:600px;}
#membermenu{float:left;width:15%;height:500px;padding-top:20px}
#showtitle{float:left;width:85%;height:50px;padding-top:20px}
#showtitle span{position:relative;}
#show{float:left;width:85%;height:400px}
.menu{margin-bottom:15px;}
.menu h4{margin-bottom:5px}
.menu a{margin-bottom:5px;display:inline-block;text-decoration: none;}
</style>
<div id="ac">
<ul id="account">
	<div id="detailmain">		
			<div id="order" class="menu">
				<h4>ORDER</h4>
				<a href="${pageContext.request.contextPath }/seller/orderlist">고객주문내역</a><br>
			</div>
			
			<div id="modify" class="menu">
				<h4>MODIFY</h4>
				<a href="${pageContext.request.contextPath }/member/mypage">판매자 정보확인/수정</a><br>
			</div>
			
			<div id="inquiry" class="menu">
				<h4>INQUIRY LIST</h4>
				<a href="${pageContext.request.contextPath }/seller/inquiryList">문의/반품/교환 내역관리</a><br>
			</div>
			
			<div id="update" class="menu">
				<h4>UPDATED LIST</h4>
				<a href="${pageContext.request.contextPath }/seller/productList">등록된상품</a><br>
			
		<div id="showtitle">
			<span>${requestScope.detailtitle }</span>
		</div>
		<div id="show">
			<jsp:include page="${requestScope.detailmain }"></jsp:include>
		</div>
		</div>
	</div>
	
</ul>
</div>