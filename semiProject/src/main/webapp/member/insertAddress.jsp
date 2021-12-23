<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<style>
	#addaddress{display:none; position:relative; left: 400px;}
	#text{position:relative; left: 480px;}
	#addaddress2{margin-top: 30px;}
	#addaddrtable{position:relative; right: 180px;}
	#addaddrtable tr{margin-top: 30px;}
	.addaddrth{margin-right: 15px; margin-top: 10px;}
	.addaddrtd{width: 380px; height: 30px; margin-bottom: 10px;}
	.addrinputbtn{width: 50px; height: 30px; position: relative; left: 15px; margin-top: 20px; margin-right: 10px;}
</style>
<script>
	function showForm(n){
		const addaddress = document.getElementById("addaddress");
		const text = document.getElementById("text");
		const showaddress = document.getElementById("showaddress");
		if(n==1){
			addaddress.style.display="block";
			text.style.display="none";
			showaddress.style.display="none";
		}else{
			addaddress.style.display="none";
			text.style.display="block";
			showaddress.style.display="block";
		}
	}
	window.onload = function(){
		if(${requestScope.result=='success'}){
			alert("배송지가 등록 되었습니다.");
		}else if(${requestScope.result=='fail'}){
			alert("배송지 등록 실패");
		}else if(${requestScope.code=='success'}){
			alert("배송지가 수정 되었습니다.");
		}else if(${requestScope.code=='fail'}){
			alert("배송지 수정 실패");
		}
	} 
</script>
<div id="showaddress">
		<table width="1000" border="1" style="text-align: center; margin: auto; margin-bottom: 30px;">
			<tr>
				<th>배송지명</th><th>수령인</th><th>전화번호</th><th>주소</th><th>수정</th><th>삭제</th>
			</tr>
			<c:forEach var="avo" items="${list }">
			<tr>
				<td>${avo.nickname}</td>
				<td>${avo.name}</td>
				<td>${avo.phone}</td>
				<td>${avo.addr }</td>
				<td><a href="<%=request.getContextPath()%>/member/updateaddr?id=${avo.id}&name=${avo.name}">수정</a></td>
				<td><a href="<%=request.getContextPath()%>/member/deleteaddr?id=${avo.id}&addr=${avo.addr}">삭제</a></td>
			</tr>
			</c:forEach>
		</table>
</div><br>
<div id="text"><a href="javascript:showForm(1)">배송지 등록하기</a></div><br>
<div id="addaddress">
	<h2>배송지 등록</h2>
	<div id="addaddress2">
		<form method="post" action="${pageContext.request.contextPath }/member/insertaddr">
			<table id="addaddrtable">
				<tr>
					<th><label for="addrname" class="addaddrth">배송지명</label></th>
					<td><input type="text" name="addrname" id="addrname" class="addaddrtd"></td>
				</tr>
				<tr>
					<th><label for="name" class="addaddrth">수령인</label></th>
					<td><input type="text" name="name" id="name" class="addaddrtd"></td>
				</tr>
				<tr>
					<th><label for="phone" class="addaddrth">전화번호</label></th>
					<td><input type="text" name="phone" id="phone" class="addaddrtd"></td>
				</tr>
				<tr>
					<th><label for="addr" class="addaddrth">주소</label></th>
					<td><input type="text" name="addr" id="addr" class="addaddrtd"></td>
				</tr>
			</table>
			<input type="submit" value="등록" class="addrinputbtn"> <input type="button" value="취소" onclick="showForm(2)" class="addrinputbtn"> 
		</form>
	</div>
</div>
