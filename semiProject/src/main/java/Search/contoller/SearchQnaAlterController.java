package Search.contoller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.Search_Inq_RvDao;
@WebServlet("/search/inqalt")
public class SearchQnaAlterController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("mi_id")!=null && req.getParameter("pi_num")!=null) {
			Search_Inq_RvDao dao=Search_Inq_RvDao.getInstance();
			
			int rs= dao.altqa(req.getParameter("mi_id"), Integer.parseInt(req.getParameter("pi_num")),req.getParameter("title"),req.getParameter("qu"));
			if(rs>0) {
				System.out.println("수정완료");
			}else {
				System.out.println("수정실패");
			}
			resp.sendRedirect(req.getContextPath()+"/search/searchdetail?pi_num="+req.getParameter("pi_num"));
			
		}
	}
}
