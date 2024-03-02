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
  <h1>게시글 정보</h1>
  
  <h2>아이디 : ${dto.id}</h2>
  <h2>제목 : ${dto.title}</h2>
  <h2>내용 : ${dto.content}</h2>
</div>
</body>
</html>