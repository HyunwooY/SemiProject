package chaneloper.seller.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.ProductDao;
import chaneloper.vo.ProductVo;

@WebServlet("/seller/productupdate")
public class ProductUpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		int pi_num = Integer.parseInt(req.getParameter("pi_num"));
		ProductDao dao = ProductDao.getInstance();
		ProductVo vo = new ProductVo();
		if(vo==null) {
			req.setAttribute("result", "fail");
			req.getRequestDispatcher("/seller/layout.jsp").forward(req,resp);
		}else {
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/seller/productList.jsp").forward(req,resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int pi_num = Integer.parseInt(req.getParameter("pi_num"));
		String pi_name=req.getParameter("pi_name");
		int pi_price=Integer.parseInt(req.getParameter("pi_price"));
		String pi_category =req.getParameter("pi_category");
		//String pd_size =req.getParameter("pd_size");
		//String pd_color =req.getParameter("pd_color");
		int pi_count = Integer.parseInt(req.getParameter("pi_count"));
		ProductVo vo = new ProductVo();
		ProductDao dao = ProductDao.getInstance();
		int n=dao.productUpdate(vo);
		if(n > 0) {
			req.setAttribute("productCode", "success");
			req.setAttribute("main", "/seller/productResult.jsp");
		} else {
			req.setAttribute("productCode", "fail");
			req.setAttribute("main", "/seller/productResult.jsp");
		}
		req.getRequestDispatcher("/layout.jsp").forward(req, resp);
	}
}
