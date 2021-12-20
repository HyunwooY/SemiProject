package Search.contoller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import chaneloper.dao.Search_ResultDao;
import chaneloper.dao.Search_inqDao;
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
			
			String spageNum=req.getParameter("pageNum");
			
			int pageNum=1;
			if(spageNum!=null) {
				pageNum=Integer.parseInt(spageNum);
			}
			int startRow=(pageNum-1)*10+1;
			int endRow=startRow+9;	
			Search_inqDao dao2=Search_inqDao.getInstance();
			ArrayList<Inquiry_historyVo> list=dao2.list(startRow, endRow, pi_num);
			int pageCount=(int)Math.ceil(dao2.getCount(pi_num)/10.0);
			int startPage=(pageNum-1)/10*10+1;
			int endPage=startPage+9;
			if(endPage>pageCount) {
				endPage=pageCount;
			}
			req.setAttribute("list", list);
			req.setAttribute("endPage", endPage);
			req.setAttribute("startPage", startPage);
			req.setAttribute("pageCount", pageCount);
			req.setAttribute("pageNum", pageNum);
			
			req.setAttribute("name", name);
			req.setAttribute("price", price);
			req.setAttribute("color", color);
			req.setAttribute("size", size);
			req.setAttribute("img", img);
			req.setAttribute("pi_num", pi_num);
			
			
			
			req.setAttribute("main","/search/searchDetail.jsp");
			req.getRequestDispatcher("/search/searchDetailLayout.jsp").forward(req, resp);
		}
		
		
		if(req.getParameter("get_color")!=null) {
			String get_color = req.getParameter("get_color");
			req.setAttribute("post_color", get_color);
			req.setAttribute("main","/search/searchDetail.jsp");
			req.getRequestDispatcher("/search/searchDetailLayout.jsp").forward(req, resp);
		}


	}

}
