package kr.co.ict;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.catalina.connector.Response;

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
	
	public List<UserVO> getAllUserList(int pageNum){
	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<UserVO> userList = new ArrayList<>();
		final int USER_COUNT = 10;
		try {
		con = ds.getConnection();
		int limitNum = ((pageNum - 1)* USER_COUNT);
		String sql = "SELECT * FROM userinfo ORDER BY user_num DESC limit ?, ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, limitNum);
		pstmt.setInt(2, USER_COUNT);
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
	
	
	
	
	public UserVO getUserData(String session_id) {
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				UserVO user = null;
				
			
				try {
					con = ds.getConnection();
				String sql = "SELECT * FROM userinfo WHERE user_id=?";
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, session_id);
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
	public UserVO getUserDataManager(int user_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserVO user = null;
		
	
		try {
			con = ds.getConnection();
		String sql = "SELECT * FROM userinfo WHERE user_num=?";
		pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, user_num);
		rs = pstmt.executeQuery();
		if(rs.next()){ 
		user_num = rs.getInt("user_num");
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
	public UserVO getUserLoginData(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserVO user = null;
		
	
		try {
			con = ds.getConnection();
		String sql = "SELECT * FROM userinfo WHERE user_id=?";
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, id);
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
	
	


	
	public void updateCheck(String session_id , String user_pw, String user_pnum, String
			user_address) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
	
		try {
			con = ds.getConnection();

		String sql = "UPDATE userinfo SET user_pw=?, user_address=?, user_pnum=? WHERE user_id =?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user_pw);
		pstmt.setString(2, user_address);
		pstmt.setString(3, user_pnum);
		pstmt.setString(4, session_id);
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
	public int getPageNum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int pageNum = 0;	
		
		
		try {
			con = ds.getConnection();
			String sql = "SELECT COUNT(*) FROM userinfo";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pageNum = rs.getInt(1);
				
				
				
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
				rs.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return pageNum;	
	}
	}


	