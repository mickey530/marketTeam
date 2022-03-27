package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.UserDAO;


public class UserInfoManagerUpdateService implements boardInterface_Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user_id = request.getParameter("id");
		String user_pw = request.getParameter("pw");
		String user_pnum = request.getParameter("pNum");
		String user_address = request.getParameter("address");
		
		UserDAO dao = UserDAO.getInstance();
		
		dao.updateCheck(user_id,user_pw,user_pnum,user_address);
		
		
		
	}

}
