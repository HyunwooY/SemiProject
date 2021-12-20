<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<script>
	window.onload = function(){
		if(${requestScope.result=='success'}){
			alert("배송지가 등록 되었습니다.");
		}
	} 
/*	function showAddress(){
		String addrname = document.getElementById("addrname").value;
		String name = document.getElementById("name").value;
		String phone = document.getElementById("phone").value;
		String addr = document.getElementById("addr").value;
		const div = document.createElement("div");
		div.innerHTML = "배송지명 : " + addrname + "<br>" +
						"수령인 : " + name + "<br>" + 
						"전화번호 : " + phone + "<br> +
						"주소 : " + addr;
		div.className = "addaddress";
		const div2 = document.getElementById("div2");
		div2.appendChild(div); 
	} */
</script>
<div id="div2"></div>
<div>
	<h3>배송지 등록</h3>
	<form method="post" action="${pageContext.request.contextPath }/member/insertaddr">
		<label for="addrname">배송지명</label>
		<input type="text" name="addrname" value="${vo.nickname }"><br>
		<label for="name">수령인</label>
		<input type="text" name="name"><br>
		<label for="phone">전화번호</label>
		<input type="text" name="phone"><br>
		<label for="addr">주소</label>
		<input type="text" name="addr"><br>
		<input type="submit" value="등록">
	</form>
</div>