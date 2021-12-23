<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<form action="${pageContext.request.contextPath }/seller/productUpdate" enctype="multipart/form-data" method="post">
		상품번호<br>
		<input type="text" name="pi_num" value="${requestScope.vo.pi_num }" readonly="readonly"><br>
		상품명<br>
		<input type="text" name="pi_name" value="${vo.pi_name }"><br>
		상품가격<br>
		<input type="text" name="pi_price" value="${vo.pi_price }"><br>
		분류<br>
		<input type="text" name="pi_category" value="${vo.pi_category }" readonly="readonly"><br>
		
		<c:forEach var="list" items="${list.pd_size }">	
			사이즈<br>
			<input type="text" name="pd_size" value="${list.pd_size }"><br>
			색상<br>
			<input type="text" name="pd_color" value="${list.pd_color }"><br>
		</c:forEach>
		
		재고<br>
		<input type="text" name="pd_count" value="${vo.pd_count }"><br>
		상품등록일<br>
		<input type="text" name="pi_regdate" value="${vo.pi_regdate }" readonly="readonly"><br>
		이미지<br>
		<input type="file" name="pp_title"><br><br>		
	</form>
	 
	 <input type="submit" value="수정">
	<input type="submit" value="취소" onclick="cansel()">
<script>
	function cansel(){
		location.href="${pageContext.request.contextPath}/seller/productList.jsp";
	}
</script>