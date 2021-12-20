<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	#form2{
		position:relative;
		left: 40px;
		bottom: 30px;
		margin: auto;
	}
</style>
<script>
	window.onload = function(){
		if(${requestScope.result=='success'}){
			alert("회원정보가 수정 되었습니다.");
		}
	} 
</script>
<form method="post" action="<%=request.getContextPath() %>/member/modify" id="form2">
	<h1>내 정보</h1>
	<label for="id" id="id">아이디</label>
	<input type="text" name="id" value="${sessionScope.id }" readonly="readonly"><br>
	<label for="pwd" id="pwd">비밀번호</label>
	<input type="password" name="pwd" value="${vo.pwd }"  placeholder=" 비밀번호"><br>
	<label for="name" id="name">이름</label>
	<input type="text" name="name" value="${vo.name}" placeholder=" 이름"><br>
	<label for="phone" id="phone">휴대폰번호</label>
	<input type="text" name="phone"  value="${vo.phone}" placeholder=" -없이 입력해 주세요"><br>
	<label for="email" id="email">이메일</label>
	<input type="text" name="email"  value="${vo.email}" placeholder=" 이메일"><br>
	
	<h4>기본 배송지 정보</h4>
	<label for="saname" id="saname">수령인</label>
	<input type="text" name="saname"  value="${addrvo.nickname}" placeholder=" 수령인"  readonly="readonly"><br>
	<label for="saphone" id="saphone">휴대폰번호</label>
	<input type="text" name="saphone"  value="${addrvo.phone}" placeholder=" 휴대폰번호"  readonly="readonly"><br>
	<label for="saaddr" id="saaddr">주소</label>
	<input type="text" name="saaddr"  value="${addrvo.addr}" placeholder=" 주소"  readonly="readonly"><br><br>
	<input type="submit" value="수정"><input type="reset" value="취소"> 
</form>