package kr.co.ict;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserDAO {
	
	    private DataSource ds = null;
	
	
		private static UserDAO dao = new UserDAO();
		
		private UserDAO() {


		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		}	 
		catch (Exception e) {
			e.printStackTrace();
}
		}
		

		public static UserDAO getInstance() {
			if(dao == null) {
				dao = new UserDAO();
			}
				
			return dao;
		}
	
	public List<UserVO> getAllUserList(){
	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<UserVO> userList = new ArrayList<>();
	
		try {
		con = ds.getConnection();
		String sql = "SELECT * FROM userinfo";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		
		while(rs.next()) {

		
		int user_num = rs.getInt("user_num");
		String user_name = rs.getString("user_name");
		String user_id = rs.getString("user_id");
		String user_pw = rs.getString("user_pw");
		String user_pnum = rs.getString("user_pnum");
		String user_address = rs.getString("user_address");
		UserVO userData = new UserVO(user_num,user_id, user_pw,  user_name, user_pnum, user_address);

		userList.add(userData);
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
		finally{
			try {
			con.close();
			pstmt.close();
			rs.close();
			} catch(SQLException se) {
				se.printStackTrace();
			}
		}
	return userList;
	}	
	
	
	
	
	public UserVO getUserData(int userNum) {
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				UserVO user = null;
				
			
				try {
					con = ds.getConnection();
				String sql = "SELECT * FROM userinfo WHERE user_num=?";
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, userNum);
				rs = pstmt.executeQuery();
				if(rs.next()){ 
				int user_num = rs.getInt("user_num");
				String user_name = rs.getString("user_name");
				String user_pnum = rs.getString("user_pnum");
				String user_address = rs.getString("user_address");
				String user_id = rs.getString("user_id");
				String user_pw= rs.getString("user_pw");
				
				user = new UserVO(user_num,user_id,user_pw, user_name, user_pnum, user_address);
					 }
				
			}catch(Exception e) {
				e.printStackTrace();
			}
				finally{
					try {
					con.close();
					pstmt.close();
					rs.close();
					} catch(SQLException se) {
						se.printStackTrace();
					}
				}
			return user;
	}	 
	
	


	
	public void updateCheck(int user_num , String user_pw, String user_pnum, String
			user_address) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
	
		try {
			con = ds.getConnection();

		String sql = "UPDATE userinfo SET user_pw=?, user_address=?, user_pnum=? WHERE user_num =?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user_pw);
		pstmt.setString(2, user_address);
		pstmt.setString(3, user_pnum);
		pstmt.setInt(4, user_num);
		pstmt.executeUpdate();
		}
		
		
		catch(Exception e) {
			e.printStackTrace();
			}
			
							
		
	}


public void deleteUser(int user_num) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
	
		try {
			con = ds.getConnection();
	
		String sql = "DELETE FROM userinfo WHERE user_num =?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, user_num);
		pstmt.executeUpdate();
		}
		
		
		catch(Exception e) {
			e.printStackTrace();
			}
		finally{
			try {
			con.close();
			pstmt.close();
			
			} catch(Exception e) {
				e.printStackTrace();
			}
		}	
	}		

	public void insertUser(String user_id ,String user_pw, String user_name, String user_pnum,
			String user_address) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
	
		try {
			con = ds.getConnection();
	
		String sql = "INSERT INTO userinfo(user_id,user_pw,user_name,user_pnum,user_address) VALUE (?,?,?,?,?)";
	    pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user_id);
		pstmt.setString(2, user_pw);
		pstmt.setString(3, user_name);
		pstmt.setString(4, user_pnum);
		pstmt.setString(5, user_address);
		pstmt.executeUpdate();
		}
		
		
		catch(Exception e) {
			e.printStackTrace();
			}
		finally{
			try {
			con.close();
			pstmt.close();
			
			} catch(Exception e) {
				e.printStackTrace();
			}
		}	
}
	}


	