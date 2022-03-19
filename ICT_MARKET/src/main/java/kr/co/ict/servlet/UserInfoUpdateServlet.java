package kr.co.ict.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.UserDAO;

/**
 * Servlet implementation class UserInfoUpdateServlet
 */
@WebServlet("/userInfoUpdate")
public class UserInfoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("session_id"); // session_id
		String user_pw = request.getParameter("pw");
		String user_address = request.getParameter("address");
		String user_pnum= request.getParameter("pNum");

		UserDAO dao = UserDAO.getInstance();
		dao.updateCheck(user_id, user_pw, user_pnum, user_address);
		
		response.sendRedirect("http://localhost:8181/ICT_MARKET/userInfo?user_id=" + user_id);
	}

}
