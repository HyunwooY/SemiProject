<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<script type="text/javascript">
	var select="default";	
	var type="";
	function input(){
		let addr=document.getElementsByClassName("input")[0];
		addr.style.display="block";
		let myAddr=document.getElementById("myAddr");
		myAddr.style.display="none";
		let selected=document.getElementById("changeAddr");
		selected.style.display="none";
		let addrList=document.getElementById("addrList");
		addrList.style.display="none"
		select="input";
		console.log(select);
	}
	function changeDefault(){
		let addr=document.getElementsByClassName("input")[0]
		addr.style.display="none";
		let myAddr=document.getElementById("myAddr");
		myAddr.style.display="block";
		let selected=document.getElementById("changeAddr");
		selected.style.display="none";
		let addrList=document.getElementById("addrList");
		addrList.style.display="none"
		select="default";
		console.log(select);
	}
	function selectList(){
		let addrList=document.getElementById("addrList");
		addrList.style.display="inline"
		select="addrList";
		console.log(select);
	}
	function go(){
		let form = document.createElement('form');
		form.setAttribute('method','post');
		form.setAttribute('action','${pageContext.request.contextPath}/member/buyProduct');
		document.charset="utf-8";
		/*input생성*/
		let hiddenField1=document.createElement('input');
		hiddenField1.setAttribute('type','hidden');
		hiddenField1.setAttribute('name','type');
		hiddenField1.setAttribute('value',type);
		console.log('type:'+type)
		
		form.appendChild(hiddenField1);
		if(select=="input"){
			let hiddenField2=document.createElement('input');
			hiddenField2.setAttribute('type','hidden');
			hiddenField2.setAttribute('name','name');
			hiddenField2.setAttribute('value',document.getElementById("name").value);
			
			form.appendChild(hiddenField2);
			
			let hiddenField3=document.createElement('input');
			hiddenField3.setAttribute('type','hidden');
			hiddenField3.setAttribute('name','addr');
			hiddenField3.setAttribute('value',document.getElementById("addr").value);
			form.appendChild(hiddenField3);
			
			let hiddenField4=document.createElement('input');
			hiddenField4.setAttribute('type','hidden');
			hiddenField4.setAttribute('name','phone');
			let first=document.getElementById("first");
			hiddenField4.setAttribute('value',first.options[first.selectedIndex].text+'-'+document.getElementById("mid").value+
										'-'+document.getElementById("last").value);
			form.appendChild(hiddenField4);
			
		}else if(select=='default'){
			let hiddenField2=document.createElement('input');
			hiddenField2.setAttribute('type','hidden');
			hiddenField2.setAttribute('name','name');
			hiddenField2.setAttribute('value','${avo.name}');
			form.appendChild(hiddenField2);

			let hiddenField3=document.createElement('input');
			hiddenField3.setAttribute('type','hidden');
			hiddenField3.setAttribute('name','addr');
			hiddenField3.setAttribute('value','${avo.addr}');
			form.appendChild(hiddenField3);

			let hiddenField4=document.createElement('input');
			hiddenField4.setAttribute('type','hidden');
			hiddenField4.setAttribute('name','phone');
			hiddenField4.setAttribute('value','${avo.phone}');			
			form.appendChild(hiddenField4);

		}else if(select=='addrList'){
			let addrselect=document.getElementsByClassName("selected");
			
			let hiddenField2=document.createElement('input');
			hiddenField2.setAttribute('type','hidden');
			hiddenField2.setAttribute('name','name');
			hiddenField2.setAttribute('value',addrselect[0].innerText);
			form.appendChild(hiddenField2);

			
			let hiddenField3=document.createElement('input');
			hiddenField3.setAttribute('type','hidden');
			hiddenField3.setAttribute('name','addr');
			hiddenField3.setAttribute('value',addrselect[1].innerText);
			form.appendChild(hiddenField3);

			let hiddenField4=document.createElement('input');
			hiddenField4.setAttribute('type','hidden');
			hiddenField4.setAttribute('name','phone');
			hiddenField4.setAttribute('value',addrselect[2].innerText);
			form.appendChild(hiddenField4);

		}
		document.body.appendChild(form);
		form.submit();
	}
	function changeAddr(selected){
		xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
				let data=xhr.responseText;
				let json=JSON.parse(data);
				let addr=document.getElementsByClassName("input")[0]
				addr.style.display="none"
				let myAddr=document.getElementById("myAddr")
				myAddr.style.display="none"
				let selected=document.getElementById("changeAddr");
				selected.style.display="block"
				let addrselect=document.getElementsByClassName("selected");
				addrselect[0].innerHTML=json.name;
				addrselect[1].innerHTML=json.addr;
				addrselect[2].innerHTML=json.phone;
			}
		}
		xhr.open('get', '${pageContext.request.contextPath}/member/selectAddr?selected='+selected, true);
		xhr.send();
	}
	function card(){
		type='신용카드';
	}
	function cash(){
		type='무통장입금';
	}
