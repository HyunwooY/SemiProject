package chaneloper.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import chaneloper.vo.ReviewVo;
import db.JDBC;

public class ReviewDao {
	private static ReviewDao rvinstance = new ReviewDao();
	
	public static ReviewDao getInstance() {
		return rvinstance;
	}
	         
	// 전체 리뷰 보기
	public ArrayList<ReviewVo> list(int startRow, int endRow, String id){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from "
						+ "("
						+ "		select rv.*, rownum rnum from"
						+ "	    ("
						+ "        select re.r_num r_num, re.ph_num ph_num, re.r_title r_title, re.r_date r_date, re.r_hit r_hit, re.r_content r_content from review re, purchase_history ph where ph.mi_id=? and  ph.ph_num=re.ph_num order by re.r_num desc"
						+ "     ) rv"
						+ ") where rnum>=? and rnum<=?";
			con = JDBC.getCon();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs = pstmt.executeQuery();
			ArrayList<ReviewVo> list = new ArrayList<ReviewVo>();
			while(rs.next()) {
				int r_num = rs.getInt("r_num");
				int ph_num = rs.getInt("ph_num");
				String r_title = rs.getString("r_title");
				Date r_date = rs.getDate("r_date");
				int r_hit = rs.getInt("r_hit");
				String r_content = rs.getString("r_content");
		//		String rp_title = rs.getString("rp_title");
				ReviewVo vo = new ReviewVo(r_num, ph_num, r_title, r_date, r_hit, r_content, null);
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
	
	public ArrayList<ReviewVo> photolist(String id){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select rp.rp_title rp_title, rp.r_num r_num from review_photo rp, review re, purchase_history ph "
					+ "where rp.r_num=re.r_num and re.ph_num=ph.ph_num and ph.mi_id=?";
			con = JDBC.getCon();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			ArrayList<ReviewVo> list = new ArrayList<ReviewVo>();
			while(rs.next()) {
				
				ReviewVo vo = new ReviewVo(rs.getInt("r_num"), 0, null, null, 0, null, rs.getString("rp_title"));
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
	
	// 리뷰 삭제
		public int ReviewDelete(int r_num) {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = JDBC.getCon();
				String sql = "delete from review where r_num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, r_num);
				return pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				return -1;
			} finally {
				JDBC.close(con, pstmt, null);
			}
		}
		
		// 전체 글의 개수
		public int getCount(String id) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = JDBC.getCon();
				String sql = "SELECT NVL(count(re.r_num),0) cnt from review re, purchase_history ph where re.ph_num=ph.ph_num and mi_id=?";
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
				String sql = "SELECT NVL(count(r_num),0) cnt from review";
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
