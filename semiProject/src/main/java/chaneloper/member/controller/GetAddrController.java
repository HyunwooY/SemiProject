package chaneloper.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import chaneloper.dao.MemberDetailDao;
import chaneloper.vo.AddressVo;

@WebServlet("/member/getaddr")
public class GetAddrController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ph_num=req.getParameter("ph_num");
		MemberDetailDao dao=MemberDetailDao.getInstance();
		AddressVo vo=dao.getAddr(Integer.parseInt(ph_num));
		JSONObject json=new JSONObject();
		resp.setContentType("text/plain;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		json.put("avo", vo);
		pw.print(json);
	}
}
