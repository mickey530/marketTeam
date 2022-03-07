<%@page import="kr.co.ict.LoginVO"%>
<%@page import="kr.co.ict.LoginDAO"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <% 
    String fId = request.getParameter("fid");
	String fPw = request.getParameter("fpw");
	
	
	 String dbType = "com.mysql.cj.jdbc.Driver";
      String dbUrl = "jdbc:mysql://localhost:3306/jdbcprac1";
      String dbId = "root";
      String dbPw = "mysql";
	
	try{
	
		 Class.forName(dbType);
    	  Connection con = DriverManager.getConnection(dbUrl, dbId, dbPw);
	
		   LoginDAO dao = LoginDAO.getInstance();
		   LoginVO user = dao.getUserDate(fId);     
		
		
		
	
		 if(user != null){                
			String uId = user.getuId();   
			String uPw = user.getuPw();   
			
			if(fId.equals(uId) && fPw.equals(uPw)){
				 
				 
				  session.setAttribute("session_id", uId);
				  session.setAttribute("session_pw", uPw);
				
				  response.sendRedirect("login_welcome.jsp");
			  }else {
				  out.println("<h1>비밀번호가 틀렸습니다. 다시 확인해주세요.</h1>") ;
			  }
		
		} else {
			out.println("<h1>아이디가 없습니다.입력 아이디를 확인해주세요.</h1>");
		}
	
		
	} catch(Exception e){
		e.printStackTrace();
	} finally {
		
	}
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>