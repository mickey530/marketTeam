package service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.BoardCommentDAO;
import kr.co.ict.BoardDAO;

public class BoardDeleteService implements boardInterface_Service{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String boardnum = request.getParameter("board_num");
		int board_num = Integer.parseInt(boardnum);
		
		String user_id = request.getParameter("user_id");
		
		HttpSession session = request.getSession();
		String sId = (String)session.getAttribute("session_id");		
		
		if(sId.equals(user_id)) {
			
		BoardCommentDAO cDao = BoardCommentDAO.getInstance();
		cDao.deleteBoardComment(board_num);
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.deleteBoard(board_num);
		
		}
	}
}