package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.BoardCommentDAO;
import kr.co.ict.BoardDAO;
import kr.co.ict.PickedDAO;
import kr.co.ict.ReportDAO;
import kr.co.ict.UserDAO;

public class UserInfoDeleteService implements boardInterface_Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("서비스는 진입함");
		String user_id = request.getParameter("user_id");
		String struNum = request.getParameter("user_num");
		int uNum = Integer.parseInt(struNum);
		HttpSession session = request.getSession();
		String sId = (String)session.getAttribute("session_id");

		if(sId.equals(user_id)) {
		
		PickedDAO pDao = PickedDAO.getInstance();
		pDao.userPickDelete(user_id);
			
		BoardCommentDAO cDao = BoardCommentDAO.getInstance();
		cDao.userDeleteBoardComment(user_id);
		
		ReportDAO rDao = ReportDAO.getInstance();
		rDao.reportedUserDelete(user_id);
		rDao.reportingUserDelete(user_id);
		
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.userDeleteBoard(user_id);	
		
		UserDAO dao = UserDAO.getInstance();
		dao.deleteUser(uNum);
		session.invalidate();
		}
	}

}
