package chaneloper.seller.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.ProductDao;
import chaneloper.vo.ProductVo;

@WebServlet("/seller/listAll")
public class ProductListAllController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		ProductDao dao = ProductDao.getInstance();
		ArrayList<ProductVo> list = dao.listAll();
		
		req.setAttribute("list", list);
		req.setAttribute("main", "/seller/productListAll.jsp");
		req.getRequestDispatcher("/layout.jsp").forward(req, resp);
	}
}
