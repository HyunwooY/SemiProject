<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	int num = Integer.parseInt(request.getParameter("num"));
	Inquiry_historyDao dao = new Inquiry_historyDao();
	Inquiry_historyVo vo = dao.select(num);
	if(vo == null){
		alert("해당 게시물은 없거나 삭제되었습니다.");
	}
</script>
<h1>내 문의 내역</h1>
<form>
</form>
<table width="600">
	<tr>
		<th>상품번호</th><th>문의제목</th><th>문의내용</th><th>답변</th>
	</tr>
		<tr>
			<td>${vo.ih_num }</td>
			<td>${vo.mi_id }</td>
			<td>${vo.ih_title }</td>
			<td>${vo.ih_question }</td>
			<td>${vo.ih_answer }</td>
		</tr>
</table>
<a href="myInquiryHistory.jsp">전체 내역 보기</a>