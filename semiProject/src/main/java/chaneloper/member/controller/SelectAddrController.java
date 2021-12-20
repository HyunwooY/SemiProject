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
import chaneloper.vo.AddressVo;

@WebServlet("/member/selectAddr")
public class SelectAddrController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=(String)req.getSession().getAttribute("id");
		String nickname=req.getParameter("selected");
		MemberDao dao=MemberDao.getInstance();
		AddressVo vo=dao.selectaddr(id, nickname, null);
		System.out.println(id+nickname+vo.getAddr());
		resp.setContentType("text/plain;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		JSONObject json=new JSONObject();
		json.put("name", vo.getName());
		json.put("addr", vo.getAddr());
		json.put("phone", vo.getPhone());
		pw.print(json);
	}
}







