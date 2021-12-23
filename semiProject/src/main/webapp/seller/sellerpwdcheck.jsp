<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	#form1{
		position:relative;
		bottom: 10px;
		top: 50px;
		margin: auto;
		margin-right: 200px;
	}
	#pwd{
		width: 150px;
		height: 20px;
		margin-bottom: 20px;
	}
	#btn{
		width: 50px;
		position: relative;
		left: 50px;
	}
</style>

<script>
	window.onload = function(){
		if(${requestScope.result == 'fail'}){
			alert("올바른 비밀번호가 아닙니다.");
		}
	}
</script>

<form method="post" action="<%=request.getContextPath() %>/seller/checkpwd"  id="form1">
	<h1>비밀번호 입력</h1><br>
	<input type="password" name="si_pwd" id="si_pwd" placeholder="password"><br>
	<br>
	<input type="submit" value="확인" id="btn">
</form>
