<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
	h1{
		position:relative;
		left: 40px;
		bottom: 30px;
		margin: auto;
	}
	table{
		position:relative;
		left: 45px;
		bottom: 30px;
		margin-top: 20px;
	}
	
</style>
<script>
	if(vo == null){
		alert("해당 게시물은 없거나 삭제되었습니다.");
	}
</script>
<h1>내 문의 내역</h1>
<form>
</form>
<table width="600">
	<tr>
		<th>상품 번호</th><th>문의 제목</th><th>문의 내용</th><th>답변</th>
	</tr>
		<tr>
			<td>${vo.pi_num }</td>
			<td>${vo.ih_title}</td>
			<td>${vo.ih_question }</td>
			<c:choose>
				<c:when test="${vo.ih_answer==null }">
					<td>아직 답변이 없습니다.</td>
				</c:when>
				<c:otherwise>
					<td>${vo.ih_answer }</td>
				</c:otherwise>
			</c:choose>
		</tr>
</table>
<a href="${pageContext.request.contextPath }/mypage/history">전체 내역 보기</a>
