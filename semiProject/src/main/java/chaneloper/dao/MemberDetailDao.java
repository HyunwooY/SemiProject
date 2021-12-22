package chaneloper.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import chaneloper.vo.AddressVo;
import chaneloper.vo.OrderHistoryVo;
import chaneloper.vo.Purchase_historyVo;
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
	public int change(String id) {  // 교환내역
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
	public ArrayList<OrderHistoryVo> showOrder(int ph_num) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = JDBC.getCon();
			ps=con.prepareStatement("select ph.ph_num ph_num,pd.pd_num pd_num, ph_type, ph_state, ph_regdate, pi_name, p_count, pi_price, pp_title "
					+ "from purchase_history ph, packaging p,product_detail pd,product_infomation pi, product_photo pp "
					+ "where ph.ph_num=p.ph_num and p.pd_num=pd.pd_num and pd.pi_num=pi.pi_num and pp.pi_num=pi.pi_num "
					+ "and ph.ph_num=? and"
					+ "(ph_state='결제전'or ph_state='결제완료' or ph_state='배송준비중' or ph_state='배송중' or ph_state='배송완료')");
			ps.setInt(1, ph_num);
			rs=ps.executeQuery();
			ArrayList<OrderHistoryVo> list=new ArrayList<OrderHistoryVo>();
			while(rs.next()) {
				OrderHistoryVo vo=new OrderHistoryVo(rs.getInt("ph_num"), null, rs.getString("ph_type"), rs.getString("ph_state"), 
						rs.getDate("ph_regdate"), rs.getString("pi_name"), rs.getInt("p_count"), rs.getInt("pi_price"),0,0,rs.getString("pp_title"),rs.getInt("pd_num"));
				list.add(vo);
			}
			return list;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			JDBC.close(con,ps,rs);
		}
	}
	public ArrayList<OrderHistoryVo> getPhlist(String id,Date start,Date end) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		PreparedStatement ps1 = null;
		ResultSet rs1 = null;
		try {
			con = JDBC.getCon();
			ps=con.prepareStatement("select ph_regdate,ph_num, ph_state, count(ph_num) count, sum(p_count*pi_price) priceall "
					+ "from (select ph.ph_num ph_num,pi.si_id si_id, ph_type, ph_state, ph_regdate, pi_name, p_count, pi_price "
					+ "from purchase_history ph, packaging p,product_detail pd ,product_infomation pi "
					+ "where ph.ph_num=p.ph_num and p.pd_num=pd.pd_num and pd.pi_num=pi.pi_num and ph.mi_id=? "
					+ "and ph_regdate>=? and ph_regdate<=? and "
					+ "(ph_state='결제전'or ph_state='결제완료' or ph_state='배송준비중' or ph_state='배송중' or ph_state='배송완료')) "
					+ "group by ph_regdate, ph_num,ph_state "
					+ "order by ph_regdate desc");
			ps.setString(1, id);
			ps.setDate(2, start);
			ps.setDate(3, end);
			rs=ps.executeQuery();
			ArrayList<OrderHistoryVo> list=new ArrayList<OrderHistoryVo>();
			while(rs.next()) {
			ps1=con.prepareStatement("select ph.ph_num ph_num,pd.pd_num pd_num, ph_type, ph_state, ph_regdate, pi_name, p_count, pi_price "
					+ "from purchase_history ph, packaging p,product_detail pd,product_infomation pi "
					+ "where ph.ph_num=p.ph_num and p.pd_num=pd.pd_num and pd.pi_num=pi.pi_num "
					+ "and ph_regdate>=? and ph_regdate<=? and ph.ph_num=? and"
					+ "(ph_state='결제전'or ph_state='결제완료' or ph_state='배송준비중' or ph_state='배송중' or ph_state='배송완료')");
			
			ps1.setDate(1, start);
			ps1.setDate(2, end);
			ps1.setInt(3, rs.getInt("ph_num"));
			rs1=ps1.executeQuery();
			rs1.next();
			OrderHistoryVo vo=new OrderHistoryVo(rs.getInt("ph_num"), id, rs1.getString("ph_type"), rs.getString("ph_state"), 
					rs.getDate("ph_regdate"), rs1.getString("pi_name"), 0, 0, rs.getInt("count"), rs.getInt("priceall"),null,0);
			list.add(vo);
			}
			return list;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			JDBC.close(ps1);
			JDBC.close(con,ps,rs);
		}
	}
	public ArrayList<OrderHistoryVo> showState(String id,Date start,Date end) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = JDBC.getCon();
			ps=con.prepareStatement("select ph.ph_num ph_num, ph_type, ph_state, ph_regdate, pi_name, p_count, pi_price "
					+ "from purchase_history ph, packaging p,product_detail pd,product_infomation pi "
					+ "where ph.ph_num=p.ph_num and p.pd_num=pd.pd_num and pd.pi_num=pi.pi_num and ph.mi_id=? "
					+ "and ph_regdate>=? and ph_regdate<=?and "
					+ "(ph_state='취소' or ph_state='환불' or ph_state='교환')");
			ps.setString(1, id);
			ps.setDate(2, start);
			ps.setDate(3, end);
			rs=ps.executeQuery();
			ArrayList<OrderHistoryVo> list=new ArrayList<OrderHistoryVo>();
			while(rs.next()) {
				OrderHistoryVo vo=new OrderHistoryVo(rs.getInt("ph_num"), id, rs.getString("ph_type"), rs.getString("ph_state"), 
						rs.getDate("ph_regdate"), rs.getString("pi_name"), rs.getInt("p_count"), rs.getInt("pi_price"),0,0,null,0);
				list.add(vo);
			}
			return list;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			JDBC.close(con,ps,rs);
		}
	}
	
	public int findP_num(int ph_num, int pd_num) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		try {
			con = JDBC.getCon();
			ps=con.prepareStatement("select p.p_num p_num from purchase_history ph, packaging p, product_detail pd "
					+ "	where ph.ph_num=p.ph_num and pd.pd_num=p.pd_num and p.ph_num=? and p.pd_num=?");
			ps.setInt(1, ph_num);
			ps.setInt(2, pd_num);
			rs=ps.executeQuery();
			if(rs.next()) {
				return rs.getInt("p_num");
			}
			return -1;
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JDBC.close(con,ps,rs);
		}
	}
	
	public int purchaseCancel(int p_num, int ph_num) {
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 =null;
		ResultSet rs=null;
		try {
			con = JDBC.getCon();
			ps=con.prepareStatement("delete from packaging where p_num=?");
			ps.setInt(1, p_num);
			ps.executeUpdate();
			ps1=con.prepareStatement("select * from packaging where ph_num=?");
			ps1.setInt(1, ph_num);
			rs=ps1.executeQuery();
			if(!rs.next()) {
				ps2=con.prepareStatement("delete from purchase_history where ph_num=?");
				ps2.setInt(1, ph_num);
				return ps2.executeUpdate();
			}
			
			return -2;
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JDBC.close(ps2);
			JDBC.close(ps1);
			JDBC.close(con,ps,rs);
		}
	}
	public int purchaseCancelAll(int ph_num) {
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		ResultSet rs = null;
		try {
			con = JDBC.getCon();
			ps=con.prepareStatement("delete from packaging where ph_num=?");
			ps.setInt(1, ph_num);
			ps.executeUpdate();
			ps1=con.prepareStatement("delete from purchase_history where ph_num=?");
			ps1.setInt(1, ph_num);
			return ps.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JDBC.close(ps1);
			JDBC.close(con,ps,rs);
		}
	}
	public AddressVo getAddr(int ph_num) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		try {
			con=JDBC.getCon();
			ps=con.prepareStatement("select ph_addr, ph_phone, ph_name from purchase_history where ph_num=?");
			ps.setInt(1, ph_num);
			rs=ps.executeQuery();
			if(rs.next()) {
				return new AddressVo(ph_num, null, rs.getString("ph_name"), null, rs.getString("ph_phone"), rs.getString("ph_addr"));
			}
			return null;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			JDBC.close(con,ps,rs);
		}
	}
}















