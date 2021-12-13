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
<div id="mdetail">
<h3>MY PAGE</h3>
	<div id="info">
	<span>주문 목록</span>
		<div id="short">
		<span class="l">입금전 ${requestScope.aPayCom }</span>
		<span class="l">입금완료 ${requestScope.bPayCom }</span>
		<span class="l">배송준비중 ${requestScope.preparingP }</span>
		<span class="l">배송중 ${requestScope.beingDelivery }</span>
		<span class="l">배송완료 ${requestScope.compDelivery }</span>
		
		<span class="r">취소 ${requestScope.cancel}</span>
		<span class="r">교환 ${requestScope.change}</span>
		<span class="r">반품 ${requestScope.refund}</span>
		</div>
	</div>
	<div id="detailmain">
		<div id="membermenu">	
			<div id="order" class="menu">
				<h4>ORDER</h4>
				<a href="${pageContext.request.contextPath }/member/showorder">주문내역</a><br>
				<a href="${pageContext.request.contextPath }/member/showstate">반품/교환/취소내역</a>
			</div>
			<div id="my" class="menu">
				<h4>MODIFY</h4>
<<<<<<< HEAD
				<a href="">개인정보확인/수정</a><br>
				<a href="${pageContext.request.contextPath }/member/insertaddr">배송지 관리</a>
=======
				<a href="${pageContext.request.contextPath }/member/modify">개인정보확인/수정</a><br>
				<a href="">배송지 관리</a>
>>>>>>> branch 'master' of https://github.com/HyunwooY/SemiProject.git
			</div>
			<div id="wishlist" class="menu">
				<h4>WISH LIST</h4>
				<a href="">찜목록</a>
			</div>
			<div id="myboard" class="menu">
				<h4>MY BOARD</h4>
				<a href="">문의하기</a><br>
				<a href="">문의내역 확인</a><br>
				<a href="">리뷰관리</a>
			</div>
		</div>
		<div id="showtitle">
			<h3>${requestScope.detailtitle }</h3>
		</div>
		<div id="show">
			<jsp:include page="${requestScope.detailmain }"></jsp:include>
		</div>
	</div>
</div>