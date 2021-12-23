package chaneloper.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.JDBC;

public class Interst_goodsDao {
	private static Interst_goodsDao instance = new Interst_goodsDao();
	
	public static Interst_goodsDao getInstance() {
		return instance;
	}
	
	public int count_ig(int pi_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			con = JDBC.getCon();
			String sql = "SELECT avg(r.R_HIT) FROM PURCHASE_HISTORY ph ,PACKAGING p ,PRODUCT_DETAIL pd ,PRODUCT_INFOMATION pi2, REVIEW r "
					+ "WHERE pi2.PI_NUM =pd.PI_NUM "
					+ "AND pd.PD_NUM = p.PD_NUM "
					+ "AND p.PH_NUM  = ph.PH_NUM "
					+ "AND pi2.PI_NUM = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pi_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("avg(r.R_HIT)");
			}
			return count;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			JDBC.close(con, pstmt, rs);
		}
	}
	
	public int count_pi_count(int pi_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			con = JDBC.getCon();
			String sql = "SELECT pi_count FROM PRODUCT_INFOMATION WHERE PI_NUM =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pi_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("pi_count");
			}
			return count;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			JDBC.close(con, pstmt, rs);
		}
	}
}
