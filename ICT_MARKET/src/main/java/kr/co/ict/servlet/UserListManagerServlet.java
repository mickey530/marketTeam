package kr.co.ict.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.UserDAO;
import kr.co.ict.UserVO;

@WebServlet("/UserList")
public class UserListManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserListManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO dao = UserDAO.getInstance();
		
		List<UserVO> userList = dao.getAllUserList();
		
		request.setAttribute("userList", userList);
		request.setCharacterEncoding("utf-8");
		RequestDispatcher dp = request.getRequestDispatcher("/manager/UserList.jsp"); 
		dp.forward(request, response);
		
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO dao = UserDAO.getInstance();
		
		List<UserVO> userList = dao.getAllUserList();
		
		request.setAttribute("userList", userList);
		request.setCharacterEncoding("utf-8");	
		RequestDispatcher dp = request.getRequestDispatcher("/manager/UserList.jsp"); 
		dp.forward(request, response);
	

	}
}














