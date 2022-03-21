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
    	HttpSession session = request.getSession();
		String session_id = (String)session.getAttribute("session_id");
		String pw = request.getParameter("pw");
		String address = request.getParameter("address");
		String pNum= request.getParameter("pNum");

		UserDAO dao = UserDAO.getInstance();
		dao.updateCheck(session_id, pw,pNum,address);

		
	}

}
