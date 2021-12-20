package Search.contoller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.AddInterestDao;
@WebServlet("/search/interest")
public class AddInterestController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("mi_id")!=null && req.getParameter("pi_num")!=null) {
			AddInterestDao dao = new AddInterestDao();
			int rs= dao.addinter(req.getParameter("mi_id"), Integer.parseInt(req.getParameter("pi_num")));
			resp.setContentType("text/xml;charset=utf-8");
			PrintWriter pw = resp.getWriter();
			pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			pw.print("<result>");
			if(rs>0) {
				//정상작동
				pw.print("<find1>success</find1>");
			}else if(rs==-2){
				pw.print("<find1>fail</find1>");
			}else {
				System.out.println("찜하기에러");
			}
			pw.print("</result>");
		}

	}
}
