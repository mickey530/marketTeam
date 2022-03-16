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
	<h1>${board.board_num }No</h1>
	<input type="text" placeholder="title" value="${board.board_title }" readonly>
	<input type="text" placeholder="amount" value="${board.board_amount }">
	<input type="text" placeholder="info" value="${board.board_info }"><br/> <!-- true/flase로 나오는데 나중에 라디오버튼이나 드롭다운으로 처리예정 -->
	<input type="text" placeholder="user_id" value="${board.user_id }" readonly>
	<input type="text" placeholder="writetime" value="${board.board_writetime}" readonly>
	조회수 : ${board.board_hit }<br/>
	<textarea rows="30" cols="50" placeholder="content">${board.board_content }</textarea><br/>
	<a href="http://localhost:8181/ICT_MARKET/boardList?board_info=ALL">목록으로</a>
	<form action="http://localhost:8181/ICT_MARKET/boardDelete" method="post">
		<input type="hidden" value="${board.board_num }" name="board_num">
		<input type="submit" value="삭제하기">
	</form>
	
	<form action="http://localhost:8181/ICT_MARKET/boardUpdateForm" method="post">
		<input type="hidden" value="${board.board_num }" name="board_num">
		<input type="submit" value="수정하기">
	</form>
		
	<table class="table table-hover" style="font-size:80%">
		<tr>
			<th class="col-md-1">아이디</th>
			<th class="col-md-8"></th>
			<th>날짜</th>
	</tr>
		<c:forEach items="${comment}" var="comment">
		<tr>
			<td>${comment.comment_id }</td>
			<td>${comment.comment_content }</td>
			<td>${comment.comment_updatetime }</td>
		</tr>
		</c:forEach>
	</table>
		<form action="BoardCommentInsertService" method="post">
			<textarea rows="3" cols="50" placeholder="댓글을 입력해주세요." name="board_num" value="${board.board_num }"></textarea>
		</form>
</body>
</html>