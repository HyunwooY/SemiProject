package chaneloper.contoller;
 
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import chaneloper.dao.MemberDao;
@WebServlet("/pwd/find")
public class FindPwdController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("main", "/member/findpwd.jsp");
		req.getRequestDispatcher("/layout").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("mi_id");
		String email = req.getParameter("mi_email");
		MemberDao dao = MemberDao.getInstance();
		String pwd = dao.findPwd(id, email);
		if(pwd!=null) {
			req.setAttribute("find", true);
			req.setAttribute("pwd", pwd);
		}else{
			req.setAttribute("find", false);
			req.setAttribute("errMsg", "입력한 회원 아이디가 없습니다.");
		}
		req.getRequestDispatcher("/layout").forward(req, resp);
	}
}
