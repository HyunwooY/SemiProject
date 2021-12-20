<%@page import="chaneloper.vo.Search_ProductVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="chaneloper.vo.Inquiry_historyVo"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
#maindiv {position: relative; padding:50px}
#mainimg{width:400px; height:500px; border:1px solid red; float:left;margin-top:21px ; width: 40%;margin-left:50px; margin-right:50px;margin-bottom:200px;}
#maintable{float: right; width: 40%;margin-left:50px;margin-right:50px;text-align: left;margin-bottom:20px;}
#pubutton{float: right; width: 40%;text-align: left; margin-right:50px}
#showimg{}
</style>


<script type="text/javascript">
	let select_color = '';
	let select_size = '';
	let size_length = 0;
	function get_size(e){
		e.preventDefault();
		
		let xhr = new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4&&xhr.status==200){
				let text=xhr.responseText;
				let data=JSON.parse(text);
				var size_tag = document.getElementById("size");
				
				if(document.getElementsByName("size_name")){
					for(let i = size_length-1 ;i >= 0; i--){
						size_tag.removeChild(document.getElementsByClassName("size_name")[i]);
					}
				}
				for(let i = 0 ;i < data.length; i++){
					
					if(data[i].count=="매진"){
						let newA=document.createElement("span");
						newA.innerHTML="품절 ";
						newA.className="size_name"

						size_tag.appendChild(newA);
					}else{
						let newA=document.createElement("a");
						newA.innerHTML=data[i].size+" ";
						newA.href="#";
						newA.className="size_name";
						newA.onclick=list;

						size_tag.appendChild(newA);
					}
				}
				select_color = e.target.innerText;
				console.log(data.length);
				size_length = data.length;

			}
		}
		xhr.open('get','${pageContext.request.contextPath}/search/staticsearch?get_color='+e.target.innerText+'&pi_num=${pi_num}',true);
		xhr.send();
	}
	
	
	function list(e){
		let showtable = document.getElementById("showtable");

		
		if(showtable.children.length>1){
			for(var i=1;i<showtable.children.length;i++){
				if(showtable.children[i].children[0].children[1].innerHTML=="( "+select_color+" "+e.target.innerHTML+")"){
					alert("이미 선택된 상품입니다");
					return 0;
				}
			}
		}

		let td_name = document.createElement("td");
		let pd_name = document.createElement("span");
		let pd_color = document.createElement("span");
		pd_name.innerHTML = '${name}';
		pd_color.innerHTML = "( "+select_color+" "+e.target.innerHTML+")";
		
		td_name.appendChild(pd_name);
		td_name.appendChild(pd_color);
		
		let pd_count = document.createElement("span");
		pd_count.innerHTML = 1;
		let td_count = document.createElement("td");
		td_count.appendChild(pd_count);
		
		let pd_up = document.createElement("input");
		let pd_down = document.createElement("input");
		let side_span = document.createElement("span");
		pd_up.type="button"
		pd_up.value="+1";
		pd_up.onclick=pl;
		side_span.innerHTML="<br>"
		pd_down.type="button"
		pd_down.value="-1";
		pd_down.onclick=mi;
		let td_updown = document.createElement("td");
		td_updown.appendChild(pd_up);
		td_updown.appendChild(side_span);
		td_updown.appendChild(pd_down);
		
		let pd_delete = document.createElement("input");
		pd_delete.type="button";
		pd_delete.value="삭제";
		pd_delete.onclick=deltr;
		let pd_result = document.createElement("span");
		pd_result.innerHTML='${price}';
		let pd_result2 = document.createElement("span");
		pd_result2.innerHTML='원';
		let td_delete = document.createElement("td");
		td_delete.appendChild(pd_result);
		td_delete.appendChild(pd_result2);
		td_delete.appendChild(pd_delete);
		
		
		let tr_total = document.createElement("tr");
		tr_total.appendChild(td_name);
		tr_total.appendChild(td_count);
		tr_total.appendChild(td_updown);
		tr_total.appendChild(td_delete);
		showtable.appendChild(tr_total);
	}
	
	function pl(e){
		let a = Number(e.target.parentElement.parentElement.childNodes[1].childNodes[0].innerHTML);
		e.target.parentElement.parentElement.childNodes[1].childNodes[0].innerHTML=a+1;
		let b = Number(e.target.parentElement.parentElement.childNodes[3].childNodes[0].innerHTML);
		e.target.parentElement.parentElement.childNodes[3].childNodes[0].innerHTML=b+Number('${price}');
	}
	
	function mi(e){
		let a = Number(e.target.parentElement.parentElement.childNodes[1].childNodes[0].innerHTML);
		let b = Number(e.target.parentElement.parentElement.childNodes[3].childNodes[0].innerHTML);
		if(a>1){
			e.target.parentElement.parentElement.childNodes[1].childNodes[0].innerHTML=a-1;
			e.target.parentElement.parentElement.childNodes[3].childNodes[0].innerHTML=b-Number('${price}');
		}else{
			alert("최소 주문 수량입니다.");
		}
	}
	
	function deltr(e){
		let showtable = document.getElementById("showtable");
		showtable.removeChild(e.target.parentElement.parentElement);
	}
	
	function postdata(e){
		
        var form = document.createElement("form");
        form.setAttribute("charset", "UTF-8");
        form.setAttribute("method", "get");  //Post 방식
        form.setAttribute("action", "${pageContext.request.contextPath}/member/buyProduct"); //요청 보낼 주소
		
        let len = showtable.childElementCount;
        
        var hiddenField = document.createElement("input");
        hiddenField.setAttribute("type", "hidden");
        hiddenField.setAttribute("name", "count");
        hiddenField.setAttribute("value", len-1);
        form.appendChild(hiddenField);
        
        hiddenField = document.createElement("input");
        hiddenField.setAttribute("type", "hidden");
        hiddenField.setAttribute("name", "pi_num");
        hiddenField.setAttribute("value", "${pi_num}");
        form.appendChild(hiddenField);
        
        hiddenField = document.createElement("input");
        hiddenField.setAttribute("type", "hidden");
        hiddenField.setAttribute("name", "check");
        hiddenField.setAttribute("value", "${pi_num}");
        form.appendChild(hiddenField);
        
		for(var i = 2; i <= len ; i++){
	        var hiddenField = document.createElement("input");
	        hiddenField.setAttribute("type", "hidden");
	        hiddenField.setAttribute("name", "name"+(i-1));
	        console.log("name"+(i-1));
	        let va = showtable.childNodes[i].childNodes[0].childNodes[1].innerHTML+" "+showtable.childNodes[i].childNodes[1].childNodes[0].innerHTML;
	        hiddenField.setAttribute("value", va);
	        form.appendChild(hiddenField);
		}
      	document.body.appendChild(form);
      	console.log(document.getElementsByName("name1")[0].value);
        form.submit();
	}
	
	function postdata2(e){
		
        var form = document.createElement("form");
        form.setAttribute("charset", "UTF-8");
        form.setAttribute("method", "get");  //Post 방식
        form.setAttribute("action", "${pageContext.request.contextPath}/member/gocart"); //요청 보낼 주소
		
        let len = showtable.childElementCount;
        
        var hiddenField = document.createElement("input");
        hiddenField.setAttribute("type", "hidden");
        hiddenField.setAttribute("name", "count");
        hiddenField.setAttribute("value", len-1);
        form.appendChild(hiddenField);
        
        hiddenField = document.createElement("input");
        hiddenField.setAttribute("type", "hidden");
        hiddenField.setAttribute("name", "pi_num");
        hiddenField.setAttribute("value", "${pi_num}");
        form.appendChild(hiddenField);
        
        hiddenField = document.createElement("input");
        hiddenField.setAttribute("type", "hidden");
        hiddenField.setAttribute("name", "check");
        hiddenField.setAttribute("value", "${pi_num}");
        form.appendChild(hiddenField);
        
		for(var i = 2; i <= len ; i++){
	        var hiddenField = document.createElement("input");
	        hiddenField.setAttribute("type", "hidden");
	        hiddenField.setAttribute("name", "name"+(i-1));
	        console.log("name"+(i-1));
	        let va = showtable.childNodes[i].childNodes[0].childNodes[1].innerHTML+" "+showtable.childNodes[i].childNodes[1].childNodes[0].innerHTML;
	        hiddenField.setAttribute("value", va);
	        form.appendChild(hiddenField);
		}
      	document.body.appendChild(form);
      	console.log(document.getElementsByName("name1")[0].value);
        form.submit();
	}
	
	/*테스트 스크립트*/
	function testscript(){
		let xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
				let data=xhr.responseText;
				let json=JSON.parse(data);
				if(json.checkcart==true){
					alert('장바구니에 추가되었습니다.');
				}else{
					alert('오류가 발생하였습니다..');
				}
			}
		}
		let len11 = document.getElementById("showtable").childElementCount-1;
		let param='';
		for(var i = 2; i <= len11+1 ; i++){
	        let va = showtable.childNodes[i].childNodes[0].childNodes[1].innerHTML+" "+showtable.childNodes[i].childNodes[1].childNodes[0].innerHTML;
			param+="&name"+(i-1)+'='+va;
		}
		xhr.open('get','${pageContext.request.contextPath}/member/gocart?count='+len11+'&pi_num='+${pi_num}+param,true);
		xhr.send();
	}
	function goods1(){
		let xhr = new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4&&xhr.status==200){
				let xml=xhr.responseXML;
				let code=xml.getElementsByTagName("find1")[0].textContent;
				if(code=='success'){
					alert("찜목록에 추가 되었습니다.");
				}else{
					alert("찜목록에 제거 되었습니다.");
				}
			}
		}
		xhr.open('get','${pageContext.request.contextPath}/search/interest?pi_num=${requestScope.pi_num }&mi_id=${sessionScope.id}',true);
		xhr.send();
	}

	
