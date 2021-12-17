package chaneloper.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.MemberDao;
import chaneloper.dao.PurchaseDao;
import chaneloper.vo.AddressVo;
import chaneloper.vo.MemberVo;
import chaneloper.vo.ShowPurchaseListVo;

@WebServlet("/member/buyProduct")
public class PayinfoController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=(String)req.getSession().getAttribute("id");
		String pd_num=(String)req.getSession().getAttribute("pd_num");
		int num=-1;
		if(pd_num==null||pd_num=="") {
			num=0;
		}else {
			num=Integer.parseInt(pd_num);
		}
		MemberDao dao=MemberDao.getInstance();
		PurchaseDao pdao=PurchaseDao.getInstance();
		MemberVo membervo=dao.select(id);
		AddressVo addressvo=dao.selectaddr(id, membervo.getName());
		ShowPurchaseListVo svo=pdao.selectProduct(num);
		req.setAttribute("vo", membervo);
		req.setAttribute("avo", addressvo);
		req.setAttribute("svo", svo);
		
		req.setAttribute("main", "/member/buyProduct.jsp");
		req.getRequestDispatcher("/layout.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		shipping_address받아오기
//		AddressVo vo=dao.
	}
}











