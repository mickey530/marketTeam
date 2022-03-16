package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.UserDAO;

public class UserInfoUpdateService implements boardInterface_Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String suNum = request.getParameter("user_num");
		String pw = request.getParameter("pw");
		String address = request.getParameter("address");
		String pNum= request.getParameter("pNum");
		int uNum = Integer.parseInt(suNum);
		UserDAO dao = UserDAO.getInstance();
		dao.updateCheck(uNum,pw,pNum,address);

		
	}

}
