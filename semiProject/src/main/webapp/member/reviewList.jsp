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
				<th width="10%">리뷰 번호</th><th width="10%">상품 번호</th><th>사진</th><th>제목</th><th>내용</th><th width="10%">별점</th><th>삭제</th>
			</tr>
			<c:forEach var="vo" items="${list }">
		<tr>
			<td>${vo.r_num }</td>
			<td>${vo.ph_num }</td>
			<td></td> 
			<td>${vo.r_title }</td>
			<td>${vo.r_content }</td>
			<td>${vo.r_hit }</td>
			<td><a href="${cp }/mypage/reviewlist?r_num=${vo.r_num }">삭제</a></td>
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
</div>