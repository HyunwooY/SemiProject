<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
  table {
    width: 1000px;
    height: 36px;
    margin-left: auto;
    margin-right: auto;
  }
</style>

<script>

	function checklast(){
		let pi_num = document.getElementsByName("hiddenpi_num")[0].value;
		let pd_num = document.getElementsByName("hiddenpd_num")[0].value;
		var num = pi_num;
		let pltable = document.getElementById("pltable");
		if(pltable.childnodes.length()==1){
			num = 0;
		}
		
 		window.location.href="${pageContext.request.contextPath }/productDelete?pd_num="+pd_num+"&pi_num="+pi_num+"&num="+num;
		
	}


</script>

<br>
<h1>상품 상세정보</h1>
<br>
<form method="post" action="${pageContext.request.contextPath }/seller/sellerProductListForm">
<table border="1" width="1000">
	<tr>
		<th>상품사진</th>
		<th>상품이름</th>
		<th>상품상세번호</th>
		<th>상품사이즈</th>
		<th>상품색상</th>
		<th>상품분류</th>
		<th>재고수</th>
		<th>상품가격</th>
		<th>상품등록일</th>
<!-- 		<th>수정</th> -->
		<th>삭제</th>	
	</tr>
	<c:forEach var="pl" items="${requestScope.pl }">		
	<tr>
	<th id="pltable"><img src="${pageContext.request.contextPath }/upload/${pl.pp_title }" alt="" width="100px" height="100px"></th>
		<td>${pl.pi_name }</td>
		<td>${pl.pd_num }</td>
		<td>${pl.pd_size }</td>
		<td>${pl.pd_color }</td>
		<td>${pl.pi_category }</td>
		<td>${pl.pd_count }</td>
		<td><fmt:formatNumber value="${pl.pi_price }"/>원</td>
		<td>${pl.pi_date }</td>
<%-- 		<td><a href="${pageContext.request.contextPath }/seller/productUpdate?pi_num=${productList.pi_num}">수정</a> --%>
		<td><a href="#" onclik="checklast()">삭제</a>
	</tr>
	<tr id="hidden" style="display:none;">
		<td colspan=9>
			<input name="hiddenpi_num" type="text" value="${pl.pi_num}"/>
			<input name="hiddenpd_num" type="text" value="${pl.pd_num }"/>
		</td>
	</tr>

	</c:forEach>

</table>
<div>
	<c:if test="${requestScope.startPage>10 }">
		<a href="${pageContext.request.contextPath }/seller/productList?pageNum=${requestScope.startPage-1}">[이전 페이지]</a>
	</c:if>		
	<c:forEach var="i" begin="${requestScope.startPage }" end="${requestScope.endPage }">
		<c:choose>
			<c:when test="${requestScope.pageNum == i }">
				<a href="${pageContext.request.contextPath }/seller/productList?pageNum=${i}"><span style="color:req">${i }</span></a>			
			</c:when>
			<c:otherwise>
				<a href="${pageContext.request.contextPath }/seller/productList?pageNum=${i}"><span style="color:gray">${i }</span></a>			
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${requestScope.endPage < requestScope.pageCount }">
		<a href="${pageContext.request.contextPath }/seller/productList?pageNum=${requestScope.endPage+1}">[다음 페이지]</a>
	</c:if>
</div>  
</form>

