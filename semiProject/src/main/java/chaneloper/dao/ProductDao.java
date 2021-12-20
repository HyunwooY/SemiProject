package chaneloper.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import chaneloper.vo.ProductVo;
import db.JDBC;

public class ProductDao {
	private static ProductDao instance = new ProductDao();

	public static ProductDao getInstance() {
		return instance;
	}

	// 상품 등록
	public int productInsert(ProductVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBC.getCon();
			String sql1 = "INSERT ALL"
					+ " INTO PRODUCT_INFOMATION VALUES(PRO_SEQ.NEXTVAL, ?, ?, ?, 0, SYSDATE, ?)"					
					+ " INTO PRODUCT_PHOTO VALUES(?, ?)"
					+ " INTO TAG VALUES(TAG_SEQ.NEXTVAL, ?, ?)"
					+ " SELECT *"
					+ " FROM DUAL";
			// 상품 
			pstmt = con.prepareStatement(sql1);		
			pstmt.setString(1, vo.getSi_id());
			pstmt.setString(2, vo.getPi_name());
			pstmt.setInt(3, vo.getPi_price());
			pstmt.setString(4, vo.getPi_category());			
			pstmt.setString(5, vo.getPp_title());
			pstmt.setInt(6, vo.getPi_num());			
			pstmt.setInt(7, vo.getPi_num());
			pstmt.setString(8, vo.getT_name());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return 
			}
			
			String sql2 = "INSERT INTO PRODUCT_DETAIL VALUES(PRODUCT_DETAIL_SEQ.NEXTVAL, PRO_SEQ.CURRVAL, ?, ?, ?)";
			pstmt = con.prepareStatement(sql2);
			pstmt.setString(1, vo.getPd_size());
			pstmt.setString(2, vo.getPd_color());
			pstmt.setInt(3, vo.getPd_count());
			
			return pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
			return -1;
		} finally {
			JDBC.close(con, pstmt, null);
		}
	}
	
	// 상품 상세 등록
	public int productInsertDetail(ProductVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBC.getCon();
			String sql = "INSERT INTO PRODUCT_DETAIL VALUES(PRODUCT_DETAIL_SEQ.NEXTVAL, ?, ?, ?, ?)";	
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, vo.getPi_num());		// 상품 번호
			pstmt.setString(2, vo.getPd_size());		// 상품 사이즈
			pstmt.setString(3, vo.getPd_color());		// 상품 색상
			pstmt.setInt(4, vo.getPd_count());			// 상품 재고량
			return pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
			return -1;
		} finally {
			JDBC.close(con, pstmt, null);
		}
	}

	// 상품 수정
	public int productUpdate(ProductVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBC.getCon();
			String sql = "UPDATE PRODUCT_INFOMATION SET PI_NAME=?, PI_PRICE=?, PI_COUNT=?, PI_COUNT=?, WHERE PI_NUM=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getPi_name());
			pstmt.setInt(2, vo.getPi_price());
			pstmt.setString(3, vo.getPi_category());
			pstmt.setInt(4, vo.getPi_count());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			JDBC.close(con, pstmt, null);
		}
	}

	// 상품 삭제
	public int productDelete(int pi_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBC.getCon();
			String sql = "DELETE FROM PRODUCT_INFOMATION WHERE PI_NUM=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pi_num);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			JDBC.close(con, pstmt, null);
		}
	}
	
	// 메인에 보여질 전체 상품 리스트
	public ArrayList<ProductVo> listAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ProductVo> list = new ArrayList<ProductVo>();
		try {
			con = JDBC.getCon();
			String sql = "SELECT *"
					+ " FROM PRODUCT_INFOMATION PI "
					+ " INNER JOIN PRODUCT_PHOTO PP ON(PI.PI_NUM = PP.PI_NUM)"
					+ " INNER JOIN PRODUCT_DETAIL PD ON(PI.PI_NUM = PD.PI_NUM)"
					+ " INNER JOIN TAG P ON(PI.PI_NUM = P.PI_NUM)";				
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();			
			while(rs.next()) {
				int pi_num = rs.getInt("pi_num");
				String si_id = rs.getString("si_id");
				String pi_name = rs.getString("pi_name");
				int pi_price = rs.getInt("pi_price");
				int pi_count = rs.getInt("pi_count");
				Date pi_date = rs.getDate("pi_date");
				String pi_category = rs.getString("pi_category");
				String pp_title = rs.getString("pp_title");
				String pd_size = rs.getString("pd_size");
				String pd_color = rs.getString("pd_color");
				int pd_count = rs.getInt("pd_count");
				String t_name = rs.getString("t_name");
				ProductVo vo = new ProductVo(pi_num, si_id, pi_name, pi_price, pi_count, pi_date, pi_category, pd_size, pd_color, pd_count, pp_title, t_name);
				list.add(vo);
			}
			return list;
		} catch(SQLException se) {
			se.printStackTrace();
			return null;
		} finally {
			JDBC.close(con, pstmt, rs);
		}		
	}

	// 판매자 각각의 상품 리스트
