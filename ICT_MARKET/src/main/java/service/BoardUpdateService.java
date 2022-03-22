package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;

public class BoardUpdateService implements boardInterface_Service {
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String Num = request.getParameter("board_num");
		int board_num = Integer.parseInt(Num); // casting
		String board_category = request.getParameter("board_category");
		String board_title= request.getParameter("board_title");
		String board_content= request.getParameter("board_content");
		String price = request.getParameter("board_amount");
		int board_amount = Integer.parseInt(price); // casting
		String boardsold = request.getParameter("board_sold");
		System.out.println("불린값:"+boardsold);
		Boolean board_sold = Boolean.valueOf(boardsold).booleanValue();
		System.out.println(board_num);
		System.out.println(board_title);
		System.out.println(board_category);
		System.out.println(board_content);
		System.out.println(board_amount);
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.updateBoard(board_num, board_title, board_category, board_sold, board_content, board_amount);
		
		
		
		
	}
}
