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
	public List<ReportVO> getAllReportList(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReportVO> ReportList = new ArrayList<>();
		
		try {
			con = ds.getConnection();
			String getInfo = "SELECT * FROM reportlist";
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
		// 리턴 값
		return ReportList;

	}
	
	// 특정 유저 검색용 메서드(검색창에서 input으로 받을 예정)
//		public List<ReportVO> getReportedUser(String input_id){
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		List<ReportVO> ReportList = new ArrayList<>();
		
//		try {
//			con = ds.getConnection();
//			String getInfo = "SELECT * FROM reportlist WHERE reported_id = ?";
//			pstmt = con.prepareStatement(getInfo);
//			pstmt.setString(1, input_id);
//			rs = pstmt.executeQuery();

//			while(rs.next()) {
//				String reported_id = rs.getString("reported_id");
//				int reported_board_num = rs.getInt("reported_board_num");
//				String reported_reason = rs.getString("reported_reason");
				
				
				// 클래스 생성 및 ArrayList에 저장
//				ReportVO reportData = new ReportVO(reported_id, reported_board_num, reported_reason);
//				ReportList.add(reportData);
//				}
			
			
//		} catch(Exception e){
//			e.printStackTrace();		
//		} finally{
			
//			try {
//				con.close();
//				pstmt.close();
//				rs.close();
//			} catch(SQLException se) {
//				se.printStackTrace();		
//			}
//		}
		// 리턴 값
//		return ReportList;
	}
