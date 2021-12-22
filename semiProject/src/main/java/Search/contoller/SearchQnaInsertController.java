package Search.contoller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.Search_inqDao;
@WebServlet("/search/inqins")
public class SearchQnaInsertController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("mi_id")!=null && req.getParameter("pi_num")!=null) {
			Search_inqDao dao=Search_inqDao.getInstance();
			
			int rs= dao.insertqna(req.getParameter("mi_id"), Integer.parseInt(req.getParameter("pi_num")),req.getParameter("title"),req.getParameter("qu"));
			if(rs>0) {
				System.out.println("추가완료");
			}else {
				System.out.println("추가실패");
			}
			resp.sendRedirect(req.getContextPath()+"/search/searchdetail?pi_num="+req.getParameter("pi_num"));
			
		}
	}
}
