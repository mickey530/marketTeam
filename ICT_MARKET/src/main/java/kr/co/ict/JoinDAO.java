package kr.co.ict;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JoinDAO {
	
	
	
		private DataSource ds = null;

	
		private static JoinDAO dao = new JoinDAO();
		 
		private JoinDAO() {
			try {
				Context ct = new InitialContext();
				ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public static JoinDAO getInstance() {
			if(dao == null) {
				dao = new JoinDAO();
			}
			return dao;
		}

	
	public void insertUser(String uName,String uId, String uPw,  String uEmail,String uPhone, String uAddr) {
		   Connection con = null;
		   PreparedStatement pstmt = null;
		  
		   try {
//			   Class.forName(dbType);
			   con = ds.getConnection();

			     
			  String sql = "INSERT INTO userinfo VALUE(?,?,?,?,?,?)";
			  pstmt = con.prepareStatement(sql);
			  pstmt.setString(1, uName);
			  pstmt.setString(2, uId);
			  pstmt.setString(3, uPw);
			  pstmt.setString(4, uEmail);
			  pstmt.setString(5, uPhone);
			  pstmt.setString(6, uAddr);
			   
			  pstmt.executeUpdate();
			
			    
		     }catch(Exception e) {
			   e.printStackTrace();
		   }finally {
	    
			try {
			   
	      	   con.close();
	          	 pstmt.close();
	          	 
	        }catch(Exception e) {
	      	  e.printStackTrace();
	        }
	              
			
		   }
	}	   
	          
	  
}