package chaneloper.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.MemberDao;
import chaneloper.vo.AddressVo;
import chaneloper.vo.MemberVo;

@WebServlet("/member/buyProduct")
public class PayinfoController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=(String)req.getSession().getAttribute("id");
		String pi_num=(String)req.getAttribute("pi_num");
		MemberDao dao=MemberDao.getInstance();
		MemberVo membervo=dao.select(id);
		AddressVo addressvo=dao.selectaddr(id, membervo.getName());
		req.setAttribute("vo", membervo);
		req.setAttribute("avo", addressvo);
		req.setAttribute("main", "/member/buyProduct.jsp");
		req.getRequestDispatcher("/layout.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("main", "/member/buyProduct.jsp");
		req.getRequestDispatcher("/layout.jsp").forward(req, resp);
	}
}











