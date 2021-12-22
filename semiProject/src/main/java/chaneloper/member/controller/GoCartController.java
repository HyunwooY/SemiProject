package chaneloper.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import chaneloper.dao.PurchaseDao;
import chaneloper.dao.Search_ResultDao;
import chaneloper.vo.ShowPurchaseListVo;

@WebServlet("/member/gocart")
public class GoCartController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Search_ResultDao dao = new Search_ResultDao();
		//String param="";
		String lastCookieNum="0";
		//ArrayList<ShowPurchaseListVo> purchaseList=new ArrayList<ShowPurchaseListVo>();; 
		JSONObject json=new JSONObject();
        if(req.getParameter("count")!=null) {
            int count =Integer.parseInt(req.getParameter("count")) ;
            String pi_num =req.getParameter("pi_num");
            System.out.println(pi_num);
            Cookie[] clist=req.getCookies();
            for(Cookie cl:clist) {
            	if(cl.getName().equals("JSESSIONID")) {	
            	}else {
            		URLDecoder.decode(cl.getValue(),"utf-8");
	            	lastCookieNum=cl.getName().substring(4,cl.getName().indexOf("_"));
            	}
            }
            for(int i=Integer.parseInt(lastCookieNum)+1;i<=Integer.parseInt(lastCookieNum)+count;i++) {
            	boolean check=false;
            	int minus=0;
                String pd = req.getParameter("name"+(i-Integer.parseInt(lastCookieNum)));
                for(Cookie cl:clist) {
                	if(cl.getName().equals("JSESSIONID")) {
                	}else {
                		
                		String clvalue=URLDecoder.decode(cl.getValue(),"utf-8");
                		if(pi_num.equals(cl.getName().substring(cl.getName().indexOf("_")+1)) && 
                				clvalue.substring(0, clvalue.length()-1).equals(pd.substring(0, pd.length()-1))) {
                			
                			int a=Integer.parseInt(Character.toString(clvalue.charAt(clvalue.length()-1)))
                					+Integer.parseInt(Character.toString(pd.charAt(pd.length()-1)));
                			String npd=pd.substring(0, pd.length()-1).concat(Integer.toString(a));
                			System.out.println(npd);
                			Cookie c=new Cookie(cl.getName(),URLEncoder.encode(npd,"utf-8"));
                			c.setMaxAge(60*60*24*30); //30일 저장
                            resp.addCookie(c);  
                            check=true;
                            minus++;
                            break;
                		}
                	}
                }
                if(check==true) {
                	continue;
                }else {
                	System.out.println(pd);
        			Cookie c=new Cookie(("name"+(i-minus)).concat("_"+pi_num),URLEncoder.encode(pd,"utf-8"));
        			c.setMaxAge(60*60*24*30); //30일 저장
                    resp.addCookie(c);  
                }
            }

            json.put("checkcart", true);
        }else {
            System.out.println("연결오류");
            json.put("checkcart", false);
        }
        resp.setContentType("text/plain;charset=utf-8");
        PrintWriter pw=resp.getWriter();
        pw.print(json);
	}
}
