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
<h1 style="text-align:center">답변작성</h1>
<c:set var = "cp" value = "${pageContext.request.contextPath }"/>
<form name="inquiryreply" method="post" action="${pageContext.request.contextPath }/seller/inquiryreply">
<input type="hidden" name="ih_num" value="${vo.ih_num }">
<table align="center">
	<tr>
		<td align="right" valign="top"><br></td>
		<td><textarea name="answer" rows="10" cols="65" maxlength="4000"></textarea></td>
	</tr>
	<tr>
		<td align="right"></td>
		<td>
		<input type=submit value="등록"/>
		</td>
	</tr>
</table>
</form>
