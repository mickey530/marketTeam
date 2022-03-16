package service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;

public class BoradDeleteService implements boardInterface_Service{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String boardnum = request.getParameter("board_num");
		int board_num = Integer.parseInt(boardnum);
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.deleteBoard(board_num);
	}
}