package chaneloper.seller.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.NoticeDao;
import chaneloper.vo.NoticeVo;
@WebServlet("/seller/notice1")
public class NoticeInsert extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("main", "/seller/noticeForm.jsp");
		req.getRequestDispatcher("/layout.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String context = req.getParameter("content");
		NoticeVo vo = new NoticeVo(0,context);
		NoticeDao dao = NoticeDao.getInstance();
		int n = dao.NoticeInsert(vo);
		req.setAttribute("main","/seller/notice.jsp");
		//req.getRequestDispatcher("/layout.jsp").forward(req,resp);
		resp.sendRedirect(req.getContextPath() + "/seller/notice");
		
	}

}
