package chaneloper.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.MemberDao;
import chaneloper.vo.AddressVo;

@WebServlet("/member/insertaddr")
public class InsertAddrController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("detailmain", "/member/insertAddress.jsp");
		req.getRequestDispatcher("/member/memberDetail").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String nickname = req.getParameter("nickname");
		String id = (String)req.getSession().getAttribute("id");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		AddressVo vo = new AddressVo(nickname, id, name, phone, email);
		MemberDao dao = MemberDao.getInstance();
		int n = dao.insertaddr(vo);
		if(n>0) {
			req.setAttribute("result", "success"); 
			req.setAttribute("detailmain", "/member/insertAddress.jsp");
		}else {
			req.setAttribute("result", "fail");
			req.setAttribute("detailmain", "/member/insertAddress.jsp");
		}
		req.getRequestDispatcher("/member/memberDetail").forward(req, resp);
	}
}
