package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.BoardCommentDAO;
import kr.co.ict.BoardDAO;
import kr.co.ict.PickedDAO;
import kr.co.ict.ReportDAO;

public class ReportedBoardDeleteService implements boardInterface_Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String sId = (String)session.getAttribute("session_id");		
		
		String boardnum = request.getParameter("board_num");
		int board_num = Integer.parseInt(boardnum);
		
		if(sId.equals("Manager")) {
			
		PickedDAO pDao = PickedDAO.getInstance();
		pDao.pickDelete(board_num);
			
		BoardCommentDAO cDao = BoardCommentDAO.getInstance();
		cDao.deleteBoardComment(board_num);
		
		ReportDAO rDao = ReportDAO.getInstance();
		rDao.reportedDelete(board_num);
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.deleteBoard(board_num);
		
		}
	}

}
