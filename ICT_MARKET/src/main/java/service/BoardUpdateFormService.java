package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.BoardDAO;
import kr.co.ict.BoardVO;

public class BoardUpdateFormService implements boardInterface_Service {
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String sId = (String)session.getAttribute("session_id");
		String user_id = request.getParameter("user_id");
		
		String board_num = request.getParameter("board_num");
		
		int boardnum = 0;
		if(board_num != null) {
			boardnum = Integer.parseInt(board_num);
		}
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO board= dao.getBoardDetail(boardnum);

		request.setAttribute("board", board);
	 }
}
