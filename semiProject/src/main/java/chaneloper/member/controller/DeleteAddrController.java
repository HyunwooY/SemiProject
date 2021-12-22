package chaneloper.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.MemberDao;
@WebServlet("/member/deleteaddr")
public class DeleteAddrController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = (String)req.getSession().getAttribute("id");
		String addr = req.getParameter("addr");
		MemberDao dao = MemberDao.getInstance();
		dao.deleteaddr(id, addr);
		req.setAttribute("detailmain", "/member/insertAddress.jsp");
		req.getRequestDispatcher("/member/addrmanagement").forward(req, resp);
	}
}
