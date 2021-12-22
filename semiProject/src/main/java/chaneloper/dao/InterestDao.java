package chaneloper.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import chaneloper.vo.InterestVo;
import db.JDBC;
//ig_sequence.nextval 시퀀스명 필요
public class InterestDao {
	private static InterestDao instance= new InterestDao();
	public static InterestDao getInstance() {
		return instance;
	}
	public int addinter(String mi_id, int pi_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;
		try {
			con = JDBC.getCon();
			
			String sql2="select * from INTEREST_GOODS where mi_id=? and pi_num=?";
			pstmt2 = con.prepareStatement(sql2);
			pstmt2.setString(1, mi_id);
			pstmt2.setInt(2, pi_num);
			rs = pstmt2.executeQuery();
			if(!rs.next()) {
				String sql="INSERT INTO INTEREST_GOODS VALUES (ig_sequence.nextval, ?, ?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, mi_id);
				pstmt.setInt(2, pi_num);
				return pstmt.executeUpdate();
			}else {
				String sql3="delete from INTEREST_GOODS where mi_id=? and pi_num=?";
				pstmt3 = con.prepareStatement(sql3);
				pstmt3.setString(1, mi_id);
				pstmt3.setInt(2, pi_num);
				pstmt3.executeUpdate();
				return -2;
			}
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JDBC.close(con,pstmt,null);
		}
	}
	public ArrayList<InterestVo> getInterestList(String mi_id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		try {
			con=JDBC.getCon();
			ps=con.prepareStatement("select pi.pi_num pi_num,pi.pi_name pi_name,pi.pi_price,si.si_name si_name,pp.pp_title pp_title "
					+ "from interest_goods ig,product_infomation pi, seller_infomation si,product_photo pp "
					+ "where ig.pi_num=pi.pi_num and si.si_id=pi.si_id and pp.pi_num=pi.pi_num and ig.mi_id=?");
			ps.setString(1, mi_id);
			rs=ps.executeQuery();
			ArrayList<InterestVo> list=new ArrayList<InterestVo>();
			while(rs.next()) {
				InterestVo vo=new InterestVo(0, mi_id, rs.getInt("pi_num"), rs.getString("si_name"), rs.getInt("pi_price"), rs.getString("pi_name"),rs.getString("pp_title"));
				list.add(vo);
			}
			return list;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}
	}
}



















