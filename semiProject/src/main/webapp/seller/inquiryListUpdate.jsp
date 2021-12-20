<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>문의수정</h1>
<form method="post" action="<%=request.getContextPath() %>/update">
	작성자<br>
	<input type="text" name="writer" value="${requestScope.vo.mi_id }"><br>
	글내용<br>
	<input type="text" name="context" value="${vo.ih_question }"><br>
	글제목<br>
	<input type="text" name="title"  value="${vo.ih_title }"><br>
	<input type="submit" value="저장">
</form>
</body>
</html>