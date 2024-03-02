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
	<h1>게시판 글입력</h1>
	<p><a href="/myBoard/list">목록보기</a></p>
	
	<form action="/myBoard/writeOk" method="post">
		<fieldset>
			<legend>글 입력</legend>
			<ul>
				<li>
				  작성자 : <input type="text" name="writer" />
				</li>
				<li>
				  제목 : <input type="text" name="title" />
				</li>
				<li>
				  내용 : <textarea name="content" cols="30" rows="10"></textarea>
				</li>
			</ul>
		</fieldset>
		<p><button>확인</button></p>
	</form>
</div>
</body>
</html>