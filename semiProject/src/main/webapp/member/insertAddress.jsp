<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
	
</div>    
<div>
	<form method="post" action="${pageContext.request.contextPath }/member/insertaddr">
		<label for="addrname">배송지명</label>
		<input type="text" name="addrname"><br>
		<label for="name">수령인</label>
		<input type="text" name="name"><br>
		<label for="phone">전화번호</label>
		<input type="text" name="phone"><br>
		<label for="addr">주소</label>
		<input type="text" name="addr"><br>
		<input type="submit" value="등록">
	</form>
</div>