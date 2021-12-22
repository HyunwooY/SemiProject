package chaneloper.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet("/cart/count")
public class CartListcountController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String how=req.getParameter("how");
		int cookieNum=Integer.parseInt(req.getParameter("cookie_num"));
		resp.setContentType("text/plain;charset=utf-8");
		JSONObject json=new JSONObject();
		if(how.equals("up")) {
			Cookie[] c=req.getCookies();
			for(Cookie cc:c) {
				if(cc.getName().equals("JSESSIONID")) {
				}else {
					if(Integer.parseInt(cc.getName().substring(4,cc.getName().indexOf("_")))==cookieNum) {
						int downcount=Integer.parseInt(URLDecoder.decode(cc.getValue(),"utf-8").substring(URLDecoder.decode(cc.getValue(),"utf-8").lastIndexOf(" ")+1))+1;
						String npd=URLDecoder.decode(cc.getValue(),"utf-8").substring(0,URLDecoder.decode(cc.getValue(),"utf-8").lastIndexOf(" ")+1).concat(Integer.toString(downcount));
						Cookie cookie=new Cookie(cc.getName(), URLEncoder.encode(npd,"utf-8"));
						cookie.setPath("/");
						cookie.setMaxAge(60*60*24*30);
						resp.addCookie(cookie);
					}
				}
			}
		}else if(how.equals("down")) {
			Cookie[] c=req.getCookies();
			for(Cookie cc:c) {
				if(cc.getName().equals("JSESSIONID")) {
				}else {
					if(Character.getNumericValue((cc.getName().charAt(4)))==cookieNum) {
						int downcount=Integer.parseInt(URLDecoder.decode(cc.getValue(),"utf-8").substring(URLDecoder.decode(cc.getValue(),"utf-8").lastIndexOf(" ")+1))-1;
						String npd=URLDecoder.decode(cc.getValue(),"utf-8").substring(0,URLDecoder.decode(cc.getValue(),"utf-8").lastIndexOf(" ")+1).concat(Integer.toString(downcount));
						Cookie cookie=new Cookie(cc.getName(), URLEncoder.encode(npd,"utf-8"));
						cookie.setPath("/");
						cookie.setMaxAge(60*60*24*30);
						resp.addCookie(cookie);
	
					}
				}
			}
		}
		PrintWriter pw=resp.getWriter();
		pw.print(json);
	}
}
