<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <form action = "${pageContext.request.contextPath }/seller/detail">    	
    	<input type="text" name="pi_num" value="${param.pi_num }"/><br>
    	사이즈<br>
    	<input type="text" name="pd_size"><br>
    	색상<br>
    	<input type="text" name="pd_color"><br>
    	재고수<br>
    	<input type="text" name="pd_count"><br>
    	
    	<input type="submit" value="등록">
    	<input type="submit" value="취소" onclick="">
    </form>