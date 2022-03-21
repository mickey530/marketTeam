package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.BoardDAO;
import kr.co.ict.BoardVO;
import kr.co.ict.UserDAO;
import kr.co.ict.UserVO;

public class MainService implements boardInterface_Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String logornot = (String)session.getAttribute("session_id");
		
		UserDAO udao = UserDAO.getInstance();
		BoardDAO dao = BoardDAO.getInstance();
		
		UserVO myname = udao.getUserData(logornot);
		
		List<BoardVO> boardListsell = dao.getAllBoardList(true);
		List<BoardVO> boardListbuy = dao.getAllBoardList(false);
		
		request.setAttribute("boardListsell", boardListsell);
		request.setAttribute("boardListbuy", boardListbuy);
		request.setAttribute("myname", myname);
	}

}
