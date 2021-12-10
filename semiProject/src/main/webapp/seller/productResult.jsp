<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록 결과</title>
</head>
<body>
	<c:when test="${requestScope.productCode=='success' }">
		<div id="productResult">
			<p>등록을 완료했습니다.
			<a href = "${pageContext.request.ContextPath }/layout">메인페이지</a>
		</div>	
	</c:when>
	<c:when test="${requestScope.productCode=='fail' || requestScope.productCode=='null' }">
		<div id="productResult">
			<p>등록에 실패했습니다.
			<a href="${pageContext.request.ContextPath }/layout">메인페이지</a>
		</div>
	</c:when>
</body>
</html>