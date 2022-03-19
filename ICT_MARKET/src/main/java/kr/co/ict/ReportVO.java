package kr.co.ict;

public class ReportVO {
	
	private int reported_num;
	private String reporting_id;
	private String reported_id;
	private int reported_board_num;
	private String reported_reason;
	
	public ReportVO(int reported_num, String reporting_id, String reported_id, int reported_board_num,
			String reported_reason) {
		super();
		this.reported_num = reported_num;
		this.reporting_id = reporting_id;
		this.reported_id = reported_id;
		this.reported_board_num = reported_board_num;
		this.reported_reason = reported_reason;
	}

	public int getReported_num() {
		return reported_num;
	}

	public void setReported_num(int reported_num) {
		this.reported_num = reported_num;
	}

	public String getReporting_id() {
		return reporting_id;
	}

	public void setReporting_id(String reporting_id) {
		this.reporting_id = reporting_id;
	}

	public String getReported_id() {
		return reported_id;
	}

	public void setReported_id(String reported_id) {
		this.reported_id = reported_id;
	}

	public int getReported_board_num() {
		return reported_board_num;
	}

	public void setReported_board_num(int reported_board_num) {
		this.reported_board_num = reported_board_num;
	}

	public String getReported_reason() {
		return reported_reason;
	}

	public void setReported_reason(String reported_reason) {
		this.reported_reason = reported_reason;
	}

	@Override
	public String toString() {
		return "ReportVO [reported_num=" + reported_num + ", reporting_id=" + reporting_id + ", reported_id="
				+ reported_id + ", reported_board_num=" + reported_board_num + ", reported_reason=" + reported_reason
				+ "]";
	}
	
}
