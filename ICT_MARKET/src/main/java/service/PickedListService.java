package service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.BoardDTO;
import kr.co.ict.BoardVO;
import kr.co.ict.PickedDAO;


public class PickedListService implements boardInterface_Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String picked_id = (String)session.getAttribute("session_id");
		
		String strpNum = request.getParameter("PageNum");
		int pNum = 0;
		try {
			pNum = Integer.parseInt(strpNum);
		}catch(Exception e) {
			pNum = 1;
		}
		
		PickedDAO dao = PickedDAO.getInstance();
		ArrayList<BoardVO> pickedList = dao.getPickedList(picked_id, pNum);
		
		int allPageNum = dao.getAllPageNum();
		
		BoardDTO dto = new BoardDTO(allPageNum, pNum);
		request.setAttribute("dto", dto);
		request.setAttribute("pickedList", pickedList);
	
	}
	}