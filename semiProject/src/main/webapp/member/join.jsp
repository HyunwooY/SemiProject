<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
#join{
	position:relative;
	top:150px;
	left:200px;
	margin:auto;
	color:white;
}
#join form .input{width:200px}
#join form input,select{font-size:1.3em;margin:10px}
.phone{width:150px}
.btn{width:100px}
</style>
<div id="join">

	<form method="post" action="${pageContext.request.contextPath }/member/join">
		<label for="id" class="label">아이디</label><br>
		<input type="text" name="id" class="input"><br>
		<label for="pwd" class="label">비밀번호</label><br>
		<input type="password" name="pwd" class="input"><br>
		<label for="name" class="label">이름</label><br>
		<input type="text" name="name" class="input"><br>
		<label for="email" class="label">이메일</label><br>
		<input type="text" name="email" class="input"><br>
		<label class="label">전화번호</label>
		<select name="first">
			<option>010</option>
			<option>011</option>
		</select><span>-</span>
		<input type="text" name="mid" class="phone"><span>-</span>
		<input type="text" name="back" class="phone"><br>
		<input type="submit" value="회원가입" class="btn">
		<input type="reset"	value="취소" class="btn">
	</form>
</div>




