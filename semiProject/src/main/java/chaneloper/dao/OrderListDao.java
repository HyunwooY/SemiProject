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
				OrderListVo vo = new OrderListVo();
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
	
	// 주문 모두 조회
	public ArrayList<OrderListVo> orderListAll(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<OrderListVo> list = new ArrayList<OrderListVo>();
		try {
			con = JDBC.getCon();
			String sql = "SELECT * FROM PURCHASE_HISTORY PH"
					+ " INNER JOIN PRODUCT_DETAIL PD ON PH.PD_NUM = PD.PD_NUM"
					+ " INNER JOIN PRODUCT_INFOMATION PI ON PD.PI_NUM = PI.PI_NUM";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				// purchase_history table
				 int ph_num = rs.getInt("ph_num");					// 구매(판매) 번호
				 String mi_id = rs.getString("mi_id");				// 구매자 ID
				 String ph_type = rs.getString("ph_type");				// 구매 방법(카드결제, 무통장...)
				 String ph_state = rs.getString("ph_state");			// 구매상태(결제전, 결제완료, 배송준비중, 배송중, 배송완료)
				 Date ph_regdate = rs.getDate("ph_regdate");			// 구매 날짜
				 String ph_addr = rs.getString("ph_addr");				// 수령 주소
				 String ph_phone = rs.getString("ph_phone");			// 수령인 전화번호
				 String ph_name	 = rs.getString("ph_name");			// 수령인
				
				// product_detail table
				 int pd_num = rs.getInt("pd_num");					// 상품 세부 번호
				 String pd_size	= rs.getString("pd_size");			// 상품 사이즈
				 String pd_color = rs.getString("pd_color");			// 상품 색상
				 int pd_count = rs.getInt("pd_count");				// 판매수
				
				// product_infomation table
				 int pi_num	= rs.getInt("pi_num");			// 상품 번호
				 String pi_name	= rs.getString("pi_name");		// 상품 이름
				 int pi_price = rs.getInt("pi_price");			// 상품 가격				
				 int pi_count = rs.getInt("pi_count");			// 판매수
				 String pi_category = rs.getString("pi_category");			// 상품 분류
				 
				 OrderListVo vo = new OrderListVo(ph_num, mi_id, ph_type, ph_state, ph_regdate, ph_addr, ph_phone, ph_name, pd_num, pd_size, pd_color, pd_count, pi_num, pi_name, pi_price, pi_count, null, pi_category);
				 list.add(vo);
			}
			return list;
		} catch(SQLException se) {
			se.printStackTrace();
			return null;
		}
	}
}
	
