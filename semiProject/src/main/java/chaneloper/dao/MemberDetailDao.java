package chaneloper.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import db.JDBC;

public class MemberDetailDao {
	private static MemberDetailDao instance=new MemberDetailDao();
	public static MemberDetailDao getInstance() {
		return instance;
	}
	public int bPayCom(String id) { 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBC.getCon();
			String sql = "select count(ph_state) cstate from member_infomation m, purchase_history p "
					+ "where m.mi_id=? and m.mi_id=p.mi_id and p.ph_state='결제전'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);		
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("cstate");
			}
			return -1;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			JDBC.close(con, pstmt, rs);
		}
	}
	public int aPayCom(String id) { 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBC.getCon();
			String sql = "select count(ph_state) cstate from member_infomation m, purchase_history p "
					+ "where m.mi_id=? and m.mi_id=p.mi_id and p.ph_state='결제완료'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);		
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("cstate");
			}
			return -1;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			JDBC.close(con, pstmt, rs);
		}
	}
	public int preparingP(String id) { 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBC.getCon();
			String sql = "select count(ph_state) cstate from member_infomation m, purchase_history p "
					+ "where m.mi_id=? and m.mi_id=p.mi_id and p.ph_state='상품준비중'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("cstate");
			}
			return -1;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			JDBC.close(con, pstmt, rs);
		}
	}
	public int beingDelivery(String id) { 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBC.getCon();
			String sql = "select count(ph_state) cstate from member_infomation m, purchase_history p "
					+ "where m.mi_id=? and m.mi_id=p.mi_id and p.ph_state='배송중'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("cstate");
			}
			return -1;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			JDBC.close(con, pstmt, rs);
		}
	}
	public int compDelivery(String id) { 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBC.getCon();
			String sql = "select count(ph_state) cstate from member_infomation m, purchase_history p "
					+ "where m.mi_id=? and m.mi_id=p.mi_id and p.ph_state='배송완료' and sysdate-ph_regdate<=30";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("cstate");
			}
			return -1;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			JDBC.close(con, pstmt, rs);
		}
	}
	public int cancel(String id) {  // 취소
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBC.getCon();
			String sql = "select count(ph_state) cstate from member_infomation m, purchase_history p "
					+ "where m.mi_id=? and m.mi_id=p.mi_id and p.ph_state='취소' and sysdate-ph_regdate<=30";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("cstate");
			}
			return -1;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			JDBC.close(con, pstmt, rs);
		}
	}
	public int refund(String id) {  // 환불
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBC.getCon();
			String sql = "select count(ph_state) cstate from member_infomation m, purchase_history p "
					+ "where m.mi_id=? and m.mi_id=p.mi_id and p.ph_state='환불' and sysdate-ph_regdate<=30";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("cstate");
			}
			return -1;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			JDBC.close(con, pstmt, rs);
		}
	}
	public int change(String id) {  // 취소내역
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBC.getCon();
			String sql = "select count(ph_state) cstate from member_infomation m, purchase_history p "
					+ "where m.mi_id=? and m.mi_id=p.mi_id and p.ph_state='교환' and sysdate-ph_regdate<=30";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("cstate");
			}
			return -1;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			JDBC.close(con, pstmt, rs);
		}
	}
}









