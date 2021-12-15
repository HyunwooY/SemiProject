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
		if(get_color!=null) {
			JSONArray color_size_count = dao.get_count(pi_num, get_color);
			JSONArray json3 = new JSONArray();
			for(int i = 0 ; i< color_size_count.length(); i++) {
				JSONObject json = color_size_count.getJSONObject(i);
				JSONObject json2 = new JSONObject();
				if(json.getInt("count")==0) {
					json2.put(json.getString("size"),"매진");
				}else {
					json2.put(json.getString("size"),json.getInt("count"));
				}
				json3.put(json2);
			}
			
			resp.setContentType("text/plain;charset=utf-8");
			PrintWriter pw = resp.getWriter();
			pw.print(json3);
		}
	}
	
}
