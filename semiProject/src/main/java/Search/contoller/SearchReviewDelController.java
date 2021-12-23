package Search.contoller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.Search_Inq_RvDao;
@WebServlet("/search/reviewdel")
public class SearchReviewDelController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pi_num = Integer.parseInt(req.getParameter("pi_num"));
		int r_num = Integer.parseInt(req.getParameter("r_num"));
		Search_Inq_RvDao dao = Search_Inq_RvDao.getInstance();
		dao.delrv(r_num);
		
		resp.sendRedirect(req.getContextPath()+"/search/searchdetail?pi_num="+pi_num);
		
	}
}
