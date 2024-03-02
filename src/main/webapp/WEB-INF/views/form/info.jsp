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
  	<h1>개인정보 폼</h1>
  	
  	<form action="/infoOk" method="post">
  		<fieldset>
  			<legend>내용입력</legend>
  			<ul>
  				<li>취미 : 
  				  <input type="checkbox" name="hobby" value="movie" /> 영화
  				  <input type="checkbox" name="hobby" value="music" /> 음악
  				  <input type="checkbox" name="hobby" value="pingpong" /> 탁구
  				</li>
  			  <li>결혼 : 
  			     <input type="radio" name="married" value="1" /> 기혼
  			     <input type="radio" name="married" value="0" /> 미혼
  			  </li>
  			</ul>
  		</fieldset>
  		<p><button>확인</button></p>
  	</form>
  </div>
</body>
</html>