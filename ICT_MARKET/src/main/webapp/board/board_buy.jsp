<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table class="table table-hover">
		<thead>
				<tr>
					<th>아이디</th>
					<th>번호</th>
					<th>카테고리</th>
					<th>제목</th>
					<th>가격</th>
					<th>쓴날짜</th>
					<th>최종수정날짜</th>
					<th>조회수</th>
				</tr>
		</thead>
    	<tbody>
    		<c:forEach var="board" items="${boardList}">
	    		<tr>
	    			<td>${board.user_id }</td>
					<td>${board.board_num }</td>
					<td>${board.board_category }</td>
					<td>${board.board_title }</td>
					<td>${board.board_amount }</td>
					<td>${board.board_writetime }</td>
					<td>${board.board_updatetime }</td>
					<td>${board.board_hit }</td>
				</tr>
    		</c:forEach>
	
</body>
</html>