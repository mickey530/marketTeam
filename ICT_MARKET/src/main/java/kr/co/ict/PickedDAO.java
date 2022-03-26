package kr.co.ict;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class PickedDAO {
	
	private DataSource ds = null;
	
	private static PickedDAO dao = new PickedDAO();
	
	private PickedDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static PickedDAO getInstance() {
		if(dao == null) {
			dao = new PickedDAO();
		}
		return dao;
	}

	public ArrayList<BoardVO> getPickedList(String picked_id, int PageNum){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String picked = "SELECT * FROM board WHERE board_num = "
				+ "(select board_num from picked where picked_user_id = ?) ORDER BY board_num DESC LIMIT ?, ?"; 
		ArrayList<BoardVO> pickedlist = new ArrayList<BoardVO>();
		final int boardCount = 10;
		try {
			con = ds.getConnection();
			int limitNum = ((PageNum -1) * boardCount);
			pstmt = con.prepareStatement(picked);
			
			pstmt.setString(1, picked_id);
			pstmt.setInt(1, limitNum);
			pstmt.setInt(2, boardCount);

			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int board_num = rs.getInt("board_num");
				String user_id = rs.getString("user_id");
				Boolean board_info = rs.getBoolean("board_info");
				String board_category = rs.getString("board_category");
				String board_title = rs.getString("board_title");
				String board_content = rs.getString("board_content");
				int board_amount = rs.getInt("board_amount");
				boolean board_sold =  rs.getBoolean("board_sold");
				int board_hit = rs.getInt("board_hit");
				int board_reported = rs.getInt("board_reported");
				Date board_writetime = rs.getDate("board_writetime");
				Date board_updatetime = rs.getDate("board_updatetime");
				int board_picked_num = rs.getInt("board_picked_num");
				
				BoardVO boardData = new BoardVO(board_num, user_id, board_info, board_category, board_title,  board_content,
						 board_amount, board_sold, board_hit, board_reported, board_writetime, board_updatetime, board_picked_num);
				pickedlist.add(boardData);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return pickedlist;
	}

	public ArrayList<PickedVO> getPicked(String picked_id, int bnum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String pick = "SELECT * FROM picked WHERE picked_user_id = ? AND board_num = ?";
		ArrayList<PickedVO> getpicked = new ArrayList<PickedVO>();
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(pick);
			pstmt.setString(1, picked_id);
			pstmt.setInt(2,  bnum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String picked_user_id = rs.getString("picked_user_id");
				int board_num = rs.getInt("board_num");
				PickedVO picked = new PickedVO(picked_user_id, board_num);
				getpicked.add(picked);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return getpicked;
	}
	
	public int pick(int board_num, String picked_id) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String pick = "INSERT INTO picked VALUES(?, ?)";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(pick);
			pstmt.setInt(1, board_num);
			pstmt.setString(2, picked_id);
			pstmt.executeUpdate();
			return 1;
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1; //db 오류
	}
	
	public int pickDelete(int board_num, String picked_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String pick = "DELETE FROM picked WHERE board_num = ? AND picked_user_id = ?";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(pick);
			pstmt.setInt(1, board_num);
			pstmt.setString(2, picked_id);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; //db 오류
	}
	
	public void pickAllSoldDelete(String picked_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String pick = "DELETE FROM picked WHERE picked_id = ?";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(pick);
			pstmt.setString(1, picked_id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getAllPageNum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String allpagenum = "SELECT COUNT(*) FROM picked";
		int pageNum = 0;
		
		try {
			
		con = ds.getConnection();

		pstmt = con.prepareStatement(allpagenum);
		
		rs = pstmt.executeQuery();
		if(rs.next()) {
			pageNum = rs.getInt(1);
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		
		}finally {
			
			try{
				con.close();
				pstmt.close();
				rs.close();
			}catch(final SQLException se) {
				se.printStackTrace();
			}
		}
		return pageNum;
	}
}

