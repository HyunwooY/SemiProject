package chaneloper.member.controller;

import java.io.IOException;

import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/member/mypage")
public class MemberMypageController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("detailmain", "/member/pwdcheck.jsp");
		req.setAttribute("main", "/member/mDetail.jsp");
		req.setAttribute("detailtitle", "비밀번호 입력");
		req.getRequestDispatcher("/member/memberDetail").forward(req, resp);
	}
}
      