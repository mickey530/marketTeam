package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.BoardDAO;
import kr.co.ict.BoardDTO;
import kr.co.ict.BoardVO;

public class UserBoardListService implements boardInterface_Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sId = (String)session.getAttribute("session_id");
		
		BoardDAO dao = BoardDAO.getInstance();
		
		
		String strpNum = request.getParameter("PageNum");
		int pNum = 0;
		try {
			pNum = Integer.parseInt(strpNum);
		}catch(Exception e) {
			pNum = 1;
		}
		List<BoardVO> boardList = dao.getAllBoardList(sId,pNum);
				
		request.setAttribute("boardList", boardList);
		
		int allPageNum = dao.getUserBoardPageNum(sId);
		BoardDTO dto = new BoardDTO(allPageNum, pNum);
		request.setAttribute("dto", dto); 
		

	}

		
	}


