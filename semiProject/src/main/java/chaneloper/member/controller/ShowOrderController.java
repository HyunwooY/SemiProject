package chaneloper.member.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

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
		req.setCharacterEncoding("utf-8");
		String id=(String)req.getSession().getAttribute("id");
		String sStart=req.getParameter("start");
		String sEnd=req.getParameter("end");
		Date start=null;
		Date end=null;
		Calendar c1=Calendar.getInstance();
		Calendar c2=Calendar.getInstance();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		if(sStart==null||sEnd==null) {
			end=Date.valueOf(sdf.format(c1.getTime()));
			req.setAttribute("end", end);
			c1.add(Calendar.DAY_OF_MONTH, 1);
			end=Date.valueOf(sdf.format(c1.getTime()));
			c2.add(Calendar.MONTH, -3);
			start=Date.valueOf(sdf.format(c2.getTime()));
		}else {
			start=Date.valueOf(sStart);
			System.out.println(sEnd.substring(0,9));
			end=Date.valueOf(sEnd.substring(0,9).concat(Integer.toString(Integer.parseInt(Character.toString(sEnd.charAt(9)))+1)));
			req.setAttribute("end", sEnd);
		}
		MemberDetailDao dao=MemberDetailDao.getInstance();
		ArrayList<OrderHistoryVo> phList=dao.getPhlist(id, start, end);
		req.setAttribute("phList", phList);
		req.setAttribute("start", start);
		req.setAttribute("detailmain", "/member/showOrder.jsp");
		req.setAttribute("detailtitle", "나의 주문내역");
		req.getRequestDispatcher("/member/memberDetail").forward(req, resp);
	}
}









