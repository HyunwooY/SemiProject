package chaneloper.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.MemberDao;
import chaneloper.dao.PurchaseDao;
import chaneloper.dao.Search_ResultDao;
import chaneloper.vo.AddressVo;
import chaneloper.vo.MemberVo;
import chaneloper.vo.ShowPurchaseListVo;

@WebServlet("/member/buyProduct")
public class PayinfoController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=(String)req.getSession().getAttribute("id");
		String radio=(String)req.getSession().getAttribute("radio");
		req.getSession().invalidate();
		req.getSession().setAttribute("id", id);
		req.getSession().setAttribute("radio",radio);				
		Search_ResultDao dao = new Search_ResultDao();
		String param="";
		ArrayList<ShowPurchaseListVo> purchaseList=new ArrayList<ShowPurchaseListVo>();; 
        if(req.getParameter("count")!=null && (req.getParameter("pi_num")!=null||(!req.getParameter("pi_num").equals("")))) {
            int count =Integer.parseInt(req.getParameter("count")) ;
            int pi_num =Integer.parseInt(req.getParameter("pi_num")) ;
            for(int i=1 ;i<=count; i++) {
                String pd = req.getParameter("name"+i);
                System.out.println(pd);
                String[] str = pd.split("\s+");
                int pd_num = dao.get_pd_num(pi_num,str[1],str[2]);
                param+="&name"+i+"="+pd;
                System.out.println(pd_num);
                PurchaseDao pdao=PurchaseDao.getInstance();
                ShowPurchaseListVo svo=pdao.selectProduct(pd_num,Integer.parseInt(str[4]),pi_num);
                purchaseList.add(svo);
            }
        }else {
            int count=Integer.parseInt(req.getParameter("count"));
            int pd_num =Integer.parseInt(req.getParameter("pd_num")) ;
            PurchaseDao pdao=PurchaseDao.getInstance();
            ShowPurchaseListVo svo=pdao.selectProduct(pd_num,count,-1);
            purchaseList.add(svo);
        }
		MemberDao mdao=MemberDao.getInstance();
		MemberVo membervo=mdao.select(id);
		ArrayList<AddressVo> addrlist=mdao.addrList(id);
		req.setAttribute("vo", membervo);
		req.getSession().setAttribute("list", purchaseList);
		if(req.getSession().getAttribute("id")==null||req.getSession().getAttribute("id").equals("")) {
			req.getSession().setAttribute("backp", "go");
			req.getSession().setAttribute("count", req.getParameter("count"));
			req.getSession().setAttribute("pi_num", req.getParameter("pi_num"));
			req.getSession().setAttribute("parame", param);
            resp.sendRedirect(req.getContextPath()+"/member/login");
        }else {
        	System.out.println(id+","+membervo.getName());
        	AddressVo addressvo=mdao.selectaddr(id, membervo.getName());
        	req.setAttribute("avo", addressvo);
        	req.setAttribute("addr", addrlist);
        	req.setAttribute("main", "/member/buyProduct.jsp");
    		req.getRequestDispatcher("/layout.jsp").forward(req, resp);
        }
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		ArrayList<ShowPurchaseListVo> list=(ArrayList<ShowPurchaseListVo>)req.getSession().getAttribute("list");
		String id=(String)req.getSession().getAttribute("id");
		String payType=req.getParameter("type");
		String name=req.getParameter("name");
		String addr=req.getParameter("addr");
		String phone=req.getParameter("phone");
		AddressVo avo=new AddressVo(-1,id, name, null, phone, addr);
		PurchaseDao dao=PurchaseDao.getInstance();
		int ph_num=dao.purchase(avo, id, payType);
		for(ShowPurchaseListVo vo:list) {
			dao.purchase(vo, ph_num);
		}
		req.setAttribute("main", "/member/purchaseResult.jsp");
		req.getRequestDispatcher("/layout.jsp").forward(req, resp);
	}
}











