<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<script>
		function home(){			
			confirm("등록을 취소하시겠습니까?");
		}
	</script>

	<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/seller/insert">
		<input type="hidden" name="pi_num" value="${param.pi_num }"/><br>		
		<input type="hidden" name="si_id" value="${param.si_id }"/><br>		
		상품명<br>
		<input type="text" name="pi_name"><br>
		가격<br>
		<input type="text" name="pi_price"><br>	
		분류<br>
		<input type="text" name="pi_category"><br>	
		태그명<br>
		<input type="text" name="t_name" value="#"><br>
		이미지<br>	
		<input type="file" name="pp_title"><br>
	
		<input type="submit" value="등록">
		<input type="submit" value="취소" onclick="home()"><br>
	</form>
