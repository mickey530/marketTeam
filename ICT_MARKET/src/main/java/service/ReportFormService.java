package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;
import kr.co.ict.BoardVO;

public class ReportFormService implements boardInterface_Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		BoardDAO bDao = BoardDAO.getInstance();
		BoardVO boarddetail = bDao.getBoardDetail(board_num);
		request.setAttribute("boarddetail", boarddetail);
		
	}

}
