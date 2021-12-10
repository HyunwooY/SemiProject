<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
#login{
	position:relative;
	top:150px;
	margin:auto;
	color:white;
}
#login form .input{width:200px;}
#login form .input,label{font-size:1.3em;margin:10px}
#pwd{margin-left:40px}
.btn{width:100px;height:35px;position:relative;top:30px}
#member{margin-right:100px}
</style>

<div id="login">
	<form method="post" action="${pageContext.request.contextPath }/member/login" id="form">
	<label for="member">일반사용자</label>
	<label for="seller">판매사업자</label><br>
	<input type="radio" name="type" value="일반사용자" id="member" class="radio" onclick="mclick()">
	<input type="radio" name="type" value="판매사업자" id="seller" class="radio" onclick="sclick()"><br>

	
		<label for="id" id="id">아이디</label>
		<input type="text" name="id" class="input">
		<label for="pwd" id="pwd">비밀번호</label>
		<input type="password" name="pwd" class="input"><br>
		<input type="submit" value="로그인" class="btn">
	</form>	
</div>
<script>
	function mclick(){
		document.getElementById("form").action="${pageContext.request.contextPath }/member/mlogin";
	}
	function sclick(){
		document.getElementById("form").action="${pageContext.request.contextPath }/seller/slogin";
	}
</script>



