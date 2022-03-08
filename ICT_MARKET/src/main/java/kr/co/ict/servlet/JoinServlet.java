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
		   
		    String user_id = request.getParameter("id");
		    String user_pw = request.getParameter("pw");
		    String user_name = request.getParameter("name");
		    String user_pnum = request.getParameter("phone");
		    String user_address = request.getParameter("addr");
		    
		  
		    
		    UserDAO dao = UserDAO.getInstance();
		    dao.insertUser(user_id,user_pw,user_name,user_pnum,user_address);
		    
		    
		    request.setAttribute("id",user_id);
		    request.setAttribute("pw",user_pw);
		    request.setAttribute("name",user_name);
		    request.setAttribute("phone",user_pnum);
		    request.setAttribute("addr",user_address);
		    
		    
		   
		    
		    
		    RequestDispatcher dp = request.getRequestDispatcher("/users/join_welcome.jsp");
		    dp.forward(request, response);
		    System.out.println("post방식으로 접속");
		
	}

}
