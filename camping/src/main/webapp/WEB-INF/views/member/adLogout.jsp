<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그아웃</title>
</head>
<body>
<c:remove var="adId" scope="session" />
<c:redirect url="/main" />
</body>
</html>