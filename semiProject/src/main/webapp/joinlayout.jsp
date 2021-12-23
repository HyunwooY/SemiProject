<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
#main{padding-top: 80px;padding-bottom:80px}
#join{
	position:relative;
	margin:auto;
	color:white;
	width:500px
}
#join {height:auto;text-align:left}
#text{position:relative;margin-bottom:20px}
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





