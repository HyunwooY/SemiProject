package chaneloper.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import chaneloper.vo.Search_DetailProductVo;
import chaneloper.vo.Search_ProductVo;
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
			if(CATEGORY==null&&sort==null) {
				sql = "SELECT a.PI_NUM ,a.PI_NAME,a.PI_PRICE, b.PD_COLOR,c.PP_TITLE, d.t_name FROM PRODUCT_INFOMATION a "
						+ "INNER JOIN PRODUCT_DETAIL b ON(a.PI_NUM = b.PI_NUM) "
						+ "INNER JOIN PRODUCT_PHOTO c ON(a.PI_NUM = c.PI_NUM) "
						+ "INNER JOIN TAG d ON(a.PI_NUM = d.PI_NUM) "
						+ "where a.PI_NAME like "+"\'%"+keyword+"%\'";
				
			}else if(CATEGORY==null) {
				sql = "SELECT a.PI_NUM ,a.PI_NAME,a.PI_PRICE, b.PD_COLOR,c.PP_TITLE, d.t_name FROM PRODUCT_INFOMATION a "
						+ "INNER JOIN PRODUCT_DETAIL b ON(a.PI_NUM = b.PI_NUM) "
						+ "INNER JOIN PRODUCT_PHOTO c ON(a.PI_NUM = c.PI_NUM) "
						+ "INNER JOIN TAG d ON(a.PI_NUM = d.PI_NUM) "
						+ "WHERE a.PI_NAME like "+"\'%"+keyword+"%\' "
						+ "ORDER BY a." + sort;
			}else if(sort==null) {
				sql = "SELECT a.PI_NUM ,a.PI_NAME,a.PI_PRICE, b.PD_COLOR,c.PP_TITLE, d.t_name FROM PRODUCT_INFOMATION a "
						+ "INNER JOIN PRODUCT_DETAIL b ON(a.PI_NUM = b.PI_NUM) "
						+ "INNER JOIN PRODUCT_PHOTO c ON(a.PI_NUM = c.PI_NUM) "
						+ "INNER JOIN TAG d ON(a.PI_NUM = d.PI_NUM) "
						+ "WHERE a.PI_NAME like "+"\'%"+keyword+"%\' "
						+ "AND a.PI_CATEGORY = "+ CATEGORY;
			}else if(CATEGORY!=null&&sort!=null) {
				sql = "SELECT a.PI_NUM ,a.PI_NAME,a.PI_PRICE, b.PD_COLOR,c.PP_TITLE, d.t_name FROM PRODUCT_INFOMATION a "
						+ "INNER JOIN PRODUCT_DETAIL b ON(a.PI_NUM = b.PI_NUM) "
						+ "INNER JOIN PRODUCT_PHOTO c ON(a.PI_NUM = c.PI_NUM) "
						+ "INNER JOIN TAG d ON(a.PI_NUM = d.PI_NUM) "
						+ "WHERE a.PI_NAME like "+"\'%"+keyword+"%\' "
						+ "AND a.PI_CATEGORY = "+ CATEGORY
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
	
	public ArrayList<Search_DetailProductVo> search_product(int pi_num){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Search_DetailProductVo> list = new ArrayList<Search_DetailProductVo>();

		try {
			String sql = "SELECT a.PI_NAME, a.PI_PRICE, b.PD_SIZE ,b.PD_COLOR,b.PD_COUNT, c.PP_TITLE , d.R_NUM ,d.R_TITLE,d.r_content ,d.R_DATE ,d.R_HIT ,e.RP_TITLE "
					+ "FROM product_infomation a, PRODUCT_DETAIL b, PRODUCT_PHOTO c, REVIEW d, review_photo e,PURCHASE_HISTORY f "
					+ "WHERE a.PI_NUM = b.PI_NUM "
					+ "AND a.PI_NUM = c.PI_NUM "
					+ "AND a.PI_NUM = f.PI_NUM "
					+ "AND f.PH_NUM = d.PH_NUM "
					+ "AND d.R_NUM = e.R_NUM "
					+ "AND a.PI_NUM =" + pi_num;
			con = JDBC.getCon();
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Search_DetailProductVo vo = new Search_DetailProductVo(
						pi_num,
						rs.getString(1), 
						rs.getInt(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getInt(5), 
						rs.getString(6), 
						rs.getInt(7), 
						rs.getString(8), 
						rs.getString(9), 
						rs.getString(10), 
						rs.getInt(11),
						rs.getString(12));
			}
			return list;
		}catch(SQLException se){
			se.printStackTrace();
			return null;
		}finally {
			JDBC.close(con, pstmt, rs);
		}
	}
	
}
