package chaneloper.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import chaneloper.vo.Inquiry_historyVo;
import chaneloper.vo.ReviewVo;
import chaneloper.vo.Search_ProductVo;
import chaneloper.vo.TagVo;
import db.JDBC;

public class Search_ResultDao {
	public ArrayList<Search_ProductVo> search_product(String keyword, String CATEGORY, String sort){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Search_ProductVo> list = new ArrayList<Search_ProductVo>();
		String sql = "";
		try {
			con = JDBC.getCon();
			if(CATEGORY==null&&sort.equals("null")) {
				sql = "SELECT a.PI_NUM ,a.PI_NAME,a.PI_PRICE, b.PD_COLOR,b.pd_size, c.PP_TITLE FROM PRODUCT_INFOMATION a "
						+ "INNER JOIN PRODUCT_DETAIL b ON(a.PI_NUM = b.PI_NUM) "
						+ "INNER JOIN PRODUCT_PHOTO c ON(a.PI_NUM = c.PI_NUM) "
						+ "where a.PI_NAME like "+"\'%"+keyword+"%\'";
				
			}else if(CATEGORY==null) {
				sql = "SELECT a.PI_NUM ,a.PI_NAME,a.PI_PRICE, b.PD_COLOR,b.pd_size,c.PP_TITLE FROM PRODUCT_INFOMATION a "
						+ "INNER JOIN PRODUCT_DETAIL b ON(a.PI_NUM = b.PI_NUM) "
						+ "INNER JOIN PRODUCT_PHOTO c ON(a.PI_NUM = c.PI_NUM) "
						+ "WHERE a.PI_NAME like "+"\'%"+keyword+"%\' "
						+ "ORDER BY a." + sort;

			}else if(sort.equals("null")) {
                sql = "SELECT a.PI_NUM ,a.PI_NAME,a.PI_PRICE, b.PD_COLOR,b.pd_size,c.PP_TITLE FROM PRODUCT_INFOMATION a "
                        + "INNER JOIN PRODUCT_DETAIL b ON(a.PI_NUM = b.PI_NUM) "
                        + "INNER JOIN PRODUCT_PHOTO c ON(a.PI_NUM = c.PI_NUM) "
                        + "WHERE a.PI_NAME like "+"'%"+keyword+"%' "
                        + "AND a.PI_CATEGORY = "+ "'"+CATEGORY+ "'";
            }else if(CATEGORY!=null&&sort.equals("null")) {
                sql = "SELECT a.PI_NUM ,a.PI_NAME,a.PI_PRICE, b.PD_COLOR,b.pd_size,c.PP_TITLE FROM PRODUCT_INFOMATION a "
                        + "INNER JOIN PRODUCT_DETAIL b ON(a.PI_NUM = b.PI_NUM) "
                        + "INNER JOIN PRODUCT_PHOTO c ON(a.PI_NUM = c.PI_NUM) "
                        + "WHERE a.PI_NAME like "+"'%"+keyword+"%' "
                        + "AND a.PI_CATEGORY = "+ "'"+ CATEGORY+ "'"
                        + " ORDER BY a." + sort;
			}else if(sort.equals("null")) {
				sql = "SELECT a.PI_NUM ,a.PI_NAME,a.PI_PRICE, b.PD_COLOR,b.pd_size,c.PP_TITLE FROM PRODUCT_INFOMATION a "
						+ "INNER JOIN PRODUCT_DETAIL b ON(a.PI_NUM = b.PI_NUM) "
						+ "INNER JOIN PRODUCT_PHOTO c ON(a.PI_NUM = c.PI_NUM) "
						+ "WHERE a.PI_NAME like "+"\'%"+keyword+"%\' "
						+ "AND a.PI_CATEGORY = "+ "\'"+CATEGORY+ "\'";
			}else if(CATEGORY!=null&&sort!=null) {
				sql = "SELECT a.PI_NUM ,a.PI_NAME,a.PI_PRICE, b.PD_COLOR,b.pd_size,c.PP_TITLE FROM PRODUCT_INFOMATION a "
						+ "INNER JOIN PRODUCT_DETAIL b ON(a.PI_NUM = b.PI_NUM) "
						+ "INNER JOIN PRODUCT_PHOTO c ON(a.PI_NUM = c.PI_NUM) "
						+ "WHERE a.PI_NAME like "+"\'%"+keyword+"%\' "
						+ "AND a.PI_CATEGORY = "+ "\'"+ CATEGORY+ "\'"
						+ " ORDER BY a." + sort;
			}
			pstmt=con.prepareStatement(sql);
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
				
			}else if(CATEGORY==null) {
				sql = "SELECT a.PI_NUM ,d.t_name FROM PRODUCT_INFOMATION a "
						+ "INNER JOIN TAG d ON(a.PI_NUM = d.PI_NUM) "
						+ "WHERE a.PI_NAME like "+"\'%"+keyword+"%\' "
						+ "ORDER BY a." + sort;
			}else if(sort==null) {
				sql = "SELECT a.PI_NUM , d.t_name FROM PRODUCT_INFOMATION a "
						+ "INNER JOIN TAG d ON(a.PI_NUM = d.PI_NUM) "
						+ "WHERE a.PI_NAME like "+"\'%"+keyword+"%\' "
						+ "AND a.PI_CATEGORY = "+ CATEGORY;
			}else if(CATEGORY!=null&&sort!=null) {
				sql = "SELECT a.PI_NUM ,d.t_name FROM PRODUCT_INFOMATION a "
						+ "INNER JOIN TAG d ON(a.PI_NUM = d.PI_NUM) "
						+ "WHERE a.PI_NAME like "+"\'%"+keyword+"%\' "
						+ "AND a.PI_CATEGORY = "+ CATEGORY
						+ " ORDER BY a." + sort;
			}
			pstmt=con.prepareStatement(sql);
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
	
	public HashMap<String, Integer> get_count(int pi_num, String get_color) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		try {
			String sql="select pd_size,pd_count from product_detail where pi_num = ? and pd_color = ?";
			con = JDBC.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, pi_num);
			pstmt.setString(2, get_color);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				map.put(rs.getString(1), rs.getInt(2));
			}
					
			return map;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			JDBC.close(con, pstmt, rs);
		}
	}
	
}
