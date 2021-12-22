package chaneloper.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import chaneloper.dao.MemberDetailDao;
import chaneloper.vo.OrderHistoryVo;
@WebServlet("/member/purchasedetail")
public class ShowPurchaseDetailController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int ph_num=Integer.parseInt(req.getParameter("ph_num"));
		MemberDetailDao dao=MemberDetailDao.getInstance();
		ArrayList<OrderHistoryVo> list=dao.showOrder(ph_num);
		JSONArray ajson=new JSONArray();
		for(OrderHistoryVo vo:list) {
			JSONObject json=new JSONObject();
			json.put("pp_title",vo.getPp_title());
			json.put("ph_num",vo.getPh_num());
			json.put("pi_name",vo.getPi_name());
			json.put("pd_count",vo.getP_count());
			json.put("pi_price",vo.getPi_price());
			ajson.put(json);
		}
		resp.setContentType("text/plain;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		pw.print(ajson);
	}
}










