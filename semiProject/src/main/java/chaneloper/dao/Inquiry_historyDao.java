package chaneloper.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import chaneloper.vo.Inquiry_historyVo;
import db.JDBC;

public class Inquiry_historyDao {
	// 가장 큰 글 번호
	public int getMaxNum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBC.getCon();
			String sql = "SELECT NVL(MAX(IH_NUM),0) mnum FROM INQUIRY_HISTORY";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int maxNum = rs.getInt("mnum");
			return maxNum;
		} catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}
	}
	
	public int insert(Inquiry_historyVo vo) {
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		try {
			con = JDBC.getCon();
			int inquiryNum = getMaxNum() + 1;
			
		} catch (SQLException se) {
			se.printStackTrace();
			return -1;
		}
	}
	
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
