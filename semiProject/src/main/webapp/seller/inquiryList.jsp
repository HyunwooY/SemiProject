<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>

  table {
    width: 960px;
    height: 110px;
    margin-left: 50px;
    margin-right: auto;
  }
  
</style>
	<c:set var = "cp" value = "${pageContext.request.contextPath }"/>
	<br>
	<h1>문의 내역</h1>
	<br>
	<table>
		<tr>
			<th>문의번호</th>
			<th>작성자</th>
			<th>제목</th>
		</tr>	
		<tr>
	<c:forEach var="vo" items="${list }" >
		<tr>
			<td>${vo.ih_num }</td>
			<td>${vo.mi_id }</td>
			<td><a href="${cp }/inquirydetail?ih_num=${vo.ih_num}">${vo.ih_question }</a></td>
			
		</tr>
		<c:if test="${vo.ih_answer!=null }">
			<tr>			
			<td></td>			
			<td></td>
			</tr>	
		</c:if>
		<hr>
	</c:forEach>
	</tr>
	</table>
	
	<!-- 페이징 처리 -->
  	<div>
		<c:if test="${requestScope.startPage>10 }">
			<a href="${cp }/seller/inquiryList?pageNum=${requestScope.startPage-1}">[이전 페이지]</a>
		</c:if>		
		<c:forEach var="i" begin="${requestScope.startPage }" end="${requestScope.endPage }">
			<c:choose>
				<c:when test="${requestScope.pageNum == i }">
					<a href="${cp }/seller/inquiryList.jsp?pageNum=${i}"><span style="color:req">${i }</span></a>			
				</c:when>
				<c:otherwise>
					<a href="${cp }/seller/inquiryList?pageNum=${i}"><span style="color:gray">${i }</span></a>			
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${requestScope.endPage < requestScope.pageCount }">
			<a href="${cp }/seller/inquiryList?pageNum=${requestScope.endPage+1}">[다음 페이지]</a>
		</c:if>
	</div>

	<div>
	<form method="post" action="${cp }/seller/inquiryList"">
		<select name="field">
			<option value="mi_id" <c:if test="${field=='mi_id' }">selected</c:if>>작성자</option>
			<option value="ih_title" <c:if test="${field=='ih_title' }">selected</c:if>>제목</option>
		</select>
		<input type="text" name="keyword" value="${keyword }">
		<input type="submit" value="검색">
	</form>
</div>
