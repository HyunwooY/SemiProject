<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<c:set var="keyword" value="${keyword }"></c:set>
<c:set var="cp" value="${pageContext.request.contextPath }"/>
<style>
.Products, .Paging, .bestProducts{margin: auto; display:table;}
.Products{ width: 1100px; height: 950px;}
.Paging{ width:600px; height: 100px; color: #757575;font-style: italic}
.Paging #page{line-height: 100px; vertical-align: middle;}
li {list-style: none; }
ul.bestlist{
    width: 250px;
    float : left;
    margin : 5px;
    height: 470px;
}
ul.list{
    width: 200px;
    float : left;
    margin : 5px;
    height: 470px;
}
li .chips{					/*색상*/
	float: left;
	width: 15px;
    height: 15px;
    margin: 10px 4px 4px 0;
    border: 1px solid #ddd;
}
ul.list li.item{
	display: table-cell, inline-block;
    margin: 20px 0px 70px;
    border-right: 0px solid rgba(255,255,255,0);
    border-left: 0px solid rgba(255,255,255,0);
    box-sizing: border-box;
    color: #757575;
    vertical-align: top;
}
.color{width:100px; height: 10px; list-style: none; float:left; }
.imgDiv{ width: 100%; height: 300px; border:1px solid black;}
.imgDiv img{width:100%; height: 100%;}
.price{margin-top: 4px; }
.color li{
	display:inline;
}
.categoryTitle{text-align: left; padding-top: 30px; padding-bottom:40px; padding-left: 15px;}
</style>
<script>
	function none() {}
</script>
<div class="bestProducts"> <!-- 베스트 제품 4개 띄우는 영역 (베스트제품 기준은 pi_count(조회수) desc) -->
	<div class="categoryTitle"><h3>${CATEGORY } BEST</h3></div>
	<c:forEach var="bp" items="${requestScope.bestList }">
		<ul class="bestlist">
		<li class="item"> <!-- 상품 1 -->
			<div class="box"> <!-- 상품1 안에 제일 큰 박스 -->
				<div class="imgDiv">
					<a href="${cp }/search/searchdetail?pi_num=${bp.pi_num }">
						<img src="${cp }/images/${bp.pp_title}">
					</a>
				</div>
				<div class="prdInfo"> <!-- 상품 세부정보 -->
					<p class="name">
						<a href="${cp }/search/searchdetail?pi_num=${bp.pi_num }">
						<span>${bp.pi_name }</span>
						</a>
					</p>
					<p class="price">${bp.pi_price }</p>
					<p class="tag">
						<c:forEach var="t" items="${tag }" >
							<c:if test="${t.pi_num==bp.pi_num }">
								<c:choose >
									<c:when test="${t.tag!=null}">
										[${t.tag }]
									</c:when>
									<c:otherwise>
										<span></span>
									</c:otherwise>
								</c:choose>
							</c:if>
						</c:forEach>
					</p>
					<div class="color"> <!-- 색상 div -->
						<ul>
							<c:forEach var="co" items="${color }" >
								<c:if test="${co.pi_num==bp.pi_num }">
									<li style="background-color:${co.pd_color};" class="chips"> </li>
								</c:if> 
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</li>
	</ul>
	</c:forEach>
</div>

<div class="Products"> <!--제품들 10개씩-->
	<div class="categoryTitle"><h3>${CATEGORY }</h3></div>
	<c:forEach var="vo" items="${requestScope.list }"> 
	<ul class="list">
		<li class="item"> <!-- 상품 1 -->
			<div class="box"> <!-- 상품1 안에 제일 큰 박스 -->
				<div class="imgDiv">
					<a href="${cp }/search/searchdetail?pi_num=${vo.pi_num }">
						<img src="${cp }/${vo.pp_title}">
					</a>
				</div>
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
								<c:choose >
									<c:when test="${t.tag!=null}">
										[${t.tag }]
									</c:when>
									<c:otherwise>
										<span></span>
									</c:otherwise>
								</c:choose>
							</c:if>
						</c:forEach>
					</p>
					<div class="color"> <!-- 색상 div -->
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
		</li>
	</ul>
	</c:forEach>
</div>
<div class="Paging"><!-- 페이징 처리 하는부분 -->
	<p id="page">
	<c:if test="${startPage>10 }">
		<a href="${cp }/search/category?pageNum=${startPage-1}&CATEGORY=${category}&keyword=${keyword }&sort=${sort}"><<</a>
	</c:if>
	<c:choose>
		<c:when test="${pageNum!=1 }">
			<a href="${cp }/search/category?pageNum=${pageNum-1}&CATEGORY=${category}&keyword=${keyword }&sort=${sort}"><</a>
		</c:when>
		<c:otherwise>
			<a href="javascript:none()"><</a>
		</c:otherwise>
	</c:choose>
	<c:forEach var="i" begin="${startPage }" end="${endPage }">
		<c:choose>
			<c:when test="${pageNum==i }"> <%-- 현재 페이지 링크색상 다르게 표시하기위해 --%>
				<a href="${cp }/search/category?pageNum=${i}&CATEGORY=${category}&keyword=${keyword }&sort=${sort}"><span style="color:red">${i }</span></a>
			</c:when>
			<c:otherwise>
				<a href="${cp }/search/category?pageNum=${i}&CATEGORY=${category}&keyword=${keyword }&sort=${sort}"><span style="color:gray">${i }</span></a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:choose>
		<c:when test="${pageNum!=endPage }">
			<a href="${cp }/search/search?pageNum=${pageNum+1}&CATEGORY=${category}&keyword=${keyword }&sort=${sort}">></a>
		</c:when>
		<c:otherwise>
			<a href="javascript:none()">></a>
		</c:otherwise>
	</c:choose>
	<c:if test="${endPage<totalPage1 }">
		<a href="${cp }/search/category?pageNum=${endPage+1}&CATEGORY=${category}&keyword=${keyword }&sort=${sort}">>></a>
	</c:if>
	</p>
</div>
