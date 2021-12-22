<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


	<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/seller/insert">	
		상품명<br>
		<input type="text" name="pi_name"><br>
		가격<br>
		<input type="text" name="pi_price"><br>	
		분류<br>
		<input type="text" name="pi_category"><br>			
		이미지<br>	
		<input type="file" name="pp_title"><br><br><br>
		
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
<!-- 		분류<br> -->
<!-- 		<select> -->
<!-- 			<option>상의</option> -->
<!-- 			<option>하의</option> -->
<!-- 			<option>원피스</option> -->
<!-- 			<option>아우터</option> -->
<!-- 			<option>악세서리</option> -->
<!-- 			<option> -->
<!-- 		</select><br><br><br> -->
		재고수<br>
		<input type="text" name="pd_count"><br><br>
		

		태그<br>
		<input type="text" name="t_name" value="#" id="tp"><br>
		
		<input type="submit" value="등록" onclick="return checkBox()">
		<input type="submit" value="취소" onclick="home()"><br>
	</form>
