<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<script type="text/javascript">
	function input(){
		let addr=document.getElementsByClassName("input")[0]
		addr.style.display="block"
		let myAddr=document.getElementById("myAddr")
		myAddr.style.display="none"
	}
	function changeDefault(){
		let addr=document.getElementsByClassName("input")[0]
		addr.style.display="none"
		let myAddr=document.getElementById("myAddr")
		myAddr.style.display="block"
	}
</script>
<style>
#purchase{position:relative;top:50px;left:100px;width:80%;height:1000px;margin:0px;padding:0px;text-align:left;margin:auto}

table{width:800px;position:relative;top:10px;}
table {margin:0px;padding:0px}
th, tr{padding-left:0px;padding-right:0px}
.div{margin-bottom:20px}
#takeinfo #h3{display:inline-block}
#takeinfo #btn{height:25px;position:relative;top:-2px;left:10px}
.input{display:none;}
</style>    
<div id="purchase">
	<div id="buyinfo" class="div">
		<h3>구매자정보</h3>
		<table>
			<tr>
				<th>이름</th>
				<td>${vo.name }</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>${vo.email }</td>
			</tr>
			<tr>
				<th>휴대폰 번호</th>
				<td>${vo.phone }</td>
			</tr>
		</table>
	</div>
	<div id="takeinfo" class="div">
		<h3 id="h3">받는사람정보</h3><input type="button" value="배송지추가" id="btn"><br>
		<label for="default">기본배송지</label>
		<input type="radio" name="select" id="default" checked="checked" onclick="changeDefault()">
		<label for="input">직접입력</label>
		<input type="radio" name="select" id="input" onclick="input()">
		<table class="input">
			<tr>
				<th>이름</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>배송주소</th>
				<td><input type="text" name="addr"></td>
			</tr>
			<tr>
				<th>연락처</th>
				<td>
					<select name="first">
						<option>010</option>
						<option>011</option>
					</select><span>-</span>
					<input type="text" name="mid"><span>-</span>
					<input type="text" name="last">
				</td>
			</tr>
		</table>
		<table id="myAddr">
			<tr>
				<th>이름</th>
				<td>${avo.name }</td>
			</tr>
			<tr>
				<th>배송주소</th>
				<td>${avo.addr}</td>
			</tr>
			<tr>
				<th>연락처</th>
				<td>${avo.phone}</td>
			</tr>
		</table>
	</div>
	<div id="payinfo" class="div">
		<h3>상품정보</h3>
		<table>
			<c:forEach var="vo" items="${list}">
				<c:if test="${vo.si_name!=siname}">
					<c:set var="siname" value="${vo.si_name }"/>
				</c:if>
					<tr>
						<th colspan="4">${siname }</th>
					</tr>
					<tr>
						<td><img src="${pageContext.request.contextPath}/upload/${vo.pp_title}"></td>
						<td>${vo.pi_name }</td>
						<td>${vo.pd_color }</td>
						<td>${vo.pd_size }</td>		
						<td>${vo.purchase_count}</td>
						<td>${vo.pi_price * vo.purchase_count}</td>
					</tr>
				
			</c:forEach>
		</table>
	</div>
	<div id="purchaseType">
		<label for="creditcard">신용카드</label>
		<input type="radio" name="type" value="신용카드" id="creditcard">
		<label for="cash">무통장입금</label>
		<input type="radio" name="type" value="무통장입금" id="cash">
	</div>
</div>








