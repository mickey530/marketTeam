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

	public List<BoardVO> getAllBoardList(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> boardList = new ArrayList<>();
		try {
			con = ds.getConnection();
	
			String sql = "SELECT * FROM board";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();

			while(rs.next()) {
				String user_id = rs.getString("user_id");
				boolean board_info = rs.getBoolean("board_info");
				int board_num = rs.getInt("board_num");
				String board_content = rs.getString("board_content");
				String board_category = rs.getString("board_category");
				int board_amount = rs.getInt("board_amount");
				boolean board_sold =  rs.getBoolean("board_sold");
				int board_reported = rs.getInt("board_reported");
				Date board_writetime = rs.getDate("board_writetime");
				Date board_updatetime = rs.getDate("board_updatetime");

				
				BoardVO boardData = new BoardVO(user_id, board_info, board_num, board_content,
						board_category, board_amount, board_sold, board_reported, board_writetime, board_updatetime);
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
}