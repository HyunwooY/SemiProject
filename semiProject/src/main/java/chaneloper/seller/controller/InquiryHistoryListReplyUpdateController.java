package chaneloper.seller.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.Inquiry_historyDao;
import chaneloper.vo.Inquiry_historyVo;

@WebServlet("/seller/inquiryreply")
public class InquiryHistoryListReplyUpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/seller/inquiryListReplyForm.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String ih_answer = req.getParameter("answer");
		Inquiry_historyVo vo = new Inquiry_historyVo(0,null,0,null,null,ih_answer);
		Inquiry_historyDao dao = Inquiry_historyDao.getInstance();
		int n = dao.SellerInquiryUpdate(vo);
		resp.sendRedirect(req.getContextPath() + "/seller/inquiry_history");
		
	}

}
