<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
    table, th, td {
    border: 1px solid #bcbcbc;
  }
  table {
    width: 400px;
    height: 200px;
    margin-left: auto;
    margin-right: auto;
  }
</style>

<c:set var="cp" value="${pageContext.request.contextPath }"/>
<!-- <h1>공지 사항</h1> -->
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
