<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원로그아웃</title>
</head>
<body>
<c:remove var="memId" scope="session" />
<c:redirect url="/home" />


</body>
</html>