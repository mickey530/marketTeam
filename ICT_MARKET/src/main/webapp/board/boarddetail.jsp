<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${board.board_num }No</h1>
	<input type="text" placeholder="title" value="${board.board_title }" readonly>
	<input type="text" placeholder="amount" value="${board.board_amount }"><br/>
	<input type="text" placeholder="user_id" value="${board.user_id }" readonly>
	<input type="text" placeholder="writetime" value="${board_writetime}" readonly>
	${board.board_hit }<br/>
	<textarea rows="30" cols="50" placeholder="content">${board.board_content }</textarea><br/>
	<a href="http://localhost:8181/ICT_MARKET/board/Board_list.jsp">목록으로</a>
	<form action="http://localhost:8181/ICT_MARKET/boardDelete" method="post">
		<input type="hidden" value="${board.board_num }" name="board_num">
		<input type="submit" value="삭제하기">
	</form>
	
	<form action="http://localhost:8181/ICT_MARKET/board/boardUpdateForm.jsp" method="post">
		<input type="hidden" value="${board.board_num }" name="board_num">
		<input type="submit" value="수정하기">
	
	</form>
</body>
</html>