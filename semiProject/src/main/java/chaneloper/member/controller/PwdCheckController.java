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
import chaneloper.vo.AddressVo;
import chaneloper.vo.MemberVo;
@WebServlet("/member/checkpwd")
public class PwdCheckController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id = (String)req.getSession().getAttribute("id");
		String pwd = req.getParameter("pwd");
		MemberDao dao = MemberDao.getInstance();
		if(dao.login(id, pwd)) {
			MemberVo vo = dao.select(id);
			if(vo==null) {
				req.setAttribute("result", "fail");
			}else {
				req.setAttribute("vo", vo);
				AddressVo addrvo = dao.selectaddr(id, vo.getName());
				req.setAttribute("addrvo",addrvo);
				req.setAttribute("detailmain","/member/mypage.jsp");
				req.setAttribute("detailtitle", "내 정보");
				req.getRequestDispatcher("/member/memberDetail").forward(req, resp);
			}
		}else {
			req.setAttribute("result", "fail");
			req.setAttribute("detailmain", "/member/pwdcheck.jsp");
			
			req.getRequestDispatcher("/member/memberDetail").forward(req, resp);
		}
	}            
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("detailmain", "/member/pwdcheck.jsp");
		req.getRequestDispatcher("/member/memberDetail").forward(req, resp);
/*		JSONObject json = new JSONObject();
		if(dao.login(id, pwd)) {
			json.put("check", true);
		}else {
			json.put("check", false);
		}	
		PrintWriter pw = resp.getWriter();
		pw.print(json); */
	}
}
