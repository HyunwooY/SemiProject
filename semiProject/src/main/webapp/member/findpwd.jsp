<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<style>
#find{
	position:relative;
	top: 90px;
	margin: auto;
	color: black;
}
h1{margin-bottom: 20px;}
#member{margin-right: 100px;}
label{margin: 15px; font-size: 1.3em;}
.radio{margin-bottom: 10px;}
#ex{margin-bottom: 10px;}
#t1{margin-bottom: 10px;}
#id{width: 250px; height: 20px;}
#email{width: 250px; height: 20px; margin-bottom: 20px;}
#btn{width: 100px; height: 35px; font-size: 15px;}
a{color:white;}
</style>
<script>
	var radio = null;
	function findpwd(){
		var xhr = new XMLHttpRequest();
		var id = document.getElementById("id");
		var email = document.getElementById("email");
		xhr.onreadystatechange = function() {
			if(xhr.readyState==4 && xhr.status==200){
				var data = xhr.responseText;
				var json = JSON.parse(data);
				var div = document.getElementById("showpwd");
				if(json.find == true){
					var form = document.getElementById("form");
					form.style.display = "none";
					div.innerHTML = "회원가입 시 사용한 비밀번호는 <strong>" + json.pwd + "</strong> 입니다.";
				}else{
					div.innerHTML = "아이디 또는 이메일 정보가 틀렸습니다."
				}
			}
		};
		let param = "id=" + id.value + "&email=" + email.value + "&type=" + radio;
		xhr.open('post','${pageContext.request.contextPath }/pwd/find',true);
		xhr.setRequestHeader('ConTent-Type','application/x-www-form-urlencoded');
		xhr.send(param);
	}
	function mpwdfind(){
		radio = "일반사용자";
		document.getElementById("ex").innerHTML = "비밀번호는 아이디와 이메일을 통해 찾을 수 있습니다.";
		document.getElementById("id").placeholder = "아이디";
		document.getElementById("email").placeholder = "이메일";
	}
	function spwdfind(){
		radio = "판매사업자";
		document.getElementById("ex").innerHTML = "비밀번호는 사업자번호와 이메일을 통해 찾을 수 있습니다.";
		document.getElementById("id").placeholder = "사업자번호";
		document.getElementById("email").placeholder = "이메일";
	}
</script>
<div id="find">
	<h1>비밀번호 찾기</h1>
	<form method="post" action="${pageContext.request.contextPath }/pwd/find" id="form">
		<div>
			<label for="member">일반사용자</label>
			<label for="seller">판매사업자</label><br>
			<input type="radio" name="type" value="일반사용자" id="member" class="radio" onclick="mpwdfind()">
			<input type="radio" name="type" value="판매사업자" id="seller" class="radio" onclick="spwdfind()"><br>
			<h5 id="ex"></h5>
			<div id="t1">
				<input type="text" name="id" id="id">
			</div>	
		</div>
		<div>
			<div id="t2">
				<input type="text" name="email" id="email">
			</div>
		</div>
		<div>
			<div>
				<input type="button" value="찾기" id="btn" onclick="findpwd()">
			</div>
		</div>
	</form>
		<div id="showpwd"></div><br>
		<a href="${pageContext.request.contextPath}/member/login">로그인 화면으로 돌아가기</a>
</div>
