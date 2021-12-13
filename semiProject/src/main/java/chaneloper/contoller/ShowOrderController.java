package chaneloper.contoller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/showorder")
public class ShowOrderController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("detailmain", "/member/showOrder.jsp");
		req.setAttribute("main", "/member/mDetail.jsp");
		req.setAttribute("detailtitle", "나의 주문내역");
		req.getRequestDispatcher("/member/memberDetail").forward(req, resp);
	}
}
