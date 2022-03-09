package kr.co.ict;

public class JoinVO {
	
	private String uName;
	private String uId;
	private String uPw;
	private String uEmail;
	private String phone;
	private String addr;

	
	public JoinVO(String uName, String uId, String uPw, String uEmail, String phone, String addr) {
		super();
		this.uName = uName;
		this.uId = uId;
		this.uPw = uPw;
		this.uEmail = uEmail;
		this.phone = phone;
		this.addr = addr;
	}


	public String getuName() {
		return uName;
	}


	public void setuName(String uName) {
		this.uName = uName;
	}


	public String getuId() {
		return uId;
	}


	public void setuId(String uId) {
		this.uId = uId;
	}


	public String getuPw() {
		return uPw;
	}


	public void setuPw(String uPw) {
		this.uPw = uPw;
	}


	public String getuEmail() {
		return uEmail;
	}


	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}


	@Override
	public String toString() {
		return "joinVO [uName=" + uName + ", uId=" + uId + ", uPw=" + uPw + ", uEmail=" + uEmail + ", phone=" + phone
				+ ", addr=" + addr + "]";
	}
	

}
