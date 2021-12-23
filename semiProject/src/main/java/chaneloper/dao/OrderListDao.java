package chaneloper.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import chaneloper.vo.Inquiry_historyVo;
import chaneloper.vo.OrderListVo;
import db.JDBC;

public class OrderListDao {
private static OrderListDao instance = new OrderListDao();
	
	public static OrderListDao getInstance() {
		return instance;
	}
	public int OrderInsert(OrderListVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JDBC.getCon();
			String sql="";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,vo.getPi_num());
			pstmt.setString(2,vo.getPd_size());
			pstmt.setInt(3,vo.getPd_count());
			pstmt.setString(4,vo.getPi_name());
			pstmt.setDate(5,vo.getPh_regdate());
			pstmt.setInt(6,vo.getPi_price());
			pstmt.setString(7,vo.getPd_color());
		return pstmt.executeUpdate();
	}catch(SQLException se) {
		se.printStackTrace();
		return -1;
	}finally {
		JDBC.close(con,pstmt,null);
	}
}
	public ArrayList<OrderListVo> list(String mi_id, int startRow, int endRow){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBC.getCon();
			String sql = "select * from PURCHASE_HISTORY PH"
					+ " INNER JOIN MEMBER_INFOMATION MI ON PH.MI_ID = MI.MI_ID"
					+ " WHERE PH.MI_ID=?";
				
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			ArrayList<OrderListVo> list = new ArrayList<OrderListVo>();
			while(rs.next()) {
				int pi_num = rs.getInt("pi_num");
				String pd_size = rs.getString("pd_size");
				int pd_count = rs.getInt("pd_count");
				String pi_name = rs.getString("pi_name");
				Date Ph_regdate = rs.getDate("Ph_regdate");
				int pi_price = rs.getInt("pi_price");
				String pd_color = rs.getString("pd_color");
				OrderListVo vo = new OrderListVo(pi_num, pd_size, pd_count, pi_name, Ph_regdate, pi_price, pd_color);
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
	public int getCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBC.getCon();
			String sql = "";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			int maxnum = rs.getInt("cnt");
			return maxnum;
		} catch(SQLException se) {
			se.printStackTrace();
			return -1;
		} finally {
			JDBC.close(con, pstmt, rs);
		}
	}
}
	
