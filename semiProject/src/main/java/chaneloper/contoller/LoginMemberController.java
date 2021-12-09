package chaneloper.contoller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.MemberDao;

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
		MemberDao dao=MemberDao.getInstance();
		if(dao.login(id, pwd)) {
			req.setAttribute("code", true);
			req.getSession().setAttribute("id", id);
		}else {
			req.setAttribute("code", false);
			req.setAttribute("errMsg", "아이디 혹은 비밀번호가 틀렸습니다.");
		}
		req.getRequestDispatcher("/layout").forward(req, resp);
	}
}








