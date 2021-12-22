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
@WebServlet("/search/upload")
public class SearchReviewUploadController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String saveDir =req.getSession().getServletContext().getRealPath("/product_img");
		System.out.println(saveDir);
		String pi_num = req.getParameter("pi_num");
		System.out.println("연결확인");
		MultipartRequest mr = new MultipartRequest(
				req, //request객체
				saveDir, //저장할 디렉토리
				1024*1024*5, //최대업로드가능한 크기(바이트 단위)
				"utf-8", // 인코딩 방식
				new DefaultFileRenamePolicy()//동일한 파일명이 존재할시 이를 처리할 객체
		);
		if(mr.getParameter("mi_id")!=null) {
			
			System.out.println(mr.getParameter("date"));
			System.out.println(mr.getParameter("mi_id"));
			System.out.println(mr.getParameter("title"));
			System.out.println(mr.getParameter("context"));
			System.out.println(mr.getParameter("rating"));
			System.out.println(mr.getParameter("adbt"));
			
			for(int i=0;i<=Integer.parseInt(mr.getParameter("adbt"));i++) {
				String saveFileName = mr.getFilesystemName("file"+i);//저장된 파일명
				String datadir = saveDir+"\\"+saveFileName;
				File f = new File(datadir);
			}
				
		}else {
			System.out.println("에러에러");
		}
		resp.sendRedirect(req.getContextPath()+"/search/searchdetail?pi_num="+pi_num);
	}
}
