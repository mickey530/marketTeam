package kr.co.ict;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	
	
	private DataSource ds = null;

	private static BoardDAO dao = new BoardDAO();

	private BoardDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static BoardDAO getInstance(){
		if(dao == null) {
			dao = new BoardDAO();		
		}
		return dao;
	}

	// board_info : true > sell
	// board_info : false > buy
	public List<BoardVO> getAllBoardList(boolean boardInfo){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> boardList = new ArrayList<>();
		try {
			con = ds.getConnection();
	
			String sql = "SELECT * FROM board WHERE board_info = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setBoolean(1, boardInfo);
			
			rs = pstmt.executeQuery();

			while(rs.next()) {
				int board_num = rs.getInt("board_num");
				String user_id = rs.getString("user_id");
				boolean board_info = rs.getBoolean("board_info");
				String board_category = rs.getString("board_category");
				String board_title = rs.getString("board_title");
				String board_content = rs.getString("board_content");
				int board_amount = rs.getInt("board_amount");
				boolean board_sold =  rs.getBoolean("board_sold");
				int board_hit = rs.getInt("board_hit");
				int board_reported = rs.getInt("board_reported");
				Date board_writetime = rs.getDate("board_writetime");
				Date board_updatetime = rs.getDate("board_updatetime");

				
				BoardVO boardData = new BoardVO(board_num, user_id, board_info, board_category, board_title, board_content, board_amount, board_sold, board_hit, board_reported, board_writetime, board_updatetime);
				boardList.add(boardData);
				
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
				rs.close();
			} catch(SQLException se) {
				se.printStackTrace();
			}
		}	
		return boardList;
	}
	
	
	
	public void insertBoard(String user_id, boolean board_info, String board_category, String board_title,  String board_content,
			 int board_amount, boolean board_sold) 
		{
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			
			String sql = "INSERT INTO board(user_id, board_info, board_category, board_title, board_content, board_amount, board_sold)"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setBoolean(2, board_info);
			pstmt.setString(3, board_category);
			pstmt.setString(4, board_title);
			pstmt.setString(5, board_content);
			pstmt.setInt(6, board_amount);
			pstmt.setBoolean(7, board_sold);
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
			} catch(SQLException se) {
				se.printStackTrace();
			}
		}	
	}
	
	public void updateBoard(boolean board_info, String board_category, String board_title,  String board_content,
			 int board_amount, boolean board_sold) 
		{
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			
			String sql = "UPDATE board SET board_info = ?, board_category = ?, board_title = ?, board_content = ?, board_amount = ?, board_sold = ? board_updatetime = now()"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setBoolean(1, board_info);
			pstmt.setString(2, board_category);
			pstmt.setString(3, board_title);
			pstmt.setString(4, board_content);
			pstmt.setInt(5, board_amount);
			pstmt.setBoolean(6, board_sold);
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
			} catch(SQLException se) {
				se.printStackTrace();
			}
		}	
	}
	
	
}