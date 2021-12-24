package chaneloper.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
			String sql = "INSERT INTO INQUIRY_HISTORY VALUES(INQURI_SEQ.NEXTVAL, ?, ?, ?, ?, null)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getMi_id());
			pstmt.setInt(2, vo.getPi_num());
			pstmt.setString(3, vo.getIh_title());
			pstmt.setString(4, vo.getIh_question());
			
			return pstmt.executeUpdate();
		} catch(SQLException se) {
			se.printStackTrace();
			return -1;
		} finally {
			JDBC.close(con, pstmt, null);
		}
	}
	
	
	public ArrayList<Inquiry_historyVo> list(int startRow, int endRow, String field, String keyword, String id){
		System.out.println("startRow:" + startRow);
		System.out.println("endRow:" + endRow);
		System.out.println("id:" + id);
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		try {
			if(field==null || field.equals("")) {
				sql = "select * from "
						+ "("
						+ "		select r.*, rownum rnum from"
						+ "	    ("
						+ "        SELECT ih.ih_num ih_num, ih.mi_id mi_id,ih.pi_num pi_num,ih.ih_title ih_title,ih.ih_question ih_question, ih.ih_answer ih_answer from inquiry_history ih,seller_infomation si, product_infomation pi "
						+ "		   where pi.pi_num=ih.pi_num and si.si_id=pi.si_id and si.si_id=?"
						+ "     ) r"
						+ ") where rnum>=? and rnum<=?";
			}else {
				sql = "select * from "
						+ "("
						+ "		select i.*, rownum rnum from"
						+ "	    ("
						+ "        select ih.ih_num ih_num, ih.mi_id mi_id,ih.pi_num pi_num,ih.ih_title ih_title,ih.ih_question ih_question, ih.ih_answer ih_answer from inquiry_history ih,seller_infomation si, product_infomation pi "
						+ " 	   where pi.pi_num=ih.pi_num and si.si_id=pi.si_id and si.si_id=? and " + field + " like '%" + keyword + "%'"
						+ "     ) i"
						+ ") where rnum>=? and rnum<=?";
			}
			con = JDBC.getCon();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
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
			System.out.println("daolist:" + list);
			return list;
		} catch(SQLException se) {
			se.printStackTrace();
			return null;
		} finally{
			JDBC.close(con, pstmt, rs);
		}
	}
	
	public int getCount(String field,String keyword) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBC.getCon();
			String sql="select NVL(count(num),0) from inquiry_history";
			if(field!=null && !field.equals("")) {
				sql += "where" + field + "like '%" + keyword + "%'";
			}
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
			return rs.getInt(1);
			}
			return -1;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			JDBC.close(con,pstmt,rs);
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
	
	// 판매자 문의 답글
	public int SellerInquiryUpdate(Inquiry_historyVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBC.getCon();
			String sql = "UPDATE Inquiry_history SET IH_ANSWER=? WHERE IH_NUM=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getIh_answer());
			pstmt.setInt(2, vo.getIh_num());
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
	
	//상세글보기 
		public Inquiry_historyVo select(int num){
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;		
			try {
				con=JDBC.getCon();
				String sql="select * from inquiry_history where ih_num=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, num);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					String mi_id = rs.getString("mi_id");
					int pi_num = rs.getInt("pi_num");
					String ih_title = rs.getString("ih_title");
					String ih_question = rs.getString("ih_question");
					String ih_answer = rs.getString("ih_answer");
					Inquiry_historyVo vo = new Inquiry_historyVo(num, mi_id, pi_num, ih_title, ih_question, ih_answer);
					return vo;
				}	
				return null;
			}catch(SQLException se) {
				se.printStackTrace();
				return null;
			}finally {
				JDBC.close(con, pstmt, rs);
			}
		}
	
	// 전체 글의 개수
	public int getCount(String field, String keyword, String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBC.getCon();
			String sql = "SELECT NVL(count(ih_num),0) cnt from inquiry_history ih,seller_infomation si, product_infomation pi "
					+"where pi.pi_num=ih.pi_num and si.si_id=pi.si_id and si.si_id=?";
			if(field!=null && !field.equals("")) {
				sql += " and " + field + " like '%" + keyword + "%'";
			}
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			return -1;
		} catch(SQLException se) {
			se.printStackTrace();
			return -1; 
		} finally {
			JDBC.close(con, pstmt, rs);
		}
	}
	
	//가장 큰 글번호
		public int getMaxNum() {
			Connection con = null;
			PreparedStatement pstmt = null;
			String sql = "SELECT NVL(count(ih_num),0) cnt from inquiry_history";
			ResultSet rs = null;
			try {
				con = JDBC.getCon();
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				rs.next();
				int maxnum = rs.getInt("cnt");
				return maxnum;
			}catch(SQLException s) {
				s.printStackTrace();
				return -1;
			}finally {
				JDBC.close(con, pstmt, rs);
			}
		}
}