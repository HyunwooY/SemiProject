<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form method="post" action="${pageContext.request.contextPath }/seller/sjoin">
	<label for="id" class="label">아이디</label><br>
	<input type="text" name="id" class="input"><br>
	<label for="pwd" class="label">비밀번호</label><br>
	<input type="password" name="pwd" class="input"><br>
	<label for="name" class="label">브랜드명</label><br>
	<input type="text" name="name" class="input"><br>
	<label for="snum" class="label">사업자번호</label><br>
	<input type="text" name="snum" class="input"><br>
	<label for="saddr" class="label">소재지</label><br>
	<input type="text" name="snum" class="input"><br>
	<label for="email" class="label">이메일</label><br>
	<input type="text" name="email" class="input"><br>
	<label class="label">연락처</label>
	<select name="first">
		<option>010</option>
		<option>011</option>
	</select><span>-</span>
	<input type="text" maxlength="4" size="4" name="mid" class="phone"><span>-</span>
	<input type="text" maxlength="4" size="4" name="back" class="phone"><br>
	<input type="submit" value="회원가입" class="btn">
	<input type="reset"	value="취소" class="btn">
</form>