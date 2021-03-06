package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.UserDAO;
import kr.co.ict.UserVO;

public class UserInfoUpdateFormService implements boardInterface_Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	
		String suNum = request.getParameter("user_num");
		int uNum = Integer.parseInt(suNum);
		
		System.out.println(uNum);
		UserDAO dao = UserDAO.getInstance();
		UserVO user = dao.getUserDataManager(uNum);
		request.setAttribute("user", user);
	}

}
