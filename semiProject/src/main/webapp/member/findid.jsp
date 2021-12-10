<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<form method="post" action="${pageContext.request.contextPath }/id/find" id="form">
	<div>
		<div>
			<h1>아이디 찾기</h1>
			<h5>아이디는 가입시 입력하신 이름과 이메일을 통해 찾을 수 있습니다.</h5>
			<div>
			   	<input type="text" name="name" placeholder="이름" id="name">
			</div>
		</div>	
	</div>
	<div>
		<div>
			<div>
				<input type="text" name="email" placeholder="이메일" id="email">
			</div>
		</div>	
	</div>
	<div>
		<div>
			<input type="button" value="찾기" id="btn">
		</div>
	</div>
</form>
