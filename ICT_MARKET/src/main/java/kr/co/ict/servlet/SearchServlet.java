package kr.co.ict.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDAO dao = BoardDAO.getInstance();
		
		request.setCharacterEncoding("utf-8");
		
		//Search Keyword
	    String searchkeyword = request.getParameter("search_keyword");
	    
	    //WTS or WTB
	    String sellorbuy = request.getParameter("board_info");
	    Boolean SorB = Boolean.valueOf(sellorbuy).booleanValue();
	    
	    //Search criteria
	    String sCrite = request.getParameter("search_category");
	    
	    //* criteria (OR)
	    //String qOnly = request.getParameter("only");
	    //String qAnd = request.getParameter("and");
	    
	    dao.getsearchBoard(sCrite,SorB,searchkeyword);
	   
	    RequestDispatcher dp = request.getRequestDispatcher("/board/Board_search.jsp");
	    dp.forward(request, response);
	}

}
