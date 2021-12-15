package chaneloper.member.controller;
 
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
		String radio = req.getParameter("type");
		if(radio.equals("일반사용자")) {
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			MemberDao dao = MemberDao.getInstance();
			String id = dao.findId(name, email);
			JSONObject json = new JSONObject();
			if(id!=null) {
				json.put("find", true);
				json.put("id", id);
			}else{
				json.put("find", false);
			}
			resp.setContentType("text/plain;charset=utf-8");
			PrintWriter pw = resp.getWriter();
			pw.print(json);
		}else if(radio.equals("판매사업자")) {
			String num = req.getParameter("si_num");
			String phone = req.getParameter("mi_phone");
			String email = req.getParameter("mi_email");
			SellerDao dao = SellerDao.getInstance();
			String si_id = dao.sellerFindId(num, phone, email);
			JSONObject json = new JSONObject();
			if(si_id!=null) {
				json.put("find", true);
				json.put("id", si_id);
			}else {
				json.put("find", false);
			}
			resp.setContentType("text/plain;charset=utf-8");
			PrintWriter pw = resp.getWriter();
			pw.print(json);
		}
	}
}