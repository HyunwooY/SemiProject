package Search.contoller;

/*
 * 	script writer : 
 * 
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

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
@WebServlet("/search/searchdetail")
public class SearchDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		//상품번호
		//int pi_num = Integer.parseInt(req.getParameter("pi_num"));
		int pi_num = 3;
		Search_ResultDao dao = new Search_ResultDao();
		dao.search_product(getServletInfo(), getServletName(), getServletInfo());
		ArrayList<ReviewVo> review = dao.get_review(pi_num);
		ArrayList<Inquiry_historyVo> inq = dao.get_Inquiry_historyVo(pi_num);
		ArrayList<Search_ProductVo> product = dao.get_product(pi_num);
		
		
		ArrayList<String> color = new ArrayList<String>();
		ArrayList<String> size = new ArrayList<String>();
		ArrayList<String> title = new ArrayList<String>();
		String name= null;
		int price = 0;
		for(Search_ProductVo vo:product){
			//제품명
			name = vo.getPi_name();
			//가격
			price = vo.getPi_price();
			//색상
            if (!color.contains(vo.getPd_color())) {
            	color.add(vo.getPd_color());
            }
			//사이즈
            if (!size.contains(vo.getPd_size())) {
            	size.add(vo.getPd_size());
            }
			//이미지명
            if (!title.contains(vo.getPp_title())) {
            	title.add(vo.getPp_title());
            }
		}
		
		req.setAttribute("name", name);
		req.setAttribute("price", price);
		req.setAttribute("color", color);
		req.setAttribute("size", size);
		req.setAttribute("title", title);

		req.setAttribute("inq", inq);
		req.setAttribute("review",review);
		req.setAttribute("main","/searchDetail.jsp");
		req.getRequestDispatcher("/layout.jsp").forward(req, resp);
		
	}
}
