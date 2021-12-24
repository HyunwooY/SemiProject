package chaneloper.seller.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.ProductDao;

@WebServlet("/seller/productDel")
public class SellerProductDelController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		ProductDao dao = ProductDao.getInstance();
		int pi_num = Integer.parseInt(req.getParameter("pi_num"));
		
		dao.productDel(pi_num);
		resp.sendRedirect(req.getContextPath() + "/seller/productInfoList?pageNum=1");
	}
}
