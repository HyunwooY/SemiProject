<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
#join{
	position:relative;
	top:150px;
	left:450px;
	margin:auto;
	color:white;
}
#text{position:relative;top:-50px;}
#join {text-align:left;}
#join form .input{width:200px}
#join form input,select{font-size:1.3em;margin:10px}
.phone{width:150px}
.btn{width:100px}
</style>
<div id="join">
	<div id="text">
		<h1>회원가입</h1><br>
		<input type="button" value="일반사용자" onclick="location.href='${pageContext.request.contextPath}/member/mjoin'">
		<input type="button" value="판매사업자" onclick="location.href='${pageContext.request.contextPath}/seller/sjoin'">
	</div>
	<div id="form">
	<jsp:include page="${requestScope.form }"/>
	</div>
</div>





