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
  <h1>개인정보</h1>
  
  <!-- 클래스의 앞글자를 소문자로 한 변수명으로 커맨드객체에 접근 할 수 있다. -->
  
  <h2>
    취미 :    
    <c:forEach items="${infoDTO.hobby}" var="hobby">
      ${hobby}
    </c:forEach> 
  </h2>
  
  <h2>결혼 : ${infoDTO.married==1 ? "기혼" : "미혼"}</h2>
  
  <h2>국적 : ${infoDTO.nation}</h2>
</div>
</body>
</html>