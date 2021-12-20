//package chaneloper.seller.controller;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import chaneloper.dao.ProductDao;
//import chaneloper.vo.ProductVo;
//
//@WebServlet("/seller/detail")
//public class ProductDetailController extends HttpServlet{
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setAttribute("detailmain", "productDetailForm.jsp");
//		req.setAttribute("main", "/seller/sellerpage.jsp");
//		req.getRequestDispatcher("/layout.jsp").forward(req, resp);
//	}
//	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
//		
//		
//		int pi_num = Integer.parseInt(req.getParameter("pi_num"));
//		String pd_size = req.getParameter("pd_size");
//		String pd_color = req.getParameter("pd_color");
//		int pd_count = Integer.parseInt(req.getParameter("pd_count"));
//		
//		ProductVo vo = new ProductVo(pi_num, null, null, 0, 0, null, null, pd_size, pd_color, pd_count, null, null);
//		ProductDao dao = ProductDao.getInstance();
//		
//		int n = dao.productInsertDetail(vo);
//		if (n > 0) {
//			req.setAttribute("productCode", "success");
//			req.setAttribute("detailmain", "productResult.jsp");
//			req.setAttribute("main", "/seller/sellerpage.jsp");
//		} else {
//			req.setAttribute("productCode", "fail");
//			req.setAttribute("detailmain", "productResult.jsp");
//			req.setAttribute("main", "/seller/sellerpage.jsp");
//		}
//		req.getRequestDispatcher("/layout.jsp").forward(req, resp);
//		
//	}
//}
