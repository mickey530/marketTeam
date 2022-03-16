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

public class BoardCommentDAO {
	
	
	private DataSource ds = null;

	private static BoardCommentDAO dao = new BoardCommentDAO();

	private BoardCommentDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static BoardCommentDAO getInstance(){
		if(dao == null) {
			dao = new BoardCommentDAO();		
		}
		return dao;
	}

	public List<BoardCommentVO> getBoardCommentList(int comment_board_num){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardCommentVO> boardcommentList = new ArrayList<>();
		try {
			con = ds.getConnection();
	
			String sql = "SELECT * FROM boardcomment ORDER BY comment_num DESC";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();

			while(rs.next()) {
				
				int comment_num = rs.getInt("comment_num");
				String comment_id = rs.getString("comment_id");
				String comment_content = rs.getString("comment_content");
				Date comment_writetime = rs.getDate("comment_writetime");
				Date comment_updatetime = rs.getDate("comment_updatetime");



				BoardCommentVO boardData = new BoardCommentVO(comment_num, comment_id, comment_board_num, 
						comment_content, comment_writetime, comment_updatetime);
				boardcommentList.add(boardData);
			
				
				
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
		return boardcommentList;
	}
}