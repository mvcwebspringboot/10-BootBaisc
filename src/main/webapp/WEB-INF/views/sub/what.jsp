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
  	<h1>당신은 독도에 대해 무엇을 알고 계신가요?</h1>
  	
  	<section>
  	 <c:forEach items="${list}" var="cont">
  	   <p>${cont}</p>
  	 </c:forEach>
  	</section>
  </div>
</body>
</html>