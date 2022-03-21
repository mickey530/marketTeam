package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BoardInsertFormService implements boardInterface_Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sId = (String)session.getAttribute("session_id");
		request.setAttribute("session_id", sId);
		
		System.out.println("세션에 아이디 있음? : " + sId);
		
		if(sId == null) {
			response.sendRedirect("http://localhost:8181/ICT_MARKET/boardList?board_info=ALL");
		}		
	}

}
