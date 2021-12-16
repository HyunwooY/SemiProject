package Search.contoller;

import java.io.IOException;
import java.io.PrintWriter;
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
		String get_color = req.getParameter("get_color");
		//작동확인
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
