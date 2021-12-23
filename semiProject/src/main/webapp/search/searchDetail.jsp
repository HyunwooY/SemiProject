<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="chaneloper.vo.Search_ProductVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="chaneloper.vo.Inquiry_historyVo"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
#maindiv {position: relative; padding:50px;}
#mainimg{position: relative; width:500px; height:600px;  float:left;margin-top:21px ; margin-left:150px; margin-right:50px;margin-bottom:80px; }
#mainimg img{width:100%;height:100%;}
#maintable{position: relative; float: right; width: 500px;margin-left:50px;margin-right:50px;text-align: left;margin-bottom:20px;margin-top:100px;}
#showtable img{width:10px;height:10px;}
#pubutton{position: relative; float: right; width: 40%;text-align: left;margin-left:10px;}
#showimg{position: relative; width:100%;  clear:both; margin-bottom:40px;margin-top:20px;padding-right:100px; border-top: 1px solid #444444}
#showimg img{width:900px; height:1200px;  background-size: contain; background-repeat: no-repeat; background-position: center;}
#anno{width:700px;  display:inline-block; margin-left:50px; margin-right:50px;margin-top:20px; margin-bottom:20px; text-align: left;}
#inqtable{ position: relative; width:49%; height:500px;  float: left; margin-top:20px; border-right: 1px solid black; padding-right: 15px;}
#inqt{width: 100%; border-collapse: collapse;}
#inqt .td{min-height:25px;border-bottom: 1px solid #444444;padding: 10px;}
#inqt .th{border-bottom: 1px solid #444444;padding: 10px;}
#rvttable{position: relative; width:49%; height:500px;  float: right;margin-top:20px;}
#rvdiv{width:300px; height:70px;text-align: left; position: relative; float: left; margin-b}
#rvimg{width:300px;height:70px; position: relative; float: left;}
#rvimg img{width:25%;height:100%; margin-right:13px;}
#sadann{position: absolute; right:400px; top:70px;}
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
<c:set var="cp" value="${pageContext.request.contextPath }"/>

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
		
		let pd_up = document.createElement("img");
		let pd_down = document.createElement("img");
		let side_span = document.createElement("span");
		pd_up.src="${pageContext.request.contextPath}/images/up.png"
		pd_up.onclick=pl;
		side_span.innerHTML="<br>"
		pd_down.src="${pageContext.request.contextPath}/images/down.png"
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

	function addrv(){
		var rvtable = document.getElementById("rvtable");
		rvtable.style.display = "none";
		var input_lv = document.getElementById("input_lv");
		input_lv.style.display ="block";
	}
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
<div id="maindiv">
<!-- 이미지 -->
	<div id="mainimg">
		<img src="${pageContext.request.contextPath}/upload/${img[0]}">
	</div>
<!-- 제품상세 -->
	<div id="maintable">
	    <table id="showtable" >
			<th colspan=3>${name}</th>
			<tr>
<<<<<<< HEAD
			    <td colspan=4><br>
				    가격 :  <fmt:formatNumber value="${price}" pattern="#,###"/>원<br>
				    적립금 :  <fmt:formatNumber value="${Math.round(price*0.01)}" pattern="#,###"/>원
=======
			    <td colspan=3>
				    가격 :  ${price}원
>>>>>>> branch 'master' of https://github.com/HyunwooY/SemiProject.git
			    </td>
			</tr>
			<tr>
			    <td colspan=3>
			     적립금 :  ${Math.round(price*0.01)}원
				</td>
			</tr>
			<tr>
				<td colspan=3>
				</td>
			</tr>
			<tr>

				<td colspan=3>
<%  
	ArrayList<String> color = (ArrayList<String>)request.getAttribute("color");
	for(int i =0 ;i<color.size();i++){
%>
					<a href="#" onclick="get_size(event)"><%=color.get(i) %></a>
<%		
	}
%>

				</td>
			</tr>
			<tr>
				<td colspan=3; id="size">
				</td>
			</tr>
	    </table>
	</div>
	<!-- 제품결제 -->
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
	</div>
	<div id="sadann">
		<span>별점:${score }</span>
		<span>조회수:${count }</span>
		<a href="#inqtable">문의/리뷰</a>
	</div>	

