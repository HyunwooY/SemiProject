package Search.contoller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.AddInterestDao;
@WebServlet("/search/interest")
public class AddInterestController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AddInterestDao dao = new AddInterestDao();
		dao.addinter(req.getParameter("mi_id"), Integer.parseInt(req.getParameter("pi_num")));
	}
}
