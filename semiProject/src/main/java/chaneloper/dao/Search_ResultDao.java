package chaneloper.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import chaneloper.vo.ColorVo;
import chaneloper.vo.Inquiry_historyVo;
import chaneloper.vo.ReviewVo;
import chaneloper.vo.Search_ProductVo;
import chaneloper.vo.TagVo;
import db.JDBC;

public class Search_ResultDao {
	// 검색값의 총 갯수 가져오기
	public int search_productCount(String keyword, String CATEGORY, String sort){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Search_ProductVo> list = new ArrayList<Search_ProductVo>();
		String sql = ""; 
		try {
			con = JDBC.getCon();
			if(CATEGORY==null&&sort==null) {
				sql = "SELECT distinct NVL(count(a.pi_num),0) count FROM PRODUCT_INFOMATION a"
						+ " where a.PI_NAME like "+"\'%"+keyword+"%\'";
				pstmt=con.prepareStatement(sql);
			}else if(CATEGORY==null) {
				sql = "SELECT distinct NVL(count(a.pi_num),0) count FROM PRODUCT_INFOMATION a"
						+ " where a.PI_NAME like "+"\'%"+keyword+"%\'"
						+ " order by "+ sort +" desc";
				pstmt=con.prepareStatement(sql);
			}else if(sort==null) {
				sql = "SELECT distinct NVL(count(a.pi_num),0) count FROM PRODUCT_INFOMATION a"
						+ " where a.PI_NAME like "+"\'%"+keyword+"%\'"
						+ " and a.pi_category = "+ "\'"+ CATEGORY+ "\'";
				pstmt=con.prepareStatement(sql);
			}else if(CATEGORY!=null&&sort!=null) {
				sql = "SELECT distinct NVL(count(a.pi_num),0) count FROM PRODUCT_INFOMATION a"
						+ " where a.PI_NAME like "+"\'%"+keyword+"%\'"
						+ " and pi_category = "+ "\'"+ CATEGORY+ "\'"
						+ " order by "+ sort +" desc";
				pstmt=con.prepareStatement(sql);
			}
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("count");
			}
			return -1;
		}catch(SQLException se){
			se.printStackTrace();
			return -1;
		}finally {
			JDBC.close(con, pstmt, rs);
		}
	}
	
	public ArrayList<ColorVo> get_color() { // 모든 컬러 다 가져오기
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ColorVo> list = new ArrayList<ColorVo>();
		String sql = "SELECT distinct pd_color ,PI_num FROM PRODUCT_detail";
		try {
			con = JDBC.getCon();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				list.add(new ColorVo(rs.getInt("pi_num"),rs.getString("pd_color")));
			}
			return list;
		}catch(SQLException se){
			se.printStackTrace();
			return null;
		}finally {
			JDBC.close(con, pstmt, rs);
		}
	}
	
	public ArrayList<Search_ProductVo> search_product(String keyword, String CATEGORY, String sort, int startRow, int endRow){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Search_ProductVo> list = new ArrayList<Search_ProductVo>();
		String sql = "";
		try {
			con = JDBC.getCon();
			if(CATEGORY==null&&sort==null) {
//				sql = "SELECT distinct a.PI_NUM ,a.PI_NAME,a.PI_PRICE, c.PP_TITLE FROM PRODUCT_INFOMATION a "
//						+ "INNER JOIN PRODUCT_DETAIL b ON(a.PI_NUM = b.PI_NUM) "
//						+ "INNER JOIN PRODUCT_PHOTO c ON(a.PI_NUM = c.PI_NUM) "
//						+ "where a.PI_NAME like "+"\'%"+keyword+"%\'";
				sql = "select * from "
						+ "("
						+ "   select z.*,rownum rnum from"
						+ "   ("
						+ "SELECT distinct a.PI_NUM ,a.PI_NAME,a.PI_PRICE, c.PP_TITLE FROM PRODUCT_INFOMATION a"
						+ " INNER JOIN PRODUCT_DETAIL b ON(a.PI_NUM = b.PI_NUM)"
						+ " INNER JOIN PRODUCT_PHOTO c ON(a.PI_NUM = c.PI_NUM)"
						+ " where a.PI_NAME like "+"\'%"+keyword+"%\'"
						+ "   )z"
						+ ") where rnum>=? and rnum<=?"; 
					pstmt=con.prepareStatement(sql);
					pstmt.setInt(1, startRow);
					pstmt.setInt(2, endRow);
			}else if(CATEGORY==null) {		////////// 여기
				sql = "select * from "
						+ "("
						+ "   select z.*,rownum rnum from"
						+ "   ("
						+ "select distinct pi.pi_num, pi_name, pi_price, pp_title, pi_date, pi_count"
						+ " from product_infomation pi, product_detail pd, product_photo pp"
						+ " where pi.pi_num=pd.pi_num and pd.pi_num=pp.pi_num and PI_NAME like "+"\'%"+keyword+"%\'"
						+ " order by "+ sort +" desc"
						+ "   )z"
						+ " ) where rnum>=? and rnum<=?";	
					pstmt=con.prepareStatement(sql);
					pstmt.setInt(1, startRow);
					pstmt.setInt(2, endRow);
			}else if(sort==null) {
				sql = "select * from "
						+ "("
						+ "   select z.*,rownum rnum from"
						+ "   ("
						+	"SELECT distinct a.PI_NUM ,a.PI_NAME,a.PI_PRICE, c.PP_TITLE FROM PRODUCT_INFOMATION a"
						+ " INNER JOIN PRODUCT_DETAIL b ON(a.PI_NUM = b.PI_NUM)"
						+ " INNER JOIN PRODUCT_PHOTO c ON(a.PI_NUM = c.PI_NUM)"
						+ " where a.PI_NAME like "+"\'%"+keyword+"%\'"
						+ " AND a.PI_CATEGORY = "+ "\'" + CATEGORY + "\'"
						+ "   )z"
						+ ") where rnum>=? and rnum<=?"; 
					pstmt=con.prepareStatement(sql);
					pstmt.setInt(1, startRow);
					pstmt.setInt(2, endRow);
			}else if(CATEGORY!=null&&sort!=null) {		////////// 여기
				sql = "select * from "
						+ "("
						+ "   select z.*,rownum rnum from"
						+ "   ("
						+ "select distinct pi.pi_num, pi_name, pi_price, pp_title, pi_date, pi_count"
						+ " from product_infomation pi, product_detail pd, product_photo pp"
						+ " where pi.pi_num=pd.pi_num and pd.pi_num=pp.pi_num and PI_NAME like "+"\'%"+keyword+"%\'"
						+ " AND pi_category = "+ "\'"+ CATEGORY+ "\'"
						+ " order by "+ sort +" desc"
						+ "   )z"
						+ " ) where rnum>=? and rnum<=?";	
					pstmt=con.prepareStatement(sql);
					pstmt.setInt(1, startRow);
					pstmt.setInt(2, endRow);
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Search_ProductVo vo = new Search_ProductVo(rs.getInt(1),rs.getString(2),rs.getInt(3),null,null,rs.getString(4));
				list.add(vo);
			}
			return list;
		}catch(SQLException se){
			se.printStackTrace();
			return null;
		}finally {
			JDBC.close(con, pstmt, rs);
		}
	}
	
	public ArrayList<TagVo> get_tag(String keyword, String CATEGORY, String sort){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<TagVo> list = new ArrayList<TagVo>();
		String sql = "";
		try {
			con = JDBC.getCon();
			if(CATEGORY==null&&sort==null) {
				sql = "SELECT a.PI_NUM ,d.t_name FROM PRODUCT_INFOMATION a "
						+ "INNER JOIN TAG d ON(a.PI_NUM = d.PI_NUM) "
						+ "where a.PI_NAME like "+"\'%"+keyword+"%\'";
				pstmt=con.prepareStatement(sql);
			}else if(CATEGORY==null) {
				sql = "SELECT a.PI_NUM ,d.t_name FROM PRODUCT_INFOMATION a "
						+ "INNER JOIN TAG d ON(a.PI_NUM = d.PI_NUM) "
						+ "WHERE a.PI_NAME like "+"\'%"+keyword+"%\' "
						+ "ORDER BY a." + sort;
				pstmt=con.prepareStatement(sql);
			}else if(sort==null) {
				sql = "SELECT a.PI_NUM , d.t_name FROM PRODUCT_INFOMATION a "
						+ "INNER JOIN TAG d ON(a.PI_NUM = d.PI_NUM) "
						+ "WHERE a.PI_NAME like "+"\'%"+keyword+"%\' "
						+ " AND a.PI_CATEGORY = "+ "\'" + CATEGORY + "\'";
//						+ "AND a.PI_CATEGORY = ?";
				pstmt=con.prepareStatement(sql);
//				pstmt.setString(1, CATEGORY);
			}else if(CATEGORY!=null&&sort!=null) {
				sql = "SELECT a.PI_NUM ,d.t_name FROM PRODUCT_INFOMATION a "
						+ "INNER JOIN TAG d ON(a.PI_NUM = d.PI_NUM) "
						+ "WHERE a.PI_NAME like "+"\'%"+keyword+"%\' "
						+ " AND a.PI_CATEGORY = "+ "\'" + CATEGORY + "\'"
//						+ "AND a.PI_CATEGORY = ?"
						+ " ORDER BY a." + sort;
				pstmt=con.prepareStatement(sql);
//				pstmt.setString(1, CATEGORY);
			}
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				TagVo vo = new TagVo(rs.getInt(1),rs.getString(2));
				list.add(vo);
			}
			return list;
		}catch(SQLException se){
			se.printStackTrace();
			return null;
		}finally {
			JDBC.close(con, pstmt, rs);
		}
	}
	public ArrayList<Inquiry_historyVo> get_Inquiry_historyVo(int pi_num){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Inquiry_historyVo> list = new ArrayList<Inquiry_historyVo>();
		
		try {
			con = JDBC.getCon();
			String sql = "SELECT ih.IH_NUM ,ih.MI_ID ,ih.PI_NUM ,ih.IH_TITLE ,ih.IH_QUESTION ,ih.IH_ANSWER "
					+"FROM INQUIRY_HISTORY ih , PRODUCT_INFOMATION pi ,MEMBER_INFOMATION mi "
					+"WHERE ih.PI_NUM =pi.PI_NUM "
					+"AND ih.MI_ID =mi.MI_ID "
					+"AND ih.pi_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pi_num);
			return list;
		}catch(SQLException se){
			se.printStackTrace();
			return null;
		}finally {
			JDBC.close(con, pstmt, rs);
		}
	}
	
	public ArrayList<ReviewVo> get_review(int pi_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ReviewVo> list = new ArrayList<ReviewVo>();
		
		try {
			con = JDBC.getCon();
			String sql = "SELECT * FROM review r, REVIEW_PHOTO rp, PURCHASE_HISTORY ph "
					+ "WHERE r.R_NUM =rp.R_NUM "
					+ "AND r.PH_NUM =ph.PH_NUM "
					+ "AND ph.PI_NUM =? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pi_num);
			return list;
		}catch(SQLException se){
			se.printStackTrace();
			return null;
		}finally {
			JDBC.close(con, pstmt, rs);
		}
	}
	
	public ArrayList<Search_ProductVo> get_product(int pi_num){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Search_ProductVo> list = new ArrayList<Search_ProductVo>();
		String sql = "SELECT a.PI_NUM ,a.PI_NAME,a.PI_PRICE, b.PD_COLOR,b.pd_size,c.PP_TITLE FROM PRODUCT_INFOMATION a "
				+ "INNER JOIN PRODUCT_DETAIL b ON(a.PI_NUM = b.PI_NUM) "
				+ "INNER JOIN PRODUCT_PHOTO c ON(a.PI_NUM = c.PI_NUM) "
				+ "where a.PI_NUM = ? ";
		try {
			con = JDBC.getCon();
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, pi_num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Search_ProductVo vo = new Search_ProductVo(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6));
				list.add(vo);
			}
			return list;
		}catch(SQLException se){
			se.printStackTrace();
			return null;
		}finally {
			JDBC.close(con, pstmt, rs);
		}
	}
	
	public JSONArray get_count(int pi_num, String get_color) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		JSONArray jsonarray = new JSONArray();
		try {
			String sql="select pd_size,pd_count from product_detail where pi_num = ? and pd_color = ? order by pd_size";
			con = JDBC.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, pi_num);
			pstmt.setString(2, get_color);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				JSONObject json = new JSONObject();
				json.put("size",rs.getString(1));
				if(rs.getInt(2)==0) {
					json.put("count","매진");
				}else {
					json.put("count", Integer.toString(rs.getInt(2)));
				}
				
				jsonarray.put(json);
			}
			return jsonarray;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			JDBC.close(con, pstmt, rs);
		}
	}
	
	public int get_pd_num(int pi_num, String color, String size) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql="select pd_num from product_detail where pi_num = ? and pd_color = ? and pd_size =?";
			con = JDBC.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, pi_num);
			pstmt.setString(2, color);
			pstmt.setString(3, size);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}else {
				return -1;
			}
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JDBC.close(con, pstmt, rs);
		}
	}
	
}
