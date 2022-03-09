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
	private String board_title;
	private int board_reported;
	private Date board_writetime;
	private Date board_updatetime;
	// FOREIGN KEY(user_id) REFERENCES userinfo(user_id));
	
	public BoardVO(String user_id, boolean board_info, int board_num, String board_content, String board_category,
			int board_amount, boolean board_sold, String board_title, int board_reported, Date board_writetime,
			Date board_updatetime) {
		super();
		this.user_id = user_id;
		this.board_info = board_info;
		this.board_num = board_num;
		this.board_content = board_content;
		this.board_category = board_category;
		this.board_amount = board_amount;
		this.board_sold = board_sold;
		this.board_title = board_title;
		this.board_reported = board_reported;
		this.board_writetime = board_writetime;
		this.board_updatetime = board_updatetime;
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
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public int getBoard_reported() {
		return board_reported;
	}
	public void setBoard_reported(int board_reported) {
		this.board_reported = board_reported;
	}
	public Date getBoard_writetime() {
		return board_writetime;
	}
	public void setBoard_writetime(Date board_writetime) {
		this.board_writetime = board_writetime;
	}
	public Date getBoard_updatetime() {
		return board_updatetime;
	}
	public void setBoard_updatetime(Date board_updatetime) {
		this.board_updatetime = board_updatetime;
	}
	@Override
	public String toString() {
		return "BoardVO [user_id=" + user_id + ", board_info=" + board_info + ", board_num=" + board_num
				+ ", board_content=" + board_content + ", board_category=" + board_category + ", board_amount="
				+ board_amount + ", board_sold=" + board_sold + ", board_title=" + board_title + ", board_reported="
				+ board_reported + ", board_writetime=" + board_writetime + ", board_updatetime=" + board_updatetime
				+ "]";
	}
	
	
}
	