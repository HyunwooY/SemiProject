package chaneloper.seller.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.SellerDao;
import chaneloper.vo.ProductVo;

@WebServlet("/seller/producDetailtList")
public class SellerProductListController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		// 페이징 처리	
		String spageNum = req.getParameter("pageNum");
		int pageNum = 1;
		if(spageNum != null) {
			pageNum = Integer.parseInt(spageNum);
		}
		int startRow = (pageNum-1)*10+1;
		int endRow = startRow + 9;
		
		
		String si_id = (String)req.getSession().getAttribute("id");
		int pi_num = Integer.parseInt(req.getParameter("pi_num"));
		System.out.println("si_id:" + si_id);
		SellerDao dao = SellerDao.getInstance();
		ArrayList<ProductVo> productList = dao.productList(si_id, pi_num, startRow, endRow);	
	
		
		
		int count = dao.getCountProduct();		// 전체 글의 수
		int pageCount = (int)Math.ceil(count / 10.0);		// 전체 페이지 수
		int startPageNum = ((pageNum - 1) / 10 * 10) + 1;		// 시작 페이지 번호
		int endPageNum = startPageNum + 9;		// 끝 페이지 번호
		if(endPageNum > pageCount) {
			endPageNum = pageCount;
		}
		
		req.setAttribute("pl", productList);
		req.setAttribute("main", "/seller/sellerProductList.jsp");
		req.getRequestDispatcher("/layout.jsp").forward(req, resp);
	}

}
