package chaneloper.contoller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet("/search/search")  
public class SearchController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String word = req.getParameter("word");		
		req.setAttribute("word", word);
		req.getRequestDispatcher("/search/detailSearch.jsp").forward(req, resp);
	}}
/*		// product_information Dao 조회
		Products dao=ProductsDao.getInstance();
		int n=dao.search(word);	
		if(n>0) {
			req.setAttribute("word", word);
			req.getRequestDispatcher("/search/detailSearch.jsp").forward(req, resp);
		}else {
			resp.sendRedirect(req.getContextPath() + "/layout.jsp");
		}
*/
/*		resp.setContentType("text/xml;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		JSONObject json=new JSONObject();
		if(n>0) {
			json.put("code","success");
			req.setAttribute("word", word);
		}else {
			json.put("code","fail");
		}
		pw.print(json);
		}
	}
		String categori = req.getParameter("categori");
/*		if(categori.equals("mainsearch")) {
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
*/	
