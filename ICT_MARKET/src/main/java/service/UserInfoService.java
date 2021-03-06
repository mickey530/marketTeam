package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.UserDAO;
import kr.co.ict.UserVO;

public class UserInfoService implements boardInterface_Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	HttpSession session = request.getSession();
		String session_id = (String)session.getAttribute("session_id");
		System.out.println(session_id);
		
		UserDAO dao = UserDAO.getInstance();
		UserVO user = dao.getUserData(session_id);
		request.setAttribute("user", user);
	}
}
