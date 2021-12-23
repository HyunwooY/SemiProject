<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<form action="${pageContext.request.contextPath }/seller/ProductUpdate" enctype="multipart/form-data" method="get">
		상품명<br>
		<input type="text" name="pi_name"><br>
		상품번호<br>
		<input type="text" name="pi_num" value="${requestScope.vo.pi_num }" readonly="readonly"><br>
		가격<br>
		<input type="text" name="pi_price" value="${vo.pi_price }"><br>
		분류<br>
		<input type="text" name="pi_category" value="${vo.pi_category }" readonly="readonly"><br>	
		이미지<br>	
		<input type="file" name="pp_title" value="${pageContext.request.contextPath }/upload/${vo.pp_title }">	
		
		상세 정보<br>
		<label>
			<input type="checkbox" name="pd_size" value="S">S
		</LABEL>
		<label>
			<input type="checkbox" name="pd_size" value="M">M
		</label>
		<label>
			<input type="checkbox" name="pd_size" value="L">L
		</label>
		<label>
			<input type="checkbox" name="pd_size" value="XL">XL
		</label>
		<label>
			<input type="checkbox" name="pd_size" value="free">Free<br>
		</label>
		
		
		<label for="pd_color" id="red">
			<input type="checkbox" name="pd_color" value="RED">레드
		</label>
		<label>
			<input type="checkbox" name="pd_color" value="YELLOW">옐로우
		</label>
		<label>
			<input type="checkbox" name="pd_color" value="BLUE">블루
		</label>
		<label>
			<input type="checkbox" name="pd_color" value="GREEN">그린
		</label>
		<label>			
			<input type="checkbox" name="pd_color" value="GRAY">그레이
		</label>
		<label>
			<input type="checkbox" name="pd_color" value="BLACK">블랙<br>
		</label>		
	</form>



<!-- 		재고수<br> -->
<!-- 		<input type="text" name="pd_count"><br><br> -->
		

<!-- 		태그<br> -->
<!-- 		<input type="text" name="t_name" value="#" id="tp"><br> -->
		
<!-- 		<input type="submit" value="등록" onclick="return checkBox()"> -->
<!-- 		<input type="submit" value="취소" onclick="cansel()"><br> -->
		
		
		
<!-- 		상품번호<br> -->
<%-- 		<input type="text" name="pi_num" value="${requestScope.vo.pi_num }" readonly="readonly"><br> --%>
<!-- 		상품명<br> -->
<%-- 		<input type="text" name="pi_name" value="${vo.pi_name }"><br> --%>
<!-- 		상품가격<br> -->
<%-- 		<input type="text" name="pi_price" value="${vo.pi_price }"><br> --%>
<!-- 		분류<br> -->
<%-- 		<input type="text" name="pi_category" value="${vo.pi_category }" readonly="readonly"><br> --%>
		
<%-- 		<c:forEach var="list" items="${list.pd_size }">	 --%>
<!-- 			사이즈<br> -->
<%-- 			<input type="text" name="pd_size" value="${list.pd_size }"><br> --%>
<!-- 			색상<br> -->
<%-- 			<input type="text" name="pd_color" value="${list.pd_color }"><br> --%>
<%-- 		</c:forEach> --%>
		
<!-- 		재고<br> -->
<%-- 		<input type="text" name="pd_count" value="${vo.pd_count }"><br> --%>
<!-- 		상품등록일<br> -->
<%-- 		<input type="text" name="pi_regdate" value="${vo.pi_date }" readonly="readonly"><br> --%>
<!-- 		이미지<br> -->
<%-- 		<input type="file" name="pp_title" value="${pageContext.request.contextPath }/upload/${vo.pp_title }">		 --%>
	
	 
<!-- 	 <input type="submit" value="수정"> -->
<!-- 	<input type="submit" value="취소" onclick="cansel()"> -->
	
	
<script>
	function cansel(){
		location.href="${pageContext.request.contextPath}/seller/productList";
	}
</script>