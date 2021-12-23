<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	#pwd{
		width: 130px;
		height: 20px;
		margin-bottom: 20px;
	}
	#btn{
		position: relative;
		left: 40px;
		width: 50px;
	}
</style>
<script>
/*	function checkpwd(){
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState==4 && xhr.status==200){
				var data = xhr.responseText; 
				var json = JSON.parse(data);
				if(json.check==true){
					var form1 = document.getElementById("form1").style.display = "none";
				}else{
					alert("올바른 비밀번호가 아닙니다.");
				}
			}
		}
		var pwd = document.getElementById("pwd");
		var param = "pwd=" + pwd.value;
		xhr.open("post","${pageContext.request.contextPath}/checkpwd",true);
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.send(param); 
	} */
	window.onload = function(){
		if(${requestScope.result == 'fail'}){
			alert("올바른 비밀번호가 아닙니다.");
		}
	}
</script>
<form method="post" action="<%=request.getContextPath() %>/member/checkpwd">
	<input type="password" name="pwd" id="pwd" placeholder="password"><br>
	<input type="submit" value="확인" id="btn">
</form>
