package service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.BoardDAO;
import kr.co.ict.PickedDAO;
import kr.co.ict.PickedVO;

public class PickAddOrDeleteService implements boardInterface_Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String picked_id = (String)session.getAttribute("session_id");
		
		String pickcheck = request.getParameter("dibcheck");
		System.out.println("픽들어온값"+pickcheck);
		
		String board_num = request.getParameter("board_num");
		int pNum = 0;
		try {
			pNum = Integer.parseInt(board_num);
		}catch(Exception e) {
			pNum = 1;
		}
				
		PickedDAO dao = PickedDAO.getInstance();
		BoardDAO daoboard = BoardDAO.getInstance();
		ArrayList<PickedVO> getPicked = dao.getPicked(picked_id, pNum);
		request.setAttribute("getPicked", getPicked);
		System.out.println(getPicked);
		
		if(pickcheck.equals("dibit")) {
			dao.pick(pNum, picked_id);
			//pick count(up and down)
			daoboard.pickedCountPlus(pNum);
		}else if(pickcheck.equals("cancel")) {
			dao.pickDelete(pNum, picked_id);
			//pick count(up and down)
			daoboard.pickedCountMinus(pNum);
		}
		
	}

}
