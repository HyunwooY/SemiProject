package Search.contoller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.InterestDao;
import chaneloper.dao.Search_inqDao;
@WebServlet("/search/inq")
public class SearchQnaController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("mi_id")!=null && req.getParameter("pi_num")!=null) {
			Search_inqDao dao=Search_inqDao.getInstance();
			String title = req.getParameter("title");
			ArrayList<String> rs= dao.getqa(req.getParameter("mi_id"), Integer.parseInt(req.getParameter("pi_num")),req.getParameter("title"));
			resp.setContentType("text/xml;charset=utf-8");
			PrintWriter pw = resp.getWriter();
			pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			pw.print("<result>");
			pw.print("<que>"+rs.get(0)+"</que>");
			pw.print("<ans>"+rs.get(1)+"</ans>");
			pw.print("<tit>"+title+"</tit>");
			pw.print("</result>");
		}
	}
}
