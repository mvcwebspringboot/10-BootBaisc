<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Boot</title>
</head>
<body>
<div id="wrap">
	<h1>글 상세보기</h1>
  <p><a href="/myBoard/list">목록보기</a></p>
	
	<ul>
		<li>글번호 : ${dto.seq}</li>
		<li>작성자 : ${dto.writer}</li>
		<li>제목 : ${dto.title}</li>
		<li>내용 : ${dto.content}</li>
		<li>작성일 : ${dto.regdate}</li>
	</ul>
</div>
</body>
</html>