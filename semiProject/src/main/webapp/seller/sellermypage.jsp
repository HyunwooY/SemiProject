<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<style>
	#form2{
		position:relative;
		left: 40px;
		top: 50px;
		margin: auto;
	}
</style>
<script>
	window.onload = function(){
		if(${requestScope.result=='success'}){
			alert("판매자 정보가 수정 되었습니다.");
		}
	} 
</script>
<form method="post" action="<%=request.getContextPath() %>/seller/modify" id="form2">
	<h1>내 정보</h1>
	<label for="id" id="id">아이디</label>
	<input type="text" name="si_id" value="${sessionScope.id }" readonly="readonly"><br>
	
	<label for="pwd" id="pwd">비밀번호</label>
	<input type="password" name="si_pwd" value="${vo.si_pwd }"  placeholder=" 비밀번호"><br>
	
	<label for="name" id="num">사업자번호</label>
	<input type="text" name="si_num" value="${vo.si_num}" placeholder=" 사업자번호"><br>
	
	<label for="addr" id="addr">주소</label>
	<input type="text" name="si_addr" value="${vo.si_addr}" placeholder=" 주소"><br>
	
	<label for="phone" id="phone">휴대폰번호</label>
	<input type="text" name="si_phone"  value="${vo.si_phone}" placeholder=" -없이 입력해 주세요"><br>
	
	<label for="brandName" id="name">브랜드명</label>
	<input type="text" name="si_name"  value="${vo.si_name}" placeholder=" 브랜드명"><br>
	
	<label for="email" id="email">이메일</label>
	<input type="text" name="si_email"  value="${vo.si_email}" placeholder=" 이메일"><br>
	
	<input type="submit" value="수정"><input type="reset" value="취소"> 
</form>
