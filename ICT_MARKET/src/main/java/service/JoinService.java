package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.UserDAO;

public class JoinService implements boardInterface_Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 request.setCharacterEncoding("utf-8");
		    String name = request.getParameter("name");
		    String id = request.getParameter("id");
		    String pw = request.getParameter("pw");
		    String phone = request.getParameter("phone");
		    String addr = request.getParameter("addr");
		    
		    UserDAO dao = UserDAO.getInstance();
		    dao.insertUser(id, pw, name, phone, addr);
		
	}

}