<!-- 상품이미지 출력 -->
	
	<div id="showimg">
			<c:forEach var="i" begin="0" end="${img.size()-1}">
						<img src="${pageContext.request.contextPath}/upload/${img[i]}">
			</c:forEach>
	 </div>
	 <hr/>
	<div id="anno">
		<h3>[교환 및 반품 안내]</h3><br>
		<span>단순 변심에 의한 교환 및 반품은 고객님께서 왕복 택배 요금을 부담해 주셔야 합니다.</span><br><br>
		<h3>[교환 및 반품 주소]</h3><br>
		<span>택배사 이용시 : 서울특별시 종로구 율곡로10길 105 디아망 4F(봉익동 10-1 디아망 4F)  </span><br><br>
		<h3>[교환 절차 안내]</h3><br>
		<h3>1. 교환 신청하기 </h3><br>
		<span>- 모든 교환 및 반품은 휴일포함 7일 이내 사이트내의 QnA 게시판을 통해 교환</span><br>
		<span>및 반품 의사를 밝혀주셔야 합니다.</span><br><br>
		<span>- 교환의 경우, 문의글 작성 시 교환을 원하시는 [색상]과 [사이즈]를 정확히 기입해주셔야</span><br>
		<span>보다 빠른 교환 처리가 가능합니다.</span><br><br>
		<span>- 여행 및 출장 등의 개인적인 사유로 인해 신청기간이 지날 경우 처리가 불가능한 점 양해부</span><br>
		<span>탁드립니다.</span><br><br>
		<h3>2. 교환할 제품 보내기 </h3><br>
		<span>- 불량 및 오배송을 제외한 모든 교환건의 택배 접수는 택배사 상관없이 '선불결제'를 통해 직</span><br>
		<span>접 접수해 주셔야 합니다.</span><br><br><br>
		<span>- 쇼핑몰에서는 택배기사님 직접 픽업신청 서비스를 제공하지 않고 있습니다.</span><br>
		<span>- 보내주신 제품은 평균 2~3일 이내 도착하며, 확인 후 교환제품 발송까지는 영업일 기준 최</span><br>
		<span>대 3-7일이 소요될 수 있습니다.</span><br><br>
		<h3>3. 교환완료 제품 수령하기 </h3><br>
		<span>- 교환 택배비 입금 확인이 되어야 교환 제품이 발송되오니 확인 부탁드립니다.</span><br><br>
		<h3>[반품 절차 안내]</h3><br>
		<h3>1. 반품 신청하기</h3><br>
		<span>- 모든 교환 및 반품은 휴일포함 7일 이내 사이트내 QnA게시판을 통해 교환 및</span><br>
		<span>반품 의사를 밝혀주셔야 합니다.</span><br><br>
		<span>- 반품원하실 경우, 문의글 작성 하실 때</span><br>
		<span>원하시는 반품 서비스 1. 부분 반품/전체 반품 여부 2. 부분 반품 시 반품을 원하시는 제품명을</span><br>
		<span>정확히 기입해주셔야 보다 빠른 반품 처리가 가능합니다.</span><br><br>
		<span>- 무통장입금 거래 고객님의 경우, 반품 시 환불받으실 [계좌번호][은행명][예금주명]을 같이</span><br>
		<span>기입해주셔야 확인 후 빠른 환불 처리가 가능합니다.</span><br><br>
		<span>- 여행 및 출장 등의 개인적인 사유로 인해 신청기간이 지날 경우 처리가 어렵습니다.</span><br><br>
		<h3>2. 반품할 제품 보내기</h3><br>
		<span>- 불량 및 오배송을 제외한 모든 반품건의 택배 접수는 '선불결제'를 통해 직접 접수해 주셔야</span><br>
		<span>합니다.</span><br><br>
		<span>- 쇼핑몰에서는 택배기사님 직접 픽업신청 서비스를 제공하지 않고 있습니다.</span><br><br>
		<span>- 보내주신 제품은 평균 2~3일 이내 도착합니다.</span><br><br>
		<h3>3. 금액 환불</h3><br>
		<span>- 반품 제품의 검품이 끝난 뒤에 실 결제 방식에 따라 환불을 도와드리고 있습니다.</span><br><br>
		<span>- 무통장 입금으로 결제를 하신 고객님들은 회원가입 시 혹은 반품 문의글 작성 시</span><br>
		<span>입력해 주신 계좌번호로 물품 도착 후 업무일 기준 1-2일 내로 환불금액을 입금해 드립니다.</span><br><br>
		<span>- 카드 결제를 하신 고객님들은 카드사를 통해 결제 취소가 이루어져,</span><br>
		<span> 전산상으로는 '환불 완료'라고 나타나도 금액 환불은 최대 3-7일 뒤에 완료될 수 있는 점 양해</span><br>
		<span>부탁드립니다.</span><br><br>
	</div>
	<hr/>
<!-- 문의 페이징 -->
	<div id="inqtable">
	<h2>문의사항</h2><br>
	 <hr/>
		<div id="p1">
			<table id="inqt">
				<tr>
					<th width="20%">글번호</th>
					<th width="20%">작성자</th>
					<th>제목</th>
				</tr >
					<c:forEach var="vo" items="${list }">
						<tr>
							<td height="38px">${vo.ih_num }</td>
							<td height="38px">${vo.mi_id }</td>
							<td height="38px"><a href="#" onclick="inqck(event)">${vo.ih_title }</a></td>
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
					<td><input id="p3_t" type="text" name="title" readonly size="80" style="height:30px"></td>
				</tr>
				<tr>
					<td>문의</td>
					<td ><input id="p3_q" type="textarea" name="question" size="80" style="height:250px"></td>
				</tr>
				<tr id="p3_tr">
					<td>답변</td>
					<td ><input id="p3_a" type="text" name="answer" readonly size="80" style="height:100px"></td>
				</tr>
				<tr>
					<td id="c1" >
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
	</div>


<!-- 리뷰 페이징 -->
	<div id="rvttable">
	<h2>리뷰</h2><br>
	 <hr/>
		<div id="rvtable">
			<c:forEach var="vo" items="${list_rv }">
				<div id="rvdiv">
					<span>${vo.getMI_ID() }</span> 
					<c:forEach var="i" begin="0" end="${vo.getR_HIT()-1 }">
					<span>★</span>
					</c:forEach>
					<span>${vo.getR_DATE() }</span> <a href="${cp }/search/reviewdel?r_num=${vo.getR_NUM()}&pi_num=${pi_num}">삭제</a><br>
					<span>${vo.getR_TITLE() }</span><br>
					<span>${vo.getR_CONTENT() }</span><br>
				</div>
				<div id="rvimg">
				<c:forEach var="vo2" items="${list_pt}">
					<c:if test="${vo2.getR_num() eq vo.getR_NUM() }">
						<img src="${pageContext.request.contextPath}/upload/${vo2.getTitle()}">
					</c:if>
				</c:forEach>
				</div>
			</c:forEach>
			<div style="position: absolute; right: 0px; bottom: 50px;">
				<a href="#" onclick="addrv()">후기작성</a>
			</div>
		</div>
	
	
	
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
	</div>
</div>





