<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	.mpinput{width: 300px; height: 23px;}
	.mypagebtn{position: relative; left:200px; top: 40px; margin-right: 30px; width: 70px; height: 30px; }
	#deleteMember{float:right;position:relative;top:330px;font-size:0.8em}
</style>
<script>
	window.onload = function(){
		if(${requestScope.result=='success'}){
			alert("회원정보가 수정 되었습니다.");
		}
	}  
	function deletemember(){
		if(confirm("정말 회원탈퇴 하시겠습니까?")){
			location.href="${pageContext.request.contextPath}/member/checkpwd?delete=true";
		}else{
			alert("감사합니다. 앞으로도 저희 CHANELOPER를 많이 이용해주세요!");
		}
	}
</script>
<div id="mypagediv">
	<div id="mypagediv2">
		<div id="deleteMember">
			<a href="javascript:deletemember()">회원탈퇴</a>
		</div>
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
					<br><br><h3>기본 배송지 정보</h3>
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