package chaneloper.contoller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import chaneloper.dao.Search_ResultDao;
import chaneloper.vo.Search_ProductVo;


@WebServlet("/search/search")  
public class SearchController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String keyword = req.getParameter("word");	
		// product_information Dao 조회
		Search_ResultDao dao=new Search_ResultDao();
		ArrayList<Search_ProductVo> list=dao.search_product(keyword, null, null);
		
		req.setAttribute("list", list);
		req.setAttribute("main", "/searchResult.jsp");
		req.getRequestDispatcher("/layout.jsp").forward(req, resp);
		}
	}
/*		if(n>0) {
			req.setAttribute("word", word);
			req.getRequestDispatcher("/search/searchResult.jsp").forward(req, resp);
		}else {
			resp.sendRedirect(req.getContextPath() + "/layout.jsp");
		}
	}
}


		String categori = req.getParameter("categori");
/*		if(categori.equals("mainsearch")) {
			if(keyword==null) {
				req.setAttribute("misskeyword", "검색어를 입력해주세요.");
				req.getRequestDispatcher("/main.jsp").forward(req, resp);
			}else {

			}
		}else if(categori.equals("detailsearch")) {
			if(keyword==null) {
				req.setAttribute("misskeyword", "검색어를 입력해주세요.");
				req.getRequestDispatcher("/search/detailsearch.jsp").forward(req, resp);
			}else {

			}
		}
*/	
