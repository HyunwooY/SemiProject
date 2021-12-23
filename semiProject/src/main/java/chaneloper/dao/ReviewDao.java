package chaneloper.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import chaneloper.vo.Inquiry_historyVo;
import chaneloper.vo.ReviewVo;
import db.JDBC;

public class ReviewDao {
	private static ReviewDao rvinstance = new ReviewDao();
	
	public static ReviewDao getInstance() {
		return rvinstance;
	}
	
	public int reviewInsert(ReviewVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBC.getCon();
			String sql = "insert into review values(rv_seq.NEXTVAL, ?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, vo.getPh_num());
			pstmt.setString(2, vo.getR_title());
			pstmt.setDate(3, vo.getR_date());
			pstmt.setInt(4, vo.getR_hit());
			pstmt.setString(5, vo.getR_content());
			pstmt.setString(6, vo.getRp_title());
			
			return pstmt.executeUpdate();
		} catch(SQLException se) {
			se.printStackTrace();
			return -1;
		} finally {
			JDBC.close(con, pstmt, null);
		}
	}
	// 전체 리뷰 보기
	public ArrayList<ReviewVo> rvlist(int startRow, int endRow, String field, String keyword){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		try {
			if(field==null || field.equals("")) {
				sql = "select * from "
						+ "("
						+ "		select rv.*, rownum rnum from"
						+ "	    ("
						+ "        select * from review order by r_num desc"
						+ "     ) rv"
						+ ") where rnum>=? and rnum<=?";
			}else {
				sql = "select * from "
						+ "("
						+ "		select rv.*, rownum rnum from"
						+ "	    ("
						+ "        select * from review where " + field + " like '%" + keyword + "%'"
						+ "     ) rv"
						+ ") where rnum>=? and rnum<=?";
			}
			con = JDBC.getCon();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			ArrayList<ReviewVo> rvlist = new ArrayList<ReviewVo>();
			while(rs.next()) {
				int r_num = rs.getInt("r_num");
				int ph_num = rs.getInt("ph_num");
				String r_title = rs.getString("r_title");
				Date r_date = rs.getDate("r_date");
				String r_hit = rs.getString("r_hit");
				String rp_title = rs.getString("rp_title");
				ReviewVo vo = new ReviewVo(r_num, ph_num, r_title, r_date, ph_num, r_hit, rp_title);
				rvlist.add(vo);
			}
			return rvlist;
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
		
		//상세글보기 
			public ReviewVo select(int r_num){
				Connection con=null;
				PreparedStatement pstmt=null;
				ResultSet rs=null;		
				try {
					con=JDBC.getCon();
					String sql="select * from review where r_num=?";
					pstmt=con.prepareStatement(sql);
					pstmt.setInt(1, r_num);
					rs=pstmt.executeQuery();
					if(rs.next()) {
						int ph_num = rs.getInt("ph_num");
						String r_title = rs.getString("r_title");
						Date r_date = rs.getDate("r_date");
						String r_hit = rs.getString("r_hit");
						String rp_title = rs.getString("rp_title");
						ReviewVo vo = new ReviewVo(r_num, ph_num, r_title, r_date, ph_num, r_hit, rp_title);
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
		public int getCount(String field, String keyword) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = JDBC.getCon();
				String sql = "SELECT NVL(count(r_num),0) cnt from review";
				if(field!=null && !field.equals("")) {
					sql += " where " + field + " like '%" + keyword + "%'";
				}
				pstmt = con.prepareStatement(sql);
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
