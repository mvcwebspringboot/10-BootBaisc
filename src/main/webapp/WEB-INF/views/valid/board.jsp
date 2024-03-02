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
  	<h1>게시글 등록</h1>
  	
  	<form action="/regist" method="post">
  		<fieldset>
  			<legend>내용입력</legend>
  			<ul>
  				<li>아이디 : <input type="text" name="id" /></li>
  			  <li>제목 : <input type="text" name="title" /></li>
  			  <li>내용 : <input type="text" name="content" /></li>
  			</ul>
  		</fieldset>
  		<p><button>확인</button></p>
  	</form>
  </div>
</body>
</html>