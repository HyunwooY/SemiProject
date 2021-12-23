package chaneloper.seller.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import chaneloper.dao.ProductDao;
import chaneloper.vo.ProductVo;

@WebServlet("/seller/insert")
public class ProductInsertController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("detailmain", "productInsertForm.jsp");
		req.setAttribute("main", "/seller/sellerpage.jsp");
		req.getRequestDispatcher("/layout.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext application = getServletConfig().getServletContext();		
		String path = application.getRealPath("/upload");
		System.out.println(path);
		String id = (String)req.getSession().getAttribute("id");
		MultipartRequest multi = new MultipartRequest(req, path, 1024 * 1024 * 10, "UTF-8",
				new DefaultFileRenamePolicy());
		
		String pi_name = multi.getParameter("pi_name");
		int pi_price = Integer.parseInt(multi.getParameter("pi_price"));
		
		String pp_title = multi.getFilesystemName("pp_title");
//		System.out.println("title: " + pp_title);
		String t_name = multi.getParameter("t_name");
		String pi_category = multi.getParameter("pi_category");
		
		ProductVo vo1 = new ProductVo(0, id, pi_name, pi_price, 0, null, pi_category, null, null, 0, pp_title, t_name, 0);
		ProductDao dao = ProductDao.getInstance();	
		
		int n = dao.productInsert(vo1);
		
		if (n > 0 ) {
			req.setAttribute("path", path);
			req.setAttribute("detailmain", "productInfoList.jsp");
			req.setAttribute("productCode", "success");
			req.setAttribute("main", "/seller/sellerpage.jsp");
		} else {
			req.setAttribute("productCode", "fail");
			req.setAttribute("detailmain", "productInfoList.jsp");
			req.setAttribute("main", "/seller/sellerpage.jsp");
		}
		System.out.println("pi_num:" + n);
		String[] pd_size = multi.getParameterValues("pd_size");
		String[] pd_color = multi.getParameterValues("pd_color");
		
		int pd_count = Integer.parseInt(multi.getParameter("pd_count"));		
		
		for(String size:pd_size) {
			for(String color:pd_color) {
					ProductVo vo2 = new ProductVo(0, null, null, 0, 0, null, null, size, color, pd_count, null, null, 0);
					dao.productInsertDetail(n,vo2);
			}
		}
		resp.sendRedirect(req.getContextPath() + "/seller/productInfoList?pageNum=1");
	}
}
