package chaneloper.contoller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.Search_ResultDao;
import chaneloper.vo.Inquiry_historyVo;
@WebServlet("/search/searchdetail")
public class SearchDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pi_num = Integer.parseInt(req.getParameter("pi_num"));
		Search_ResultDao dao = new Search_ResultDao();
		dao.search_product(getServletInfo(), getServletName(), getServletInfo());
		dao.get_review(pi_num);
		dao.get_Inquiry_historyVo(pi_num);

	}
}
