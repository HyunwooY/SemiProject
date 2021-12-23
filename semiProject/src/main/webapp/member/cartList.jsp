<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
#main{padding-top:50px;padding-bottom:90px}
#cartlist{position:relative;left:100px;width:70%;
		height:auto;margin:0px;padding:0px;text-align:left;margin:auto;
		}
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
<script>
	var param="";
	var checkcount=0;
	function gobuy(){
		console.log(param);
	}
	function countUp(cookieNum,price){
		let xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
				let count=document.getElementsByClassName("count");
				let priceAll=document.getElementsByClassName("priceAll");
				count[cookieNum-1].innerHTML=parseInt(count[cookieNum-1].innerHTML)+1;
				priceAll[cookieNum-1].innerHTML=parseInt(count[cookieNum-1].innerHTML)*price;
				let data=xhr.responseText;
				let json=JSON.parse(data);
				
			}
		}
		xhr.open('get','${pageContext.request.contextPath}/cart/count?how=up&cookie_num='+cookieNum,true);
		xhr.send();
	}
	function countDown(cookieNum,price){
		let xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
				let count=document.getElementsByClassName("count");
				let priceAll=document.getElementsByClassName("priceAll");
				if(parseInt(count[cookieNum-1].innerHTML)-1==0){
					let cdown=document.getElementsByClassName("cdown");
				}else{
					count[cookieNum-1].innerHTML=parseInt(count[cookieNum-1].innerHTML)-1;
					priceAll[cookieNum-1].innerHTML=parseInt(count[cookieNum-1].innerHTML)*price;
				}
				let data=xhr.responseText;
				let json=JSON.parse(data);
				
			}
		}
		xhr.open('get','${pageContext.request.contextPath}/cart/count?how=down&cookie_num='+cookieNum,true);
		xhr.send();
	}
	function cookiedelete(cookienum){
		console.log("aaaa")
		location.href="${pageContext.request.contextPath}/member/deleteCookie?cookieNum="+cookienum;
	}
</script>
<div id="cartlist">
	<c:if test="${result0!=null }">
		<table>
			<tr>
				<th class="throw" colspan="4" style="text-align:left;padding-bottom:10px;">${siname }</th>
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
			<tr>
				<td colspan="7" id="isnull">${result0 }</td>
			</tr>
		</table>
	</c:if>
	<form method="get" action="${pageContext.request.contextPath}/member/buyProduct">
	<table>
		<c:forEach var="vo" items="${cartlist}" varStatus="status">
			<c:if test="${vo.si_name!=siname}">
				<c:set var="siname" value="${vo.si_name }"/>
				<tr>
					<th class="throw" colspan="4" style="text-align:left;padding-bottom:10px;">${siname }</th>
				</tr>
				<tr>
					<th width="30px"></th>
					<th width="140px">사진</th>
					<th width="250px">상품명</th>
					<th width="100px">색상</th>
					<th width="50px">사이즈</th>
					<th width="80px">수량</th>
					<th width="100px">가격</th>
					<th width="50px"></th>
				</tr>
			</c:if>
				<tr>
					<c:set var="pcount" value="${vo.purchase_count}"/>
					<c:set var="priceAll" value="${pcount* vo.pi_price}"/>
					<td><input type="checkbox" name="product" value="${vo.pd_num},${pcount},${vo.pi_num}"></td>
					<td width="140px"><img src="${pageContext.request.contextPath}/upload/${vo.pp_title}" class="imgs"></td>
					<td>${vo.pi_name }</td>
					<td>${vo.pd_color }<br><ul><li style="background-color:${vo.pd_color}" class=chips></li></ul></td>
					<td>${vo.pd_size }</td>		
					<td>
					<div class="count">${pcount}</div>
					<div id="countControll">
						<div class="up">
							<a href="javascript:countUp(${status.count},${vo.pi_price })">
								<img src="${pageContext.request.contextPath}/images/up.png">
							</a>
						</div>
						<div class="down">
							<a href="javascript:countDown(${status.count},${vo.pi_price })" class="cdown">
								<img src="${pageContext.request.contextPath}/images/down.png" >
							</a>
						</div>
					</div>
					</td>
					<td class="priceAll">${priceAll}</td>
					<td width="50px"><input type="button" value="상품삭제" onclick="cookiedelete(${status.count})"></td>
				</tr>
		</c:forEach>
	</table>
	<c:if test="${result0==null }">
		<div id="gobuy">
			<input type="submit" value="선택상품 구매하기	" id="gobuybtn">
		</div>
	</c:if>
	</form>
</div>





