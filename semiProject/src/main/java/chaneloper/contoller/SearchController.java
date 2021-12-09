package chaneloper.contoller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/search/search")
public class SearchController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String keyword = req.getParameter("keyword");
		String categori = req.getParameter("categori");
		
		if(categori.equals("mainsearch")) {
			if(keyword==null) {
				req.setAttribute("misskeyword", "검색어를 입력해주세요.");
				req.getRequestDispatcher("/main.jsp").forward(req, resp);
			}else {

			}
		}else if(categori.equals("detailsearch")) {
			if(keyword==null) {
				req.setAttribute("misskeyword", "검색어를 입력해주세요.");
				req.getRequestDispatcher("/search/detailsearch.jsp").forward(req, resp);
			}else {

			}
		}
	}
}