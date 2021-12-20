package chaneloper.seller.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.Inquiry_historyDao;
import chaneloper.vo.Inquiry_historyVo;

public class NoticeController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String spageNum = req.getParameter("pageNum");
		int pageNum = 1;
		if(spageNum != null) {
			pageNum = Integer.parseInt(spageNum);
		}
		int startRow = (pageNum-1)*10+1;
		int endRow = startRow + 9;
		
		NoticeDao dao = NoticeDao.getInstance();
		ArrayList<NoticeVo> list = dao.list(startRow, endRow);
		
		
		int count = dao.getCount();		// 전체 글의 수
		int pageCount = (int)Math.ceil(count / 10.0);		// 전체 페이지 수
		int startPageNum = ((pageNum - 1) / 10 * 10) + 1;		// 시작 페이지 번호
		int endPageNum = startPageNum + 9;		// 끝 페이지 번호
		if(endPageNum > pageCount) {
			endPageNum = pageCount;
		}
		
		req.setAttribute("list", list);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("startPage", startPageNum);
		req.setAttribute("endPage", endPageNum);
		req.setAttribute("pageNum", pageNum);
		
		req.setAttribute("detailtitle", "공지사항");
		req.setAttribute("detailmain", "/seller/inquiryList.jsp");
		req.setAttribute("main", "/seller/sellerpage.jsp");
		req.getRequestDispatcher("/layout").forward(req, resp);
	}
	}


