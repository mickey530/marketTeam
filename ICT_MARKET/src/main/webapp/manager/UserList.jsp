<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>관리자 - 유저 리스트</title>
</head>
<body>
	<table class="table table-hover">
	  <thead>
	    <tr>
	      <th scope="col">아이디</th>
	      <th scope="col">비밀번호</th>
	      <th scope="col">이름</th>
	      <th scope="col">연락처</th>
	      <th scope="col">주소</th>
	    </tr>
	  </thead>
	  <tbody>
		<c:forEach var="i" items="${userList}">
			<tr>
				<td>${i.user_id}</td>
				<td>${i.user_pw}</td>
				<td><a href="http://localhost:8181/ICT_MARKET/userInfo?user_num=${i.user_num}">${ i.user_name}</a></td>
				<td>${i.user_pnum}</td>
				<td>${i.user_address}</td>
		    </tr>
		</c:forEach>
	  </tbody>
	</table>
</body>
</html>