package chaneloper.contoller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.MemberDao;
import chaneloper.vo.MemberVo;
@WebServlet("/member/modify")
public class MemberModifyController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("mi_id");
		String pwd = req.getParameter("mi_pwd");
		MemberDao dao = MemberDao.getInstance();
		MemberVo vo = dao.select(id, pwd);
		if(vo==null) {
			req.setAttribute("result","fail");
			req.getRequestDispatcher("/member/modifyResult.jsp").forward(req, resp);
		}else {
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/member/modifyForm.jsp").forward(req, resp);
		}	
	} 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("mi_id");
		String pwd = req.getParameter("mi_pwd");
		String name = req.getParameter("mi_name");
		String email = req.getParameter("mi_email");
		String phone = req.getParameter("mi_phone");
		MemberVo vo = new MemberVo(id, pwd, name, email, phone);
		MemberDao dao = MemberDao.getInstance();
		int n = dao.update(vo);
		if(n>0) {
			req.setAttribute("result", "success");
		}else {
			req.setAttribute("result", "fail");
		}
		req.getRequestDispatcher("/member/modifyForm.jsp").forward(req, resp);
	}
}
