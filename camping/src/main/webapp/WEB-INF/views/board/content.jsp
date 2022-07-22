<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>

<body>
	<center><b>글내용</b></center>
	<table width="500" border="1" cellspacing="0" cellpadding="0" align="center" colspan="6" rowspan=""5>
		<tr>
			<td width="100" align="center">카테고리</td>
				<c:if test="${board.category == 1}">
					<td colspan="4">캠핑장 후기</td>			         			
         		</c:if>
         		<c:if test="${board.category == 2}">
         			<td colspan="4">장비 후기</td>
         		</c:if>
         		<c:if test="${board.category == 3}">
         			<td colspan="4">캠핑 요리</td>
         		</c:if>
         		<c:if test="${board.category == 4}">
         			<td colspan="4">질문</td>
         		</c:if>
         		<c:if test="${board.category == 5}">
         			<td colspan="4">팁</td>
         		</c:if>
         		<c:if test="${board.category == 6}">
         			<td colspan="4">건의사항</td>
         		</c:if>
		<tr/>
		<tr>
			<td width="50" align="center" >글번호</td>
			<td width="50" >${board.boardnum}</td>

			
			<td width="150" align="center" >조회수</td>
			<td width="150" >${board.readcount}</td>
		</tr>
		<tr>
    		<td width="50" align="center" >작성자</td>
    		<td width="50" >${board.writer}</td>
    		<td width="150" align="center" >작성일시</td>
    		<td width="150" align="center">
    			<fmt:formatDate type="date" pattern = "yyyy-MM-dd HH:mm:ss" value="${board.reg}" /></td>
  		</tr>
  		<tr>
			<td width="100" align="center">제목</td>
			<td colspan="4">${ board.title }</td>
		</tr>
		<tr>
			<td width="100" align="center">글내용</td>
			<td colspan="4">${ board.content }</td>
		</tr>
		<tr>
			<td width="100" align="center">첨부파일</td>
			<td>
     			<img src="/resources/img/${board.image}" width="300" />
     		</td>
		</tr>
		<tr>
			<td width="100" align="center">비밀번호</td>
			<td colspan="4">${ board.password }</td>
		</tr>
		<tr>
			<td colspan="6" align="center">
				<input type="button" value="글수정"
				onclick="document.location.href='/board/updateForm?boardnum=${board.boardnum}&pageNum=${pageNum}'" />
				<input type="button" value="글삭제"
				onclick="document.location.href='/board/deleteForm?boardnum=${board.boardnum}&pageNum=${pageNum}'" />
				<input type="button" value="글목록"
				onclick="document.location.href='/board/list?pageNum=${pageNum}'" />
				<input type="button" value="댓글쓰기"
				onclick="document.location.href='/commentboard/writeForm?boardnum=${board.boardnum}'" />
			</td>
		</tr>
	</table>
</body>
</html>