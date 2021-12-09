package chaneloper.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			String sql="insert into seller_information values(?,?,?,?,?,?,?)";
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
}



