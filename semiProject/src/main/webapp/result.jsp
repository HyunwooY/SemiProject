<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	h1{position:relative;margin:auto;top:10px;margin-bottom:5px}
</style>
<c:choose>
	<c:when test="${requestScope.joincode=='fail' || requestScope.joincode==null}">
		<div>
		<h1>회원가입중 오류가 발생했습니다.</h1>
		</div>
	</c:when>
	<c:when test="${requestScope.joincode=='success }">
		<div>
		<h1>CHANELOPER의 가족이 되신것을 환영합니다!</h1>
		</div>
	</c:when>
	<c:when test="">
	</c:when>
</c:choose>

<script>
	

</script>






