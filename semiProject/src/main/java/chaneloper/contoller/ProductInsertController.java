package chaneloper.contoller;

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
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setAttribute("main", "/seller/productResult.jsp");
//	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		int pi_num = Integer.parseInt(req.getParameter("pi_num"));
		String si_id = req.getParameter("si_id");
		String pi_name = req.getParameter("pi_name");
		int pi_price = Integer.parseInt(req.getParameter("pi_price"));
		int pi_count = Integer.parseInt(req.getParameter("pi_count"));	
		String pi_category = req.getParameter("pi_category");
		String pp_title = req.getParameter("pp_title");
		
		MultipartRequest multi = new MultipartRequest(req, "D:\\2107\\SemiProject\\semiProject\\src\\main\\webapp\\images", 5*1024*1024, "utf-8",
								new DefaultFileRenamePolicy());
		
		String filename = multi.getFilesystemName(pp_title);
		
		
		ProductVo vo = new ProductVo();
		ProductDao dao = ProductDao.getInstance();
		
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
