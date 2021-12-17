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
		MultipartRequest multi = new MultipartRequest(req, path, 1024 * 1024 * 10, "UTF-8",
				new DefaultFileRenamePolicy());
		
		int pi_num = Integer.parseInt(multi.getParameter("pi_num"));
		String si_id = multi.getParameter("si_id");
		String pi_name = multi.getParameter("pi_name");
		int pi_price = Integer.parseInt(multi.getParameter("pi_price"));
		String pd_size = multi.getParameter("pd_size");
		String pd_color = multi.getParameter("pd_color");
		String pi_category = multi.getParameter("pi_category");
		int pd_count = Integer.parseInt(multi.getParameter("pd_count"));
		String pp_title = multi.getOriginalFileName("pp_title");
		String t_name = multi.getParameter("t_name");
		ProductVo vo = new ProductVo(pi_num, si_id, pi_name, pi_price, 0, null, pi_category, pd_size, pd_color, pd_count, pp_title, t_name);
		ProductDao dao = ProductDao.getInstance();		

		int n = dao.productInsert(vo);
		if (n > 0) {
			req.setAttribute("productCode", "success");		
			req.setAttribute("path", path);
			req.setAttribute("detailmain", "productResult.jsp");
			req.setAttribute("main", "/seller/sellerpage.jsp");
		} else {
			req.setAttribute("productCode", "fail");
			req.setAttribute("detailmain", "productResult.jsp");
			req.setAttribute("main", "/seller/sellerpage.jsp");
		}
		req.getRequestDispatcher("/layout.jsp").forward(req, resp);
	}
}
