package chaneloper.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import chaneloper.vo.MemberVo;
import db.JDBC;

public class MemberDao {
	private static MemberDao instance = new MemberDao();
	public static MemberDao getInstance() {
		return instance;
	}
	public int insert(MemberVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con= JDBC.getCon();
			con.setAutoCommit(false);
			String sql = "insert into member_infomation values(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getPhone());
			pstmt.executeUpdate();
			con.commit();
			return pstmt.executeUpdate();
		}catch(SQLException s) {
			s.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return -1;
		}finally {
			JDBC.close(con,pstmt,null);
		}
	}
	public int update(MemberVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBC.getCon();
			String sql = "update member_infomation set pwd=?, email=?, phone=? where pwd=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getPwd());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getPhone());
			pstmt.setString(4, vo.getPwd());
			return pstmt.executeUpdate();
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			JDBC.close(con, pstmt, null);
		}
	}  
	public int delete(String id, String pwd) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBC.getCon();
			String sql = "delete from member_infomation where id=? and pwd=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			return pstmt.executeUpdate();
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			JDBC.close(con, pstmt, null);
		}
	}
	public MemberVo select(String id, String pwd) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBC.getCon();
			String sql ="select * from member_infomation where id=? and pwd=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				MemberVo member = new MemberVo(id, pwd, name, email, phone);
				return member;
			}
			return null;
		}catch(SQLException s) {
			s.printStackTrace();
			return null;
		}finally {
			JDBC.close(con, pstmt, rs);
		}
	}
	public boolean checkMember(HashMap<String, String> map) {
		String id = map.get("id");
		String pwd = map.get("pwd");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBC.getCon();
			String sql = "select * from member where id=? and pwd=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
			return false;
		}catch(SQLException s) {
			s.printStackTrace();
			return false;
		}finally {
			JDBC.close(con, pstmt, rs);
		}
	}
}







