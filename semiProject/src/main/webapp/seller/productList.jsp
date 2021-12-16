<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매자 상품 목록</title>
<script type="text/javascript">
	function delProduct(){
		let xhr = new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
				let xml = xhr.responseXML;
				let code = xml.getElementsByTagName("productcode")[0].textContent;
				if(productcode=="success"){
					alert("삭제되었습니다.");
				} else{
					alert("삭제 실패!");
				}
			}
		}
	}
</script>
</head>
<body>
	<div id="productlist"></div>
	<c:forEach var="productList" items="${requestScope.productList }">
		<img src="../upload/${productList.pp_title }">
		<th>${productList.pi_name }
		<th>${productList.pi_num }
		<th>${productList.pd_size }
		<th>${productList.pd_color }
		<th>${productList.pd_count }
		<th>${productList.pi_price }원
	</c:forEach>
	<input type="button" value="수정">
	<input type="button" value="삭제" onclick="delProduct()">
	<hr>
</body>
</html>