<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="http://localhost:8181/ICT_MARKET/boardUpdate" method="post">
		<input type="hidden" name="board_num" value="${board.board_num }">
		<input type="text" name="board_title" placeholder="title" value="${board.board_title }">
		<input type="text" name="board_category" placeholder="category" value="${board.board_category }">
		<input type="text" name="board_info" placeholder="info" value="${board.board_info }"><br/>
		<input type="hidden" value="${board_writetime}" readonly>
		<textarea rows="30" cols="50" name="board_content" placeholder="content">${board.board_content }</textarea><br/>
		가격 : <input type="text" name="board_amount" placeholder="amount" value="${board.board_amount }">
		<input type="submit" value="수정완료"><input type="reset" value="초기화">
	</form>
</body>
</html>