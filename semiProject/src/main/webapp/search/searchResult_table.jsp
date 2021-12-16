<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border=1 width="500">
	<tr>
		<th> </th><th> </th><th> </th>
	</tr>
	<c:forEach var="vo" items="${list }">
	<tr>
		<td><a href="${cp }/search/searchdetail?pi_num=${vo.pi_num }">
				<img src="${vo.pp_title }">
			</a></td>
		<td><a href="${cp }/search/searchdetail?pi_num=${vo.pi_num }">
				<span>${vo.pi_name }</span>
			</a></td>
		<td>${vo.pi_price }</td>
		<td>태그</td>
		<td>
			<ul>
				<li style="background-color:green;" class="chips"> </li>
				<li style="background-color:red" class="chips"> </li>
			</ul>
		</td>
		
	</tr>
	</c:forEach>
</table>
</body>
</html>