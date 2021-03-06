package kr.co.ict;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ReportDAO {
	
	private DataSource ds = null;
	
	private static ReportDAO dao = new ReportDAO();
	
	private ReportDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static ReportDAO getInstance() {
		if(dao == null) {
			dao = new ReportDAO();
		}
		return dao;
	}
	
	// report 데이터 전체 불러오는 메서드
	public List<ReportVO> getAllReportList(int pageNum){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReportVO> ReportList = new ArrayList<>();
		final int BOARD_COUNT = 10;
		
		try {
			con = ds.getConnection();
			int limitNum = ((pageNum - 1)* BOARD_COUNT);
			String getInfo = "SELECT * FROM reportlist ORDER BY reported_num DESC limit ?, ?";
			pstmt = con.prepareStatement(getInfo);
			pstmt.setInt(1, limitNum);
			pstmt.setInt(2, BOARD_COUNT);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				int reported_num = rs.getInt("reported_num");
				String reporting_id = rs.getString("reporting_id");
				String reported_id = rs.getString("reported_id");
				int reported_board_num = rs.getInt("reported_board_num");
				String reported_reason = rs.getString("reported_reason");
				
				ReportVO reportData = new ReportVO(reported_num, reporting_id, reported_id, reported_board_num, reported_reason);
				ReportList.add(reportData);
				}
			
			
		} catch(Exception e){
			e.printStackTrace();		
		} finally{
			
			try {
				con.close();
				pstmt.close();
				rs.close();
			} catch(SQLException se) {
				se.printStackTrace();		
			}
		}
		return ReportList;

	}
	
	public ReportVO getreportDetail(int reportedNum){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ReportVO Report = null;
		
		try {
			con = ds.getConnection();
			String detail = "SELECT * FROM reportlist WHERE reported_num = ?";
			pstmt = con.prepareStatement(detail);
			
			pstmt.setInt(1, reportedNum);
			
			rs = pstmt.executeQuery();

			while(rs.next()) {
				int reported_num = rs.getInt("reported_num");
				String reporting_id = rs.getString("reporting_id");
				String reported_id = rs.getString("reported_id");
				int reported_board_num = rs.getInt("reported_board_num");
				String reported_reason = rs.getString("reported_reason");
				
				Report = new ReportVO(reported_num, reporting_id, reported_id, reported_board_num, reported_reason);
				}
			
			
		} catch(Exception e){
			e.printStackTrace();		
		} finally{
			
			try {
				con.close();
				pstmt.close();
				rs.close();
			} catch(SQLException se) {
				se.printStackTrace();		
			}
		}
		return Report;

	}
	
	public int getPageNum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int pageNum = 0;	
		try {
			con = ds.getConnection();
			String sql = "SELECT COUNT(*) FROM reportlist";
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
	
	public void report(String reporting_id, String reported_id, int reported_board_num, String reported_reason) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			String sql = "INSERT INTO reportlist(reporting_id, reported_id, reported_board_num, reported_reason) VALUES(?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, reporting_id);
			pstmt.setString(2, reported_id);
			pstmt.setInt(3, reported_board_num);
			pstmt.setString(4, reported_reason);
			pstmt.executeUpdate();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	// before board delete
	public void reportedDelete(int board_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String delete = "DELETE FROM reportlist WHERE reported_board_num = ?";
		
		try {
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(delete);
			pstmt.setInt(1, board_num);
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}	
	
	// before user delete
	public void reportedUserDelete(String user_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String delete = "DELETE FROM reportlist WHERE reported_id = ?";
		
		try {
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(delete);
			pstmt.setString(1, user_id);
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void reportingUserDelete(String user_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String delete = "DELETE FROM reportlist WHERE reporting_id = ?";
		
		try {
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(delete);
			pstmt.setString(1, user_id);
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
		
}
