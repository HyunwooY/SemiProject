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
		System.out.println("....." + req.getParameter("ih_num"));
		int ih_num = Integer.parseInt(req.getParameter("ih_num"));
		Inquiry_historyDao dao=new Inquiry_historyDao();
		Inquiry_historyVo vo=dao.select(ih_num);
		if(vo==null) {
			req.setAttribute("result","fail");
			req.getRequestDispatcher("/seller/inquirList.jsp").forward(req, resp);
		}else {
			req.setAttribute("vo", vo);
			req.setAttribute("main", "/seller/inquiryListReplyForm.jsp");
			req.getRequestDispatcher("/layout.jsp").forward(req,resp);
			// req.getRequestDispatcher("/seller/inquiryListReplyForm.jsp").forward(req, resp);
		}	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int ih_num = Integer.parseInt(req.getParameter("ih_num"));
		String ih_answer = req.getParameter("answer");
		Inquiry_historyVo vo = new Inquiry_historyVo(ih_num,null,0,null,null,ih_answer);
		Inquiry_historyDao dao = Inquiry_historyDao.getInstance();
		int n = dao.SellerInquiryUpdate(vo);
		resp.sendRedirect(req.getContextPath() + "/seller/inquiryList");
		
	}

}
