<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	fieldset {
	margin: 40px auto 40px; width:500px; height: 250px; border:none;
}
.searchbox, .searchResult, .searchProducts {
	margin: auto; display: table; 
}
.searchbox { width:600px; height: 300px;}
.searchResult { width:600px; height: 100px; border: 1px solid #666;}
.count {margin-top: 40px; }
.searchProducts { width:600px; height: 1000px;}
.searchPaging { width:600px; height: 100px;}
.searchbox .items {
	width:500px; height: 40px; margin-bottom: 10px;
}
.searchbox #CATEGORY,#keyword1,#sort {
	width: 410px; margin-bottom: 5px; 
	border: 1px solid #ddd; height: 40px!important;
}

li {list-style: none; }
ul.list {
	display: table;
    width: 100%;
    margin: 0px 0 0;
}
li .chips{
	display: inline;
	float: left;
	width: 15px;
    height: 15px;
    margin: 10px 4px 4px 0;
    border: 1px solid #ddd;
    line-height: 0;
}
ul.list li.item {
    display: inline-block;
    margin: 20px 0px 70px;
    width: 33.3%;
    border-right: 0px solid rgba(255,255,255,0);
    border-left: 0px solid rgba(255,255,255,0);
    box-sizing: border-box;
    color: #757575;
    vertical-align: top;
}
#searchBar {width: 175px; height: 50px; margin-top: 60px }
.color {width:10px; height: 10px; list-style: none; float:left; }
.searchProducts {
  margin: auto;
  width: 740px;
  height: 1000px;
  text-align: center;
}
img{
  width: 250px;
  height: 300px;
  margin-right: 20px;
  margin-bottom: 20px;
}
.price{margin-top: 4px; }
</style>
<script>
	function checkNull() {
		let keyword=document.getElementById("keyword1").value;
		let category=document.getElementById("CATEGORY").value;
		let sort=document.getElementById("CATEGORY").value;
		if(category==1 && sort==1 && keyword==""){
			alert("검색어를 입력해주세요");
		}
	}
</script>
<c:choose>
	<c:when test="${empty requestScope.keyword }"> <!-- 검색탭으로 들어온경우 -->
		<c:set var="keyword" value=""/>
	</c:when>
	<c:otherwise>
		<c:set var="keyword" value="${keyword }"/><!-- 검색키워드로 들어온경우 --><br>
	</c:otherwise>
</c:choose>
<c:set var="cp" value="${pageContext.request.contextPath }"/>
<div class="searchbox">
	<fieldset>
		<form method="get" action="${cp }/search/search">
			<div class="items">
				<select id="CATEGORY" name="CATEGORY">
					<option value="1" <c:if test="${CATEGORY=='1' }">selected</c:if>>상품분류 선택</option>
					<option value="상의" <c:if test="${CATEGORY=='상의' }">selected</c:if>>상의</option>
					<option value="하의" <c:if test="${CATEGORY=='하의' }">selected</c:if>>하의</option>
					<option value="원피스" <c:if test="${CATEGORY=='원피스' }">selected</c:if>>원피스</option>
					<option value="아우터" <c:if test="${CATEGORY=='아우터' }">selected</c:if>>아우터</option>
					<option value="악세사리" <c:if test="${CATEGORY=='악세사리' }">selected</c:if>>악세사리</option>
				</select> 
			</div>
			<div class="items">
				<input type="text" id="keyword1" name="keyword" value="${keyword }"><br>
			</div>
			<div class="items">
				<select id="sort" name="sort">
					<option value="1" <c:if test="${CATEGORY=='1' }">selected</c:if>>:::기준선택:::</option>
					<option value="pi_date" <c:if test="${sort=='pi_date' }">selected</c:if>>신상품 순</option>
					<option value="pi_count" <c:if test="${sort=='pi_count' }">selected</c:if>>인기상품 순</option>
				</select><br>
			</div>
			<input type="submit" value="SEARCH" id="searchBar" onclick="checkNull()">
		</form>
	</fieldset>
</div>
<div class="searchResult">
	<p class="count"></p>
	<p class="count"> ITEMS </p>
</div>

<div class="searchProducts"> <!-- 조회된 제품들 10개씩-->
	<c:forEach var="vo" items="${requestScope.list }" varStatus="status"> 
	<ul class="list">
		<li class="item"> <!-- 상품 1 -->
			<div class="box"> <!-- 상품1 안에 제일 큰 박스 -->
				<a href="${cp }/search/searchdetail?pi_num=${vo.pi_num }">
				<img src="${cp }/${vo.pp_title}">
				</a>
				<div class="prdInfo"> <!-- 상품 세부정보 -->
					<p class="name">
						<a href="${cp }/search/searchdetail?pi_num=${vo.pi_num }">
						<span>${vo.pi_name }</span>
						</a>
					</p>
					<p class="price">${vo.pi_price }</p>
					<p class="tag">
						<c:forEach var="t" items="${tag }" >
							<c:if test="${t.pi_num==vo.pi_num }">
								${t.tag } 
							</c:if> 
						</c:forEach>
					</p>
					<div class="color"> <!-- 색상 div -->
						<div class="colorchip">
							<ul>
								<c:forEach var="co" items="${color }" >
									<c:if test="${co.pi_num==vo.pi_num }">
										<li style="background-color:${co.pd_color};" class="chips"> </li>
									</c:if> 
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</li>
	</ul>
	</c:forEach>
</div>

<div calss="searchPaging"><!-- 페이징 처리 하는부분 -->
	<p>
	<c:if test="${startPage>10 }">
		<a href="${cp }/search/list?pageNum=${startPage-1}">[이전페이지]</a>
	</c:if>
	<c:forEach var="i" begin="${startPage }" end="${endPage }">
		<c:choose>
			<c:when test="${pageNum==i }"> <%-- 현재 페이지 링크색상 다르게 표시하기위해 --%>
				<a href="${cp }/search/list?pageNum=${i}"><span style="color:red">${i }</span></a>
			</c:when>
			<c:otherwise>
				<a href="${cp }/search/list?pageNum=${i}"><span style="color:gray">${i }</span></a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${endPage<pageCount }">
		<a href="${cp }/search/list?pageNum=${endPage+1}">[다음페이지]</a>
	</c:if>
	</p>
</div>