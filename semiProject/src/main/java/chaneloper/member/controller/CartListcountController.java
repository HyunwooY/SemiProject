package chaneloper.member.controller;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cart/count")
public class CartListcountController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String what=req.getParameter("what");
		Cookie[] c=req.getCookies();
		for(Cookie cc:c) {
			if(cc.getName().equals("JSESSIONID")) {
			}else {
				System.out.println(cc.getName()+","+URLDecoder.decode(cc.getValue(),"utf-8"));
			}
		}
		req.getRequestDispatcher("/member/cartlist").forward(req, resp);
	}
}
