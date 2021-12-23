package chaneloper.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.ReviewDao;
import chaneloper.vo.ReviewVo;
@WebServlet("/mypage/reviewlist")
public class ReviewListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String spageNum = req.getParameter("pageNum");
		String id = (String)req.getSession().getAttribute("id");
		String id1 = req.getParameter("id1");
		
		int pageNum = 1;
		if(spageNum!=null) { 
			pageNum = Integer.parseInt(spageNum);
		}
		       
		int startRow = (pageNum-1)*10+1;
		int endRow = startRow+9;
		
		ReviewDao dao = ReviewDao.getInstance();
//		if(dao.reviewSelect(id1)==id)
//		dao.list(startRow, endRow);
		
		ArrayList<ReviewVo> list = dao.list(startRow, endRow);
		int pageCount = (int)Math.ceil(dao.getCount()/10.0); 
		int startPageNum = ((pageNum-1)/10*10)+1; 
		int endPageNum = startPageNum+9;
		if(endPageNum>pageCount) {
			endPageNum=pageCount;
		}
		req.setAttribute("list", list);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("startPage", startPageNum);
		req.setAttribute("endPage", endPageNum);
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("detailmain", "/member/reviewList.jsp");
		req.setAttribute("detailtitle", "나의 리뷰");
		req.getRequestDispatcher("/member/memberDetail").forward(req, resp);
	}
}
