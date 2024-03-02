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
	<h1>티켓구매(Card)</h1>
	
	<p>에러발생여부에 1을 입력하면 에러를 강제로 발생시킴니다.</p>
	
	<form action="/buyTicketCard" method="post">
		<fieldset>
			<legend>구매정보</legend>
			
			<ul>
				<li>고객아이디 : <input type="text" name="customerid" /></li>
				<li>티켓구매수 : <input type="number" name="amount" /></li>
				<li>에러발생여부 : <input type="text" name="error" value="0" /></li>
			</ul>
		</fieldset>
		<p><button>구매하기</button></p>
	</form>
</div>
</body>
</html>