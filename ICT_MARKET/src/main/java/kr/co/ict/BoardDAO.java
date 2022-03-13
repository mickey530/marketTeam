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
	public List<BoardVO> getAllBoardList(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> boardList = new ArrayList<>();
		try {
			con = ds.getConnection();
	
			String sql = "SELECT * FROM board ORDER BY board_num DESC";
			pstmt = con.prepareStatement(sql);
			
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

				
				BoardVO boardData = new BoardVO(board_num, user_id, board_info, board_category, board_title,  board_content,
						 board_amount, board_sold, board_hit, board_reported, board_writetime, board_updatetime);
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
	public List<BoardVO> getAllBoardList(Boolean boardInfo){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> boardList = new ArrayList<>();
		try {
			con = ds.getConnection();
	
			String sql = "SELECT * FROM board WHERE board_info = " + boardInfo + " ORDER BY board_num DESC";
			pstmt = con.prepareStatement(sql);
			
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

				
				BoardVO boardData = new BoardVO(board_num, user_id, boardInfo, board_category, board_title,  board_content,
						 board_amount, board_sold, board_hit, board_reported, board_writetime, board_updatetime);
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
	
	public void updateBoard(String board_title, String board_content,
			String board_category, String board_amount, int board_sold, String user_id) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			
			String update = "UPDATE board SET board_title = ?, board_content = ?, board_category = ?, board_amount = ?, board_sold = ? WHERE user_id = ?";
			
			pstmt = con.prepareStatement(update);
			
			pstmt.setString(1, board_title);
			pstmt.setString(2, board_content);
			pstmt.setString(3, board_category);
			pstmt.setString(4, board_amount);
			pstmt.setInt(5, board_sold);
			pstmt.setString(6, user_id);
			
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

					
					boardthread = new BoardVO(board_num, user_id, board_info, board_category, board_title,  board_content,
							 board_amount, board_sold, board_hit, board_reported, board_writetime, board_updatetime);
					
					
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
	
	public ArrayList<BoardVO> getsearchBoard(String keyword, String searchword) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO boardData = null;
		ArrayList<BoardVO> searchresult = new ArrayList<BoardVO>();
		
		try {
			con = ds.getConnection();
	
			String sql = "SELECT * FROM board WHERE "+keyword+" LIKE ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+searchword+"%");
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
				
				boardData = new BoardVO(board_num, user_id, board_info, board_category, board_title,  board_content,
						 board_amount, board_sold, board_hit, board_reported, board_writetime, board_updatetime);
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

	public int getsearchCount(String keyword, String searchword) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			con = ds.getConnection();
			
			String sql = "SELECT COUNT(IDX) AS COUNT FORM board WHERE "+keyword+" LIKE ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+searchword+"%");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("count");
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

	
}

	