package chaneloper.seller.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.Inquiry_historyDao;
@WebServlet("/Inquiry_historydelete")
public class InquiryHistoryListDelete extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int ih_num=Integer.parseInt(req.getParameter("ih_num"));
		Inquiry_historyDao dao=new Inquiry_historyDao();
		int n=dao.delete(ih_num);
		if(n>0) {
			resp.sendRedirect(req.getContextpath() + "/inquiryList");
		}else {
			req.setAttribute("result", "fail");
			req.getRequestDispatcher("/seller/result.jsp").forward(req, resp);
		}
	}

}
