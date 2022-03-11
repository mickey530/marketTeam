<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="#" method="post">
	<input type="text" name="user_id" placeholder="아이디를 입력해주세요." required><br/>
	<input type="text" name="board_category" placeholder="카테고리를 입력해주세요." required><br/>
	<input type="text" name="board_title" placeholder="제목을 입력해주세요." required><br/>
	<textarea rows="30" cols="50" name="board_content" placeholder="본문을 입력해주세요." required></textarea><br/>
	<input type="submit" value="글쓰기"><input type="reset" value="초기화">
	</form>
</body>
</html>