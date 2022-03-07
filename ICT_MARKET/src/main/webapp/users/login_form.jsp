<%-- member/loginForm.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 로그인 </title>

<br>
</style>
</head>
<body>
	<h3> 로그인 </h3>
	<form action="http://localhost:5151/ICT_MARKET/ICTL" name="loginForm" method="post">
		<table border="1">
			<tr>
				<td id="id"> 아이디 </td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td id="pw"> 비밀번호 </td>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<td id="submit" colspan="2">
					<input type="submit" value="로그인" > 
					<a href="#">회원가입</a>
			</tr>
		</table>
	</form>
</body>
</html>	
		

