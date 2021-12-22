package Search.contoller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.AddInterestDao;
import chaneloper.dao.Search_Inq_RvDao;
@WebServlet("/search/inqdel")
public class SearchQnaDelController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("mi_id")!=null && req.getParameter("pi_num")!=null) {
			Search_Inq_RvDao dao=Search_Inq_RvDao.getInstance();
			System.out.println(req.getParameter("mi_id"));
			System.out.println(req.getParameter("title"));
			System.out.println(req.getParameter("pi_num"));
			int rs= dao.delqa(req.getParameter("mi_id"), Integer.parseInt(req.getParameter("pi_num")),req.getParameter("title"));
			if(rs>0) {
				System.out.println("삭제완료");
			}else {
				System.out.println("실패");
			}
			resp.sendRedirect(req.getContextPath()+"/search/searchdetail?pi_num="+req.getParameter("pi_num"));
		}
	}
}
