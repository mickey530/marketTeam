package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.BoardDAO;
import kr.co.ict.BoardVO;
import kr.co.ict.ReportDAO;

public class ReportService implements boardInterface_Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String reporting_id = (String)session.getAttribute("session_id");
		
		int reported_board_num = Integer.parseInt(request.getParameter("board_num"));
		String report_reason = request.getParameter("report_reason");
		
		BoardDAO bDao = BoardDAO.getInstance();
		BoardVO board = bDao.getBoardDetail(reported_board_num);
		String reported_id = board.getUser_id();

		request.setAttribute("board_num", reported_board_num);
		
		ReportDAO dao = ReportDAO.getInstance();
		dao.report(reporting_id, reported_id, reported_board_num, report_reason);
	}

}
