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
<table width="600" border="1">
	<tr>
		<th>문의 번호</th><th>상품 번호</th><th>작성자 아이디</th><th>문의 제목</th><th>문의 내용</th>
	</tr>
	<c:forEach var="vo" items="${list }">
		<tr>
			<td>${vo.ih_num }</td>
			<td>${vo.pi_num }</td>
			<td>${vo.mi_id }</td> 
			<td>${vo.ih_title }</td>
			<td><a href="${cp }/mypage/ihdetail?ih_num=${vo.ih_num }">${vo.ih_question }</a></td>
		</tr>
	</c:forEach>
</table>
<!-- 페이징 처리 -->
<div id="page">
	<c:if test="${startPage>10 }">
		<a href="${cp }/mypage/hestory?pageNum=${startPage-1}">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${startPage }" end="${endPage }">
		<c:choose>
			<c:when test="${pageNum==i }">
				<a href="${cp }/mypage/hestory?pageNum=${i}&keyword=${keyword}&field=${field}">
				<span>${i }</span>
				</a>
			</c:when>
			<c:otherwise>
				<a href="${cp }/mypage/hestory?pageNum=${i}&keyword=${keyword}&field=${field}">
				<span>${i }</span>
				</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${endPage<pageCount }">
		<a href="${cp }/mypage/hestory?pageNum=${endPage+1}">[다음]</a>
	</c:if>
</div>
<!-- 검색창 -->
<div>
	<form method="post" action="${cp }/mypage/history">
		<select name="field">
			<option value="mi_id" <c:if test="${field=='mi_id' }">selected</c:if>>작성자</option>
			<option value="ih_title" <c:if test="${field=='ih_title' }">selected</c:if>>제목</option>
			<option value="ih_question" <c:if test="${field=='ih_question ' }">selected</c:if>>내용</option>
		</select>
		<input type="text" name="keyword" value="${keyword }">
		<input type="submit" value="검색">
	</form>
</div>
