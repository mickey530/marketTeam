package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.UserDAO;

public class UserInfoDeleteService implements boardInterface_Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String struNum = request.getParameter("user_num");
		int uNum = Integer.parseInt(struNum);
		
		// 1. dao积己
		UserDAO dao = UserDAO.getInstance();
		// 2. 昏力肺流 角青
		dao.deleteUser(uNum);
		
	}

}
