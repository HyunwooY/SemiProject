package Search.contoller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import chaneloper.dao.Search_ResultDao;
import chaneloper.vo.Inquiry_historyVo;
import chaneloper.vo.ReviewVo;
import chaneloper.vo.Search_ProductVo;
@WebServlet("/search/staticsearch")
public class StaticSearchController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		//int pi_num =Integer.parseInt(req.getParameter("pi_num"));
		int pi_num = 3;
		Search_ResultDao dao = new Search_ResultDao();
		
		//색상_사이즈 가져오기
		
		//작동확인
		if(req.getParameter("get_color")!=null) {
			String get_color = req.getParameter("get_color");
			JSONArray size_count = dao.get_count(pi_num, get_color);
			resp.setContentType("text/plain;charset=utf-8");
			PrintWriter pw = resp.getWriter();
			pw.print(size_count);
		}
		
		
//		if(req.getParameter("g_color")!=null) {
//			String g_color = req.getParameter("g_color");
//			String g_size = req.getParameter("g_size");
//			String g_count = req.getParameter("g_count");
//			int json_pd_num = dao.get_pd_num(g_color,g_size,g_count);
//			resp.setContentType("text/plain;charset=utf-8");
//			PrintWriter pw = resp.getWriter();
//			pw.print(json_pd_num);
//		}

	}
}
