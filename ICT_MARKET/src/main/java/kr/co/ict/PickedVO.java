package kr.co.ict;

public class PickedVO {
	
	private String picked_user_id;
	private int board_num;
	
	public PickedVO(String picked_user_id, int board_num) {
		super();
		this.picked_user_id = picked_user_id;
		this.board_num = board_num;
	}
	public String getPicked_user_id() {
		return picked_user_id;
	}
	public void setPicked_user_id(String picked_user_id) {
		this.picked_user_id = picked_user_id;
	}
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	@Override
	public String toString() {
		return "PickedVO [picked_user_id=" + picked_user_id + ", board_num=" + board_num + "]";
	}
	
		
	
}	

