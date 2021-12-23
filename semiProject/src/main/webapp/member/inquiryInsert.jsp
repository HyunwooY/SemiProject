<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<script>
	window.onload = function(){
		if(${requestScope.code=='success'}){
			alert("문의가 등록되었습니다.");
		}else if(${requestScope.code=='fail'}){
			alert("문의 등록 실패");
		}
}        
</script>
<style>
	#inquiryinsert{width: 1000px; margin: auto;}
	#inquiryform{margin: 10px; margin: auto; left: 250px;}
	#inform th{padding-top: 10px; padding-bottom: 10px; text-align: center;}
	.iqyinput{width: 200px; height: 22px;}
	.fbtn{position: relative; left: 120px; margin-top:20px; margin-right: 20px; width: 50px; height: 25px; border-radius: 10px;}
</style>
<div id="inquiryinsert">
	<div id="inquiryform"> 
	<c:choose>
	<c:when test="${pd_num==null }">
		<form method="post" action="${pageContext.request.contextPath }/mypage/insertinquiry">
			<table id="inform">
				<tr>
					<th width="100px">
						<label for="id">작성자</label>
					</th>
					<td>
						<input type="text" name="id" id="id" disabled="disabled" value="${sessionScope.id }" class="iqyinput">
					</td>
				</tr>
				<tr>
					<th>
						<label for="title">제목</label>
					</th>
					<td>
						<select name="title" size="1" id="title" class="iqyinput">
							<option>::분류 선택::</option>
							<option value="상품">상품문의</option>
							<option value="배송">배송문의</option>
							<option value="교환반품">교환/반품문의</option>
							<option value="입금결제">입금/결제문의</option>
							<option value="배송전취소변경">배송전취소/변경문의</option>
							<option value="기타">기타</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>
						<label for="pi_num">상품번호</label>
					</th>
					<td>
						<input type="text" name="pi_num" id="pi_num" class="iqyinput" >
					</td>
				</tr>
				<tr>
					<th>
						<label for="content">내용</label>
					</th>
					<td>
						<textarea rows="5" cols="50" name="content" style="width: 400px; height: 200px;"></textarea>
					</td>
				</tr>
			</table>
			<input type="submit" value="등록" class="fbtn"><input type="reset" value="취소" class="fbtn">
		</form>
	</c:when>
	<c:otherwise>
		<form method="post" action="${pageContext.request.contextPath }/mypage/insertinquiry">
		<table id="inform">
			<tr>
				<th width="100px">
					<h2 style="position:relative; left: 120px; bottom: 30px; margin: auto;">문의하기</h2>
				</th>
			</tr>
			<tr>
				<th width="100px">
					<label for="id">작성자</label>
				</th>
				<td>
					<input type="text" name="id" id="id" disabled="disabled" value="${sessionScope.id }" class="iqyinput">
				</td>
			</tr>
			<tr>
				<th>
					<label for="title">제목</label>
				</th>
				<td>
					<select name="title" size="1" id="title" class="iqyinput">
						<option>::분류 선택::</option>
						<option value="상품">상품문의</option>
						<option value="배송">배송문의</option>
						<option value="교환반품">교환/반품문의</option>
						<option value="입금결제">입금/결제문의</option>
						<option value="배송전취소변경">배송전취소/변경문의</option>
						<option value="기타">기타</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>
					<label for="pi_num">상품번호</label>
				</th>
				<td>
					<input type="text" name="pi_num" id="pi_num" class="iqyinput" value="${pi_num }">
				</td>
			</tr>
			<tr>
				<th>
					<label for="content">내용</label>
				</th>
				<td>
					<textarea rows="5" cols="50" name="content" style="width: 400px; height: 200px;">주문번호:${ph_num }</textarea>
				</td>
			</tr>
		</table>
		<input type="submit" value="등록" class="fbtn"><input type="reset" value="취소" class="fbtn">
	</form>
	</c:otherwise>
	</c:choose>
	</div>
</div>
