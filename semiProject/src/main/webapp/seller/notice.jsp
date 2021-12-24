<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
  table {
    width: 900px;
    height: 260px;
    margin-left: auto;
    margin-right: auto;
  }
</style>
<br>
<c:set var="cp" value="${pageContext.request.contextPath }"/>
<h1 style="text-align:center">공지사항</h1>
<<<<<<< HEAD
=======
<br>
>>>>>>> branch 'master' of https://github.com/HyunwooY/SemiProject.git
<table>
    <tr>
        <th>작성번호</th>
        <th>내용</th>
    </tr>
    <tr>
        <c:forEach var="vo" items="${list }">
            <tr>
                <td>${vo.n_num }</td>
                <td>${vo.n_context}</td>
                <c:if test="${sessionScope.radio=='판매사업자' }">
                    <td>
                        <a href="${pageContext.request.contextPath }/noticedelete?n_num=${vo.n_num }">삭제</a>
                    </td>
                </c:if>
            </tr>
        </c:forEach>
        <hr></table>
        <form name="notice" method="get" action="${pageContext.request.contextPath }/seller/notice1">
            <c:if test="${sessionScope.radio=='판매사업자' }">
                <input type="submit" value="글쓰기"></c:if>
            </form>
