package chaneloper.contoller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.MemberDao;
import chaneloper.vo.MemberVo;
@WebServlet("/member/modify")
public class MemberModifyController extends HttpServlet{
/*	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id = (String)req.getSession().getAttribute("id");
		String pwd = req.getParameter("pwd");
		MemberDao dao = MemberDao.getInstance();
		MemberVo vo = dao.select(id, pwd);
		if(vo==null) {
			req.setAttribute("result", "fail");
			req.setAttribute("detailmain","/member/mypage.jsp");
			req.getRequestDispatcher("/member/memberDetail").forward(req, resp);
		}else {
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/member/mypage.jsp").forward(req, resp);
		}
	} */
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id = (String)req.getSession().getAttribute("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		
		String saname = req.getParameter("saname");
		String saphone = req.getParameter("saphone");
		String saaddr = req.getParameter("saaddr");
		HashMap<String, String> map = new HashMap<String, String>();
		map.get(saname);
		map.get(saphone);
		map.get(saaddr);
		
		MemberVo vo1 = new MemberVo(id, pwd, name, email, phone);
		MemberDao dao = MemberDao.getInstance();
		int n = dao.update(vo1);
		if(n>0) {
			req.setAttribute("result", "success");
			MemberVo vo = dao.select(id, pwd);
			req.setAttribute("vo", vo);
		}else {
			req.setAttribute("result", "fail");
		}
		req.setAttribute("detailmain","/member/mypage.jsp");
		req.getRequestDispatcher("/member/memberDetail").forward(req, resp);
	}
}