//		public ArrayList<ProductVo> selectList(String si_id) {
//			Connection con = null;
//			PreparedStatement pstmt = null;
//			ResultSet rs = null;
//			ArrayList<ProductVo> list = new ArrayList<ProductVo>();
//			try {
//				con = JDBC.getCon();
//				String sql = "SELECT PI.PI_NUM, PI.PI_NAME, PI.PI_PRICE, PD.PD_SIZE, PD.PD_COLOR, PD.PD_COUNT, PD.PI_NUM, PP_TITLE"
//						+ " FROM SELLER_INFOMATION SI, PRODUCT_INFOMATION PI, PRODUCT_DETAIL PD, PRODUCT_PHOTO PP"
//						+ " WHERE SI.SI_ID = ? AND SI.SI_ID = PI.SI_ID"
//						+ " ORDER BY PI.PI_NUM ASC";	
//				pstmt = con.prepareStatement(sql);
//				pstmt.setString(1, "si_id");
//				rs = pstmt.executeQuery();			
//				while(rs.next()) {
//					int pi_num = rs.getInt("pi_num");
//					String pi_name = rs.getString("pi_name");
//					int pi_price = rs.getInt("pi_price");
//					int pi_count = rs.getInt("pi_count");
//					Date pi_date = rs.getDate("pi_date");
//					String pi_category = rs.getString("pi_category");
//					String pp_title = rs.getString("pp_title");
//					String pd_size = rs.getString("pd_size");
//					String pd_color = rs.getString("pd_color");
//					int pd_count = rs.getInt("pd_count");
//					ProductVo vo = new ProductVo(pi_num, si_id, pi_name, pi_price, pi_count, pi_date, pi_category, pp_title, pd_size, pd_color, pd_count);
//					list.add(vo);
//				}
//				return list;
//			} catch(SQLException se) {
//				se.printStackTrace();
//				return null;
//			} finally {
//				JDBC.close(con, pstmt, rs);
//			}		
//		}

//		public ArrayList<ProductVo> selectList(String si_id) {
//			Connection con = null;
//			PreparedStatement pstmt = null;
//			ResultSet rs = null;
//			ArrayList<ProductVo> list = new ArrayList<ProductVo>();
//			try {
//				con = JDBC.getCon();
//				String sql = "SELECT PI.PI_NUM, PI.PI_NAME, PI.PI_PRICE, PD.PD_SIZE, PD.PD_COLOR, PD.PD_COUNT, PD.PI_NUM, PP_TITLE"
//						+ " FROM SELLER_INFOMATION SI, PRODUCT_INFOMATION PI, PRODUCT_DETAIL PD, PRODUCT_PHOTO PP"
//						+ " WHERE SI.SI_ID = ? AND SI.SI_ID = PI.SI_ID"
//						+ " ORDER BY PI.PI_NUM ASC";	
//				pstmt = con.prepareStatement(sql);
//				pstmt.setString(1, "si_id");
//				rs = pstmt.executeQuery();			
//				while(rs.next()) {
//					int pi_num = rs.getInt("pi_num");
//					String pi_name = rs.getString("pi_name");
//					int pi_price = rs.getInt("pi_price");
//					int pi_count = rs.getInt("pi_count");
//					Date pi_date = rs.getDate("pi_date");
//					String pi_category = rs.getString("pi_category");
//					String pp_title = rs.getString("pp_title");
//					String pd_size = rs.getString("pd_size");
//					String pd_color = rs.getString("pd_color");
//					int pd_count = rs.getInt("pd_count");
//					ProductVo vo = new ProductVo(pi_num, si_id, pi_name, pi_price, pi_count, pi_date, pi_category, pp_title, pd_size, pd_color, pd_count);
//					list.add(vo);
//				}
//				return list;
//			} catch(SQLException se) {
//				se.printStackTrace();
//				return null;
//			} finally {
//				JDBC.close(con, pstmt, rs);
//			}		
//		}
		

}
