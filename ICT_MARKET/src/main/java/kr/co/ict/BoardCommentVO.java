package kr.co.ict;

import java.sql.Date;

public class BoardCommentVO {
	
	private int comment_num;
	private Date comment_time;
	private String comment_id;
	private int comment_board_num;
	private String comment_content;
	//FOREIGN KEY(comment_id) REFERENCES userinfo(user_id),
	//FOREIGN KEY(comment_board_num) REFERENCES board(board_num));
	
	public BoardCommentVO(int comment_num, Date comment_time, String comment_id, int comment_board_num,
			String comment_content) {
		super();
		this.comment_num = comment_num;
		this.comment_time = comment_time;
		this.comment_id = comment_id;
		this.comment_board_num = comment_board_num;
		this.comment_content = comment_content;
	}
	
	
	
	public int getComment_num() {
		return comment_num;
	}
	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}
	public Date getComment_time() {
		return comment_time;
	}
	public void setComment_time(Date comment_time) {
		this.comment_time = comment_time;
	}
	public String getComment_id() {
		return comment_id;
	}
	public void setComment_id(String comment_id) {
		this.comment_id = comment_id;
	}
	public int getComment_board_num() {
		return comment_board_num;
	}
	public void setComment_board_num(int comment_board_num) {
		this.comment_board_num = comment_board_num;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	@Override
	public String toString() {
		return "BoardCommentVO [comment_num=" + comment_num + ", comment_time=" + comment_time + ", comment_id="
				+ comment_id + ", comment_board_num=" + comment_board_num + ", comment_content=" + comment_content
				+ "]";
	}
}
