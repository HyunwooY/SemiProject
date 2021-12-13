package chaneloper.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import chaneloper.vo.Inquiry_historyVo;
import db.JDBC;

public class Inquiry_historyDao {
	private static Inquiry_historyDao instance = new Inquiry_historyDao();
	
	public static Inquiry_historyDao getInstance() {
		return instance;
	}
	
	public int inquiryInsert(Inquiry_historyVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBC.getCon();
			String sql = "INSERT INTO INQUIRY_HISTORY VALUES(INQURI_SQE.NEXTVAL, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getMi_id());
			pstmt.setInt(2, vo.getPi_num());
			pstmt.setString(3, vo.getIh_title());
			pstmt.setString(4, vo.getIh_question());
			pstmt.setString(5, vo.getIh_answer());
			
			return pstmt.executeUpdate();
		} catch(SQLException se) {
			se.printStackTrace();
			return -1;
		} finally {
			JDBC.close(con, pstmt, null);
		}
	}
	
	public ArrayList<Inquiry_historyVo> list(int startRow, int endRow){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBC.getCon();
			String sql = "select * from "
					+ "("
					+ "		select ih.*, rownum rnum from"
					+ "	    ("
					+ "        select * from inquiry_history order by ih_num desc"
					+ "     ) ih"
					+ ") where rnum>=? and rnum<=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			ArrayList<Inquiry_historyVo> list = new ArrayList<Inquiry_historyVo>();
			while(rs.next()) {
				int ih_num = rs.getInt("ih_num");
				String mi_id = rs.getString("mi_id");
				int pi_num = rs.getInt("pi_num");
				String ih_title = rs.getString("ih_title");
				String ih_question = rs.getString("ih_question");
				String ih_answer = rs.getString("ih_answer");
				Inquiry_historyVo vo = new Inquiry_historyVo(ih_num, mi_id, pi_num, ih_title, ih_question, ih_answer);
				list.add(vo);
			}
			return list;
		} catch(SQLException se) {
			se.printStackTrace();
			return null;
		} finally{
			JDBC.close(con, pstmt, rs);
		}
	}
	
	// 전체 글의 개수
	public int getCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBC.getCon();
			String sql = "SELECT NVL(count(ih_num),0) cnt from inquiry_history";
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
