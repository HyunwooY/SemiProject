<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>게시물 조회</h1>
<form id='action'>
<c:set var = "cp" value = "${pageContext.request.contextPath }"/>
	<table>
		<tr>
			<td width="20%" align="center"> 작성자 </td>
			<td> <input type='text' id='title' name='title' value='${vo.mi_id }' disabled></td>
		</tr>
		<tr>
			<td width="20%" align="center"> 제목 </td>
			<td> <input type='text' id='title' name='title' value='${vo.ih_title }' disabled></td>
		</tr>
		<tr>
			<td width="20%" align="center"> 내용 </td>
			<td>
				<textarea rows="20" cols="60" id='content' name='content' disabled>${vo.ih_question}</textarea>
			</td>
		</tr>
		<tr id="modBtn" style='display:none;'>
	    	<td colspan="2"   align="center" >
	    	<form action="${pageContext.request.contextPath }/inquiryList">
	        <input type=button id='mod' value="수정 완료" >
	        <a href="${pageContext.request.contextPath }/inquiryList">inquiryList.jsp</a>
	        </form>
         	<input type=button id='back' value="취소">
	   		</td>   
 		</tr>

</body>
</html>