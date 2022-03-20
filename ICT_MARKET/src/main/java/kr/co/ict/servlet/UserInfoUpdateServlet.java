package kr.co.ict.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String suNum = request.getParameter("user_num");
		String pw = request.getParameter("pw");
		String address = request.getParameter("address");
		String pNum= request.getParameter("pNum");
		int uNum = Integer.parseInt(suNum);
		UserDAO dao = UserDAO.getInstance();
		dao.updateCheck(uNum,pw,pNum,address);
		
		response.sendRedirect("http://localhost:8181/ICT_MARKET/userInfo?user_num="+uNum);
	}

}
