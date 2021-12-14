<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	window.onload = function(){
		if(${requestScope.result=='success'}){
			alert("회원정보가 수정이 되었습니다.");
		}
	}
</script>
<form method="post" action="<%=request.getContextPath() %>/member/modify" id="form2">
	<h1>내 정보</h1>
	<label for="id" id="id">아이디</label>
	<input type="text" name="id번" value="${sessionScope.id }" readonly="readonly"><br>
	<label for="pwd" id="pwd">비밀번호</label>
	<input type="password" name="pwd" value="${vo.pwd }"  placeholder=" 비밀번호"><br>
	<label for="name" id="name">이름</label>
	<input type="text" name="name" value="${vo.name}" placeholder=" 이름"><br>
	<label for="phone" id="phone">휴대폰번호</label>
	<input type="text" name="phone"  value="${vo.phone}" placeholder=" -없이 입력해 주세요"><br>
	<label for="email" id="email">이메일</label>
	<input type="text" name="email"  value="${vo.email}" placeholder=" 이메일"><br>
	
	<label for="saname" id="saname">수령인</label>
	<input type="text" name="saname"  value="" placeholder=" 수령인"><br>
	<label for="saphone" id="saphone">휴대폰번호</label>
	<input type="text" name="saphone"  value="" placeholder=" 휴대폰번호"><br>
	<label for="saaddr" id="saaddr">주소</label>
	<input type="text" name="saaddr"  value="" placeholder=" 주소"><br><br>
	<input type="submit" value="수정"><input type="reset" value="취소"> 
</form>