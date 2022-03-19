package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.UserDAO;

public class UserInfoUpdateService implements boardInterface_Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("session_id"); // session_id
		String user_pw = request.getParameter("pw");
		String user_address = request.getParameter("address");
		String user_pnum= request.getParameter("pNum");

		UserDAO dao = UserDAO.getInstance();
		dao.updateCheck(user_id, user_pw, user_pnum, user_address);

		
	}

}
