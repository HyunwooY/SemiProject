package chaneloper.seller.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.Inquiry_historyDao;
import chaneloper.vo.Inquiry_historyVo;
@WebServlet("/inquirydetail")
public class InquiryHistoryListDetail extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		int num = Integer.parseInt(req.getParameter("ih_num"));
		Inquiry_historyDao dao = new Inquiry_historyDao();
		Inquiry_historyVo vo = dao.select(num);
		req.setAttribute("vo", vo);
		req.setAttribute("main", "/seller/test.jsp");
		req.getRequestDispatcher("/layout.jsp").forward(req,resp);
	}
}
