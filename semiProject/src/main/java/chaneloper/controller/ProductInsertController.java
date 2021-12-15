package chaneloper.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.sql.Date;

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
public class ProductInsertController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		int pi_num = Integer.parseInt(req.getParameter("pi_num"));
		String si_id = req.getParameter("si_id");
		String pi_name = req.getParameter("pi_name");
		int pi_price = Integer.parseInt(req.getParameter("pi_price"));	
		String pd_size = req.getParameter("pd_size");
		String pd_color = req.getParameter("pd_color");

		String pi_category = req.getParameter("pi_category");
		String pi_size = req.getParameter("pi_size");
		String pi_color = req.getParameter("pi_color");
		
		int pd_count = Integer.parseInt(req.getParameter("pd_count"));	
		
		
		String pp_title = req.getParameter("pp_title");

		ProductVo vo = new ProductVo(pi_num, si_id, pi_name, pi_price, 0, null, pi_category, pd_size, pd_color, pd_count, pp_title);
		ProductDao dao = ProductDao.getInstance();	
		
		
//		MultipartRequest multi = new MultipartRequest(req, "D:\\2107\\SemiProject\\images", 5*1024*1024, "utf-8",
//								new DefaultFileRenamePolicy());		
//		String filename = multi.getFilesystemName(pp_title);		
		
		
		int n = dao.productInsert(vo);
		if(n>0) {
			req.setAttribute("productCode", "success");
			req.setAttribute("main", "/seller/productResult.jsp");
		} else {
			req.setAttribute("productCode", "fail");
			req.setAttribute("main", "/seller/productResult.jsp");
		}
		
		req.getRequestDispatcher("/layout.jsp").forward(req, resp);
	}
}
