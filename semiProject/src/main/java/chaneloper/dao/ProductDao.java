package chaneloper.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import chaneloper.vo.ProductVo;
import db.JDBC;

public class ProductDao {
	private static ProductDao instance = new ProductDao();

	public static ProductDao getInstance() {
		return instance;
	}

	// 상품 등록
	public int productInsert(ProductVo vo) {		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBC.getCon();
			String sql = "INSERT INTO PRODUCT_INFOMATION VALUES(?, ?, ?, ?, ?, sysdate, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, vo.getPi_num());
			pstmt.setString(2, vo.getSi_id());
			pstmt.setString(3, vo.getPi_name());
			pstmt.setInt(4, vo.getPi_price());
			pstmt.setInt(5, vo.getPi_count());
			pstmt.setString(6, vo.getPi_category());
			return pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
			return -1;
		} finally {
			JDBC.close(con, pstmt, null);
		}
	}

	// 상품 업데이트
	public int productUpdate(ProductVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBC.getCon();
			String sql = "UPDATE PRODUCT_INFOMATION SET PI_NAME=?, PI_PRICE=?, PI_SALES=?, WHERE PI_NUM=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getPi_name());
			pstmt.setInt(2, vo.getPi_price());
			pstmt.setInt(3, vo.getPi_count());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			JDBC.close(con, pstmt, null);
		}
	}

	// 상품 삭제
	public int productDelete(int pi_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBC.getCon();
			String sql = "DELETE FROM PRODUCT_INFOMATION WHERE PI_NUM=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pi_num);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			JDBC.close(con, pstmt, null);
		}
	}
	
	// 상품 리스트
	public ArrayList<ProductVo> listAll(int pi_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ProductVo> list = new ArrayList<ProductVo>();
		try {
			con = JDBC.getCon();
			String sql = "SELECT *"
					+ " FROM PRODUCT_INFOMATION PI "
					+ " INNER JOIN PRODUCT_PHOTO PH ON(PI.PI_NUM = PH.PI_NUM)"
					+ " INNER JOIN PRODUCT_DETAIL PD ON(PI.PI_NUM = PD.PI_NUM)"
					+ " WHERE PI.PI_NUM=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pi_num);
			rs = pstmt.executeQuery();			
			if(rs.next()) {
				String si_id = rs.getString("si_id");
				String pi_name = rs.getString("pi_name");
				int pi_price = rs.getInt("pi_price");
				int pi_count = rs.getInt("pi_count");
				Date pi_date = rs.getDate("pi_date");
				String pi_category = rs.getString("pi_category");
				String pp_title = rs.getString("pp_title");
				String pd_size = rs.getString("pd_size");
				String pd_color = rs.getString("pd_color");
				int pd_count = rs.getInt("pd_count");
				ProductVo vo = new ProductVo(pi_num, si_id, pi_name, pi_price, pi_count, pi_date, pi_category, pp_title, pd_size, pd_color, pd_count);
				list.add(vo);
			}
			return list;
		} catch(SQLException se) {
			se.printStackTrace();
			return null;
		} finally {
			JDBC.close(con, pstmt, rs);
		}		
	}
	
//	public ArrayList<ProductVo> listAll(int pi_num) {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			con = JDBC.getCon();
//			String sql = "SELECT * FROM PRODUCT_INFOMATION WHERE PI_NUM = ?";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, pi_num);
//			rs = pstmt.executeQuery();
//			ArrayList<ProductVo> list = new ArrayList<ProductVo>();
//			while(rs.next()) {
//				String si_id = rs.getString("si_id");
//				String pi_name = rs.getString("pi_name");
//				int pi_price = rs.getInt("pi_price");
//				int pi_count = rs.getInt("pi_count");
//				Date pi_date = rs.getDate("pi_date");
//				String pi_category = rs.getString("pi_category");
//				ProductVo vo = new ProductVo(pi_num, si_id, pi_name, pi_price, pi_count, null, null, null, 0, null, null, 0);
//				list.add(vo);
//			}
//			return list;
//		} catch(SQLException se) {
//			se.printStackTrace();
//			return null;
//		} finally {
//			JDBC.close(con, pstmt, rs);
//		}		
//	}	

	// 상품 이미지 등록
	
}
