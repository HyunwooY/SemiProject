package chaneloper.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.ReviewDao;
import chaneloper.vo.ReviewVo;
@WebServlet("/mypage/deletereview")
public class DeleteReviewController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num = Integer.parseInt(req.getParameter("r_num"));
		ReviewDao dao = ReviewDao.getInstance();
		dao.ReviewDelete(num);
		
		req.setAttribute("detailmain", "/member/reviewList.jsp");
		req.setAttribute("detailtitle", "나의 리뷰");
		req.getRequestDispatcher("/member/memberDetail").forward(req, resp);
	}
}
