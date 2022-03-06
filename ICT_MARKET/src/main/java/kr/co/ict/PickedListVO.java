package kr.co.ict;

public class PickedListVO {
	
	private String picked_id;
	private Boolean picked_board_info;
	private int picked_board_num;
	private int picked_num;
	
	public PickedListVO(String picked_id, Boolean picked_board_info, int picked_board_num, int picked_num) {
		super();
		this.picked_id = picked_id;
		this.picked_board_info = picked_board_info;
		this.picked_board_num = picked_board_num;
		this.picked_num = picked_num;
	}
	

	public String getPicked_id() {
		return picked_id;
	}

	public void setPicked_id(String picked_id) {
		this.picked_id = picked_id;
	}

	public Boolean getPicked_board_info() {
		return picked_board_info;
	}

	public void setPicked_board_info(Boolean picked_board_info) {
		this.picked_board_info = picked_board_info;
	}

	public int getPicked_board_num() {
		return picked_board_num;
	}

	public void setPicked_board_num(int picked_board_num) {
		this.picked_board_num = picked_board_num;
	}

	public int getPicked_num() {
		return picked_num;
	}

	public void setPicked_num(int picked_num) {
		this.picked_num = picked_num;
	}

	@Override
	public String toString() {
		return "PickedListVO [picked_id=" + picked_id + ", picked_board_info=" + picked_board_info
				+ ", picked_board_num=" + picked_board_num + ", picked_num=" + picked_num + "]";
	}	
}
