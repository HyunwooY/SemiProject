<%@page import="java.util.ArrayList"%>
<%@page import="chaneloper.vo.Inquiry_historyVo"%>
<%@page import="chaneloper.dao.Inquiry_historyDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath }"/>
<style>
	h1{
		position:relative;
		left: 40px;
		bottom: 30px;
		margin: auto;
	}
	table{
		position:relative;
		left: 45px;
		bottom: 30px;
		margin-top: 20px;
	}
</style>
<h1>내 문의 내역</h1>
<table width="600">
	<tr>
		<th>문의번호</th><th>작성자아이디</th><th>문의제목</th><th>문의내용</th><th>상품번호</th>
	</tr>
	<c:forEach var="vo" items="${list }">
		<tr>
			<td>${vo.ih_num }</td>
			<td>${vo.mi_id }</td>
			<td>${vo.ih_title }</td>
			<td><a href="inquiryDetail.jsp?ih_num=${vo.getIh_num() }">${vo.ih_question }</a></td>
			<td>${vo.pi_num }</td>
		</tr>
	</c:forEach>
</table>
<div>
	<c:forEach var="i" begin="${startPage }" end="${endPage }">
		<c:choose>
			<c:when test="${pageNum==i }">
				<a href="${cp }/mypage/hestory?pageNum=${i}">
				<span>${i }</span>
				</a>
			</c:when>
			<c:otherwise>
				<a href="${cp }/mypage/hestory?pageNum=${i}">
				<span>${i }</span>
				</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</div>
