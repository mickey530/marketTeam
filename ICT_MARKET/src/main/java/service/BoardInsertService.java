package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.BoardDAO;

public class BoardInsertService implements boardInterface_Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDAO dao = BoardDAO.getInstance();
		HttpSession session = request.getSession();
		String sId = (String)session.getAttribute("session_id");
		String boardInfo = request.getParameter("board_info");
		Boolean board_info = Boolean.valueOf(boardInfo).booleanValue() ;
		
		String board_category = request.getParameter("board_category");
		String board_title = request.getParameter("board_title");
		String board_content = request.getParameter("board_content");
		String boardAmount = request.getParameter("board_amount");
		String price = boardAmount.replaceAll(",", "");
		int board_amount = Integer.parseInt(price); // casting
		
		dao.insertBoard(sId, board_info, board_category, board_title, board_content, board_amount);
	}

}
