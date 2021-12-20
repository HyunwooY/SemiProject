//package chaneloper.seller.controller;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import chaneloper.dao.MemberDao;
//import chaneloper.dao.SellerDao;
//import chaneloper.vo.AddressVo;
//import chaneloper.vo.MemberVo;
//import chaneloper.vo.SellerVo;
//
//
//@WebServlet("/seller/detailmodify")
//public class SellerModifyController extends HttpServlet {
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("utf-8");
//		String id = (String)req.getSession().getAttribute("id");
//		String pwd = req.getParameter("pwd");
//		SellerDao dao = SellerDao.getInstance();
//		if(dao.sellerLogin(id, pwd)) {
//			SellerVo vo = dao.sellerSellect(id);
//			if(vo==null) {
//				req.setAttribute("result", "fail");
//			}else {
//				req.setAttribute("vo", vo);
//				req.setAttribute("detailmain","/seller/sellermypage.jsp");
//				req.getRequestDispatcher("/seller/sellerpage").forward(req, resp);
//			}
//		}else {
//			req.setAttribute("result", "fail");
//			req.setAttribute("detailmain", "/seller/sellerpwdcheck.jsp");
//			req.getRequestDispatcher("/seller/sellerpage").forward(req, resp);
//		}
//	}
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setAttribute("detailmain", "/seller/sellerpwdcheck.jsp");
//		req.getRequestDispatcher("/seller/sellerpage").forward(req, resp);
//	}
//}
