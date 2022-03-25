package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;
import kr.co.ict.BoardVO;
import kr.co.ict.ReportDAO;
import kr.co.ict.ReportVO;

public class ReportedDetailService implements boardInterface_Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reported_num = Integer.parseInt(request.getParameter("reported_num"));
		int reported_board_num = Integer.parseInt(request.getParameter("reported_board_num"));
		
		ReportDAO dao = ReportDAO.getInstance();
		ReportVO reportDetail = dao.getreportDetail(reported_num);
		request.setAttribute("reportDetail", reportDetail);
		
		BoardDAO bDao = BoardDAO.getInstance();
		BoardVO boarddetail = bDao.getBoardDetail(reported_board_num);
		request.setAttribute("boarddetail", boarddetail);
		
	}

}
