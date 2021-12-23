<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	#mypagediv{margin: auto; }
	#mypagediv2{margin: 10px; padding-top: 30px; padding-left: 20px;}
	#mypageform th{padding-top: 15px; padding-bottom: 10px;}
	h2{margin-bottom: 20px;}
	.mpinput{width: 300px; height: 23px;}
	.mypagebtn{position: relative; left:170px; top: 50px; margin-right: 30px; width: 60px; height: 30px; }
</style>
<script>
	window.onload = function(){
		if(${requestScope.result=='success'}){
			alert("회원정보가 수정 되었습니다.");
		}
	} 
</script>
<div id="mypagediv">
	<h2 style="padding-left: 200px;">내 정보</h2>
	<div id="mypagediv2">
	<form method="post" action="<%=request.getContextPath() %>/member/modify" id="form2">
		<table id="mypageform">
			<tr>
				<th>
					<label for="id" id="id" class="mypagelabel">아이디</label>
				</th>
				<td>
					<input type="text" name="id" value="${sessionScope.id }" readonly="readonly" disabled="disabled" class="mpinput">
				</td>
			</tr>
			<tr>
				<th>
					<label for="pwd" id="pwd" class="mypagelabel">비밀번호</label>
				</th>
				<td>
					<input type="password" name="pwd" value="${vo.pwd }"  placeholder=" 비밀번호" class="mpinput">
				</td>
			</tr>
			<tr>
				<th>
					<label for="name" id="name" class="mypagelabel">이름</label>
				</th>
				<td>
					<input type="text" name="name" value="${vo.name}" placeholder=" 이름" class="mpinput">
				</td>
			</tr>
			<tr>
				<th>
					<label for="phone" id="phone" class="mypagelabel">휴대폰번호</label>
				</th>
				<td>
					<input type="text" name="phone"  value="${vo.phone}" placeholder=" -없이 입력해 주세요" class="mpinput">
				</td>
			</tr>	
			<tr>
				<th>
					<label for="email" id="email" class="mypagelabel">이메일</label>
				</th>
				<td>
					<input type="text" name="email"  value="${vo.email}" placeholder=" 이메일" class="mpinput">
				</td>
			</tr>	
			<tr>
				<th>
					<br><br><br><h3>기본 배송지 정보</h3>
				</th>
			</tr>
			<tr>
				<th>
					<label for="saname" id="saname" class="mypagelabel">수령인</label>
				</th>
				<td>
					<input type="text" name="saname"  value="${addrvo.name}" placeholder=" 수령인"  readonly="readonly" class="mpinput">
				</td>
			</tr>	
			<tr>
				<th>
					<label for="saphone" id="saphone" class="mypagelabel">휴대폰번호</label>
				</th>
				<td>
					<input type="text" name="saphone"  value="${addrvo.phone}" placeholder=" 휴대폰번호"  readonly="readonly" class="mpinput">
				</td>
			</tr>	
			<tr>
				<th>
					<label for="saaddr" id="saaddr" class="mypagelabel">주소</label>
				</th>
				<td>
					<input type="text" name="saaddr"  value="${addrvo.addr}" placeholder=" 주소"  readonly="readonly" class="mpinput">
				</td>
			</tr>	
		</table>
		<input type="submit" value="수정" class="mypagebtn"><input type="reset" value="취소" class="mypagebtn"> 
	</form>
	</div>
</div>