<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<style>
.btn1,.btn2,.btn3,.btn4{margin-right:-8px;}
.btn2,.btn3,.btn4,.btn5{border-top-left:-5px;border-bottom-left:-5px}
#start,#end{height:18px;position:relative;top:-2px}
#table{width:1000px;position:relative;top:10px;text-align:center;
		border-top:2px solid black;border-bottom:2px solid black;
		border-collapse:collapse;}
#table {margin:0px;padding:0px}
th, tr{padding-left:0px;padding-right:0px;}
th, td{padding-top:5px;padding-bottom:5px}
.img{width:140px;height:180px}

</style>
<script>

</script>
<div>
	<form method="get" action="${pageContext.request.contextPath }/member/showorder">
		<input type="button" value="오늘" onclick="set(0)" class="btn1">
		<input type="button" value="1주일" onclick="setweek(7)" class="btn2">
		<input type="button" value="1개월" onclick="set(1)" class="btn3">
		<input type="button" value="3개월" onclick="set(3)" class="btn4">
		<input type="button" value="6개월" onclick="set(6)" class="btn5">	
		<input type="date" name="start" id="start" value="${requestScope.start }">
		<input type="date" name="end" id="end" value="${requestScope.end }">
		<input type="submit" value="조회">
	</form>
</div>
<div id="orderboard">
	<table id="table">
		<tr>
			<th width="120px">주문일자</th>
			<th width="400px">상품정보</th>
			<th width="50px">수량</th>
			<th width="120px">상품구매금액</th>
			<th width="140px">주문상태</th>
			<th width="170px">취소/교환/반품</th>
		</tr>
		<c:forEach var="vo" items="${requestScope.phList}" varStatus="status">
			<tr>
				<td>${vo.ph_regdate }</td>
				<c:choose>
					<c:when test="${vo.ph_count -1>0}">
						<td><a href="javascript:titleclick(${status.count+1},${vo.ph_num })" class="titlea">${vo.pi_name } 외 ${vo.ph_count -1}건</a></td>
					</c:when>
					<c:otherwise>
						<td><a href="javascript:titleclick(${status.count+1},${vo.ph_num })" class="titlea">${vo.pi_name }</a></td>
					</c:otherwise>
				</c:choose>
				<td>${vo.ph_count }</td>
				<td>${vo.priceAll }</td>
				<td>${vo.ph_state }</td>
				<td>
				<c:choose>
					<c:when test="${vo.ph_state=='결제전' || vo.ph_state=='결제완료'}">
					<a href="">취소</a>
					</c:when>
					<c:when test="${vo.ph_state=='배송완료'||vo.ph_state=='배송준비중'||vo.ph_state=='배송중'}">
					<a href="">교환</a>/<a href="">반품</a>
					</c:when>
				</c:choose>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>

