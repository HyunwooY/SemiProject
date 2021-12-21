<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	/* window.onload = function(){
		if(${requestScope.code=='success'}){
			alert("배송지가 수정 되었습니다.");
		}else if(${requestScope.code=='fail'}){
			alert("배송지 수정 실패");
		}
	} */
	function back(){
		window.location = "${pageContext.request.contextPath}/member/addrmanagement";
	}
</script> 
<div id="showdiv">
	<h2>배송지 수정</h2>
	<form method="post" action="${pageContext.request.contextPath }/member/updateaddr">
		<input type="hidden" name="num" value="${vo.num }">
		<label for="addrname">배송지명</label>
		<input type="text" name="addrname" id="addrname" value="${vo.nickname }"><br>
		<label for="name">수령인</label>
		<input type="text" name="name" id="name" value="${vo.name }"><br>
		<label for="phone">전화번호</label>
		<input type="text" name="phone" id="phone" value="${vo.phone }"><br>
		<label for="addr">주소</label>
		<input type="text" name="addr" id="addr" value="${vo.addr }"><br>
		<input type="submit" value="수정"><input type="button" value="취소" onclick="back()">
	</form>
</div>