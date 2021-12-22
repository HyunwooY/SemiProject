package Search.contoller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.Search_ResultDao;
import chaneloper.vo.ColorVo;
import chaneloper.vo.Search_ProductVo;
import chaneloper.vo.TagVo;
@WebServlet("/search/category")
public class CategoryController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String keyword = req.getParameter("keyword");
		System.out.println("1" + keyword); // 여기서 keyword=""
		req.setAttribute("keyword", keyword);
		
		String category = req.getParameter("CATEGORY");
		System.out.println("2" + category); // category=null
		req.setAttribute("category", category);
		if(category!=null) {
			if(category.equals("1") || category=="") {
				category=null;
			}
		}
		System.out.println("3" + category); // category=null
		String sort = req.getParameter("sort");
		System.out.println("4" + sort); // sort=""
		req.setAttribute("sort", sort);
		if(sort!=null) {
			if(sort.equals("1") || sort=="") {
				sort=null;
			}
		}
		System.out.println("5" + sort); // sort=null
		Search_ResultDao dao=new Search_ResultDao();
		ArrayList<Search_ProductVo> list=null;
		String spageNum=req.getParameter("pageNum"); // **
		System.out.println(spageNum);
		int pageNum=1;
		if (spageNum!=null) { // null일수가 없다. 
			pageNum=Integer.parseInt(spageNum);
		}
		int endRow=pageNum*10; //10
		int startRow=endRow-9; //1
		int ccc=0;
		//세부페이지로 이동후 검색할때
		if(keyword!=null) {
			//카테고리랑 정렬이 없다면
			if(category==null&&sort==null) { 
				System.out.println("ok");
				list=dao.search_product(keyword, null, null, startRow, endRow);
				ccc=dao.search_productCount(keyword, category, sort);
				ArrayList<TagVo> tag = dao.get_tag(keyword, null, null);
				ArrayList<ColorVo> color = dao.get_color();
				req.setAttribute("tag", tag);
				req.setAttribute("color", color);
				req.setAttribute("keyword", keyword);
				req.setAttribute("list", list);
			//카테고리만 없다면
			}else if(category==null) {
				list=dao.search_product(keyword, null, sort, startRow, endRow);
				ccc=dao.search_productCount(keyword, category, sort);
				ArrayList<TagVo> tag = dao.get_tag(keyword, null, sort);
				ArrayList<ColorVo> color = dao.get_color();
				req.setAttribute("tag", tag);
				req.setAttribute("keyword", keyword);
				req.setAttribute("sort", sort);
				req.setAttribute("color", color);
				req.setAttribute("list", list);
			//정렬만 없다면
			}else if(sort==null) {
				list=dao.search_product(keyword, category, null, startRow, endRow);
				ccc=dao.search_productCount(keyword, category, sort);
				ArrayList<TagVo> tag = dao.get_tag(keyword, category, null);
				ArrayList<ColorVo> color = dao.get_color();
				req.setAttribute("tag", tag);
				req.setAttribute("keyword", keyword);
				req.setAttribute("color", color);
				req.setAttribute("CATEGORY", category);
				req.setAttribute("list", list);
			// 둘다 있을때
			}else if(category!=null&&sort!=null) {
				list=dao.search_product(keyword, category, sort, startRow, endRow);
				ccc=dao.search_productCount(keyword, category, sort);
				ArrayList<TagVo> tag = dao.get_tag(keyword, category, sort);
				ArrayList<ColorVo> color = dao.get_color();
				req.setAttribute("tag", tag);
				req.setAttribute("keyword", keyword);
				req.setAttribute("CATEGORY", category);
				req.setAttribute("color", color);
				req.setAttribute("sort", sort);
				req.setAttribute("list", list);
			}
		}else {	
			keyword=null;
			list=dao.search_product(keyword, category, null, startRow, endRow);
			ArrayList<TagVo> tag = dao.get_tag(keyword, category, null);
			ArrayList<ColorVo> color = dao.get_color();
			req.setAttribute("tag", tag);
			req.setAttribute("keyword", keyword);
			req.setAttribute("color", color);
			req.setAttribute("CATEGORY", category);
			req.setAttribute("list", list);
		}
	
		int totalPage1=(int)Math.ceil(ccc/10.0);	// 전체페이지 갯수
		int startPageNum= ((pageNum-1)/10*10) + 1;	//시작 페이지 번호
		int endPageNum=startPageNum+9;	//끝 페이지 번호
		
		if (endPageNum>totalPage1) {
			endPageNum=totalPage1;
		}
		req.setAttribute("totalPage1", totalPage1);
		req.setAttribute("startPage", startPageNum);
		req.setAttribute("ccc", ccc);
		req.setAttribute("endPage", endPageNum);
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("main", "/search/category.jsp");
		req.getRequestDispatcher("/layout.jsp").forward(req, resp);
	}
}

