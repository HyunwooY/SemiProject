<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>

</style>
<script>
	if(vo == null){
		alert("해당 게시물은 없거나 삭제되었습니다.");
	}
</script>
<table width="1000" border="1" style="text-align: center; margin: auto; margin-bottom: 30px;">
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
<a href="${pageContext.request.contextPath }/mypage/history" style="padding-left: 440px;">전체 내역 보기</a>
