<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String saveDir=application.getRealPath("/upload");
	out.print("업로드경로"+ saveDir +"<br>");
	
	MultipartRequest mr=new MultipartRequest(
		request, //request객체
		saveDir, //저장할 디렉토리
		1024*1024*5, //최대업로드가능한 크기(바이트단위)
		"utf-8",//인코딩방식
		new DefaultFileRenamePolicy()//동일한 파일명이 존재할시 이를 처리할 객체
	);
	Int pi_num=Integer.parseInt(mr.getParameter("pi_num"));
	String pi_name=mr.getParameter("pi_name");
	Int pi_num=Integer.parseInt(mr.getParameter("pi_price"));
	String orgFileName=mr.getOriginalFileName("file1");//전송된파일명
	String orgFileName=mr.getOriginalFileName("file2");
	String orgFileName=mr.getOriginalFileName("file3");

	String saveFileName=mr.getFilesystemName("file1");//저장된 파일명
	String saveFileName=mr.getFilesystemName("file2");
	String saveFileName=mr.getFilesystemName("file3");
	
	File f=new File(saveDir +"\\" + saveFileName);//업로드된 파일정보를 갖는 객체
	long filesize=f.length();//파일크기
	FileinfoVo vo=new FileinfoVo(pi_num,pi_name,title,content,orgFileName,saveFileName,filesize);
	FileinfoDao dao=new FileinfoDao();
	int n=dao.insert(vo);
	if(n>0){
		out.print("<h1>업로드 성공!</h1>");
	}else{
		out.print("<h1>업로드 실패!</h1>");
	}
%>
<h1>파일업로드 완료!</h1>
상품번호 : <%=pi_num %><br>
상품명 : <%=pi_name %><br>
가격 : <%=pi_price %><br>
전송된 이미지 : <%=orgFileName %><br>
저장된 이미지 : <%=saveFileName %><br>
</body>
</html>