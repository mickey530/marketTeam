<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%
    
     String sId = (String)session.getAttribute("session_id");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



  <h1><%=sId %>님이 로그인이 되셨습니다.</h1>
   <a href="http://localhost:5151/ICT_MARKET/users/login_form.jsp">로그인창으로 돌아가기</a>
</body>
</html>