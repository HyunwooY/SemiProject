<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<style>
.btn1,.btn2,.btn3,.btn4{margin-right:-8px;}
.btn2,.btn3,.btn4,.btn5{border-top-left:-5px;border-bottom-left:-5px}
#start,#end{height:18px;position:relative;top:-2px}
#table{width:1000px;position:relative;top:10px;text-align:center}
</style>

<div>
	<form method="get" action="${pageContext.request.contextPath }/member/showstate">
		<input type="button" value="오늘" onclick="set(0)" class="btn1">
		<input type="button" value="1주일" onclick="setweek(7)" class="btn2">
		<input type="button" value="1개월" onclick="set(1)" class="btn3">
		<input type="button" value="3개월" onclick="set(3)" class="btn4">
		<input type="button" value="6개월" onclick="set(6)" class="btn5">	
		<input type="date" id="start" value="${requestScope.start }">
		<input type="date" id="end" value="${requestScope.end }">
		<input type="submit" value="조회">
	</form>
</div>
<div id="stateboard">
	<table id="table">
		<tr>
			<th width="120px">주문일자</th>
			<th width="500px">상품정보</th>
			<th width="60px">수량</th>
			<th width="150px">상품구매금액</th>
			<th width="170px">주문상태</th>
		</tr>
		<c:forEach var="vo" items="${requestScope.list}">
		<tr>
			<td>${vo.ph_regdate }</td>
			<td>${vo.pi_name }</td>
			<td>${vo.p_count }</td>
			<td>${vo.pi_price * vo.p_count }</td>
			<td>${vo.ph_state }</td>
		</tr>
		</c:forEach>
	</table>
</div>
<script>
	window.onload=set(3);
	function set(change){
		let date=new Date();
		document.getElementById("start").value=new Date(date.setMonth(date.getMonth()-change)).toISOString().substring(0, 10);
		document.getElementById("end").value=new Date().toISOString().substring(0, 10);
	}
	function setweek(change){
		let date=new Date();
		document.getElementById("start").value=new Date(date.setDate(date.getDate()-change)).toISOString().substring(0, 10);
		document.getElementById("end").value=new Date().toISOString().substring(0, 10);
	}
</script>