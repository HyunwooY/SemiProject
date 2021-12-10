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
		String si_id = req.getParameter("si_id");
		String pi_name = req.getParameter("pi_name");
		int pi_price = Integer.parseInt(req.getParameter("pi_price"));
		int pi_sales = Integer.parseInt(req.getParameter("pi_sales"));	

		ProductVo vo = new ProductVo(pi_num, si_id, pi_name, pi_price, pi_sales, null);
		ProductDao dao = ProductDao.getInstance();
		
		int n = dao.productInsert(vo);
		if(n>0) {
			req.setAttribute("productCode", "success");
		} else {
			req.setAttribute("productCode", "faile");
		}
		req.getRequestDispatcher("/seller/productResult.jsp").forward(req, resp);
	}
}
