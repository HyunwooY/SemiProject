<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1 style="text-align:center">공지사항작성</h1>
<form name="notice" method="post" action="${pageContext.request.contextPath }/seller/notice1">
<table align="center">
<tr>
<td align="right">작성자:&nbsp;</td>
<td><input type="text" size="5" value="관리자" disabled/></td>
</tr>
<tr>
<td align="right" valign="top"><br>글내용:&nbsp;</td>
<td><textarea name="content" rows="10" cols="65" maxlength="4000"></textarea></td>
</tr>
<tr>
<td align="right"></td>
<td>
<input type=submit value="등록"/>
<input type=button value="취소" onClick="backToList(this.form)"/>
</td>
</tr>
</table>
</form>