package chaneloper.seller.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.NoticeDao;
@WebServlet("/noticedelete")
public class NoticeDelete extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int n_num = Integer.parseInt(req.getParameter("n_num"));
		NoticeDao dao = NoticeDao.getInstance();
		int n=dao.delete(n_num);
		if(n>0) {
			//목록페이지로 이동 
			resp.sendRedirect(req.getContextPath() +"/notice");//목록을 보여주는 리스트컨트롤러로 이동
		}else {
			req.setAttribute("result", "fail");
			req.getRequestDispatcher("/seller/notice.jsp").forward(req, resp);
		}		
	}
}

		
