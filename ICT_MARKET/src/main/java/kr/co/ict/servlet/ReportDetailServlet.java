package kr.co.ict.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardCommentDAO;
import kr.co.ict.BoardCommentVO;
import kr.co.ict.BoardDAO;
import kr.co.ict.BoardVO;
import kr.co.ict.ReportDAO;
import kr.co.ict.ReportVO;

/**
 * Servlet implementation class ReportDetailServlet
 */
@WebServlet("/reportDetail")
public class ReportDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reportednum = request.getParameter("reported_num");
		int reported_num = Integer.parseInt(reportednum);
		
		ReportDAO dao = ReportDAO.getInstance();
		ReportVO reportDetail = dao.getreportDetail(reported_num);
		request.setAttribute("reportDetail", reportDetail);
		
		RequestDispatcher dp = request.getRequestDispatcher("/manager/Report_detail.jsp");
		dp.forward(request, response);
	
	}
}

