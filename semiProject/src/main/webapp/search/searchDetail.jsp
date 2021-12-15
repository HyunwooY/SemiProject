<%@page import="chaneloper.vo.Search_ProductVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="chaneloper.vo.Inquiry_historyVo"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
						<input type="button" value="<%=color.get(i) %>" >
<%		
	}
%>
				</td>
			</tr>

	    </table>
	</div>
</div>

<<<<<<< HEAD

=======
<script type="text/javascript">
	fucntion get_size(e){
		let xhr = new XHLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4&&xhr.status==200){
				let data=JSON.parse(xhr.responseText);
				for(var i = 0; i < data.length ; i++){
					console.log(data[i]);
				}
				
			}
		}
		xhr.open('get',"/search/staticsearch?get_color="+e.target.value,true);
		xhr.send();
	}
</script>
>>>>>>> branch 'master' of https://github.com/HyunwooY/SemiProject.git

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