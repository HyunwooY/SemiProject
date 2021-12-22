<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>게시물 조회</h1>
<form id='action'>
<c:set var = "cp" value = "${pageContext.request.contextPath }"/>
	<table>
		<tr>
			<td width="20%" align="center"> 글번호 </td>
			<td> <input type='text' id='title' name='title' value='${vo.ih_num }' disabled></td>
		</tr>
		<tr>
			<td width="20%" align="center"> 작성자 </td>
			<td> <input type='text' id='title' name='title' value='${vo.mi_id }' disabled></td>
		</tr>
		<tr>
			<td width="20%" align="center"> 제목 </td>
			<td>
				<textarea rows="20" cols="60" id='content' name='content' disabled>${vo.ih_title}</textarea>
			</td>
		</tr>
		<tr>
			<td width="20%" align="center"> 내용 </td> 
			<td><input type='text' id='id' name='id' value='${vo.ih_question }' disabled></td> 
		</tr>
		<tr id="modBtn" style='display:none;'>
	    	<td colspan="2"   align="center" >
	    	<form action="${pageContext.request.contextPath }/inquiryList">
	        <input type=button id='mod' value="수정 완료" >
	        <a href="${pageContext.request.contextPath }/inquiryList">inquiryList.jsp</a>
	        </form>
         	<input type=button id='back' value="취소">
	   		</td>   
 		</tr>
		<tr id="btn">
			<td colspan="2" align="center">
			<input type='button' id='modify' value='수정'>
			<input type='button' id='remove' value='삭제'> 
			<input type='button' id='list' value='목록'></td> 
		</tr>
	</table>
	
	<input type='hidden' id='bno' name='bno' value='${post.bno }'>
	</form>
	
<script>
	window.onload = () => {
		const remove = document.getElementById('remove')
		const list = document.getElementById('list')
		const rePost = document.getElementById('rePost')
		const modify = document.getElementById('modify')
		const actionForm = document.getElementById('action')
		
		console.log(remove)
		console.log(list)
		console.log(rePost)

		//목록으로
		list.addEventListener("click", () => {
			location.replace('/seller/inquiryList.jsp')
		})
		
		//수정 버튼 이벤트
		modify.addEventListener("click", ()=>{
			document.getElementById('title').disabled=false
			document.getElementById('content').disabled=false
			document.getElementById("modBtn").style.display="block"
			document.getElementById('btn').style.display="none"
			
		})
		
		//수정 완료
		document.getElementById('mod').addEventListener("click", () => {
			actionForm.action = '/board/modify'
			actionForm.method = 'post'
			actionForm.submit();
		})
		
		//수정 취소
		document.getElementById('back').addEventListener("click", () => {
			document.getElementById('btn').style.display="block"
			document.getElementById("modBtn").style.display="none";
			document.getElementById('content').disabled=true
			document.getElementById('title').disabled=true
		})
		
		//삭제
		remove.addEventListener("click", () => {
			if(!confirm("삭제하겠습니까?")) { return; }
			else{
				actionForm.action = '/board/remove'
				actionForm.method = 'post'
				actionForm.submit()
			}
		}) 
	}
</script>
</body>
</html>