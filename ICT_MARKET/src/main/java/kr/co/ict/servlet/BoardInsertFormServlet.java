package kr.co.ict.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BoardInsertPostingSevlet
 */
@WebServlet("/boardInsertForm")
public class BoardInsertFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sId = (String)session.getAttribute("session_id");
		request.setAttribute("session_id", sId);
		
		System.out.println("세션에 아이디 있음? : " + sId);
		
		if(sId == null) {
			response.sendRedirect("http://localhost:8181/ICT_MARKET/boardList?board_info=ALL");
		} else {
			RequestDispatcher dp = request.getRequestDispatcher("/board/Board_Insertform.jsp");
			dp.forward(request, response);
		}
		
	}

}
