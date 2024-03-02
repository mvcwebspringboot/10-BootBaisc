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
	<h1>글목록</h1>
  <p><a href="/myBoard/write">글작성</a></p>
  
  <c:forEach items="${list}" var="dto">
	  <ul>
			<li>글번호 : ${dto.seq}</li>
			<li>작성자 : ${dto.writer}</li>			
			<li><a href="/myBoard/${dto.seq}">제목 : ${dto.title}</a></li>
			<li><a href="/myBoard/delete/${dto.seq}">삭제</a></li>
		</ul>
		<hr />
  </c:forEach>
</div>
</body>
</html>