<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath }"/>
<style>
	
</style>
<div>
	<div> 
		    
	</div>
	<div>
		<table width="1000" border="1" style="text-align: center; margin: auto;">
			<tr>
				<th width="10%">리뷰 번호</th><th width="10%">상품 번호</th><th>사진</th><th>제목</th><th>내용</th><th width="10%">별점</th>
			</tr>
			<c:forEach var="vo" items="${rvlist }">
		<tr>
			<td>${vo.r_num }</td>
			<td>${vo.ph_num }</td>
			<td></td> 
			<td>${vo.r_title }</td>
			<td>${vo.r.title }</td>
			<td>${vo.r_hit }</td>
		</tr>
	</c:forEach>
		</table>
	</div>
	<!-- 페이징 처리 -->
	<div id="page" style="padding-top: 20px; padding-left: 480px;">
		<c:if test="${startPage>10 }">
			<a href="${cp }/mypage/reviewlist?pageNum=${startPage-1}">[이전]</a>
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:choose>
				<c:when test="${pageNum==i }">
					<a href="${cp }/mypage/reviewlist?pageNum=${i}&keyword=${keyword}&field=${field}">
					<span>${i }</span>
					</a>
				</c:when>
				<c:otherwise>
					<a href="${cp }/mypage/reviewlist?pageNum=${i}&keyword=${keyword}&field=${field}">
					<span>${i }</span>
					</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${endPage<pageCount }">
			<a href="${cp }/mypage/reviewlist?pageNum=${endPage+1}">[다음]</a>
		</c:if>
	</div>
	<!-- 검색창 -->
	<div style="padding-top: 30px; padding-left: 350px;" id="screview">
		<form method="post" action="${cp }/mypage/reviewlist">
			<select name="field" style="height: 25px;">
				<option value="ph_num" <c:if test="${field=='ph_num' }">selected</c:if>>상품번호</option>
				<option value="r_title" <c:if test="${field=='r_title' }">selected</c:if>>제목</option>
				<option value="r_content" <c:if test="${field=='r_content ' }">selected</c:if>>내용</option>
			</select>
			<input type="text" name="keyword" value="${keyword }" style="height: 23px;">
			<input type="submit" value="검색" style="width: 40px; height: 28px;">
		</form>
	</div>
</div>