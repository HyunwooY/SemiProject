<%@page import="chaneloper.vo.Search_ProductVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="chaneloper.vo.Inquiry_historyVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String name = (String)request.getAttribute("name");
	String price = (String)request.getAttribute("price");
	ArrayList<String> color = (ArrayList<String>)request.getAttribute("color");
	ArrayList<String> size = (ArrayList<String>)request.getAttribute("size");
	ArrayList<String> title = (ArrayList<String>)request.getAttribute("title");
%>
"${name }"

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