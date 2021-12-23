<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
  table {
    width: 900px;
    height: 260px;
    margin-left: auto;
    margin-right: auto;
  }
</style>
<br>
<h1>문의 조회</h1>
<br>
<form id='action'>
<c:set var = "cp" value = "${pageContext.request.contextPath }"/>
	<table>
	<div>
		<tr>
			<td width="-30%" align="center"> 작성자 </td>
			<td> <input type='text' id='title' name='title' value='${vo.mi_id }' disabled></td>
		</tr>
		<tr>
			<td width="-30%" align="center"> 제목 </td>
			<td> <input type='text' id='title' name='title' value='${vo.ih_title }' disabled></td>
		</tr>
	</div>
		<tr>
			<td width="-30%" align="center"> 내용 </td>
			<td>
				<textarea rows="20" cols="60" id='content' name='content' disabled>${vo.ih_question}</textarea>
			</td>
		</tr>
		</table>
		<br>
		<td>
			-답변:${vo.ih_answer }
		</td>
	</form>
	<br>
	<br>
	<form method="get" action="${pageContext.request.contextPath }/seller/inquiryreply">
	<input type="hidden" name="ih_num" value="${vo.ih_num}">
		<c:if test="${sessionScope.radio=='판매사업자' }">
		<input type="submit" value="글쓰기">
			</c:if>
			</form>
		