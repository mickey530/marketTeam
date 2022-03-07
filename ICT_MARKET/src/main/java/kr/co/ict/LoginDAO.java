package kr.co.ict;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class LoginDAO {

	
	
	
	private DataSource ds = null;


	private static  LoginDAO dao = new  LoginDAO();
	 
	private  LoginDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static  LoginDAO getInstance() {
		if(dao == null) {
			dao = new  LoginDAO();
		}
		return dao;
	}
	
	public LoginVO getUserDate(String sId){
		  
		   Connection con = null;
		   PreparedStatement pstmt = null;
		   ResultSet rs = null;
		   LoginVO user= null;
		  
		  
		
		   try {
			   
			     con = ds.getConnection();

			     
			   
			
			    String sql = "SELECT * FROM userinfo WHERE uid=?";
			   pstmt = con.prepareStatement(sql);
			   pstmt.setString(1, sId); 
			   
			   rs=pstmt.executeQuery();
			    
			    	 if(rs.next()) {
				 		    
				 		   
				 		    String uId = rs.getString("user_id");
				 		    String uPw = rs.getString("user_pw");
				 		    String uName = rs.getString("user_name");
				 		    String uPnum = rs.getString("user_pnum");
				 		    String uAddr = rs.getString("user_address");
				 		    user = new LoginVO(uId, uPw, uName , uPnum,uAddr);
				  
			   
			 
			  
			    }
		   
		   
		   }catch(Exception e) {
			   e.printStackTrace();
		   }finally {
	      
			
			   try {
	        	   con.close();
	            	 pstmt.close();
	            	 rs.close();  
	          }catch(Exception e) {
	        	  e.printStackTrace();
	          }
	                
			 }
		  
		   
		  
		 return user;
		 }

	  
}
