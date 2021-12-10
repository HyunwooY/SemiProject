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
import chaneloper.dao.SellerDao;
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
		String radio = req.getParameter("type");
		if(radio.equals("일반사용자")) {
			String id = req.getParameter("id");
			String email = req.getParameter("email");
			MemberDao dao = MemberDao.getInstance();
			String pwd = dao.findPwd(id, email);
			JSONObject json = new JSONObject();
			if(pwd!=null) {
				json.put("find", true);
				json.put("pwd", pwd);
			}else{
				json.put("find", false);
			}
			resp.setContentType("text/plain;charset=utf-8");
			PrintWriter pw = resp.getWriter();
			pw.print(json);
		}else if(radio.equals("판매사업자")) {
			String num = req.getParameter("si_num");
			String email = req.getParameter("email");
			SellerDao dao = SellerDao.getInstance();
			String mi_pwd = dao.sellerFindPwd(num, email);
			JSONObject json = new JSONObject();
			if(mi_pwd!=null) {
				json.put("find", true);
				json.put("pwd", mi_pwd);
			}else {
				json.put("find", false);
			}
		}
	}
}
