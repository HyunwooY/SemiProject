package chaneloper.seller.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.SellerDao;

@WebServlet("/seller/sellerpage")
public class SellerPageController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=(String)req.getSession().getAttribute("id");
		SellerDao dao = SellerDao.getInstance();
		
		req.setAttribute("main", "/seller/sellerpage.jsp");
		req.getRequestDispatcher("/layout.jsp").forward(req, resp);
	}
}
