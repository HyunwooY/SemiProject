package chaneloper.contoller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.SellerDao;
import chaneloper.vo.SellerVo;

@WebServlet("/seller/sjoin")
public class JoinSellerController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("form", "/seller/sjoin.jsp");
		req.getRequestDispatcher("/joinlayout").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id=req.getParameter("id");
		String pwd=req.getParameter("pwd");
		String name=req.getParameter("name");
		String snum=req.getParameter("snum");
		String saddr=req.getParameter("saddr");
		String email=req.getParameter("email");
		String phone=req.getParameter("first")+"-"+req.getParameter("mid")+"-"+req.getParameter("back");
		SellerVo vo=new SellerVo(id, pwd, snum, saddr, phone, name, email);
		SellerDao dao=SellerDao.getInstance();
		int n=dao.sellerInsert(vo);
		if(n>0) {
			req.setAttribute("code", "success");
		}else {
			req.setAttribute("code", "fail");
		}
		req.getRequestDispatcher("/layout").forward(req, resp);
	}
}












