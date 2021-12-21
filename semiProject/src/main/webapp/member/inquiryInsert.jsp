<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	window.onload = function(){
		if(${requestScope.code=='success'}){
			alert("문의가 등록되었습니다.");
		}else if(${requestScope.code=='fail'}){
			alert("문의 등록 실패");
		}
} 
</script>
<div>
	<form method="post" action="${pageContext.request.contextPath }/mypage/insertinquire">
		<label for="id">작성자</label>
		<input type="text" name="id" id="id">
		<select name="title" size="1" id="title">
			<option>::분류 선택::</option>
			<option value="상품">상품문의</option>
			<option value="배송">배송문의</option>
			<option value="교환반품">교환/반품문의</option>
			<option value="입금결제">입금/결제문의</option>
			<option value="배송전취소변경">배송전취소/변경문의</option>
			<option value="기타">기타</option>
		</select>
		<label for="content">내용</label>
		<textarea rows="5" cols="50" name="content"></textarea><br>
		<label for="password">비밀번호</label>
		<input type="password" name="password" id="password"><br>
		<input type="submit" value="등록"><input type="reset" value="취소">
	</form>
</div>