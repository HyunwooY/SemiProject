package chaneloper.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import chaneloper.vo.ProductVo;
import chaneloper.vo.SellerVo;
import db.JDBC;

public class ProductDao {
	private static ProductDao instance = new ProductDao();

	public static ProductDao getInstance() {
		return instance;
	}

	// 상품 등록
	public int productInsert(ProductVo vo) {
		SellerVo svo = new SellerVo();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBC.getCon();
			String sql = "INSERT INTO PRODUCT_INFOMATION VALUES(?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, vo.getPi_num());
			pstmt.setString(2, vo.getSi_id());
			pstmt.setString(3, vo.getPi_name());
			pstmt.setInt(4, vo.getPi_price());
			pstmt.setInt(5, vo.getPi_sales());
			pstmt.setInt(6, vo.getPi_count());
			con.commit();
			return pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
			String sql = "UPDATE PRODUCT_INFOMATION SET PI_NAME=?, PI_PRICE=?, PI_SALES=?, PI_COUNT=? WHERE PI_NUM=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getPi_name());
			pstmt.setInt(2, vo.getPi_price());
			pstmt.setInt(3, vo.getPi_sales());
			pstmt.setInt(4, vo.getPi_count());
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

}
