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
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		ResultSet rs = null;

		try {
			con = JDBC.getCon();
			String sql = "INSERT "
					+ " INTO PRODUCT_INFOMATION VALUES(PRO_SEQ.NEXTVAL,?,?,?,?,SYSDATE,?)";			
			pstmt1 = con.prepareStatement(sql);
			pstmt1.setString(1, vo.getSi_id());
			pstmt1.setString(2, vo.getPi_name());
			pstmt1.setInt(3, vo.getPi_price());
			pstmt1.setInt(4, vo.getPi_count());
			pstmt1.setString(5, vo.getPi_category());			
			int a = pstmt1.executeUpdate();
			String sql2 = "INSERT INTO PRODUCT_PHOTO VALUES(?, PRO_SEQ.CURRVAL)";
			pstmt2 = con.prepareStatement(sql2);
			pstmt2.setString(1, vo.getPp_title());			
			int b = pstmt2.executeUpdate();
			String sql3 =  "INSERT INTO TAG VALUES(TAG_SEQ.NEXTVAL, PRO_SEQ.CURRVAL, ?)";
			pstmt3 = con.prepareStatement(sql3);
			pstmt3.setString(1, vo.getT_name());
			int c = pstmt3.executeUpdate();
			pstmt4 = con.prepareStatement("select pro_seq.currval pi_num from dual");
			rs = pstmt4.executeQuery();
			if(rs.next()) {
				return rs.getInt("pi_num");				
			}
			return -1;
		} catch (SQLException se) {
			se.printStackTrace();
			return -1;
		} finally {		
			JDBC.close(pstmt3);
			JDBC.close(pstmt2);
			JDBC.close(con, pstmt1, null);
		}
	}
	
	// 상품 상세 등록
	public int productInsertDetail(int pi_num, ProductVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;	
		try {
			con = JDBC.getCon();
			String sql = "INSERT INTO PRODUCT_DETAIL VALUES(PRODUCT_DETAIL_SEQ.NEXTVAL, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pi_num);		// 상품 사이즈
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

	// 상품 정보 수정
	public int productUpdate(ProductVo vo) {
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		try {
			con = JDBC.getCon();
			String sql1 = "UPDATE PRODUCT_INFOMATION SET PI_NAME=?, PI_PRICE=?, PI_COUNT=?, PD_COUNT=? WHERE PI_NUM=?";
			pstmt1 = con.prepareStatement(sql1);
			pstmt1.setString(1, vo.getPd_size());
			pstmt1.setString(2, vo.getPd_color());
			pstmt1.setInt(3, vo.getPd_count());
			pstmt1.setInt(4, vo.getPd_count());
			pstmt1.setInt(5, vo.getPi_num());
			int a = pstmt1.executeUpdate();
			
			String sql2 = "UPDATE PRODUCT_PHOTO SET PP_TITLE=? WHERE PI_NUM=?";
			pstmt2 = con.prepareStatement(sql2);
			pstmt2.setString(1, vo.getPp_title());
			pstmt2.setInt(2, vo.getPi_num());
			int b = pstmt2.executeUpdate();
			
			String sql3 = "UPDATE TAG T_NAME=? WHERE PI_NUM=?";
			pstmt3 = con.prepareStatement(sql3);
			pstmt3.setString(1, vo.getT_name());
			pstmt3.setInt(2, vo.getPi_num());
			int c = pstmt3.executeUpdate();
			
			String sql4 = "UPDATE PRODUCT_DETAIL SET PD_SIZE=?, PD_COLOR=?, PD_COUNT=? WHERE PI_NUM=?";
			pstmt4 = con.prepareStatement(sql4);
			pstmt4.setString(1, vo.getPd_size());
			pstmt4.setString(2, vo.getPd_color());
			pstmt4.setInt(3, vo.getPd_count());
			pstmt4.setInt(5, vo.getPi_num());
			int d = pstmt4.executeUpdate();
			
			return a + b + c + d;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			JDBC.close(pstmt3);
			JDBC.close(pstmt2);
			JDBC.close(con, pstmt1, null);
		}
	}	

	// 상품 삭제
	public int productDelete(int pi_num, int pd_num) {
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		PreparedStatement pstmt5 = null;
		PreparedStatement pstmt6 = null;
		try {
			con = JDBC.getCon();		
			String sql2 = "DELETE FROM PRODUCT_DETAIL WHERE PD_NUM=?";
			pstmt2 = con.prepareStatement(sql2);
			pstmt2.setInt(1, pd_num);
			int b = pstmt2.executeUpdate(); //객체만 삭제		
				
			if(pi_num != 0) {		//전부다 삭제		
				String sql = "DELETE FROM PRODUCT_PHOTO WHERE PI_NUM=?";
				pstmt1 = con.prepareStatement(sql);
				pstmt1.setInt(1, pi_num);
				int a = pstmt1.executeUpdate();
				
				String sql3 = "DELETE FROM INQUIRY_HISTORY WHERE PI_NUM=?";
				pstmt3 = con.prepareStatement(sql3);
				pstmt3.setInt(1, pi_num);
				int c = pstmt3.executeUpdate();
				
				String sql4 = "DELETE FROM TAG WHERE PI_NUM=?";
				pstmt4 = con.prepareStatement(sql4);
				pstmt4.setInt(1, pi_num);
				int d = pstmt4.executeUpdate();
				
				String sql5 = "DELETE FROM INTEREST_GOODS WHERE PI_NUM=?";
				pstmt5 = con.prepareStatement(sql5);
				pstmt5.setInt(1, pi_num);
				int e = pstmt5.executeUpdate();
				
				String sql6 = "DELETE FROM PRODUCT_INFOMATION WHERE PI_NUM=?";
				pstmt6 = con.prepareStatement(sql6);
				pstmt6.setInt(1, pi_num);
				int f = pstmt6.executeUpdate();
				
			
			}
			return 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			JDBC.close(pstmt6);
			JDBC.close(pstmt5);
			JDBC.close(pstmt4);
			JDBC.close(pstmt3);
			JDBC.close(pstmt2);
			JDBC.close(con, pstmt1, null);
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
				int pd_num = rs.getInt("pd_num");
				ProductVo vo = new ProductVo(pi_num, si_id, pi_name, pi_price, pi_count, pi_date, pi_category, pd_size, pd_color, pd_count, pp_title, t_name, pd_num);
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

//	 판매자 각각의 상품 리스트
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
//					ProductVo vo = new ProductVo(pi_num, si_id, pi_name, pi_price, pi_count, pi_date, pi_category, pd_size, pd_color, pd_count, pp_title, pi_name);
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
