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
</body>
</html>