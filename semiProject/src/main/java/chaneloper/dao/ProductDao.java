package chaneloper.dao;

import java.sql.Connection;
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
	public ArrayList<ProductVo> list selectAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBC.getCon();
			String sql = "SELECT * FROM PRODUCT_INFOMATION PI, PRODUCT_PHOTO PH WHERE PI.PI_NUM = PH_PI_NUM";
		} catch(SQLException se) {
			se.printStackTrace();
		}
	}
	
	// 상품 이미지 등록
	
	


}
