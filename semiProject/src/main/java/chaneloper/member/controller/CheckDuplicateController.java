package chaneloper.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import chaneloper.dao.MemberDao;

@WebServlet("/check/id")
public class CheckDuplicateController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		JSONObject json=new JSONObject();
		MemberDao dao=MemberDao.getInstance();
		if(dao.checkId(id)){
			json.put("check", false);
		}else {
			json.put("check", true);
		}
		PrintWriter pw=resp.getWriter();
		pw.print(json);
	}
}









