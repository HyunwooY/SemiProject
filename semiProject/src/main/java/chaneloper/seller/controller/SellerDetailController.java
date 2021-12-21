package chaneloper.seller.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.SellerDao;
import chaneloper.vo.SellerVo;

@WebServlet("/seller/modify")
public class SellerDetailController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String si_id = (String)req.getSession().getAttribute("si_id");
		String si_pwd = req.getParameter("si_pwd");
		String si_num = req.getParameter("si_num");
		String si_addr = req.getParameter("si_addr");
		String si_phone = req.getParameter("si_phone");
		String si_name = req.getParameter("si_name");
		String si_email = req.getParameter("si_email");
		
		 SellerVo vo1 = new SellerVo(si_id, si_pwd, si_num, si_addr, si_phone, si_name, si_email);
		 SellerDao dao = SellerDao.getInstance();
		 
		 int n = dao.sellerUpdate(vo1);
		 
		 if(n > 0) {
			 req.setAttribute("productCode", "success");
			 req.setAttribute("detailmain", "/seller/productResult.jsp");
			 SellerVo vo = dao.sellerSellect(si_id);
		 } else {
			 req.setAttribute("productCode", "fail");
			 req.setAttribute("detailmain", "/seller/productResult.jsp");
		 }
		 req.getRequestDispatcher("/layout.jsp").forward(req, resp);
	}
	
}
