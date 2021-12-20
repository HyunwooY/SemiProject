package chaneloper.seller.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.SellerDao;
import chaneloper.vo.SellerVo;

@WebServlet("/seller/checkpwd")
public class SellerPwdCheckController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String si_id = (String) req.getSession().getAttribute("si_id");
		String si_pwd = req.getParameter("si_pwd");
		SellerDao dao = SellerDao.getInstance();
		if (dao.sellerLogin(si_id, si_pwd)) {
			SellerVo vo = dao.sellerSellect(si_id);
			if (vo == null) {
				req.setAttribute("result", "fail");
			} else {
				req.setAttribute("vo", vo);
				req.setAttribute("detailmain", "/seller/sellermypage.jsp");
				req.getRequestDispatcher("/seller/sellerpage").forward(req, resp);
			}
		} else {
			req.setAttribute("result", "fail");
			req.setAttribute("detailmain", "/seller/sellerpwdcheck.jsp");
			req.getRequestDispatcher("/seller/sellerpage").forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("detailmain", "/seller/sellerpwdcheck.jsp");
		req.getRequestDispatcher("/seller/sellerpage").forward(req, resp);
	}
}