</script>

<div id="maindiv">
	<div id="mainimg">
		<img src="images/"+ ${img[0]}>
	</div>
	<div id="maintable">
	    <table id="showtable" >
			<th colspan=4>${name}</th>
			<tr>
			    <td colspan=4><br>
				    가격 :  ${price}원<br>
				    적립금 :  ${Math.round(price*0.01)}원
			    </td>
			</tr>
			<tr>
			    <td colspan=4><br>
				    사이즈 정보<br>
				    M - 어깨 50 / 가슴 44 / 팔길이 63 / 총길이 82<br>
					L - 어깨 52 / 가슴 46 / 팔길이 65 / 총길이 84
				</td>
			</tr>
			<tr>
				<td colspan=4><br><br>
					*실측 사이즈는 단면(cm)으로 측정되며, 측정 방법에 따라 1~3cm 오차가 발생할 수 있습니다.<br>
					*컬러의 경우 촬영 환경에 따라 다소 차이가 있을 수 있습니다.<br><br>
				</td>
			</tr>
			<tr>

				<td colspan=4>
<%  
	ArrayList<String> color = (ArrayList<String>)request.getAttribute("color");
	for(int i =0 ;i<color.size();i++){
%>
					<a href="#" onclick="get_size(event)"><%=color.get(i) %></a>

<%		
	}
