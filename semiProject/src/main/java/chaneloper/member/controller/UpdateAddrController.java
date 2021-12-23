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
@WebServlet("/member/updateaddr")
public class UpdateAddrController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = (String)req.getSession().getAttribute("id");
		MemberDao dao = MemberDao.getInstance();
		
		String name = req.getParameter("name");
		AddressVo vo = dao.selectaddr(id, name);
		if(vo==null) {
			req.setAttribute("code", "fail");
		}else {
			req.setAttribute("vo", vo);
			req.setAttribute("detailmain", "/member/updateAddress.jsp");
		}
		req.setAttribute("detailtitle", "배송지 수정");
		req.getRequestDispatcher("/member/memberDetail").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id = (String)req.getSession().getAttribute("id");
		int num = Integer.parseInt(req.getParameter("num"));
		String nickname = req.getParameter("addrname");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String addr = req.getParameter("addr");
		AddressVo vo = new AddressVo(num, id, name, nickname, phone, addr);
		MemberDao dao = MemberDao.getInstance();
		int n = dao.updateaddr(vo);
		System.out.println(n);
		if(n>0) {
			req.setAttribute("code", "success"); 
		}else {
			req.setAttribute("code", "fail");
		}
		req.setAttribute("detailmain", "/member/insertAddress.jsp");
		req.setAttribute("detailtitle", "배송지 수정");
		req.getRequestDispatcher("/member/addrmanagement").forward(req, resp);
	}
}
