package chaneloper.contoller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.MemberDetailDao;
import chaneloper.vo.OrderHistoryVo;

@WebServlet("/member/showorder")
public class ShowOrderController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=(String)req.getSession().getAttribute("id");
		MemberDetailDao dao=MemberDetailDao.getInstance();
		ArrayList<OrderHistoryVo> list=dao.showOrder(id);
		req.setAttribute("list", list);
		req.setAttribute("detailmain", "/member/showOrder.jsp");
		req.setAttribute("detailtitle", "나의 주문내역");
		req.getRequestDispatcher("/member/memberDetail").forward(req, resp);
	}
}









