package kr.co.ict.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.UserDAO;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/ICTJ")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		   request.setCharacterEncoding("utf-8");
		    String name = request.getParameter("name");
		    String id = request.getParameter("id");
		    String pw = request.getParameter("pw");
		    String phone = request.getParameter("phone");
		    String addr = request.getParameter("addr");
		    
		
		    UserDAO dao = UserDAO.getInstance();
		
		    dao.insertUser(id, pw, name, phone, addr);
		    
		    
		    
		    request.setAttribute("name",name);
		    request.setAttribute("id",id);
		    request.setAttribute("pw",pw);
		    request.setAttribute("phone",phone);
		    request.setAttribute("addr",addr);
		    
		    RequestDispatcher dp = request.getRequestDispatcher("/users/join_welcome.jsp");
		    dp.forward(request, response);
		    
		
	}

}
