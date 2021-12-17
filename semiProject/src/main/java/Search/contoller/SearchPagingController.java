package Search.contoller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaneloper.dao.Search_ResultDao;
import chaneloper.vo.Search_ProductVo;
@WebServlet("/search/paging") // 검색 후 페이징 처리
public class SearchPagingController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String spageNum=req.getParameter("pageNum");
		int pageNum=1;
		if (spageNum!=null) { // null일수가 없다. 
			pageNum=Integer.parseInt(spageNum);
		}
		// 몇개씩 출력할건지
		int endRow=pageNum*10; //10
		int startRow=endRow-9; //1 
		
		Search_ResultDao dao=new Search_ResultDao();
//		ArrayList<Search_ProductVo> list = dao.list(startRow,endRow);
		int count=Integer.parseInt(req.getParameter("count")); // 검색된 전체재품 갯수값 (여기까진 ok)
		
		int totalPage=(int)Math.ceil(count/10.0);	// 전체페이지 갯수
		int startPageNum= ((pageNum-1)/10*10) + 1;	//시작 페이지 번호
		int endPageNum=startPageNum+9;	//끝 페이지 번호
		
		if (endPageNum>totalPage) {
			endPageNum=totalPage;
		}
//		req.setAttribute("list", list);
//		req.setAttribute("totalPage", totalPage);
//		req.setAttribute("startPage", startPageNum);
//		req.setAttribute("endPage", endPageNum);
//		req.setAttribute("pageNum", pageNum);
//		req.getRequestDispatcher("/board/list.jsp").forward(req, resp);
	}
}
