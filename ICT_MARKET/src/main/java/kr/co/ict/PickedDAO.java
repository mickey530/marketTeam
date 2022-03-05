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

public class PickedDAO {
	
	private DataSource ds = null;
	
	private static PickedDAO dao = new PickedDAO();
	
	private PickedDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/envj/jdbc/mysql");
			
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
	
	public List<PickedVO> getAllPickedList(String session_id){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<PickedVO> PickedList = new ArrayList<>();
		
		try {
			con = ds.getConnection();
			String getInfo = "SELECT * FROM pickedlist WHERE picked_id = ?";
			pstmt = con.prepareStatement(getInfo);
			pstmt.setString(1, session_id);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				String picked_id = rs.getString("picked_id");
				boolean picked_board_info = rs.getBoolean("picked_board_info");
				int picked_board_num = rs.getInt("picked_board_num");
				int picked_num = rs.getInt("picked_num");
				
				// 클래스 생성 및 ArrayList에 저장
				PickedVO pickedData = new PickedVO(picked_id, picked_board_info, picked_board_num, picked_num);
				PickedList.add(pickedData);
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
		return PickedList;

	}
	
	// 찜 목록에서 판매/구매 게시글만 보기 기능 추가 예정
	// DAO에서 메서드를 만들어 놓는 것이 효율적일지,
	// jsp 파일에서 이미 받아온 데이터를 가지고 처리하는것이 효율적일지 고민
	
	
}
