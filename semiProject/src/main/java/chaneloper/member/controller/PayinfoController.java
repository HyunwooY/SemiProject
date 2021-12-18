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
		Search_ResultDao dao = new Search_ResultDao();
		ArrayList<ShowPurchaseListVo> list =new ArrayList<ShowPurchaseListVo>();
        if(req.getParameter("count")!=null) {
            int count =Integer.parseInt(req.getParameter("count")) ;
            int pi_num =Integer.parseInt(req.getParameter("pi_num")) ;
            for(int i=1 ;i<=count; i++) {
                String pd = req.getParameter("name"+i);
                String[] str = pd.split("\s+");
                int pd_num = dao.get_pd_num(pi_num,str[1],str[2]);
                System.out.println(pd_num);
                PurchaseDao pdao=PurchaseDao.getInstance();
                ShowPurchaseListVo svo=pdao.selectProduct(pd_num,Integer.parseInt(str[4]));
                list.add(svo);
            }
        }else {
            System.out.println("연결오류");
        }
		MemberDao mdao=MemberDao.getInstance();
		MemberVo membervo=mdao.select(id);
		AddressVo addressvo=mdao.selectaddr(id, membervo.getName());
		req.setAttribute("vo", membervo);
		req.setAttribute("avo", addressvo);
		req.setAttribute("list", list);
		if(req.getSession().getAttribute("id")==null) {
            req.setAttribute("main","/member/login.jsp");
            req.getRequestDispatcher("/layout.jsp").forward(req, resp);
        }else {
        	req.setAttribute("main", "/member/buyProduct.jsp");
    		req.getRequestDispatcher("/layout.jsp").forward(req, resp);
        }
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		req.setAttribute("main", "/member/buyProduct.jsp");
		req.getRequestDispatcher("/layout.jsp").forward(req, resp);
	}
}











