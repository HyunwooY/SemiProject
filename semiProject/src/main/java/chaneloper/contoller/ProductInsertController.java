package chaneloper.contoller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.ProductDao;
import chaneloper.vo.ProductVo;

@WebServlet("/seller/insert")
public class ProductInsertController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		int pi_num = Integer.parseInt(req.getParameter("pi_num"));
		String pi_name = req.getParameter("pi_name");
		int pi_price = Integer.parseInt(req.getParameter("pi_price"));
		String pi_category = req.getParameter("pi_category");
		String pi_size = req.getParameter("pi_size");
		String pi_color = req.getParameter("pi_color");
		int pi_count = Integer.parseInt(req.getParameter("pd_count"));
		Date pi_regdate = req.getParameter("pi_regdate");

		ProductVo vo = new ProductVo(pi_num, pi_name, pi_price, null , pi_size, pi_color, pd_count, pi_regdate);
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
