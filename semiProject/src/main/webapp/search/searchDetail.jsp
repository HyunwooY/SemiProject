<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
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

#myform fieldset{
    display: inline-block; /* 하위 별점 이미지들이 있는 영역만 자리를 차지함.*/
    border: 0; /* 필드셋 테두리 제거 */
}
#myform input[type=radio]{
    display: none; /* 라디오박스 감춤 */
}
#myform label{
    font-size: 3em; /* 이모지 크기 */
    color: transparent; /* 기존 이모지 컬러 제거 */
    text-shadow: 0 0 0 #f0f0f0; /* 새 이모지 색상 부여 */
}
#myform label:hover{
    text-shadow: 0 0 0 #a00; /* 마우스 호버 */
}
#myform label:hover ~ label{
    text-shadow: 0 0 0 #a00; /* 마우스 호버 뒤에오는 이모지들 */
}

#myform fieldset{
    display: inline-block; /* 하위 별점 이미지들이 있는 영역만 자리를 차지함.*/
    direction: rtl; /* 이모지 순서 반전 */
    border: 0; /* 필드셋 테두리 제거 */
}
#myform fieldset legend{
    text-align: left;
}
#myform input[type=radio]:checked ~ label{
    text-shadow: 0 0 0 #a00; /* 마우스 클릭 체크 */
}
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
		let t_id = e.target.parentElement.parentElement.children[1].innerHTML
		let t_title = e.target.innerHTML;
		if(t_id=="${sessionScope.id}"){
			let p1 = document.getElementById("p1");
			let p2 = document.getElementById("p2");
			let p3 = document.getElementById("p3");
			let p3_a = document.getElementById("p3_a");
			let p3_q = document.getElementById("p3_q");
			let p3_t = document.getElementById("p3_t");
			
			let xhr = new XMLHttpRequest();
			xhr.onreadystatechange=function(){
				if(xhr.readyState==4&&xhr.status==200){
					let xml=xhr.responseXML;
					let ans=xml.getElementsByTagName("ans")[0].textContent;
					let que=xml.getElementsByTagName("que")[0].textContent;
					let tit=xml.getElementsByTagName("tit")[0].textContent;
					p3_q.value = que;
					p3_a.value = ans;
					p3_t.value = tit;
				}
			}
			xhr.open('get','${pageContext.request.contextPath}/search/inq?pi_num=${requestScope.pi_num }&mi_id=${sessionScope.id}&title='+e.target.innerHTML,true);
			xhr.send();
			
			p1.style.display="none";
			p2.style.display="none";
			p3.style.display="block";
		}else{
			alert("권한이 없습니다.");
		}
	}
	
	function c1(){
		let p1 = document.getElementById("p1");
		let p2 = document.getElementById("p2");
		let p3 = document.getElementById("p3");
		p1.style.display="block";
		p2.style.display="block";
		p3.style.display="none";
	}
	
	function c2(){
		let p1 = document.getElementById("p1");
		let p2 = document.getElementById("p2");
		let p3 = document.getElementById("p3");
		p1.style.display="block";
		p2.style.display="block";
		p3.style.display="none";
		let p3_t = document.getElementById("p3_t");
		window.location.href="${pageContext.request.contextPath}/search/inqdel?pi_num=${requestScope.pi_num }&mi_id=${sessionScope.id}&title="+p3_t.value;
		
	}
	
	function c3(){
		let p1 = document.getElementById("p1");
		let p2 = document.getElementById("p2");
		let p3 = document.getElementById("p3");
		p1.style.display="block";
		p2.style.display="block";
		p3.style.display="none";
		let p3_t = document.getElementById("p3_t");
		let p3_q = document.getElementById("p3_q");
		window.location.href="${pageContext.request.contextPath}/search/inqalt?pi_num=${requestScope.pi_num }&mi_id=${sessionScope.id}&title="+p3_t.value+"&qu="+p3_q.value;
	}
	
	function c4(){
		let p1 = document.getElementById("p1");
		let p2 = document.getElementById("p2");
		let p3 = document.getElementById("p3");
		let c1 = document.getElementById("c1");
		p1.style.display="none";
		p2.style.display="none";
		p3.style.display="block";
		c1.style.display="none";
		let p3_tr = document.getElementById("p3_tr");
		p3_tr.style.display="none";

		let p3_t = document.getElementById("p3_t");
		let p3_q = document.getElementById("p3_q");
		p3_t.value="";
		p3_q.value="";
		p3_t.readOnly=false;
		let c5 = document.getElementById("c5");
		c5.style.display="block";
	}
	
	function c5(){
		let p3_t = document.getElementById("p3_t");
		let p3_q = document.getElementById("p3_q");
		let p1 = document.getElementById("p1");
		let p2 = document.getElementById("p2");
		let p3 = document.getElementById("p3");
		p1.style.display="block";
		p2.style.display="block";
		p3.style.display="none";
		
		window.location.href="${pageContext.request.contextPath}//search/inqins?pi_num=${requestScope.pi_num }&mi_id=${sessionScope.id}&title="+p3_t.value+"&qu="+p3_q.value;
	}

