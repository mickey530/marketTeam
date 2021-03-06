package kr.co.ict;

public class UserVO {
	
	private String user_id; 
	private String user_pw; 
	private String user_name; 
	private String user_pnum; 
	private String user_address;
	private int user_num;
	public UserVO(int user_num,String user_id, String user_pw, String user_name, String user_pnum, String user_address) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.user_pnum = user_pnum;
		this.user_address = user_address;
		this.user_num = user_num;
		
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_pnum() {
		return user_pnum;
	}
	public void setUser_pnum(String user_pnum) {
		this.user_pnum = user_pnum;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	@Override
	public String toString() {
		return "UserVO [user_id=" + user_id + ", user_pw=" + user_pw + ", user_name=" + user_name + ", user_pnum="
				+ user_pnum + ", user_address=" + user_address + ", user_num=" + user_num + "]";
	}
	
}

