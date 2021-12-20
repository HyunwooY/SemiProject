package chaneloper.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.JDBC;
//ig_sequence.nextval 시퀀스명 필요
public class AddInterestDao {
	public int addinter(String mi_id, int pi_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;
		try {
			con = JDBC.getCon();
			
			String sql2="select * from INTEREST_GOODS where mi_id=? and pi_num=?";
			pstmt2 = con.prepareStatement(sql2);
			pstmt2.setString(1, mi_id);
			pstmt2.setInt(2, pi_num);
			rs = pstmt2.executeQuery();
			if(!rs.next()) {
				String sql="INSERT INTO INTEREST_GOODS VALUES (ig_sequence.nextval, ?, ?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, mi_id);
				pstmt.setInt(2, pi_num);
				return pstmt.executeUpdate();
			}else {
				String sql3="delete from INTEREST_GOODS where mi_id=? and pi_num=?";
				pstmt3 = con.prepareStatement(sql3);
				pstmt3.setString(1, mi_id);
				pstmt3.setInt(2, pi_num);
				pstmt3.executeUpdate();
				return -2;
			}
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JDBC.close(con,pstmt,null);
		}
	}
}
