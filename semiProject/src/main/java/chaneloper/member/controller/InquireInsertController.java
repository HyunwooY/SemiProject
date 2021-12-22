package chaneloper.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.Inquiry_historyDao;
import chaneloper.vo.Inquiry_historyVo;
@WebServlet("/mypage/insertinquiry")
public class InquireInsertController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("detailmain","/member/inquiryInsert.jsp");
		req.getRequestDispatcher("/member/memberDetail").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id = (String)req.getSession().getAttribute("id");
		String title = req.getParameter("title");
		int pi_num = Integer.parseInt(req.getParameter("pi_num"));
		String content = req.getParameter("content");
		
		Inquiry_historyVo vo = new Inquiry_historyVo(0, id, pi_num, title, content, null);
		Inquiry_historyDao dao = Inquiry_historyDao.getInstance();
		int n = dao.inquiryInsert(vo);
		if(n>0) {
			req.setAttribute("code", "success");
		}else {
			req.setAttribute("code", "fail");
		}
		req.setAttribute("detailmain","/member/inquiryInsert.jsp");
		req.getRequestDispatcher("/member/memberDetail").forward(req, resp);
	}
}
