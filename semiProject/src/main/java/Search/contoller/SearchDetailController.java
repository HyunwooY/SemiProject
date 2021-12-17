package Search.contoller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import chaneloper.dao.Search_ResultDao;
import chaneloper.vo.Inquiry_historyVo;
import chaneloper.vo.ReviewVo;
import chaneloper.vo.Search_ProductVo;
@WebServlet("/search/searchdetail")
public class SearchDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		if(req.getParameter("pi_num")!=null) {
			int pi_num = Integer.parseInt(req.getParameter("pi_num"));
			Search_ResultDao dao = new Search_ResultDao();
			ArrayList<Search_ProductVo> product = dao.get_product(pi_num);
			ArrayList<String> color = new ArrayList<String>();
			ArrayList<String> size = new ArrayList<String>();
			ArrayList<String> img = new ArrayList<String>();
			String name= "";
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
				//사이즈\
	            if (!size.contains(vo.getPd_size())) {
	            	size.add(vo.getPd_size());
	            }
				//이미지명
	            if (!img.contains(vo.getPp_title())) {
	            	img.add(vo.getPp_title());
	            }
			}
			req.setAttribute("name", name);
			req.setAttribute("price", price);
			req.setAttribute("color", color);
			req.setAttribute("size", size);
			req.setAttribute("img", img);
			req.setAttribute("pi_num", pi_num);
			req.setAttribute("main","/search/searchDetail.jsp");
			req.getRequestDispatcher("/layout.jsp").forward(req, resp);
		}
		
		
		if(req.getParameter("get_color")!=null) {
			String get_color = req.getParameter("get_color");
			req.setAttribute("post_color", get_color);
			req.setAttribute("main","/search/searchDetail.jsp");
			req.getRequestDispatcher("/layout.jsp").forward(req, resp);
		}


		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Search_ResultDao dao = new Search_ResultDao();
		if(req.getParameter("count")!=null) {
			int count =Integer.parseInt(req.getParameter("count")) ;
			int pi_num =Integer.parseInt(req.getParameter("pi_num")) ;
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			System.out.println(pi_num);
			System.out.println(count);
			for(int i=1 ;i<=count; i++) {
				String pd = req.getParameter("name"+i);
				String[] str = pd.split("\\s+");
				int pd_num = dao.get_pd_num(pi_num,str[1],str[2]);
				map.put(pd_num, Integer.parseInt(str[4]));
			}
			if(req.getSession().getAttribute("id")==null) {
				req.setAttribute("main","/member/login.jsp");
				req.getRequestDispatcher("/layout.jsp").forward(req, resp);
			}else {
				req.getSession().setAttribute("pd_num", map);
				resp.sendRedirect(req.getContextPath()+"/member/buyProduct");
			}
			System.out.println(map);
		}else {
			System.out.println("연결오류");
		}
	}
}