</script>

<c:set var="cp" value="${pageContext.request.contextPath }"/>


<div id="p1">
	<table border="1" width="500">
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>제목</th>
		</tr >
			<c:forEach var="vo" items="${list }">
				<tr>
					<td>${vo.ih_num }</td>
					<td>${vo.mi_id }</td>
					<td><a href="#" onclick="inqck(event)">${vo.ih_title }</a></td>
				</tr>
			</c:forEach>
	</table>
</div>

<div id="p2"><!-- 페이징처리 -->
	<c:forEach var="i" begin="${startPage }" end="${endPage}">
		<c:choose>
			<c:when test="${i==pageNum }">
				<a href="${cp }/search/searchdetail?pageNum=${i}&pi_num=${pi_num}">
					<span style="color:red">${i }</span>
				</a>
			</c:when>
			<c:otherwise>
				<a href="${cp }/search/searchdetail?pageNum=${i}&pi_num=${pi_num}">
					<span style="gray">${i }</span>
				</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<input type="button" value="문의하기" onclick="c4()">
</div>

<div id="p3" style="display:none">
	<table>
		<tr>
			<td>제목</td>
			<td><input id="p3_t" type="text" name="title" readonly></td>
		</tr>
		<tr>
			<td>문의</td>
			<td ><input id="p3_q" type="text" name="question"></td>
		</tr>
		<tr id="p3_tr">
			<td>답변</td>
			<td ><input id="p3_a" type="text" name="answer" readonly></td>
		</tr>
		<tr>
			<td id="c1">
				<input type="button" value="목록" onclick="c1()">
				<input type="button" value="삭제" onclick="c2()">
				<input type="button" value="수정" onclick="c3()">
			</td>
			<td id="c5" style="display:none">
				<input type="button" value="등록" onclick="c5()">
			</td>
		</tr>
	</table>
</div>

<br><br><br><br><br><br><br><br><br><br><br><br>

<script>
	function addrv(){
		var rvtable = document.getElementById("rvtable");
		rvtable.style.display = "none";
		var input_lv = document.getElementById("input_lv");
		input_lv.style.display ="block";
	}

</script>

<div id="rvtable">
	<c:forEach var="vo" items="${list_rv }">
		<div>
			<span>${vo.getMI_ID() }</span> 
			<c:forEach var="i" begin="0" end="${vo.getR_HIT()-1 }">
			<span>★</span>
			</c:forEach>
			<span>${vo.getR_DATE() }</span> <a href="#">삭제</a><br>
			
			<span>${vo.getR_TITLE() }</span><br>
			<span>${vo.getR_CONTENT() }</span><br>
		</div>
		<c:forEach var="vo2" items="${list_pt}">
			<c:if test="${vo2.getR_num() eq vo.getR_NUM() }">
					<div>
						<img src="${vo2.getTitle() }">
					</div>
			</c:if>
		</c:forEach>
	</c:forEach>
	<div>
		<a href="#" onclick="addrv()">후기작성</a>
	</div>
</div>

<script>
	var adbt=0;
	function addbutton(){
		adbt = adbt+1;
		var inputfile= document.createElement("input");
		var inputspan= document.createElement("span");
		inputfile.type="file";
		inputfile.name="file"+adbt;
		inputspan.innerHTML ="<br>";
		let myform = document.getElementById("myform");
		let adimg = document.getElementsByName("adimg")[0];
		myform.insertBefore(inputfile,adimg);
		myform.insertBefore(inputspan,adimg);
		let adbt2 = document.getElementsByName("adbt")[0];
		adbt2.value=adbt;
	}
</script>

<% 
	Date date = new Date();
	SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
	String dates = transFormat.format(date);
	
%>
<div id="input_lv" style="display:none">
	<form name="myform" id="myform" action="${cp }/search/upload?pi_num=${pi_num}" method="post" enctype="multipart/form-data">
    <fieldset>
        <input type="radio" name="rating" value="5" id="rate1"><label for="rate1">⭐</label>
        <input type="radio" name="rating" value="4" id="rate2"><label for="rate2">⭐</label>
        <input type="radio" name="rating" value="3" id="rate3"><label for="rate3">⭐</label>
        <input type="radio" name="rating" value="2" id="rate4"><label for="rate4">⭐</label>
        <input type="radio" name="rating" value="1" id="rate5"><label for="rate5">⭐</label>
    </fieldset><br>
    	아이디 <input type="text" name="mi_id" value="${sessionScope.id}" readonly>
    	날짜 <input type="text" name="date" value=<%=dates %> readonly><br>
		제목 <input type="text" name="title"><br>
		내용 <input type="text" name="context"><br>
		<input type="hidden" value="0" name="adbt">
		<input type="file" name="file0"><br>
		<input type="button" value="이미지추가" onclick="addbutton()"  name="adimg"><br>
		
		<input type="submit" value="등록">
	</form>
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