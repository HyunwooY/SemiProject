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

@WebServlet("/seller/productUpdate")
public class ProductUpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setAttribute("detailmain", "/seller/sellerProductUpdateForm.jsp");
			req.getRequestDispatcher("/layout.jsp").forward(req, resp);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int pi_num = Integer.parseInt(req.getParameter("pi_num"));
		String pi_name=req.getParameter("pi_name");
		int pi_price=Integer.parseInt(req.getParameter("pi_price"));
		String pi_category =req.getParameter("pi_category");
		String pd_size =req.getParameter("pd_size");
		String pd_color =req.getParameter("pd_color");
		int pi_count = Integer.parseInt(req.getParameter("pi_count"));
		ProductVo vo = new ProductVo(0, null, pi_name, pi_price, pi_count, null, pi_category, pd_size, pd_color, pi_count, pi_category, pi_name);
		
		System.out.println("pi_name:" + pi_name);
		System.out.println("pi_price:" + pi_price);
		System.out.println("pi_category:" + pi_category);
		System.out.println("pd_size:" + pd_size);
		System.out.println("pd_color:" + pd_color);
		System.out.println("pi_count:" + pi_count);
		
		ProductDao dao = ProductDao.getInstance();
		int n=dao.productUpdate(vo);
		if(n > 0) {
			req.setAttribute("productCode", "success");
			req.setAttribute("main", "/seller/productResult.jsp");
			req.setAttribute("detailmain", "productUpdateForm.jsp");
		} else {
			req.setAttribute("productCode", "fail");
			req.setAttribute("main", "/seller/productResult.jsp");
			req.setAttribute("detailmain", "productUpdateForm.jsp");
		}
		
		req.getRequestDispatcher("/layout.jsp").forward(req, resp);
	}
}
