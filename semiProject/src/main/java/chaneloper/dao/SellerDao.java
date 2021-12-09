package chaneloper.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import chaneloper.vo.SellerVo;
import db.JDBC;

public class SellerDao {
	private static SellerDao instance=new SellerDao();
	private SellerDao() {}
	public static SellerDao getInstance() {
		return instance;
	}
	public int insert(SellerVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			String sql="insert into seller_infomation values(?,?,?,?,?,?,?)";
			con=JDBC.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,vo.getSi_id());
			pstmt.setString(2,vo.getSi_pwd());
			pstmt.setString(3,vo.getSi_num());
			pstmt.setString(4,vo.getSi_addr());
			pstmt.setString(5,vo.getSi_phone());
			pstmt.setString(6,vo.getSi_name());
			pstmt.setString(7,vo.getEmail());
			return pstmt.executeUpdate();
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			JDBC.close(con,pstmt,null);
			
		}
	}
	
	// 아이디 찾기
	public boolean select(HashMap<String, String> map) {		
		String si_num = map.get("si_num");
		String si_email = map.get("si_email");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBC.getCon();
			String sql = "SELECT ID FROM SELLER_INFOMATION WHERE SI_NUM=? AND SI_EMAIL=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, si_num);
			pstmt.setString(2, si_email);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
			return false;
		}catch(SQLException se) {
			se.printStackTrace();
			return false;
		}finally {
			JDBC.close(con, pstmt, rs);
		}
	}
	
	// 삭제기능
	public int delete(String Si_id,String Si_pwd) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JDBC.getCon();
			String sql="delete from seller_information where Si_id=? and Si_pwd=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,Si_id);
			pstmt.setString(2,Si_pwd);
			return pstmt.executeUpdate();
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			JDBC.close(con,pstmt,null);
		}
		}
	
	//수정 기능
	public int update(SellerVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JDBC.getCon();
			String sql="update seller_information set Si_pwd=?,Si_addr=?,Si_phone=?,Si_name=?,Email=? where Si_id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getSi_pwd());
			pstmt.setString(2, vo.getSi_addr());
			pstmt.setString(3, vo.getSi_phone());
			pstmt.setString(4, vo.getSi_name());
			pstmt.setString(5, vo.getEmail());
			return pstmt.executeUpdate();
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			JDBC.close(con,pstmt,null);
		}
		}
		
	}



