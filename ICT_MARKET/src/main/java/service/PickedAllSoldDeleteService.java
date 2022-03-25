package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.PickedDAO;

public class PickedAllSoldDeleteService implements boardInterface_Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String picked_id = (String)session.getAttribute("session_id");
		
		PickedDAO dao = PickedDAO.getInstance();
		
		dao.pickAllSoldDelete(picked_id);
		
	}

}
