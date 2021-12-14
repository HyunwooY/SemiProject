package chaneloper.contoller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import chaneloper.dao.Search_ResultDao;
import chaneloper.vo.Search_ProductVo;
import chaneloper.vo.TagVo;


@WebServlet("/search/search")  
public class SearchController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String keyword = req.getParameter("keyword");
		String CATEGORY=req.getParameter("CATEGORY");
		String sort=req.getParameter("sort");
		Search_ResultDao dao=new Search_ResultDao();
		if(keyword==null) {
			req.setAttribute("main", "/searchResult.jsp");
			req.getRequestDispatcher("/layout.jsp").forward(req, resp);
		}else if(CATEGORY==null&&sort==null) {
			ArrayList<Search_ProductVo> list=dao.search_product(keyword, null, null);
			ArrayList<TagVo> tag = dao.get_tag(keyword, null, null);
			req.setAttribute("tag", tag);
			req.setAttribute("keyword", keyword);
			req.setAttribute("list", list);
			req.setAttribute("main", "/searchResult.jsp");
			req.getRequestDispatcher("/layout.jsp").forward(req, resp);
		}else if(CATEGORY==null) {
			ArrayList<Search_ProductVo> list=dao.search_product(keyword, null, sort);
			ArrayList<TagVo> tag = dao.get_tag(keyword, null, sort);
			req.setAttribute("tag", tag);
			req.setAttribute("keyword", keyword);
			req.setAttribute("sort", sort);
			req.setAttribute("list", list);
			req.setAttribute("main", "/searchResult.jsp");
			req.getRequestDispatcher("/layout.jsp").forward(req, resp);
		}else if(sort==null) {
			ArrayList<Search_ProductVo> list=dao.search_product(keyword, CATEGORY, null);
			ArrayList<TagVo> tag = dao.get_tag(keyword, CATEGORY, null);
			req.setAttribute("tag", tag);
			req.setAttribute("keyword", keyword);
			req.setAttribute("CATEGORY", CATEGORY);
			req.setAttribute("list", list);
			req.setAttribute("main", "/searchResult.jsp");
			req.getRequestDispatcher("/layout.jsp").forward(req, resp);
		}else if(CATEGORY!=null&&sort!=null) {
			ArrayList<Search_ProductVo> list=dao.search_product(keyword, CATEGORY, sort);
			ArrayList<TagVo> tag = dao.get_tag(keyword, CATEGORY, sort);
			req.setAttribute("tag", tag);
			req.setAttribute("keyword", keyword);
			req.setAttribute("CATEGORY", CATEGORY);
			req.setAttribute("sort", sort);
			req.setAttribute("list", list);
			req.setAttribute("main", "/searchResult.jsp");
			req.getRequestDispatcher("/layout.jsp").forward(req, resp);
			}
		}
	}