<script>
	
	function set(change){
		let date=new Date();
		document.getElementById("start").value=new Date(date.setMonth(date.getMonth()-change)).toISOString().substring(0, 10);
		document.getElementById("end").value=new Date().toISOString().substring(0, 10);
	}
	function setweek(change){
		let date=new Date();
		document.getElementById("start").value=new Date(date.setDate(date.getDate()-change)).toISOString().substring(0, 10);
		document.getElementById("end").value=new Date().toISOString().substring(0, 10);
	}
	function titleclick(count,ph_num){
		
		let table=document.getElementById("table");
		let newRow1=table.insertRow(count);
		newRow1.className='row1';

		console.log(count)
		let newhCell1=newRow1.insertCell(0);
		newhCell1.colSpan="6";
		newhCell1.style.borderBottom="1px solid black";
		newhCell1.style.borderTop="2px solid black";
		let newhCell2=newRow1.insertCell(1);
		newhCell2.style.borderBottom="1px solid black";
		newhCell2.style.borderTop="2px solid black";
		let newhCell3=newRow1.insertCell(2);
		newhCell3.style.borderBottom="1px solid black";
		newhCell3.style.borderTop="2px solid black";
		let newhCell4=newRow1.insertCell(3);
		newhCell4.style.borderBottom="1px solid black";
		newhCell4.style.borderTop="2px solid black";
		let newhCell5=newRow1.insertCell(4);
		newhCell5.style.borderBottom="1px solid black";
		newhCell5.style.borderTop="2px solid black";
		let newhCell6=newRow1.insertCell(5);
		newhCell6.style.borderBottom="1px solid black";
		newhCell6.style.borderTop="2px solid black";

		newhCell1.innerHTML='세부정보';
		
		let newRow3=table.insertRow(count+1);
		newRow3.className='row1';
		
		let newhCell7=newRow3.insertCell(0);
		newhCell7.style.borderBottom="2px solid black";
		let newhCell8=newRow3.insertCell(1);
		newhCell8.style.borderBottom="2px solid black";
		let newhCell9=newRow3.insertCell(2);
		newhCell9.style.borderBottom="2px solid black";
		newhCell9.colSpan="2";
		let newhCell10=newRow3.insertCell(3);
		newhCell10.style.borderBottom="2px solid black";
		newhCell10.colSpan="2";
		
		newhCell7.innerHTML='상품사진';
		newhCell8.innerHTML='상품명';
		newhCell9.innerHTML='수량';
		newhCell10.innerHTML='판매금액';
		
		
		let xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
				let data=xhr.responseText;
				let list=JSON.parse(data);
				let titlea=document.getElementsByClassName("titlea");
				titlea[count-2].href='javascript:gosmall('+list.length+','+count+','+ph_num+')';
				for(let i=0;i<list.length;i++){
					if(i!=(list.length-1)){
						let newRow2=table.insertRow(count+i+2);
						newRow2.className='row1';
						
						let newdCell1=newRow2.insertCell(0);
						newdCell1.style.width="140px";
						let newdCell2=newRow2.insertCell(1);
						let newdCell3=newRow2.insertCell(2);
						newdCell3.colSpan="2";
						let newdCell4=newRow2.insertCell(3);
						newdCell4.colSpan="2";
						/*let newdCell5=newRow2.insertCell(4);
						newdCell5.colSpan="2";*/
						
						newdCell1.innerHTML='<img src="${pageContext.request.contextPath}/upload/'+list[i].pp_title+'" class="img">';
						newdCell2.innerHTML=list[i].pi_name;
						newdCell3.innerHTML=list[i].pd_count;
						newdCell4.innerHTML=list[i].pi_price;
					}else{
						let newRow2=table.insertRow(count+i+2);
						newRow2.className='row1';
						
						let newdCell1=newRow2.insertCell(0);
						newdCell1.style.width="140px";
						newdCell1.style.borderBottom="2px solid black";
						let newdCell2=newRow2.insertCell(1);
						newdCell2.style.borderBottom="2px solid black";
						let newdCell3=newRow2.insertCell(2);
						newdCell3.colSpan="2";
						newdCell3.style.borderBottom="2px solid black";
						let newdCell4=newRow2.insertCell(3);
						newdCell4.colSpan="2";
						newdCell4.style.borderBottom="2px solid black";

						newdCell1.innerHTML='<img src="${pageContext.request.contextPath}/upload/'+list[i].pp_title+'" class="img">';
						newdCell2.innerHTML=list[i].pi_name;
						newdCell3.innerHTML=list[i].pd_count;
						newdCell4.innerHTML=list[i].pi_price;
					}
				}
			}
		}
		xhr.open('get','${pageContext.request.contextPath}/member/purchasedetail?ph_num='+ph_num,true);
		xhr.send();
	}
	function gosmall(size,count,ph_num){
		let rows=document.getElementsByClassName("row1");
		for(i=size+1;i>=0;i--){
			console.log(i);
			rows[i].remove();
		}
		let titlea=document.getElementsByClassName("titlea");
		titlea[count-2].href='javascript:titleclick('+(count)+','+ph_num+')';
	}
	
</script>






