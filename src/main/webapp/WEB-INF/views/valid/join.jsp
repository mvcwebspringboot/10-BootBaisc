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
  	<h1>회원가입 폼</h1>
  	
  	<form action="/joinOk" method="post">
  		<fieldset>
  			<legend>내용입력</legend>
  			<ul>
  				<li>아이디 : <input type="text" name="userid" /></li>
  			  <li>비밀번호 : <input type="password" name="userpw" /></li>
  			</ul>
  		</fieldset>
  		<p><button>확인</button></p>
  	</form>
  </div>
</body>
</html>