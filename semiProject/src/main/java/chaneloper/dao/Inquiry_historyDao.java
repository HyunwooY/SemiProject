package chaneloper.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.JDBC;

public class Inquiry_historyDao {
	
	// 전체 글의 개수
	public int getCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBC.getCon();
			String sql = "SELECT NVL(COUNT(NUM),0) CNT FROM INQUIRY_HISTORY";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			int maxnum = rs.getInt("cnt");
			return maxnum;			
		} catch(SQLException se) {
			se.printStackTrace();
			return -1;
		} finally {
			JDBC.close(con, pstmt, rs);
		}
	}
}
