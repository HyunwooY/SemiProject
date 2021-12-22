package chaneloper.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.InterestDao;
import chaneloper.vo.InterestVo;

@WebServlet("/member/gointerest")
public class GetInterestListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=(String)req.getSession().getAttribute("id");
		InterestDao dao=InterestDao.getInstance();
		ArrayList<InterestVo> list= dao.getInterestList(id);
		req.setAttribute("list", list);
		req.setAttribute("detailmain", "/member/myinterest.jsp");
		req.setAttribute("detailtitle", "찜목록");
		req.getRequestDispatcher("/member/memberDetail").forward(req, resp);
	}
}
