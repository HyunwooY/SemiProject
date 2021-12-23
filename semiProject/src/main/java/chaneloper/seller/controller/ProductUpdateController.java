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
		String pi_name=req.getParameter("pi_name");
		int pi_price=Integer.parseInt(req.getParameter("pi_price"));
		String pi_category =req.getParameter("pi_category");
		String pd_size =req.getParameter("pd_size");
		String pd_color =req.getParameter("pd_color");
		int pd_count = Integer.parseInt(req.getParameter("pd_count"));
		String pp_title = req.getParameter("pp_title");
		String t_name = req.getParameter("t_name");
		
		ProductVo vo = new ProductVo(0, null, pi_name, pi_price, 0, null, pi_category, pd_size, pd_color, pd_count, pp_title, t_name);
		
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
