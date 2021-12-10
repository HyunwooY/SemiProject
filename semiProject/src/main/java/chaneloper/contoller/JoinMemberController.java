package chaneloper.contoller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.MemberDao;
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
		MemberVo vo=new MemberVo(id, pwd, name, email, phone);
		   
		MemberDao dao=MemberDao.getInstance();
		int n=dao.insert(vo);
		if(n>0) {
			req.setAttribute("joincode", "success");
		}else {
			req.setAttribute("joincode", "fail");
		}
		req.getRequestDispatcher("/layout").forward(req, resp);
	}
}
