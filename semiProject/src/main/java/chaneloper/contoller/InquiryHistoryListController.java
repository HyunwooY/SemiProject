package chaneloper.contoller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.Inquiry_historyDao;
import chaneloper.vo.Inquiry_historyVo;

@WebServlet("/seller/inquiryList")
public class InquiryHistoryListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		 int ih_num = Integer.parseInt(req.getParameter("ih_num"));
		 String mi_id = req.getParameter("mi_id");
		 int pi_num = Integer.parseInt(req.getParameter("pi_num"));
		 String ih_title = req.getParameter("ih_title");
		 String ih_question = req.getParameter("ih_question");
		 String ih_answer = req.getParameter("ih_answer");
		
		
		Inquiry_historyVo vo = new Inquiry_historyVo(ih_num, mi_id, pi_num, ih_title, ih_question, ih_answer);
		Inquiry_historyDao dao = Inquiry_historyDao.getInstance();		
		
		
		req.getRequestDispatcher("/seller/inquiryList.jsp").forward(req, resp);
	}
}
