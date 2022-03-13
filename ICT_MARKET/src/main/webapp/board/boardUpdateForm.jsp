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
			<input type="text" name="title" placeholder="title" value="${board.board_title }">
			<input type="text" placeholder="amount" value="${board.board_amount }"><br/>
			<input type="text" placeholder="user_id" value="${board.user_id }" readonly>
			<input type="text" placeholder="writetime" value="${board_writetime}" readonly>
			${board.board_hit }<br/>
			<textarea rows="30" cols="50" placeholder="content">${board.board_content }</textarea><br/>
		<input type="submit" value="수정완료"><input type="reset" value="초기화">
	</form>
</body>
</html>