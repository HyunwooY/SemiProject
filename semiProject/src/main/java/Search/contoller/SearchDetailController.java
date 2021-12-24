package Search.contoller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import chaneloper.dao.Search_ResultDao;
import chaneloper.dao.Interst_goodsDao;
import chaneloper.dao.Search_Inq_RvDao;
import chaneloper.vo.Inquiry_historyVo;
import chaneloper.vo.ReviewVo;
import chaneloper.vo.Search_ProductVo;
import chaneloper.vo.Search_ReviewVo;
import chaneloper.vo.Search_ReviewptVo;
@WebServlet("/search/searchdetail")
public class SearchDetailController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		if(req.getParameter("pi_num")!=null) {
			String savedir =req.getSession().getServletContext().getRealPath("/upload");
			int pi_num = Integer.parseInt(req.getParameter("pi_num"));
			Search_ResultDao dao = new Search_ResultDao();
			ArrayList<Search_ProductVo> product = dao.get_product(pi_num);
			int good=dao.increaseCount(pi_num); // 제품 방문시 조회수 올리기 메소드
			if(good>0) System.out.println("good");
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
			Search_Inq_RvDao dao2=Search_Inq_RvDao.getInstance();
			ArrayList<Inquiry_historyVo> list=dao2.list(startRow, endRow, pi_num);
			int pageCount=(int)Math.ceil(dao2.getCount(pi_num)/10.0);
			int startPage=(pageNum-1)/10*10+1;
			int endPage=startPage+9;
			if(endPage>pageCount) {
				endPage=pageCount;
			}
			
			Interst_goodsDao dao3 = Interst_goodsDao.getInstance();
			int score = dao3.count_ig(pi_num);
			int count = dao3.count_pi_count(pi_num);
			
			ArrayList<Search_ReviewVo> list_rv = dao2.getrv(pi_num);
			ArrayList<Search_ReviewptVo> list_pt = dao2.getpt();
			
			req.setAttribute("score", score);
			req.setAttribute("count", count);
			req.setAttribute("list_rv", list_rv);
			req.setAttribute("list_pt", list_pt);
			
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
			req.setAttribute("savedir", savedir);
			
			req.setAttribute("main","/search/searchDetail.jsp");
			req.getRequestDispatcher("../layout.jsp").forward(req, resp);
		}
		
		
		if(req.getParameter("get_color")!=null) {
			String get_color = req.getParameter("get_color");
			req.setAttribute("post_color", get_color);
			req.setAttribute("main","/search/searchDetail.jsp");
			req.getRequestDispatcher("../layout.jsp").forward(req, resp);
		}

	}

}