%>
<br>
				</td>
			</tr>
			<tr><br>
				<td colspan=4; id="size">
				</td>
			</tr>
	    </table>
	</div>
	<div id="pubutton">
	    <table >
	    	<tr>
	    		<td>
	    			<a href="#" onclick="postdata(event)">구매하기</a>&nbsp;&nbsp;
	    		</td>

	    		<td>
	    			<a href="#" onclick="goods1()">찜하기</a>&nbsp;&nbsp;
	    		</td>

	    		<td>
	    			<a href="#" onclick="testscript()">장바구니 담기</a>&nbsp;&nbsp;
	    		</td>
	    	</tr>
	    </table>
		<div id="showimg">
<c:forEach var="i" begin="0" end="2">
			<img src="images/"+ ${img[i]} class="showimg" width=40% height=400px border="1px solid red">
</c:forEach>
	    </div>
	</div>
</div>

<script type="text/javascript">
	function inqck(e){
		alert(e.target.parentElement.parentElement.parentElement.innerHTML);
	}

</script>

<c:set var="cp" value="${pageContext.request.contextPath }"/>

<div>
	<div>
		<table border="1" width="500">
			<tr>
				<th>글번호</th>
				<th>작성자</th>
				<th>제목</th>
			</tr>
				<c:forEach var="vo" items="${list }">
					<tr>
						<td>${vo.ih_num }</td>
						<td>${vo.mi_id }</td>
						<td><a href="#" onclick="inqck(event)">${vo.ih_title }</a></td>
					</tr>
					<tr style="display:;">
						<td>문의</td>
						<td>${vo.ih_question }</td>
						<td>
						<input type="button" value="삭제" onclick="">
						<input type="button" value="수정" onclick="">
						</td>
					</tr>
					<tr style="display:;">
						<td>답변</td>
						<td colspan=2>${vo.ih_answer }</td>
					</tr>
						
	
				</c:forEach>
		</table>
		<a href="#">문의하기</a>
	</div>
	
	<div><!-- 페이징처리 -->
		<c:forEach var="i" begin="${startPage }" end="${endPage}">
			<c:choose>
				<c:when test="${i==pageNum }">
					<a href="${cp }/search/searchdetail?pageNum=${i}">
						<span style="color:red">${i }</span>
					</a>
				</c:when>
				<c:otherwise>
					<a href="${cp }/search/searchdetail?pageNum=${i}">
						<span style="gray">${i }</span>
					</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
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