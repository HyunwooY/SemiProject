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
		int n = dao.deleteaddr(id, addr);
		if(n>0) {
			req.setAttribute("result", "success");
		}else {
			req.setAttribute("result", "fail");
		}
		req.setAttribute("detailmain", "/member/insertAddress.jsp");
		req.getRequestDispatcher("/member/memberDetail").forward(req, resp);
	}
}
