package chaneloper.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.MemberDetailDao;

@WebServlet("/member/change/status")
public class ChangeStatusController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String status=req.getParameter("status");
		String spd_num=req.getParameter("pd_num");
		String sph_num=req.getParameter("ph_num");
		int pd_num=0;
		int ph_num=0;
		if(spd_num!=null) pd_num=Integer.parseInt(spd_num);
		if(sph_num!=null) ph_num=Integer.parseInt(sph_num);
		MemberDetailDao dao=MemberDetailDao.getInstance();
		if(status.equals("cancel")) {
			System.out.println(dao.purchaseCancel(pd_num,ph_num));
			resp.sendRedirect(req.getContextPath()+"/member/showorder");
		}else if(status.equals("change")||status.equals("refund")) {
			req.setAttribute("pd_num", pd_num);
			req.setAttribute("detailtitle", "나의 주문내역");
			req.setAttribute("detailmain", "/member/inquiryInsert.jsp");
			req.getRequestDispatcher("/member/memberDetail").forward(req, resp);
		}else if(status.equals("cancelAll")) {
			dao.purchaseCancelAll(ph_num);
			resp.sendRedirect(req.getContextPath()+"/member/showorder");
		}else if(status.equals("changeAll")||status.equals("refundAll")) {
			req.setAttribute("ph_num", ph_num);
			req.setAttribute("detailtitle", "나의 주문내역");
			req.setAttribute("detailmain", "/member/inquiryInsert.jsp");
		}
		
	}
}









