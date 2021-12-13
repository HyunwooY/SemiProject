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
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("detailmain", "/member/modifyForm.jsp");
		req.setAttribute("main", "/member/mDetail.jsp");
//		req.setAttribute("detailtitle", "내 정보");
		
		req.getRequestDispatcher("/member/memberDetail").forward(req, resp);
	}
}
