<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
#update{
  	left:50px
  }
</style>
<br>
<div name="update">
<h1>상품 등록</h1>
<br>
	<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/seller/insert">	
		상품명<br>
		<input type="text" name="pi_name"><br>
		가격<br>
		<input type="text" name="pi_price"><br>			
		이미지<br>	
		<input type="file" name="pp_title"><br><br><br>
		
		
		상세 정보<br>
		<label>
			<input type="checkbox" name="pi_category" value="상의" onclick='checkOnlyOne(this)'/>상의
		</label>
		<label>
			<input type="checkbox" name="pi_category" value="하의" onclick='checkOnlyOne(this)'/>하의
		</label>
		<label>
			<input type="checkbox" name="pi_category" value="원피스" onclick="checkOnlyOne(this)"/>원피스
		</label>
		<label>
			<input type="checkbox" name="pi_category" value="아우터" onclick="checkOnlyOne(this)"/>아우터
		</label>
		<label>
			<input type="checkbox" name="pi_category" value="악세사리" onclick="checkOnlyOne(this)"/>악세사리
		</label>
		<br>
		
		<script>
			function checkOnlyOne(target){
				document.querySelectorAll('input[type=checkbox]').forEach(el => el.checked = false);
				
				target.checked = true;
			}
		</script>
		
		
		
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
		<br>
		
		<label>
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

		재고수<br>
		<input type="text" name="pd_count"><br><br>
		

		태그<br>
		<input type="text" name="t_name" value="#" id="tp"><br><br>
		
		<input type="submit" value="등록" onclick="return checkBox()">
		<input type="submit" value="취소" onclick="cansel()"><br>
	</form>
	</div>
	
	<script>
		function cansel(){
			location.href="${pageContext.request.contextPath}/seller/sellerpage.jsp"
		}
	</script>
