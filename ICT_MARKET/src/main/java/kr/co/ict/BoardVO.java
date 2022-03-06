package kr.co.ict;

import java.sql.Date;

public class BoardVO {
	
	private String user_id;
	private boolean board_info;
	private int board_num;
	private String board_content;
	private String board_category;
	private int board_amount;
	private boolean board_sold;
	private int board_reported;
	private Date board_bdate;
	// FOREIGN KEY(user_id) REFERENCES userinfo(user_id));
	
	public BoardVO(String user_id, boolean board_info, int board_num, String board_content, String board_category,
			int board_amount, boolean board_sold, int board_reported, Date board_bdate) {
		super();
		this.user_id = user_id;
		this.board_info = board_info;
		this.board_num = board_num;
		this.board_content = board_content;
		this.board_category = board_category;
		this.board_amount = board_amount;
		this.board_sold = board_sold;
		this.board_reported = board_reported;
		this.board_bdate = board_bdate;
	}
	
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public boolean isBoard_info() {
		return board_info;
	}
	public void setBoard_info(boolean board_info) {
		this.board_info = board_info;
	}
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getBoard_category() {
		return board_category;
	}
	public void setBoard_category(String board_category) {
		this.board_category = board_category;
	}
	public int getBoard_amount() {
		return board_amount;
	}
	public void setBoard_amount(int board_amount) {
		this.board_amount = board_amount;
	}
	public boolean isBoard_sold() {
		return board_sold;
	}
	public void setBoard_sold(boolean board_sold) {
		this.board_sold = board_sold;
	}
	public int getBoard_reported() {
		return board_reported;
	}
	public void setBoard_reported(int board_reported) {
		this.board_reported = board_reported;
	}
	public Date getBoard_bdate() {
		return board_bdate;
	}
	public void setBoard_bdate(Date board_bdate) {
		this.board_bdate = board_bdate;
	}
	@Override
	public String toString() {
		return "BoardVO [user_id=" + user_id + ", board_info=" + board_info + ", board_num=" + board_num
				+ ", board_content=" + board_content + ", board_category=" + board_category + ", board_amount="
				+ board_amount + ", board_sold=" + board_sold + ", board_reported=" + board_reported + ", board_bdate="
				+ board_bdate + "]";
	}	
}