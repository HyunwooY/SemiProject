package chaneloper.seller.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.Inquiry_historyDao;
import chaneloper.vo.Inquiry_historyVo;

<<<<<<< HEAD
=======
@WebServlet("/inquiryupdate")
>>>>>>> branch 'master' of https://github.com/HyunwooY/SemiProject.git
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
		String mi_id=req.getParameter("mi_id");
		int pi_num=Integer.parseInt(req.getParameter("pi_num"));
		String ih_title=req.getParameter("ih_title");
		String ih_question=req.getParameter("ih_question");
		String ih_answer=req.getParameter("ih_answer");
		Inquiry_historyVo vo=new Inquiry_historyVo(ih_num,mi_id,pi_num,ih_title,ih_question,ih_answer);
		Inquiry_historyDao dao=new Inquiry_historyDao();
		int n=dao.update(vo);
		if(n>0) {
			req.setAttribute("result","success");
		}else {
			req.setAttribute("result","fail");
		}
		req.getRequestDispatcher("//result.jsp").forward(req, resp);
	}
<<<<<<< HEAD
}
=======

	}


>>>>>>> branch 'master' of https://github.com/HyunwooY/SemiProject.git
