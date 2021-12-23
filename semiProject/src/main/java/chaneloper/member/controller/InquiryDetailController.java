package chaneloper.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.Inquiry_historyDao;
import chaneloper.vo.Inquiry_historyVo;
@WebServlet("/mypage/ihdetail")
public class InquiryDetailController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num = Integer.parseInt(req.getParameter("ih_num"));
		Inquiry_historyDao dao = new Inquiry_historyDao();
		Inquiry_historyVo vo = dao.select(num);
		req.setAttribute("vo", vo);
		req.setAttribute("detailmain", "/member/inquiryDetail.jsp");
		req.setAttribute("detailtitle", "나의 문의내역");
		req.getRequestDispatcher("/member/memberDetail").forward(req, resp);
	}
}
