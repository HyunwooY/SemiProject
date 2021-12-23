<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	function checkDup(){
		let id=document.getElementById("id").value;
		xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
				let data=xhr.responseText;
				let json=JSON.parse(data);
				if(json.check==true){
					alert('해당 아이디는 사용가능 합니다.');
				}else if(json.check==false){
					alert('해당 아이디는 사용중입니다.\n다른 아이디를 입력해주세요');
				}
			}
		}
		xhr.open('get','${pageContext.request.contextPath}/check/id?id='+id,true);
		xhr.send();
	}
</script>  
<style>
#joinForm{margin:auto;text-align:left}
</style>  
<div id="joinForm">
<form method="post" action="${pageContext.request.contextPath }/member/mjoin">
	<label for="id" class="label">아이디</label><br>
	<input type="text" name="id" class="input" id="id">
	<input type="button" value="중복확인" style="font-size:1em" onclick="checkDup()"><br>
	<label for="pwd" class="label">비밀번호</label><br>
	<input type="password" name="pwd" class="input"><br>
	<label for="name" class="label">이름</label><br>
	<input type="text" name="name" class="input"><br>
	<label for="email" class="label">이메일</label><br>
	<input type="text" name="email" class="input"><br>
	<label class="label">전화번호</label><br>
	<select name="first">
		<option>010</option>
		<option>011</option>
	</select><span>-</span>
	<input type="text" name="mid" class="phone"><span>-</span>
	<input type="text" name="back" class="phone"><br>
	<label class="label">주소</label><br>
	<input type="text" name="addr"><br>
	
	<input type="submit" value="회원가입" class="btn">
	<input type="reset"	value="취소" class="btn">
</form>
</div>