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
	
	// all board list
	public List<BoardVO> getAllBoardList(int PageNum){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> boardList = new ArrayList<>();
		final int boardCount = 10;
		try {
			con = ds.getConnection();
			
			int limitNum = (PageNum -1) * boardCount;
			
			String sql = "SELECT * FROM board ORDER BY board_num DESC limit ?, ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, limitNum);
			pstmt.setInt(2, boardCount);
			
			rs = pstmt.executeQuery();

			while(rs.next()) {
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
	// true : sell / false : buy
	public List<BoardVO> getAllBoardList(Boolean boardInfo, int PageNum){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> boardList = new ArrayList<>();
		try {
			con = ds.getConnection();
			int limitNum = (PageNum -1) * 10;
			String sql = "SELECT * FROM board WHERE board_info = " + boardInfo + " ORDER BY board_num DESC limit ?, 20";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, limitNum);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				int board_num = rs.getInt("board_num");
				String user_id = rs.getString("user_id");
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
				
				BoardVO boardData = new BoardVO(board_num, user_id, boardInfo, board_category, board_title,  board_content,
						 board_amount, board_sold, board_hit, board_reported, board_writetime, board_updatetime, board_picked_num);
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
	public List<BoardVO> getAllBoardList(String sId, int pageNum){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		final int boardCount = 10;
		
		List<BoardVO> boardList = new ArrayList<>();
		
		try {
			con = ds.getConnection();
			int limitNum = (pageNum -1) * boardCount;	
			String sql = "SELECT * FROM board WHERE user_id = ? ORDER BY board_num DESC limit ?, ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sId);
			pstmt.setInt(2, limitNum);
			pstmt.setInt(3, boardCount);
			
			rs = pstmt.executeQuery();

			while(rs.next()) {
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

	public void insertBoard(String user_id, boolean board_info, String board_category, String board_title , String board_content, int board_amount) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			// 'board_sold' has false as default value
			String sql = "INSERT INTO board(user_id, board_info, board_category, board_title, board_content,  board_amount, board_sold)"
					+ "VALUES(?, ?, ?, ?, ?, ?, false)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setBoolean(2, board_info);
			pstmt.setString(3, board_category);
			pstmt.setString(4, board_title);
			pstmt.setString(5, board_content);
			pstmt.setInt(6, board_amount);
		
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
	
	public void updateBoard(int board_num, String board_title, String board_category, boolean board_info, String board_content, int board_amount) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			
			String update = "UPDATE board SET board_title = ?, board_category = ?, board_info = ?, board_content = ?,  board_amount = ?, board_updatetime = NOW() WHERE board_num = ?";
			
			pstmt = con.prepareStatement(update);
			
			pstmt.setString(1, board_title);
			pstmt.setString(2, board_category);
			pstmt.setBoolean(3, board_info);
			pstmt.setString(4, board_content);
			pstmt.setInt(5, board_amount);
			pstmt.setInt(6, board_num);
			
			pstmt.executeUpdate();	
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{
				con.close();
				pstmt.close();
			}catch(final Exception e) {
				e.printStackTrace();
			}
		}
	}

	public BoardVO getBoardDetail(int boardNum) {
		
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				BoardVO boardthread = null;
				
				try {
					
				con = ds.getConnection();

				String detail = "SELECT * FROM board WHERE board_num = ?";

				pstmt = con.prepareStatement(detail);
				
				pstmt.setInt(1, boardNum);
				
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
					int board_picked_num = rs.getInt("board_picked_num");
					
					boardthread = new BoardVO(board_num, user_id, board_info, board_category, board_title,  board_content,
							 board_amount, board_sold, board_hit, board_reported, board_writetime, board_updatetime, board_picked_num);
					hitCount(board_num);
					
					
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
			return boardthread;
	}

	public void deleteBoard(int board_num) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String delete = "DELETE FROM board WHERE board_num = ?";
		
		try {
			
		con = ds.getConnection();
		pstmt = con.prepareStatement(delete);
		pstmt.setInt(1, board_num);
		pstmt.executeUpdate();
		
	}catch(Exception e) {
		e.printStackTrace();
		
	}finally {
		
		try{
			con.close();
			pstmt.close();
		}catch(final SQLException se) {
			se.printStackTrace();
		}
	}
	}
	
	public ArrayList<BoardVO> getsearchBoard(String where, Boolean sorB, String searchword) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO boardData = null;
		ArrayList<BoardVO> searchresult = new ArrayList<BoardVO>();
		
		try {
			con = ds.getConnection();
	
			String sql = "SELECT * FROM board WHERE "+where+" AND board_info= ? LIKE '%?%'";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setBoolean(1, sorB);
			pstmt.setString(2, searchword);
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
				int board_picked_num = rs.getInt("board_picked_num");
				
				boardData = new BoardVO(board_num, user_id, board_info, board_category, board_title,  board_content,
						 board_amount, board_sold, board_hit, board_reported, board_writetime, board_updatetime, board_picked_num);
				searchresult.add(boardData);
				
				
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
		return searchresult;
	}
	
public ArrayList<BoardVO> getsearchBoardhead(String searchword) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO boardData = null;
		ArrayList<BoardVO> searchresult = new ArrayList<BoardVO>();
		
		try {
			con = ds.getConnection();
	
			String sql = "SELECT * FROM board LIKE '%?%'";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, searchword);
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
				int board_picked_num = rs.getInt("board_picked_num");
				
				boardData = new BoardVO(board_num, user_id, board_info, board_category, board_title,  board_content,
						 board_amount, board_sold, board_hit, board_reported, board_writetime, board_updatetime, board_picked_num);
				searchresult.add(boardData);
				
				
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
		return searchresult;
	}

	public int getsearchCount(String keyword, Boolean sorB, String searchword) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			con = ds.getConnection();
			
			String sql = "SELECT COUNT(IDX) AS COUNT FORM board WHERE \"+where+\" AND board_info= ? LIKE '%?%'";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setBoolean(1, sorB);
			pstmt.setString(2, searchword);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
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
		return count;
	}
	
public void pickedCount(int pick) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String pickedcount = "update board set board_picked_num = (board_picked_num +1) where board_num = ?";
		
		try {
		con = ds.getConnection();
		
		pstmt = con.prepareStatement(pickedcount);
		
		pstmt.setInt(1, pick);
		
		pstmt.executeUpdate();	
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{
				con.close();
				pstmt.close();
			}catch(final Exception e) {
				e.printStackTrace();
			}
		}
		}
	
	private void hitCount(int hit) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String hitcount = "update board set board_hit = (board_hit +1) where board_num = ?";
		
		try {
		con = ds.getConnection();
		
		pstmt = con.prepareStatement(hitcount);
		
		pstmt.setInt(1, hit);
		
		pstmt.executeUpdate();	
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{
				con.close();
				pstmt.close();
			}catch(final Exception e) {
				e.printStackTrace();
			}
		}
		}

	public int getAllPageNum() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String allpagenum = "SELECT COUNT(*) board";
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
	public int getUserBoardPageNum(String sId) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String allpagenum = "SELECT COUNT(user_id) FROM board WHERE user_id =?";
		int pageNum = 0;
		
		try {
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(allpagenum);
			pstmt.setString(1, sId);
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

	