package chaneloper.member.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

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
		String how=req.getParameter("how");
		int cookieNum=Integer.parseInt(req.getParameter("cookie_num"));
		Cookie[] c=req.getCookies();
		for(Cookie cc:c) {
			if(cc.getName().equals("JSESSIONID")) {
			}else {
				if(Character.getNumericValue((cc.getName().charAt(4)))==cookieNum) {
					int upcount=Character.getNumericValue(URLDecoder.decode(cc.getValue(),"utf-8").charAt(cc.getValue().length()-1))+1;
					String npd=URLDecoder.decode(cc.getValue(),"utf-8").substring(0,URLDecoder.decode(cc.getValue(),"utf-8").length()-1).concat(Integer.toString(upcount));
					
					Cookie cookie=new Cookie(cc.getName(), URLEncoder.encode(npd,"utf-8"));
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*30);
					resp.addCookie(cookie);

				}
				
				System.out.println(cc.getName()+","+URLDecoder.decode(cc.getValue(),"utf-8"));
				
			}
		}

	}
}
