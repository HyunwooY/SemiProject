package Search.contoller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import chaneloper.dao.Search_Inq_RvDao;
@WebServlet("/search/upload")
public class SearchReviewUploadController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String saveDir =req.getSession().getServletContext().getRealPath("/upload");
		System.out.println(saveDir);
		int pi_num = Integer.parseInt(req.getParameter("pi_num"));
		System.out.println("연결확인");
		MultipartRequest mr = new MultipartRequest(
				req, //request객체
				saveDir, //저장할 디렉토리
				1024*1024*5, //최대업로드가능한 크기(바이트 단위)
				"utf-8", // 인코딩 방식
				new DefaultFileRenamePolicy()//동일한 파일명이 존재할시 이를 처리할 객체
		);
		if(mr.getParameter("mi_id")!=null) {
			

			String mi_id = mr.getParameter("mi_id");
			String title = mr.getParameter("title");
			String context = mr.getParameter("context");
			int rating = Integer.parseInt(mr.getParameter("rating"));
			Search_Inq_RvDao dao = Search_Inq_RvDao.getInstance();
			
			for(int i=0;i<=Integer.parseInt(mr.getParameter("adbt"));i++) {
				System.out.println(mr.getFilesystemName("file"+i));
				String saveFileName = mr.getFilesystemName("file"+i);//저장된 파일명
				String datadir = saveDir+"\\"+saveFileName;
				File f = new File(datadir);
				dao.insertrv(pi_num, mi_id, title, rating, context , saveFileName);
			}
				
		}else {
			System.out.println("에러에러");
		}
		resp.sendRedirect(req.getContextPath()+"/search/searchdetail?pi_num="+pi_num);
	}
}
