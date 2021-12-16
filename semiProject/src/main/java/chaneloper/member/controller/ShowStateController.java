package chaneloper.member.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.MemberDetailDao;
import chaneloper.vo.OrderHistoryVo;

@WebServlet("/member/showstate")
public class ShowStateController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=(String)req.getSession().getAttribute("id");
		String sStart=req.getParameter("start");
		String sEnd=req.getParameter("end");
		Date start=null;
		Date end=null;
		Calendar c=Calendar.getInstance();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		if(sStart==null||sEnd==null) {
			end=Date.valueOf(sdf.format(c.getTime()));
			c.add(Calendar.MONTH, -3);
			start=Date.valueOf(sdf.format(c.getTime()));
		}else {
			start=Date.valueOf(sStart);
			end=Date.valueOf(sEnd);
		}
		MemberDetailDao dao=MemberDetailDao.getInstance();
		ArrayList<OrderHistoryVo> list=dao.showState(id,start,end);
		req.setAttribute("list", list);
		req.setAttribute("start", start);
		req.setAttribute("end", end);
		req.setAttribute("detailmain", "/member/showState.jsp");
		req.setAttribute("main", "/member/mDetail.jsp");
		req.setAttribute("detailtitle", "반품/교환/취소내역");
		req.getRequestDispatcher("/member/memberDetail").forward(req, resp);
	}
}
