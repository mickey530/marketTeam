<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="http://localhost:8181/ICT_MARKET/CommentUpdate" method="post">
		<textarea name="comment_content">${comment.comment_content}</textarea>
		<input type="hidden" name="comment_num" value="${comment.comment_num }">
		<input type="hidden" name="comment_board_num" value="${comment.comment_board_num }">
		<input type="submit" value="댓글수정">
	</form>
</body>
</html>