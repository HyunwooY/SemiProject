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
@WebServlet("/id/find")
public class FindIdController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("mi_name");
		String email = req.getParameter("mi_email");
		String phone = req.getParameter("mi_phone");
		MemberDao dao = MemberDao.getInstance();
		String id = dao.findId(name, email, phone);
		JSONObject json = new JSONObject();
		if(id!=null) {
			json.put("find", true);
			json.put("mi_id", id);
		}else {
			json.put("find", false);
		}
		resp.setContentType("text/plain;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.print(json);
	}
}
