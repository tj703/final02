<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>
1:${memId }
2:${status }
3:${camplist.num}
4:${dto }
5:${FavoriteDTO }
</h1>
<c:if test = "${result == 1 }">
	<script>
		alert("삭제되었습니다.");
		history.go(-1)
	</script>
</c:if>
<c:if test = "${result == 0 }">
	<script>
		alert("이미 삭제되었거나 없는 항목입니다.");
	
	</script>
</c:if>
</body>
</html>