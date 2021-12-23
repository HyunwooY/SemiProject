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

@WebServlet("/member/mjoin")
public class JoinMemberController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("form", "/member/mjoin.jsp");
		req.getRequestDispatcher("/joinlayout").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name=req.getParameter("name");
		String id=req.getParameter("id");
		String pwd=req.getParameter("pwd");
		String email=req.getParameter("email");
		String phone=req.getParameter("first")+"-"+req.getParameter("mid")+"-"+req.getParameter("back");
		String addr=req.getParameter("addr");
		MemberVo vo=new MemberVo(id, pwd, name, email, phone);
		AddressVo avo=new AddressVo(0, id, name, "기본배송지", phone, addr);
		MemberDao dao=MemberDao.getInstance();
		int n=dao.insert(vo)+dao.insertaddr(avo);
		System.out.println(n);
		if(n>1) {
			req.setAttribute("joincode", "success");
			req.setAttribute("main", "result.jsp");
		}else {
			req.setAttribute("joincode", "fail");
			req.setAttribute("main", "result.jsp");
		}
		req.getRequestDispatcher("/layout.jsp").forward(req, resp);
	}
}
