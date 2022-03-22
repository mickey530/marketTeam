package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.ReportDAO;
import kr.co.ict.ReportVO;

public class ReportListService implements boardInterface_Service {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		ReportDAO dao = ReportDAO.getInstance();
		
		List<ReportVO> reportList = dao.getAllReportList();
		
		request.setAttribute("reportList", reportList);
	}
}