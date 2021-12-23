<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
  table {
    width: 900px;
    height: 360px;
    margin-left: auto;
    margin-right: auto;
  }
</style>
<h1 style="text-align:center">공지사항작성</h1>
<script>
    function backToList() {
        location.href = "${pageContext.request.contextPath }/seller/notice";
    }
</script>
<form name="notice" method="post" action="${pageContext.request.contextPath }/seller/notice1">
    <table align="center">
        <tr>
            <td align="right">
                <br>글내용:&nbsp;</td>
                <td>
                    <textarea name="content" rows="10" cols="106" maxlength="4000"></textarea>
                </td>
            </tr>
            <tr>
                <td align="right"></td>
                <td>
                    <input type="submit" value="등록"/>
                    <input type="button" value="취소" onClick="backToList()"/>
                </td>
            </tr>
        </table>
    </form>