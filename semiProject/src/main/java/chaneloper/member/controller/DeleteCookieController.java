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

@WebServlet("/member/deleteCookie")
public class DeleteCookieController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int cookieNum=Integer.parseInt(req.getParameter("cookieNum"));
		Cookie[] cookie=req.getCookies();
		int lastCookieNum=0;
		 for(Cookie cl:cookie) {
         	if(cl.getName().equals("JSESSIONID")) {	
         	}else {
            	if(lastCookieNum<Integer.parseInt(cl.getName().substring(4,cl.getName().indexOf("_")))) {
            		lastCookieNum=Integer.parseInt(cl.getName().substring(4,cl.getName().indexOf("_")));
            	}
         	}
         }
		for(Cookie c:cookie) {
			if(c.getName().equals("JSESSIONID")) {
			}else {
				if(Integer.parseInt(c.getName().substring(4,c.getName().indexOf("_")))==cookieNum) {
					Cookie co=new Cookie(c.getName(),"");
					co.setPath("/");
					co.setMaxAge(0);
					resp.addCookie(co);
				}else if(Integer.parseInt(c.getName().substring(4,c.getName().indexOf("_")))>cookieNum){
					int cnum=Integer.parseInt(c.getName().substring(4,c.getName().indexOf("_")))-1; //새로 부여 될쿠키의 번호
					String oldback=c.getName().substring(c.getName().indexOf("_")); // 쿠키 뒷자리(pi_num)
					String newname="name"+cnum+oldback;
					Cookie co=new Cookie(newname,c.getValue());
					co.setPath("/");
					co.setMaxAge(60*60*24*30);
					resp.addCookie(co);
				}
				if(Integer.parseInt(c.getName().substring(4,c.getName().indexOf("_")))==lastCookieNum) {
					Cookie co=new Cookie(c.getName(),"");
					co.setPath("/");
					co.setMaxAge(0);
					resp.addCookie(co);
				}
			}
		}
		resp.sendRedirect(req.getContextPath()+"/member/cartlist");
		
		
	}
}