</script>
<style>
#purchase{position:relative;top:50px;left:100px;width:80%;height:1000px;margin:0px;padding:0px;text-align:left;margin:auto}

table{width:800px;position:relative;top:10px;}
table {margin:0px;padding:0px}
th, tr{padding-left:0px;padding-right:0px}
.div{margin-bottom:20px}
#takeinfo #h3{display:inline-block}
#takeinfo #btn{height:25px;position:relative;top:-2px;left:10px}
.input{display:none;}
.imgs{width:140px;height:190px}
#changeAddr{display:none;}
#addrList{display:none}
</style>    
<div id="purchase">
	<div id="buyinfo" class="div">
		<h3>구매자정보</h3>
		<table>
			<tr>
				<th width="200px">이름</th>
				<td>${vo.name }</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>${vo.email }</td>
			</tr>
			<tr>
				<th>휴대폰 번호</th>
				<td>${vo.phone }</td>
			</tr>
		</table>
	</div>
	<div id="takeinfo" class="div">
		<h3 id="h3">받는사람정보</h3><br>
		<label for="default">기본배송지</label>
		<input type="radio" name="selectAddr" id="default" checked="checked" onclick="changeDefault()">
		<label for="selectList">배송지선택</label>
		<input type="radio" name="selectAddr" id="selectList" onclick="selectList()">
		<select name="addrList" id="addrList" onchange="changeAddr(this.options[this.selectedIndex].text)">
			<c:forEach var="addr" items="${addr }">
				<option value="${addr.nickname }">${addr.nickname }</option>
			</c:forEach>
		</select>
		<label for="input">직접입력</label>
		<input type="radio" name="selectAddr" id="input" onclick="input()">
		<table class="input">
			<tr>
				<th width="200px">이름</th>
				<td><input type="text" name="name" id="name"></td>
			</tr>
			<tr>
				<th>배송주소</th>
				<td><input type="text" name="addr" id="addr"></td>
			</tr>
			<tr>
				<th>연락처</th>
				<td>
					<select name="first" id="first">
						<option>010</option>
						<option>011</option>
					</select><span>-</span>
					<input type="text" name="mid" id="mid"><span>-</span>
					<input type="text" name="last" id="last">
				</td>
			</tr>
		</table>
		<table id="myAddr">
			<tr>
				<th width="200px">이름</th>
				<td>${avo.name }</td>
			</tr>
			<tr>
				<th>배송주소</th>
				<td>${avo.addr}</td>
			</tr>
			<tr>
				<th>연락처</th>
				<td>${avo.phone}</td>
			</tr>
		</table>
		<table id="changeAddr">
			<tr>
				<th width="200px">이름</th>
				<td class="selected"></td>
			</tr>
			<tr>
				<th>배송주소</th>
				<td class="selected"></td>
			</tr>
			<tr>
				<th>연락처</th>
				<td class="selected"></td>
			</tr>
		</table>
	</div>
	<div id="payinfo" class="div">
		<h3>상품정보</h3>
		<table>
			<c:forEach var="vo" items="${list}">
				<c:if test="${vo.si_name!=siname}">
					<c:set var="siname" value="${vo.si_name }"/>
					<tr>
						<th colspan="4">${siname }</th>
					</tr>
					<tr>
						<th>사진</th>
						<th>상품명</th>
						<th>색상</th>
						<th>사이즈</th>
						<th>구매수량</th>
						<th>가격</th>
					</tr>
				</c:if>
					<tr>
						<td width="140px"><img src="${pageContext.request.contextPath}/upload/${vo.pp_title}" class="imgs"></td>
						<td>${vo.pi_name }</td>
						<td>${vo.pd_color }</td>
						<td>${vo.pd_size }</td>		
						<td>${vo.purchase_count}</td>
						<td>${vo.pi_price * vo.purchase_count}</td>
					</tr>
			</c:forEach>
		</table>
	</div>
	<div id="purchaseType">
		<label for="creditcard">신용카드</label>
		<input type="radio" name="type" value="신용카드" id="creditcard" onclick="card()">
		<label for="cash">무통장입금</label>
		<input type="radio" name="type" value="무통장입금" id="cash" onclick="cash()">
	</div>
	<div>
		<input type="button" value="결제하기" onclick="go()">
	</div>
</div>








