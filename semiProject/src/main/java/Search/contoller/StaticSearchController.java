package Search.contoller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import chaneloper.dao.Search_ResultDao;
@WebServlet("/search/staticsearch")
public class StaticSearchController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String get_color = req.getParameter("get_color");
		//int pi_num =Integer.parseInt(req.getParameter("pi_num"));
		int pi_num = 3;
		
		Search_ResultDao dao = new Search_ResultDao();
		System.out.println(get_color);
		if(get_color!=null) {
			JSONArray size_count = dao.get_count(pi_num, get_color);
			System.out.println(size_count.length());
			
			resp.setContentType("text/plain;charset=utf-8");
			PrintWriter pw = resp.getWriter();
			pw.print(size_count);
		}
	}
	
}
