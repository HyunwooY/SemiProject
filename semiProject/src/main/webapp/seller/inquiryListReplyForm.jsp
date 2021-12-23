<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1 style="text-align:center">답변작성</h1>
<form name="inquiryreply" method="post" action="${pageContext.request.contextPath }/seller/inquiryreply">
<table align="center">
<tr>
<td align="right" valign="top"><br>내용:&nbsp;</td>
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
