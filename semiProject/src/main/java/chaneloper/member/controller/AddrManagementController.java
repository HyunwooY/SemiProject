package chaneloper.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.MemberDao;
import chaneloper.vo.AddressVo;
import chaneloper.vo.MemberVo;
@WebServlet("/member/addrmanagement")
public class AddrManagementController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("utf-8");
		String id = (String)req.getSession().getAttribute("id");
		MemberDao dao = MemberDao.getInstance();
		ArrayList<AddressVo> list = dao.addrList(id);
		req.setAttribute("list", list);
		
		req.setAttribute("detailmain", "/member/insertAddress.jsp");
		req.setAttribute("main", "/member/mDetail.jsp");
		req.setAttribute("detailtitle", "배송지 관리");
		req.getRequestDispatcher("/member/memberDetail").forward(req, resp);
	}
}
