package chaneloper.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.Inquiry_historyDao;
import chaneloper.vo.Inquiry_historyVo;
@WebServlet("/mypage/insertinquire")
public class InquireInsertController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect(req.getContextPath() + "/member/memberDetail");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id = (String)req.getSession().getAttribute("id");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		Inquiry_historyVo vo = new Inquiry_historyVo(0, id, 0, title, content, null);
		Inquiry_historyDao dao = Inquiry_historyDao.getInstance();
		int n = dao.inquiryInsert(vo);
		if(n>0) {
			req.setAttribute("code", "success");
		}else {
			req.setAttribute("code", "fail");
		}
		req.setAttribute("detailmain","/member/inquiryinsert.jsp");
		req.getRequestDispatcher("/member/memberDetail").forward(req, resp);
	}
}