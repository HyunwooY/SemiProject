package chaneloper.contoller;

/*
 * 	script writer : 
 * 
 */


import java.io.IOException;
import java.util.ArrayList;

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
		//상품번호
		int pi_num = Integer.parseInt(req.getParameter("pi_num"));
		Search_ResultDao dao = new Search_ResultDao();
		dao.search_product(getServletInfo(), getServletName(), getServletInfo());
		ArrayList<ReviewVo> review = dao.get_review(pi_num);
		ArrayList<Inquiry_historyVo> inq = dao.get_Inquiry_historyVo(pi_num);
		ArrayList<Search_ProductVo> product = dao.get_product(pi_num);
		
		
		ArrayList<String> color = new ArrayList<String>();
		ArrayList<String> size = new ArrayList<String>();
		ArrayList<String> title = new ArrayList<String>();
		for(Search_ProductVo vo:product){
			//제품명
			String name = vo.getPi_name();
			//가격
			int price = vo.getPi_price();
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

			//재고 확인
			//
		}
		
		
		
		req.setAttribute("product", product);
		req.setAttribute("inq", inq);
		req.setAttribute("review",review);
		req.getRequestDispatcher("/searchDetail.jsp").forward(req, resp);
		

	}
}
