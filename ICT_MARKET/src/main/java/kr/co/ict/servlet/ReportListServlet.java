package kr.co.ict.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;
import kr.co.ict.BoardDTO;
import kr.co.ict.BoardVO;
import kr.co.ict.ReportDAO;
import kr.co.ict.ReportVO;

/**
 * Servlet implementation class ReportListServlet
 */
@WebServlet("/reportList")
public class ReportListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String spNum = request.getParameter("page_num");
		int pNum = 0;
	
		try {
			pNum = Integer.parseInt(spNum);
		}
		catch(Exception e) {
			pNum=1;
		}
		
		ReportDAO dao = ReportDAO.getInstance();
		List<ReportVO> reportList = dao.getAllReportList(pNum);
		int total_page = dao.getPageNum();
		request.setAttribute("reportList", reportList);
		
		BoardDTO dto = new BoardDTO(total_page, pNum);
		request.setAttribute("dto", dto);
		
		
		RequestDispatcher dp = request.getRequestDispatcher("/manager/ReportList.jsp");
		dp.forward(request, response);
	}
}
