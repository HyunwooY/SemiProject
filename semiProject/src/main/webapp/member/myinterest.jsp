<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<style>
#cartlist{position:relative;left:10px;top:-15px}
table{width:800px;position:relative;top:10px;}
table {margin:0px;padding:0px;text-align:center;border-bottom:1px solid black;border-collapse:collapse}
th, tr{padding-left:0px;padding-right:0px;}
td{padding-bottom:0px}
tr, td{border-bottom:1px solid black;border-collapse:collapse}
.imgs{width:140px;height:190px;padding:0px}
.count{position:relative;top:10px;left:20px;float:left;padding:0px;width:20px}
.down{clear:both;padding:0px;position:relative;left:1px}
.up{margin:0px;margin-bottom:2px}
.up img{width:20px;height:20px}
.down img{width:20px;height:20px;position:relative;left:}
#cartlist ul{display:inline-block;list-style:none}
.chips{width:15px;height:15px;border:0.5px solid #ddd;position:relative;top:5px}
#gobuybtn{position:relative;top:20px;height:30px;font-size:1.005em;text-align:center}
.throw{padding-top:10px;font-size:1.1em}
#isnull{padding-top:10px;padding-bottom:10px}
#countControll{width:21px;height:50px;text-align:center;position:relative;float:left;left:40px}
</style>
<div id="cartlist">
	<table>
		<c:forEach var="vo" items="${list}" varStatus="status">
			<c:if test="${vo.si_name!=siname}">
				<c:set var="siname" value="${vo.si_name }"/>
				<tr>
					<th class="throw" colspan="4" style="text-align:left;padding-bottom:10px;">${siname }</th>
				</tr>
				<tr>
					<th width="140px">사진</th>
					<th width="250px">상품명</th>
					<th width="130px">가격</th>
				</tr>
			</c:if>
				<tr>
					<td width="140px"><img src="${pageContext.request.contextPath}/upload/${vo.pp_title}" class="imgs"></td>
					<td><a href="${pageContext.request.contextPath}/search/searchdetail?pi_num=${vo.pi_num }">${vo.pi_num }${vo.pi_name }</a></td>
					<td>${vo.pi_price}</td>
				</tr>
		</c:forEach>
	</table>
</div>