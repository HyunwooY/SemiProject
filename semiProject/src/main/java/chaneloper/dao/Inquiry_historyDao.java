package chaneloper.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import chaneloper.vo.Inquiry_historyVo;
import chaneloper.vo.MemberVo;
import chaneloper.vo.ProductVo;
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
			String sql = "INSERT INTO INQUIRY_HISTORY VALUES(INQURI_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
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
	
	public Inquiry_historyVo select(int ih_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBC.getCon();
			String sql ="select * from Inquiry_history where ih_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ih_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String mi_id = rs.getString("mi_id");
				int pi_num = rs.getInt("pi_num");
				String ih_title = rs.getString("ih_title");
				String ih_question = rs.getString("ih_question");
				String ih_answer = rs.getString("ih_answer");
				Inquiry_historyVo Inquiry_history = new Inquiry_historyVo(ih_num,mi_id,pi_num,ih_title,ih_question,ih_answer);
				return Inquiry_history;
			}
			return null;
		}catch(SQLException s) {
			s.printStackTrace();
			return null;
		}finally {
			JDBC.close(con, pstmt, rs);
		}
	}
	
	public ArrayList<Inquiry_historyVo> list(int startRow, int endRow){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from "
					+ "("
					+ "		select ih.*, rownum rnum from"
					+ "	    ("
					+ "        select * from inquiry_history order by ih_num desc"
					+ "     ) ih"
					+ ") where rnum>=? and rnum<=?";
			con = JDBC.getCon();
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
				System.out.println(vo);
				list.add(vo);
				System.out.println(list);
			}
			return list;
		} catch(SQLException se) {
			se.printStackTrace();
			return null;
		} finally{
			JDBC.close(con, pstmt, rs);
		}
	}
	
	// 문의내역 수정
	public int InquiryUpdate(Inquiry_historyVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBC.getCon();
			String sql = "UPDATE Inquiry_history SET IH_TITLE=?,IH_QUESTION=? WHERE IH_NUM=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getIh_title());
			pstmt.setString(2, vo.getIh_question());
			pstmt.setInt(3, vo.getIh_num());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			JDBC.close(con, pstmt, null);
		}
	}

	// 문의내역 삭제
	public int inquiryDelete(int ih_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBC.getCon();
			String sql = "DELETE FROM Inquiry_history WHERE IH_NUM=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ih_num);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			JDBC.close(con, pstmt, null);
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