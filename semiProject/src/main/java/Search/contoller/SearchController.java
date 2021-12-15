package Search.contoller;

import java.io.IOException;
<<<<<<< HEAD
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

		String category =req.getParameter("CATEGORY");
		if(category!=null) {
			if(category.equals("1")) {
				category=null;
			}
		}
		String sort = req.getParameter("sort");
		if(sort!=null) {
			if(sort.equals("1")) {
				sort=null;
			}
		}

		Search_ResultDao dao=new Search_ResultDao();
		
		//검색탭으로 검색할때
		
		
		

		//세부페이지로 이동후 검색할때
		if(keyword!=null) {
			//카테고리랑 정렬이 없다면
			if(category==null&&sort==null) {
				ArrayList<Search_ProductVo> list=dao.search_product(keyword, null, null);
				ArrayList<TagVo> tag = dao.get_tag(keyword, null, null);
				req.setAttribute("tag", tag);
				req.setAttribute("keyword", keyword);
				req.setAttribute("list", list);
			//카테고리만 없다면
			}else if(category==null) {
				ArrayList<Search_ProductVo> list=dao.search_product(keyword, null, sort);
				ArrayList<TagVo> tag = dao.get_tag(keyword, null, sort);
				req.setAttribute("tag", tag);
				req.setAttribute("keyword", keyword);
				req.setAttribute("sort", sort);
				req.setAttribute("list", list);
			//정렬만 없다면
			}else if(sort==null) {
				ArrayList<Search_ProductVo> list=dao.search_product(keyword, category, null);
				ArrayList<TagVo> tag = dao.get_tag(keyword, category, null);
				req.setAttribute("tag", tag);
				req.setAttribute("keyword", keyword);
				req.setAttribute("CATEGORY", category);
				req.setAttribute("list", list);
			// 둘다 있을때
			}else if(category!=null&&sort!=null) {
				ArrayList<Search_ProductVo> list=dao.search_product(keyword, category, sort);
				ArrayList<TagVo> tag = dao.get_tag(keyword, category, sort);
				req.setAttribute("tag", tag);
				req.setAttribute("keyword", keyword);
				req.setAttribute("CATEGORY", category);
				req.setAttribute("sort", sort);
				req.setAttribute("list", list);

=======
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

		String category =req.getParameter("CATEGORY");
		if(category!=null) {
			if(category.equals("1")) {
				category=null;
			}
		}
		String sort = req.getParameter("sort");
		if(sort!=null) {
			if(sort.equals("1")) {
				sort=null;
			}
		}

		Search_ResultDao dao=new Search_ResultDao();
		if(keyword!=null) {
			//카테고리랑 정렬이 없다면
			if(category==null&&sort==null) {
				ArrayList<Search_ProductVo> list=dao.search_product(keyword, null, null);
				ArrayList<TagVo> tag = dao.get_tag(keyword, null, null);
				req.setAttribute("tag", tag);
				req.setAttribute("keyword", keyword);
				req.setAttribute("list", list);
			//카테고리만 없다면
			}else if(category==null) {
				ArrayList<Search_ProductVo> list=dao.search_product(keyword, null, sort);
				ArrayList<TagVo> tag = dao.get_tag(keyword, null, sort);
				req.setAttribute("tag", tag);
				req.setAttribute("keyword", keyword);
				req.setAttribute("sort", sort);
				req.setAttribute("list", list);
			//정렬만 없다면
			}else if(sort==null) {
				ArrayList<Search_ProductVo> list=dao.search_product(keyword, category, null);
				ArrayList<TagVo> tag = dao.get_tag(keyword, category, null);
				req.setAttribute("tag", tag);
				req.setAttribute("keyword", keyword);
				req.setAttribute("CATEGORY", category);
				req.setAttribute("list", list);
			// 둘다 있을때
			}else if(category!=null&&sort!=null) {
				ArrayList<Search_ProductVo> list=dao.search_product(keyword, category, sort);
				ArrayList<TagVo> tag = dao.get_tag(keyword, category, sort);
				req.setAttribute("tag", tag);
				req.setAttribute("keyword", keyword);
				req.setAttribute("CATEGORY", category);
				req.setAttribute("sort", sort);
				req.setAttribute("list", list);
>>>>>>> branch 'master' of https://github.com/HyunwooY/SemiProject.git
			}

		}
		req.setAttribute("main", "/search/searchResult.jsp");
		req.getRequestDispatcher("/layout.jsp").forward(req, resp);
	}
}


