<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
#fieldset{width:500px
       
};

</style>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	    <h1 align="center"> 회원 가입 </h1>
<fieldset id="fieldset" >	
	<form action="#" name="" method="post">
		<table border="1" width="500px">
			<tr>
				<td id="name"> 이 름 </td>
				<td id="name"><input type="text" name="name"required></td>
			</tr>
			<tr>
				<td id="id"> 아이디  </td>
				<td>
					<input type="text" name="id"required>
				</td>				
			</tr>
			<tr>
				<td id="pw"> 비밀번호 </td>
				<td><input type="password" name="pw"required></td>
			</tr>
			
			<tr>
				<td id="email"> E-mail </td>
				<td>
					<input type="text" name="email"> @
					<select name="domain">
						<option value="naver"> naver </option>
						<option value="gmail"> gmail</option>
						<option value="daum"> daum </option>
					</select>
				</td>
			</tr>
			<tr>
				<td id="phone"> 폰번호 </td>
				<td>
					<input type="text" name="phone1" size="1" required> -
					<input type="text" name="phone2" size="3" required> -
					<input type="text" name="phone3" size="3" required>
				</td>
			</tr>
			<tr>
				<td id="addr"> 주 소 </td>
				<td><input type="text" name="addr" size="50"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="회원가입"> 
					<input type="reset" value="초기화">
				</td>
			</tr>
		</table>
	</form>
</fieldset>	
</body>
</html>