package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;

public class BoardInsertService implements boardInterface_Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDAO dao = BoardDAO.getInstance();
		String user_id =  request.getParameter("user_id"); // session
		String boardInfo = request.getParameter("board_info");
		Boolean board_info = Boolean.parseBoolean(boardInfo); // casting
		String board_category = request.getParameter("board_category");
		String board_title = request.getParameter("board_title");
		String board_content = request.getParameter("board_content");
		String boardAmount = request.getParameter("board_amount");
		int board_amount = Integer.parseInt(boardAmount); // casting
		
		dao.insertBoard(user_id, board_info, board_category, board_title, board_content, board_amount);
	}

}
