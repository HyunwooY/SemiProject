package chaneloper.seller.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/seller/sellermypage")
public class SellerMypageController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("detailmain", "/seller/sellerpwdcheck.jsp");
		req.setAttribute("main", "/seller/sellerpage.jsp");
		
		req.getRequestDispatcher("/layout.jsp").forward(req, resp);
	}
}
