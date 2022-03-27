package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.BoardDAO;
import kr.co.ict.PickedDAO;

public class PickCancelService implements boardInterface_Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String picked_id = (String)session.getAttribute("session_id");
		
		String boardnum = request.getParameter("board_num");
		int board_num = Integer.parseInt(boardnum);
		
		PickedDAO dao = PickedDAO.getInstance();
		BoardDAO daoboard = BoardDAO.getInstance();
		
		dao.pickDelete(board_num, picked_id);
		daoboard.pickedCountMinus(board_num);
	}

}
