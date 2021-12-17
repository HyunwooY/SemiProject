package chaneloper.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.JDBC;
//ig_sequence.nextval 시퀀스명 필요
public class AddInterestDao {
	public int addinter(String mi_id, int pi_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = JDBC.getCon();
			String sql="INSERT INTO INTEREST_GOODS VALUES (ig_sequence.nextval, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mi_id);
			pstmt.setInt(2, pi_num);
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JDBC.close(con,pstmt,null);
		}
	}
}
