<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	#puchaseResult{width:80%;text-align:center;margin:auto;}
	#thanksMsg{text-align:center;position:relative;top:200px}
	#imgthanks{position:relative;text-align:center;width:300px;height:250px;left:33%}
	#tomain{margin:auto;border-radius:20px;width:150px;height:30px;font-size:1.1em}
</style>
<div id="purchaseResult">
	<div id="imgthanks"><img src="${pageContext.request.contextPath }/images/purchasesuccess.png"></div>
	<div id="thanksMsg">
		<h3>고객님의 주문이 완료되었습니다.</h3>
		<p>고객님의 주문/결제가 정상적으로 완료되었습니다.</p>
		<p>결제 및 배송상황을 확인하시려면 <a href="${pageContext.request.contextPath }/member/showorder">주문내용보기</a>를 클릭해주세요.</p>
		<p>이용해주셔서 감사합니다</p>
		<p>상품에 대한 문의는 제품페이지 혹은 마이페이지의 문의등록에서 가능합니다.</p>
		<input type="button" value="메인페이지로" id="tomain" onclick="location.href='${pageContext.request.contextPath}/layout'">
	</div>
</div>