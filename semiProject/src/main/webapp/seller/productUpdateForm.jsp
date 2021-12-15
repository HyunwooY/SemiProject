<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정</title>
</head>
<body>
	<h1>상품 정보 수정</h1>
	<form action="${pageContext.request.contextPath }/seller/update" enctype="multipart/form-data">
		상품번호<br>
		<input type="text" name="pi_num" value="${requestScope.vo.pi_num }" readonly="readonly"><br>
		상품명<br>
		<input type="text" name="pi_name"><br>
		상품가격<br>
		<input type="text" name="pi_price"><br>
		분류<br>
		<input type="text" name="pi_category"><br>
		사이즈<br>
		<input type="text" name="pd_size"><br>
		색상<br>
		<input type="text" name="pd_color"><br>
		재고<br>
		<input type="text" name="pd_count"><br>
		상품등록일<br>
		<input type="text" name="pi_regdate"><br>
		이미지<br>
		<input type="file" name="file"><br><br>
		<input type="submit" value="수정">
	</form>
	
	<!-- 취소버튼 위치가 수정 옆에 위치해야 함 -->
	<form action="${pageContext.request.contextPath }/layout.jsp">
		<input type="submit" value="취소">
	</form>
</body>
</html>