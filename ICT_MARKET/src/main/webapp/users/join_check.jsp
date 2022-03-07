
<%@page import="kr.co.ict.JoinDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("utf-8");
    String name = request.getParameter("name");
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");
    String addr = request.getParameter("addr");
   
    
    JoinDAO dao = JoinDAO.getInstance();
    dao.insertUser(name, id, pw, email, phone, addr);
    
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1> <%=id %>님 회원 가입이 완료되었습니다. </h1>
   <a href="login_form.jsp">로그인창으로 이동하기</a>
</body>
</html>