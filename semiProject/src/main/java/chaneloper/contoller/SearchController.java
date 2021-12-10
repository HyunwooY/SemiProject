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
		String keyword = req.getParameter("keyword");
		String categori = req.getParameter("categori");
		String sort = req.getParameter("sort");
		
		// product_information Dao 조회
		Search_ResultDao dao=new Search_ResultDao();
		ArrayList<Search_ProductVo> list=dao.search_product(keyword, categori, sort);
		
		req.setAttribute("list", list);
		req.setAttribute("main", "/searchResult.jsp");
		req.getRequestDispatcher("/layout.jsp").forward(req, resp);
		}
	}

