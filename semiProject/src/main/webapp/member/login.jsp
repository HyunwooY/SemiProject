<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
#main{padding-top:150px;padding-bottom:150px}
#login{
	position:relative;
	margin:auto;
	color:black;
}
#login form .input{width:200px;}
#login form .input,label{font-size:1.3em;margin:10px}
#pwd{margin-left:40px}
.btn{width:100px;height:35px;position:relative;top:30px}
#member{margin-right:100px}
#find{position:relative;top:-35px}
#findid{border-right:1px solid black;width:90px;display:inline-block}
</style>

<div id="login">
	<form method="post" action="${pageContext.request.contextPath }/member/login" id="form">
	<label for="member">일반사용자</label>
	<label for="seller">판매사업자</label><br>
	<input type="radio" name="type" value="일반사용자" id="member" class="radio" onclick="mclick()" checked="checked">
	<input type="radio" name="type" value="판매사업자" id="seller" class="radio" onclick="sclick()"><br>
	
		<label for="id" id="id">아이디</label>
		<input type="text" name="id" class="input">
		<label for="pwd" id="pwd">비밀번호</label>
		<input type="password" name="pwd" class="input"><br>
		<input type="submit" value="로그인" class="btn">
	</form>	
	<div id="find">
		<a href="${pageContext.request.contextPath }/id/find" id="findid">아이디찾기</a>
		<a href="${pageContext.request.contextPath }/pwd/find">비밀번호찾기</a>
	</div>
</div>
<script>

</script>



