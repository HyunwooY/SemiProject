package chaneloper.seller.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.OrderListDao;
import chaneloper.vo.OrderListVo;

@WebServlet("/seller/orderListAll")
public class OrderListController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		OrderListDao dao = OrderListDao.getInstance();
		ArrayList<OrderListVo> listAll = dao.orderListAll();
		
		req.setAttribute("listAll", listAll);
		req.setAttribute("main", "/seller/sellerShowOrderList.jsp");
		req.getRequestDispatcher("/layout.jsp").forward(req, resp);
	}
}
