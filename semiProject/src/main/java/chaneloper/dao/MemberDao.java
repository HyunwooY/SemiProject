package chaneloper.dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import chaneloper.vo.AddressVo;
import chaneloper.vo.MemberVo;
import db.JDBC;
import oracle.net.jdbc.TNSAddress.Address;
    
public class MemberDao {
	private static MemberDao instance = new MemberDao();
	public static MemberDao getInstance() {
		return instance;
	}
	//회원가입
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
	//회원 수정
	public int update(MemberVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBC.getCon();
			String sql = "update member_infomation set mi_pwd=?, mi_email=?, mi_phone=? where mi_pwd=?";
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
	//회원 삭제
	public int delete(String id, String pwd) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBC.getCon();
			String sql = "delete from member_infomation where mi_id=? and mi_pwd=?";
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
	//내정보 확인
	public MemberVo select(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBC.getCon();
			String sql ="select * from member_infomation where mi_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String pwd = rs.getString("mi_pwd");
				String name = rs.getString("mi_name");
				String email = rs.getString("mi_email");
				String phone = rs.getString("mi_phone");
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
	//로그인
	public boolean login(String id, String pwd) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBC.getCon();
			String sql = "select * from member_infomation where mi_id=? and mi_pwd=?";
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
	//아이디 찾기
	public String findId(String name, String email) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBC.getCon();
			String sql = "select mi_id from member_infomation where mi_name=? and mi_email=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString("mi_id");
			}
			return null;
		}catch(SQLException s) {
			s.printStackTrace();
			return null;
		}finally {
			JDBC.close(con, pstmt, rs);
		}
	}
	//비밀번호 찾기
	public String findPwd(String id, String email) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBC.getCon();
			String sql = "select mi_pwd from member_infomation where mi_id=? and mi_email=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, email);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString("mi_pwd");
			}
			return null;
		}catch(SQLException s) {
			s.printStackTrace(); 
			return null;
		}finally {
			JDBC.close(con, pstmt, rs);
		}
	}
	
	public boolean checkId(String id) { // 멤버와 셀러 같이 탐색
		Connection con = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs2 = null;
		try {
			con = JDBC.getCon();
			pstmt1 = con.prepareStatement("select mi_id from member_infomation where mi_id=?");
			pstmt1.setString(1, id);
			rs1 = pstmt1.executeQuery();
			pstmt2 = con.prepareStatement("select si_id from seller_infomation where si_id=?");
			pstmt2.setString(1, id);
			rs2 = pstmt2.executeQuery();
			if(rs1.next() || rs2.next()) {
				return false;
			}else {
				return true;
			}
		}catch(SQLException s) {
			s.printStackTrace();
			return false;
		}finally {
			JDBC.close(null,pstmt2,rs2);
			JDBC.close(con, pstmt1, rs1);
		}
	}
	//배송지 추가
	public int insertaddr(AddressVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con= JDBC.getCon();
			con.setAutoCommit(false);
			String sql = "insert into shipping_address values(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getNickname());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getPhone());
			pstmt.setString(5, vo.getAddr());
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
	
	//배송지 조인
	public AddressVo selectaddr(String id, String name) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBC.getCon();
			String sql ="select * from member_infomation mi, shipping_address sa where mi.mi_id=? and sa.sa_name=? and mi.mi_id=sa.mi_id";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String sanickname = rs.getString("sa_nickname");
				String saphone = rs.getString("sa_phone");
				String saaddr = rs.getString("sa_addr");
				AddressVo addrvo = new AddressVo(id,name,sanickname,saphone,saaddr);
				return addrvo;
			}
			return null;
		}catch(SQLException s) {
			s.printStackTrace();
			return null;
		}finally {
			JDBC.close(con, pstmt, rs);
		}
	}
//	public AddressVo defaultaddr(String id, String name, String df) {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			con = JDBC.getCon();
//			String sql ="select * from member_infomation mi, shipping_address sa "
//					+ "where mi.mi_id=? and sa.sa_name=? and mi.mi_id=sa.mi_id";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, id);
//			pstmt.setString(2, name);
//			rs = pstmt.executeQuery();
//			if(rs.next()) {
//				String sanickname = rs.getString("sa_nickname");
//				String saphone = rs.getString("sa_phone");
//				String saaddr = rs.getString("sa_addr");
//				AddressVo addrvo = new AddressVo(id,name,sanickname,saphone,saaddr);
//				return addrvo;
//			}
//			return null;
//		}catch(SQLException s) {
//			s.printStackTrace();
//			return null;
//		}finally {
//			JDBC.close(con, pstmt, rs);
//		}
//	}
}

