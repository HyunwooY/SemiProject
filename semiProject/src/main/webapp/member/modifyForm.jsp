<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<h1>개인정보수정</h1>
<form method="post" action="<%=request.getContextPath() %>/member/modify">
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
