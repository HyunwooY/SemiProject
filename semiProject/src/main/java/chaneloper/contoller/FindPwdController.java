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
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("mi_id");
		String email = req.getParameter("mi_email");
		MemberDao dao = MemberDao.getInstance();
		String pwd = dao.findPwd(id, email);
		JSONObject json = new JSONObject();
		if(pwd!=null) {
			json.put("find", true);
			json.put("mi_pwd", pwd);
		}else {
			json.put("find", false);
		}
		resp.setContentType("text/plain;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.print(json);
	}
}
