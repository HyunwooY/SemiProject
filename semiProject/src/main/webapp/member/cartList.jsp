<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
#cartlist{position:relative;top:50px;left:100px;width:70%;
		height:1000px;margin:0px;padding:0px;text-align:left;margin:auto;
		}
table{width:800px;position:relative;top:10px;}
table {margin:0px;padding:0px;text-align:center;border-bottom:1px solid black;border-collapse:collapse}
th, tr{padding-left:0px;padding-right:0px;}
td{padding-bottom:0px}
tr, td{border-bottom:1px solid black;border-collapse:collapse}
.imgs{width:140px;height:190px;padding:0px}
.count{position:relative;top:10px;left:20px;float:left;padding:0px;}
.down{clear:both;padding:0px;position:relative;left:4px}
.up{margin:0px;margin-bottom:2px}
.up img{width:20px;height:20px}
.down img{width:20px;height:20px;position:relative;left:}
#cartlist ul{display:inline-block;list-style:none}
.chips{width:15px;height:15px;border:0.5px solid #ddd;position:relative;top:5px}
#gobuybtn{position:relative;top:20px;height:30px;font-size:1.005em;text-align:center}


</style>
<script>
	var param="";
	var checkcount=0;
	function checked(pd_num,count){
		checkcount++;
		param+="&pd_num"+checkcount+"="+pd_num+"&count="+checkcount+"="+count;
	}
	function gobuy(){
		console.log(param);
	}
</script>
<div id="cartlist">
	<form method="post" action="${pageContext.request.contextPath}/member/cartlist">
	<table>
		<c:forEach var="vo" items="${cartlist}">
			<c:if test="${vo.si_name!=siname}">
				<c:set var="siname" value="${vo.si_name }"/>
				<tr>
					<th colspan="4" style="text-align:left;padding-bottom:10px;">${siname }</th>
				</tr>
				<tr>
					<th width="30px"></th>
					<th width="140px">사진</th>
					<th width="250px">상품명</th>
					<th width="100px">색상</th>
					<th width="50px">사이즈</th>
					<th width="100px">구매수량</th>
					<th width="130px">가격</th>
				</tr>
			</c:if>
				<tr>
					<td><input type="checkbox" name="product" value="${vo.pd_num},${vo.purchase_count}"></td>
					<td width="140px"><img src="${pageContext.request.contextPath}/upload/${vo.pp_title}" class="imgs"></td>
					<td>${vo.pi_name }</td>
					<td>${vo.pd_color }<br><ul><li style="background-color:${vo.pd_color}" class=chips></li></ul></td>
					<td>${vo.pd_size }</td>		
					<td>
						<div class="count">${vo.purchase_count}</div>
						<div class="up">
							<a href="${pageContext.request.contextPath}/cart/count?what=up&pd_num=${vo.pd_num}">
								<img src="${pageContext.request.contextPath}/images/up.png">
							</a>
						</div>
						<div class="down">
							<a href="${pageContext.request.contextPath}/cart/count?what=down&pd_num=${vo.pd_num}">
								<img src="${pageContext.request.contextPath}/images/down.png">
							</a>
						</div>
					</td>
					<td>${vo.pi_price * vo.purchase_count}</td>
				</tr>
		</c:forEach>
	</table>
	
	<div id="gobuy">
		<input type="submit" value="선택상품 구매하기	" id="gobuybtn">
	</div>
	</form>
</div>





