package chaneloper.seller.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.Inquiry_historyDao;
import chaneloper.vo.Inquiry_historyVo;


public class InquiryHistoryListUpdate extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int ih_num=Integer.parseInt(req.getParameter("ih_num"));
		Inquiry_historyDao dao=new Inquiry_historyDao();
		Inquiry_historyVo vo=dao.select(ih_num);
		if(vo==null) {
			req.setAttribute("result","fail");
			req.getRequestDispatcher("/member/result.jsp").forward(req, resp);
		}else {
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/member/inquiryListUpdate.jsp").forward(req, resp);
		}	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int ih_num=Integer.parseInt(req.getParameter("ih_num"));
		String ih_question=req.getParameter("ih_question");
		String ih_title=req.getParameter("ih_title");
		Inquiry_history vo=new Inquiry_history(ih_num,null,null,ih_question,ih_title,null);
		Inquiry_historyDao dao=new Inquiry_historyDao();
		int n=dao.update(vo);
		if(n>0) {
			req.setAttribute("result","success");
		}else {
			req.setAttribute("result","fail");
		}
		req.getRequestDispatcher("//result.jsp").forward(req, resp);
	}

	}


