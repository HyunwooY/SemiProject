package chaneloper.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.Inquiry_historyDao;
import chaneloper.vo.Inquiry_historyVo;
@WebServlet("/mypage/history")
public class InquiryHistoryController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String spageNum = req.getParameter("pageNum");
		
		int pageNum = 1;
		if(spageNum!=null) {
			pageNum = Integer.parseInt(spageNum);
		}
		
		int startRow = (pageNum-1)*10+1;
		int endRow = startRow+9;
		
		Inquiry_historyDao dao = Inquiry_historyDao.getInstance();
		dao.list(startRow, endRow);
		
		ArrayList<Inquiry_historyVo> list = dao.list(startRow, endRow);
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
		req.setAttribute("detailmain", "/member/myInquiryHistory.jsp");
		req.getRequestDispatcher("/member/memberDetail").forward(req, resp);
	}
}
