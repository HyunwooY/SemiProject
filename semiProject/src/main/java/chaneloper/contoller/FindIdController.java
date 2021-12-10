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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("main", "/member/findid.jsp");
		req.getRequestDispatcher("/layout").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("mi_name");
		String email = req.getParameter("mi_email");
		String phone = req.getParameter("mi_phone");
		MemberDao dao = MemberDao.getInstance();
		String id = dao.findId(name, email, phone);
		if(id!=null) {
			req.setAttribute("find", true);
			req.setAttribute("id", id);
		}else{
			req.setAttribute("find", false);
			req.setAttribute("errMsg", "입력한 회원정보가 없습니다.");
		}
		req.getRequestDispatcher("/layout").forward(req, resp);
	}
}