<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="buyinfo">
	<h3>구매자정보</h3>
	<table>
		<tr>
			<th>이름</th>
			<td>${requestScope.membervo.mi_name }</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${requestScope.membervo.mi_email }</td>
		</tr>
		<tr>
			<th>휴대폰 번호</th>
			<td>${requestScope.membervo.mi_phone }</td>
		</tr>
	</table>
</div>
<div id="takeinfo">
	<h3>받는사람정보</h3><input type="button" value="배송지 변경"><br>
	<table>
		<tr>
			<th>이름</th>
			<td>a</td>
		</tr>
		<tr>
			<th>배송주소</th>
			<td>a</td>
		</tr>
		<tr>
			<th>연락처</th>
			<td>a</td>
		</tr>
	</table>
</div>
<div id="payinfo">
	<h3>결제정보</h3>
	<table>
		<tr>
			<th colspan="4"><!-- 판매자 정보 -->a</th>
		</tr>
		<tr>
			<td><!-- 사진 -->a</td>
			<td><!-- 상품명 -->a</td>
			<td><!-- 수량 -->a</td>
			<td><!-- 총수량 -->a</td>
		</tr>
	</table>
</div>









