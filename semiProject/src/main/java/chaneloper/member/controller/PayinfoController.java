package chaneloper.member.controller;

import java.io.IOException;
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
        if(req.getParameter("count")!=null) {
            int count =Integer.parseInt(req.getParameter("count")) ;
            int pi_num =Integer.parseInt(req.getParameter("pi_num")) ;
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            System.out.println(pi_num);
            System.out.println(count);
            for(int i=1 ;i<=count; i++) {
                String pd = req.getParameter("name"+i);
                String[] str = pd.split("\s+");
                int pd_num = dao.get_pd_num(pi_num,str[1],str[2]);
                map.put(pd_num, Integer.parseInt(str[4]));
            }
            if(req.getSession().getAttribute("id")==null) {
                req.setAttribute("main","/member/login.jsp");
                req.getRequestDispatcher("/layout.jsp").forward(req, resp);
            }else {
                req.getSession().setAttribute("pd_num", map);
                resp.sendRedirect(req.getContextPath()+"/member/buyProduct");
            }
            System.out.println(map);
        }else {
            System.out.println("연결오류");
        }
		MemberDao mdao=MemberDao.getInstance();
		PurchaseDao pdao=PurchaseDao.getInstance();
		MemberVo membervo=mdao.select(id);
		AddressVo addressvo=mdao.selectaddr(id, membervo.getName());
		ShowPurchaseListVo svo=pdao.selectProduct(1);
		req.setAttribute("vo", membervo);
		req.setAttribute("avo", addressvo);
		req.setAttribute("svo", svo);
		
		req.setAttribute("main", "/member/buyProduct.jsp");
		req.getRequestDispatcher("/layout.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		req.setAttribute("main", "/member/buyProduct.jsp");
		req.getRequestDispatcher("/layout.jsp").forward(req, resp);
	}
}











