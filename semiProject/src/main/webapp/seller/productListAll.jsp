<%@page import="chaneloper.vo.ProductVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<style>
	* {
		margin: 0;
		padding: 0;
	}
	li {
		list-style: none;
	}
	.clear {
		clear: both;
	}
	.box {
		width: 1320px; 
		margin: 0 auto;
	}
#content_box h3 {				/* 후손 선택자 */
	flaot: left;
	margin-left: 0px;
}
#content_box p {
	float: right;
}
</style>


<form action="${pagecontext.request.contextPath }/seller/listAll">		
	<section id="content_box">
	<div class="box">	
		<h3>전체 상품</h3>
		<p> 판매자추천순 | 인기도순 | 평점높은순 | 최신등록순</p>
		<div class="clear"></div>
		<ul class="items">
		<c:forEach var="list" items="${requestScope.list }">	
			<!-- 이미지 클릭 시 상세페이지로 이동해야 함 -->
	
		
			<div class="box">
				<img src="../upload/${list.pp_title }" onclick="location.href='https://www.naver.com'">			
			</div>
			<li class="a">${list.pi_name }</li>		
			<li class="b">${list.pi_price }원</li>	
			<li class="c">${list.pd_color }</li>			
			<li class="d">${list.t_name }</li>	

		</c:forEach>
		</ul>
	</div>
	<div class="clear"></div>
	</section>
</form>
	<hr>


