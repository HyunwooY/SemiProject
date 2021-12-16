package chaneloper.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import chaneloper.vo.AdressVo;
import db.JDBC;

public class PurchaseDao {
	public int purchase(AdressVo vo, String id, String ph_type) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = JDBC.getCon();
			ps=con.prepareStatement("insert into purchase_history values(ph_seq.nextval,?,?,'결제전',sysdate,?,?,?)");
			ps.setString(1, id);
			ps.setString(2, ph_type);
			ps.setString(3, vo.getAddr());
			ps.setString(4, vo.getPhone());
			ps.setString(5, vo.getName());
			return ps.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JDBC.close(con,ps,null);
		}
	}
}
