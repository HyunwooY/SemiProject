package chaneloper.seller.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.ProductDao;
import chaneloper.dao.SellerDao;
import chaneloper.vo.ProductVo;

@WebServlet("/productDelete")
public class ProductDeleteController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
//		String si_id = (String)req.getSession().getAttribute("id");
		int pi_num = Integer.parseInt(req.getParameter("pi_num"));	
		
		
		
		
		int pd_num = Integer.parseInt(req.getParameter("pd_num"));	
		
		ProductDao dao = ProductDao.getInstance();
		
//		SellerDao dao1 = SellerDao.getInstance();
//		ArrayList<ProductVo> productList = dao1.productList(si_id, pi_num, 0, 0);	
		
		dao.productDelete(0, pd_num);
		
		
		

		resp.sendRedirect(req.getContextPath() + "/seller/producDetailtList?pi_num=" + pi_num);
	}
}
