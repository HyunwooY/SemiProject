<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
#find{
	position:relative;
	top: 90px;
	margin: auto;
	color: white;
}
h1{margin-bottom: 20px;}
#member{margin-right: 100px;}
label{margin: 15px; font-size: 1.3em;}
.radio{margin-bottom: 10px;}
#ex{margin-bottom: 10px;}
#t1{margin-bottom: 10px;}
#name{width: 250px; height: 20px;}
#email{width: 250px; height: 20px; margin-bottom: 20px;}
#btn{width: 100px; height: 35px; font-size: 15px;}
a{color:white;}
</style>
<script type="text/javascript">
	function findid(){
		var xhr = new XMLHttpRequest();
		var name = document.getElementById("name");
		var email = document.getElementById("email");
		xhr.onreadystatechange = function(){
			if(xhr.readyState==4 && xhr.status==200){
				var data = xhr.responseText;
				var json = JSON.parse(data);
				var div = document.getElementById("showid");
				if(json.find == true){
					var form = document.getElementById("form");
					form.style.display = "none";
					div.innerHTML = "회원가입 시 사용한 아이디는 <strong>" + json.id + "</strong> 입니다.";
				}else{
					div.innerHTML = "회원 가입 정보가 없습니다."
				}
			}
		};
		
		let param = "name=" + name.value + "&email=" + email.value;
		xhr.open('post','${pageContext.request.contextPath }/id/find',true);
		xhr.setRequestHeader('ConTent-Type','application/x-www-form-urlencoded');
		xhr.send(param);
	}
	function midfind(){
		document.getElementById("ex").innerHTML = "아이디는 가입시 입력하신 이름과 이메일을 통해 찾을 수 있습니다.";
		document.getElementById("name").placeholder = "이름";
		document.getElementById("email").placeholder = "이메일";
	}
	function sidfind(){
		document.getElementById("ex").innerHTML = "아이디는 가입시 입력하신 사업자번호와 전화번호를 통해 찾을 수 있습니다.";
		document.getElementById("name").placeholder = "사업자번호";
		document.getElementById("email").placeholder = "전화번호";
	}
</script>
<div id="find">
	<h1>아이디 찾기</h1>
	<form method="post" action="${pageContext.request.contextPath }/id/find" id="form">
		<div>
			<label for="member">일반사용자</label>
			<label for="seller">판매사업자</label><br>
			<input type="radio" name="type" value="일반사용자" id="member" class="radio" onclick="midfind()">
			<input type="radio" name="type" value="판매사용자" id="seller" class="radio" onclick="sidfind()"><br>
			<h5 id="ex"></h5>
			<div id="t1">
				<input type="text" name="name" id="name">
			</div>	
		</div>
		<div>
			<div id="t2">
				<input type="text" name="email" id="email">
			</div>
		</div>
		<div>
			<div>
				<input type="button" value="찾기" id="btn" onclick="findid()">
			</div>
		</div>
	</form>
	<div id="showid"></div><br>
	<a href="${pageContext.request.contextPath}/member/login">로그인 화면으로 돌아가기</a>
</div>
