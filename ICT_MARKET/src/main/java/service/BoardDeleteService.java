package service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.BoardCommentDAO;
import kr.co.ict.BoardDAO;
import kr.co.ict.PickedDAO;

public class BoardDeleteService implements boardInterface_Service{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String boardnum = request.getParameter("board_num");
		int board_num = Integer.parseInt(boardnum);
		
		String user_id = request.getParameter("user_id");
		
		HttpSession session = request.getSession();
		String sId = (String)session.getAttribute("session_id");		
		
		int page_num = Integer.parseInt(request.getParameter("page_num"));
		request.setAttribute("page_num", page_num);
		request.setAttribute("board_num", board_num);
		
		if(sId.equals(user_id)) {
		
		PickedDAO pDao = PickedDAO.getInstance();
		pDao.pickDelete(board_num, user_id);
			
		BoardCommentDAO cDao = BoardCommentDAO.getInstance();
		cDao.deleteBoardComment(board_num);
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.deleteBoard(board_num);
		
		
		
		}
	}
}