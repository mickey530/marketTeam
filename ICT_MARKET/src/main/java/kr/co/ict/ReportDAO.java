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
	
	public List<ReportVO> getAllReportedList(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReportVO> ReportList = new ArrayList<>();
		
		try {
			con = ds.getConnection();
			String getInfo = "SELECT * FROM reportlist ORDER BY reported_num DESC";
			pstmt = con.prepareStatement(getInfo);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				int reported_num = rs.getInt("reported_num");
				String reporting_id = rs.getString("reporting_id");
				String reported_id = rs.getString("reported_id");
				int reported_board_num = rs.getInt("reported_board_num");
				String reported_reason = rs.getString("reported_reason");
				
				
				// 클래스 생성 및 ArrayList에 저장
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
	
	// reported user search
	public List<ReportVO> getReportedUser(String reported_id){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReportVO> ReportList = new ArrayList<>();
		
		try {
			con = ds.getConnection();
			String getInfo = "SELECT * FROM reportlist WHERE reported_id = ? ORDER BY reported_num DESC";
			pstmt = con.prepareStatement(getInfo);
			pstmt.setString(1, reported_id);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				int reported_num = rs.getInt("reported_num");
				String reporting_id = rs.getString("reporting_id");
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
	
	// reported detail page
	public ReportVO getReportedDetail(int reported_num){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ReportVO reportData = null;
		
		try {
			con = ds.getConnection();
			String getInfo = "SELECT * FROM reportlist WHERE reported_num = ?";
			pstmt = con.prepareStatement(getInfo);
			pstmt.setInt(1, reported_num);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				String reporting_id = rs.getString("reporting_id");
				String reported_id = rs.getString("reported_id");
				int reported_board_num = rs.getInt("reported_board_num");
				String reported_reason = rs.getString("reported_reason");
				
				reportData = new ReportVO(reported_num, reporting_id, reported_id, reported_board_num, reported_reason);
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
		return reportData;
	}
	
	// board report method
	public void reportBoard(String reporting_id, String reported_id, int reported_board_num, String reported_reason) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			String report = "INSERT INTO reportlist (reporting_id, reported_id, reported_board_num, reported_reason) VALUES (?, ?, ?, ?) ";
			pstmt = con.prepareStatement(report);
			pstmt.setString(1, reporting_id);
			pstmt.setString(2, reported_id);
			pstmt.setInt(3, reported_board_num);
			pstmt.setString(4, reported_reason);
			pstmt.executeUpdate();
			
		} catch(Exception e){
			e.printStackTrace();		
		} finally{
			
			try {
				con.close();
				pstmt.close();
			} catch(SQLException se) {
				se.printStackTrace();		
			}
		}
	}
}
