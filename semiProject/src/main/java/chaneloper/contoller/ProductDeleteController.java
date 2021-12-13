package chaneloper.contoller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.ProductDao;
import chaneloper.vo.ProductVo;

@WebServlet("/seller/delete")
public class ProductDeleteController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		int pi_num = Integer.parseInt(req.getParameter("pi_num"));	
		
		ProductDao dao = ProductDao.getInstance();
		
		int n= dao.productDelete(pi_num);
		if(n>0) {
			req.setAttribute("productcode", "success");
			req.setAttribute("main", "/seller/productResult.jsp");
		}else {
			req.setAttribute("productcode", "fail");
			req.setAttribute("main", "/seller/productResult.jsp");
		}
		req.getRequestDispatcher("../layout.jsp").forward(req, resp);
	}
}
