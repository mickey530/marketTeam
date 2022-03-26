package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDTO;
import kr.co.ict.ReportDAO;
import kr.co.ict.ReportVO;

public class ReportListService implements boardInterface_Service {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String spNum = request.getParameter("page_num");
		int pNum = 0;
	
		try {
			pNum = Integer.parseInt(spNum);
		}
		catch(Exception e) {
			pNum=1;
		}
		
		ReportDAO dao = ReportDAO.getInstance();
		List<ReportVO> reportList = dao.getAllReportList(pNum);
		int total_page = dao.getPageNum();
		request.setAttribute("reportList", reportList);
		
		BoardDTO dto = new BoardDTO(total_page, pNum);
		request.setAttribute("dto", dto);
	}
}