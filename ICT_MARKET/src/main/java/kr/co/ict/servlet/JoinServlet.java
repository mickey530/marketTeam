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
		
		 
		 UserDAO dao = UserDAO.getInstance();
		
		 request.setCharacterEncoding("utf-8");
		   
		    String id = request.getParameter("user_id");
		    String pw = request.getParameter("user_pw");
		    String name = request.getParameter("user_name");
		    String phone = request.getParameter("user_phone");
		    String addr = request.getParameter("user_address");
		    
		    
		    dao.insertUser(id, pw, name, phone, addr);
		   System.out.println("post방식으로 접속");
		    
		  //  request.setAttribute("id",id);
		  //  request.setAttribute("pw",pw);
		  //  request.setAttribute("name",name);
		  //  request.setAttribute("phone",phone);
		  //  request.setAttribute("addr",addr);
		  //  RequestDispatcher dp = request.getRequestDispatcher("users/join_form");
		  //  dp.forward(request, response);
		   
			response.sendRedirect("http://localhost:8181/ICT_MARKET/join_welcome.jsp");
		
	}

}
