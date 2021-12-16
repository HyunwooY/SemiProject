<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	window.onload = function(){
		if(${requestScope.result=='success'}){
			alert("배송지가 등록 되었습니다.");
		}
	} 
</script>
<div>
	
</div>    
<div>
	<form method="post" action="${pageContext.request.contextPath }/member/insertaddr">
		<label for="addrname">배송지명</label>
		<input type="text" name="addrname" value="${vo.nickname }"><br>
		<label for="name">수령인</label>
		<input type="text" name="name" value="${vo.name }"><br>
		<label for="phone">전화번호</label>
		<input type="text" name="phone" value="${vo.phone }"><br>
		<label for="addr">주소</label>
		<input type="text" name="addr" value="${vo.addr }"><br>
		<input type="submit" value="등록">
	</form>
</div>