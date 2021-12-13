package chaneloper.contoller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.MemberDao;
@WebServlet("/checkpwd")
public class PwdCheckController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id = (String)req.getSession().getAttribute("id");
		String pwd = req.getParameter("pwd");
		MemberDao dao = MemberDao.getInstance();
		if(dao.login(id, pwd)) {
			req.setAttribute("check", true);
		}else {
			req.setAttribute("check", false);
		}	
		req.getRequestDispatcher("/layout").forward(req, resp);
	}
}
