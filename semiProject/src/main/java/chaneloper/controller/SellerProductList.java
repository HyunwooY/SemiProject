package chaneloper.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.ProductDao;
import chaneloper.vo.ProductVo;

@WebServlet("/seller/productList")
public class SellerProductList extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");		
		
		String si_id = req.getParameter("si_id");

		ProductDao dao = ProductDao.getInstance();
		ArrayList<ProductVo> list = dao.selectList(si_id);

		req.setAttribute("list", list);
		req.getRequestDispatcher("/seller/productList.jsp").forward(req, resp);
	}
}
