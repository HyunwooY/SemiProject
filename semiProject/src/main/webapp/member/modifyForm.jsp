<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	#form2{display:none;}
</style>
<script>
	function checkpwd(){
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState==4 && xhr.status==200){
				
				if(== true){
					var form1 = document.getElementById("form1");
					form1.style.display = none;
					var form2 = document.getElementById("form2");
					form2.style.display = block;
				}else{
					alert("올바른 비밀번호가 아닙니다.");
				}
			}
		}
		var pwd = document.getElementById("pwd");
		var param = "?pwd=" + pwd.value;
		xhr.open("post","${pageContext.request.contextPath}/checkpwd",true);
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.send(param);
	}
</script>
<form method="post" action="" id="form1">
	<h2>비밀번호 입력</h2><br>
	<input type="password" name="pwd" id="pwd" placeholder="password"><br>
	<input type="button" value="확인" onclick="checkpwd()">
</form>
<form method="post" action="<%=request.getContextPath() %>/member/modify" id="form2">
	<h1>개인정보수정</h1>
	<label for="id" id="id">아이디</label>
	<input type="text" name="id" value="${vo.id }" readonly="readonly"><br>
	<label for="pwd" id="pwd">비밀번호</label>
	<input type="password" name="pwd" value="${vo.pwd }" placeholder="변경시 입력해 주세요"><br>
	<label for="name" id="name">이름</label>
	<input type="text" name="name" value="${vo.name }" placeholder=" 이름"><br>
	<label for="phone" id="phone">휴대폰번호</label>
	<input type="text" name="phone"  value="${vo.phone }" placeholder=" -없이 입력해 주세요"><br>
	<label for="email" id="email">이메일</label>
	<input type="text" name="email"  value="${vo.email }" placeholder=" 이메일"><br>
	<input type="submit" value="수정"><input type="reset" value="취소"> 
</form>
