package service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;

public class BoardSearchService implements boardInterface_Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDAO dao = BoardDAO.getInstance();
		
		request.setCharacterEncoding("utf-8");
		
	    String search = request.getParameter("searchkey");
	    
	    request.setAttribute("search",search);
	   
	    RequestDispatcher dp = request.getRequestDispatcher("/board/Board_search.jsp");
	    
	    dp.forward(request, response);
		
	}

}
