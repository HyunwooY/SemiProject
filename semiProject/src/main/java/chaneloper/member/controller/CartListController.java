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
		ArrayList<Cookie> list=new ArrayList<Cookie>();
		Cookie[] c=req.getCookies();
		Search_ResultDao dao = new Search_ResultDao();
		String param="";
		ArrayList<ShowPurchaseListVo> purchaseList=new ArrayList<ShowPurchaseListVo>();
		for(Cookie cc:c) {
			list.add(cc);
//			Cookie c1=new Cookie(cc.getName(),"");
//			c1.setMaxAge(0);
//			resp.addCookie(c1);
			if(cc.getName().equals("JSESSIONID")) {
			}else {
				System.out.println(cc.getName()+","+URLDecoder.decode(cc.getValue(),"utf-8"));
				int count =c.length ;
	            int pi_num =Integer.parseInt(cc.getName().substring(cc.getName().indexOf("_")+1));
                String pd = cc.getValue();
                System.out.println(URLDecoder.decode(cc.getValue(),"utf-8"));
                String[] str = URLDecoder.decode(cc.getValue(),"utf-8").split("\s+");
                System.out.println(str[0]+str[1]+str[2]+str[3]+str[4]);
                int pd_num = dao.get_pd_num(pi_num,str[1],str[2]);
                param+="&"+cc.getName().substring(0,cc.getName().indexOf("_"))+"="+pd;
                System.out.println(pd_num);
                PurchaseDao pdao=PurchaseDao.getInstance();
                ShowPurchaseListVo svo=pdao.selectProduct(pd_num,Integer.parseInt(str[4]));
                purchaseList.add(svo);
			}
		}
		System.out.println(param);
		req.setAttribute("cartlist",purchaseList);
		req.setAttribute("main", "/member/cartList.jsp");
		req.getRequestDispatcher("/layout.jsp").forward(req, resp);
	}
}











