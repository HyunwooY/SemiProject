package chaneloper.seller.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.SellerDao;
import chaneloper.vo.ProductVo;

@WebServlet("/seller/productList")
public class SellerProductListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute(", resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
//		String si_id = (String)req.getSession().getAttribute("id");
//		System.out.println(si_id);
//		SellerDao dao = SellerDao.getInstance();
//		ArrayList<ProductVo> productList = dao.productList(si_id);
//		req.setAttribute("productList", productList);
//		req.setAttribute("main", "/seller/sellerpage.jsp");
		req.getRequestDispatcher("/layout").forward(req, resp);
	}
}
