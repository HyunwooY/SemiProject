package chaneloper.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import chaneloper.vo.AddressVo;
import chaneloper.vo.ShowPurchaseListVo;
import db.JDBC;

public class PurchaseDao {
	private static PurchaseDao instance=new PurchaseDao();
	public static PurchaseDao getInstance() {
		return instance;
	}
	public int purchase(AddressVo vo, String id, String ph_type) {
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
	public ShowPurchaseListVo selectProduct(int pd_num) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		try {
			con = JDBC.getCon();
			ps=con.prepareStatement("select pp_title, pi_name, pd_size, pd_color, pi_price,si_name "
					+ "from product_infomation pi,product_detail pd, product_photo pp, seller_infomation si "
					+ "where pi.pi_num=pd.pi_num and pi.pi_num=pp.pi_num and pd_num=? and "
					+ "si.si_id=pi.si_id");
			ps.setInt(1, pd_num);
			rs=ps.executeQuery();
			if(rs.next()) {
				return new ShowPurchaseListVo(rs.getString("pp_title"), rs.getString("pi_name"),
						rs.getString("pd_size"), rs.getString("pd_color"), rs.getInt("pi_price"), rs.getString("si_name"));
			}
			return null;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}
	}
}









