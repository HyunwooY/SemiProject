<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
	<form method="post" action="${pageContext.request.contextPath }">
	<input type="hidden" name="id" value="">
		<table>
			<tr>
				<th width="100px">
					<label for="ph_num">상품번호</label>
				</th>
				<td>	
					<input type="text" name="ph_num" id="ph_num">
				</td>
			</tr>
			<tr>
				<th>
					<label for="title">제목</label>
				</th>
				<td>
					<input type="text" name="title" id="tite">
				</td>
			</tr>
			<tr>
				<th>
					<label for="r_photo">사진</label>
				</th>
				<td>	
					<input type="text" name="r_photo" id="r_photo">
				</td>
			</tr>
			<tr>
				<th>
					<label for="content">내용</label>
				</th>
				<td>
					<textarea rows="5" cols="50" name="content"></textarea>
				</td>
			</tr>
			<tr>
				<th>
					<label for="r_hit">별점</label>
				</th>
				<td>	
					<input type="text" name="r_hit" id="r_hit">
				</td>
			</tr>
			<tr>
		</table>
		<input type="submit" value="등록" class="rvbtn"><input type="reset" value="취소" class="rvfbtn">
		</form>
</div>
