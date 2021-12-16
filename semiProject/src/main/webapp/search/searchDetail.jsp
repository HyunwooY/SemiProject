<%@page import="chaneloper.vo.Search_ProductVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="chaneloper.vo.Inquiry_historyVo"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	let select_color = '';
	let select_size = '';
	let size_length = 0;
	function get_size(e){
		e.preventDefault();
		select_color = e.target.innerText;
		let xhr = new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4&&xhr.status==200){
				let text=xhr.responseText;
				let data=JSON.parse(text);
				var size_tag = document.getElementById("size");
				
				if(!!document.getElementsByName("size_name")){
					for(let i = size_length-1 ;i >= 0; i--){
						size_tag.removeChild(document.getElementsByClassName("size_name")[i]);
					}
				}
				for(let i = 0 ;i < data.length; i++){
					
					if(data[i].count=="매진"){
						let newA=document.createElement("span");
						newA.innerHTML="품절";
						newA.className="size_name"
						size_tag.appendChild(newA);
					}else{
						let newA=document.createElement("a");
						newA.innerHTML=data[i].size;
						newA.href="#";
						newA.className="size_name"
						newA.onclick="list(event)"
						size_tag.appendChild(newA);
					}
					
					
				}
				console.log(data.length);
				size_length = data.length;
			}
		}
		xhr.open('get','../search/staticsearch?get_color='+e.target.innerText,true);
		xhr.send();
	}
	
	
	function list(e){
		select_size = e.target.innerHTML;
		
	}
	
</script>

<div>
	<div>
		<img src="images/"+ ${img[0]} alt="Image1">
	</div>
	<div>
	    <table >
			<th>${name}</th>
			<tr>
			    <td><br><br>
				    가격 :  ${price}원<br>
				    적립금 :  ${Math.round(price*0.01)}원
			    </td>
			</tr>
			<tr>
			    <td><br><br>
				    사이즈 정보<br>
				    M - 어깨 50 / 가슴 44 / 팔길이 63 / 총길이 82<br>
					L - 어깨 52 / 가슴 46 / 팔길이 65 / 총길이 84
				</td>
			</tr>
			<tr>
				<td><br><br>
					*실측 사이즈는 단면(cm)으로 측정되며, 측정 방법에 따라 1~3cm 오차가 발생할 수 있습니다.<br>
					*컬러의 경우 촬영 환경에 따라 다소 차이가 있을 수 있습니다.
				</td>
			</tr>
			<tr>

				<td>색상 : 
<%  
	ArrayList<String> color = (ArrayList<String>)request.getAttribute("color");
	for(int i =0 ;i<color.size();i++){
%>
						<a href="#" onclick="get_size(event)" ><%=color.get(i) %></a>

<%		
	}
%>
				</td>
			</tr>
			<tr>
				<td id="size">
					
				</td>
			</tr>
			<tr>
				<td>
					<span></span>
				</td>
			</tr>

	    </table>
	</div>
</div>




<!-- 이미지 -->
<!-- 제품명 -->
<!-- 가격 -->

<!-- 색상(클릭) -->

<!-- 선택한 색상의 사이즈 카운트가 없으면 매진 -->
<!-- 사이즈(클릭) -->

<!-- 구매버튼 -->
<!-- 찜하기 -->
<!-- 장바구니 추가 -->

<!-- 상품이미지 출력 -->

<!-- 안내 문구 -->

<!-- 리뷰 페이징 -->

<!-- 문의 페이징 -->