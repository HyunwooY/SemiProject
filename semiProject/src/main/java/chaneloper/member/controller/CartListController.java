package chaneloper.member.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.PurchaseDao;
import chaneloper.dao.Search_ResultDao;
import chaneloper.vo.ShowPurchaseListVo;

@WebServlet("/member/cartlist")
public class CartListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int loopcount=1;
		Cookie[] c=req.getCookies();
		Search_ResultDao dao = new Search_ResultDao();
		String param="";
		String ppp="";
		ArrayList<ShowPurchaseListVo> purchaseList=new ArrayList<ShowPurchaseListVo>();
		for(int i=0;;i++) {
			if(c.length==0) {
				System.out.println("정보없음");
				break;
			}
//			Cookie c1=new Cookie(cc.getName(),"");
//			c1.setMaxAge(0);
//			resp.addCookie(c1);
			if(i>=c.length) i=0;
			if(c[i].getName().equals("JSESSIONID")) {
			}else {
				if(c[i].getName().startsWith("name"+(loopcount))) {
					System.out.println(c[i].getName()+","+URLDecoder.decode(c[i].getValue(),"utf-8"));
					int count =c.length ;
		            int pi_num =Integer.parseInt(c[i].getName().substring(c[i].getName().indexOf("_")+1));
	                String pd = c[i].getValue();
	                System.out.println(URLDecoder.decode(c[i].getValue(),"utf-8"));
	                String[] str = URLDecoder.decode(c[i].getValue(),"utf-8").split("\s+");
	                System.out.println(str[0]+str[1]+str[2]+str[3]+str[4]);
	                int pd_num = dao.get_pd_num(pi_num,str[1],str[2]);
	                param+="&"+c[i].getName().substring(0,c[i].getName().indexOf("_"))+"="+pd;
	                System.out.println(pd_num);
	                PurchaseDao pdao=PurchaseDao.getInstance();
	                ShowPurchaseListVo svo=pdao.selectProduct(pd_num,Integer.parseInt(str[4]));
	                purchaseList.add(svo);
	                ppp+="&pd_num"+loopcount+"="+pd_num+"&count="+Integer.parseInt(str[4]);
	                loopcount++;
	                if(loopcount==c.length) break;
				}
			}
		}
		System.out.println(param);
		
		req.setAttribute("cartlist",purchaseList);
		req.setAttribute("main", "/member/cartList.jsp");
		req.getRequestDispatcher("/layout.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String[] param=req.getParameterValues("product");
		for(String s:param) {
			System.out.println(s);
		}
	}
}











