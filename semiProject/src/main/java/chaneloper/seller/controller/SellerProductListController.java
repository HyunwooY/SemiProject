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
public class SellerProductListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");		
		
		String si_id = req.getParameter("si_id");

		SellerDao dao = SellerDao.getInstance();
		ArrayList<ProductVo> list = dao.productList(si_id);

		req.setAttribute("list", list);
		req.getRequestDispatcher("/seller/productList.jsp").forward(req, resp);
	}
}
