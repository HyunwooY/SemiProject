package chaneloper.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.MemberDao;
import chaneloper.dao.SellerDao;

@WebServlet("/member/login")
public class LoginMemberController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("main", "/member/login.jsp");
		req.getRequestDispatcher("/layout").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id=req.getParameter("id");
		String pwd=req.getParameter("pwd");
		String radio=req.getParameter("type");
		String check=(String)req.getSession().getAttribute("backp");
		if(check==null) {
			check="";
		}
		System.out.println(check);
		if(radio.equals("일반사용자")) {
			MemberDao dao=MemberDao.getInstance();
			if(dao.login(id, pwd)) {
				req.setAttribute("lcode", true);
				req.getSession().setAttribute("radio", radio);
				req.getSession().setAttribute("id", id);
			}else {
				req.setAttribute("lcode", false);
				req.setAttribute("errMsg", "아이디 혹은 비밀번호가 틀렸습니다."); 
			}
			if(check.equals("go")) {
				resp.sendRedirect(req.getContextPath()+"/member/buyProduct?count="+req.getSession().getAttribute("count")
								+"&pi_num="+req.getSession().getAttribute("pi_num")+req.getSession().getAttribute("parame"));
			}else {
				req.getRequestDispatcher("/layout").forward(req, resp);
			}
			
		}else if(radio.equals("판매사업자")) {
			SellerDao dao=SellerDao.getInstance();
			if(dao.sellerLogin(id, pwd)) {
				req.setAttribute("lcode", true);
				req.getSession().setAttribute("radio", radio);
				req.getSession().setAttribute("id", id);
			}else {
				req.setAttribute("lcode", false);
				req.setAttribute("errMsg", "아이디 혹은 비밀번호가 틀렸습니다."); 
			}
			req.getRequestDispatcher("/layout").forward(req, resp);
		}		
	}
}








