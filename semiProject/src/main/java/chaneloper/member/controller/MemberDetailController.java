package chaneloper.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.MemberDetailDao;

@WebServlet("/member/memberDetail")
public class MemberDetailController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=(String)req.getSession().getAttribute("id");
		MemberDetailDao dao=MemberDetailDao.getInstance();
		int aPayCom=dao.aPayCom(id);
		int bPayCom=dao.bPayCom(id);
		int preparingP=dao.preparingP(id);
		int beingDelivery=dao.beingDelivery(id);
		int compDelivery=dao.compDelivery(id);
		int cancel=dao.cancel(id);
		int refund=dao.refund(id);
		int change=dao.change(id);
		req.setAttribute("aPayCom", aPayCom);
		req.setAttribute("bPayCom", bPayCom);
		req.setAttribute("preparingP", preparingP);
		req.setAttribute("beingDelivery", beingDelivery);
		req.setAttribute("compDelivery", compDelivery);
		req.setAttribute("cancel", cancel);
		req.setAttribute("refund", refund);
		req.setAttribute("change", change);
		req.setAttribute("main", "/member/mDetail.jsp");
		req.getRequestDispatcher("/layout.jsp").forward(req, resp);
	}
}
