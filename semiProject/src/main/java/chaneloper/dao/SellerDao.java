package chaneloper.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import chaneloper.vo.ProductVo;
import chaneloper.vo.SellerVo;
import db.JDBC;

public class SellerDao {
	private static SellerDao instance=new SellerDao();
	private SellerDao() {}
	public static SellerDao getInstance() {
		return instance;
	}
	public int sellerInsert(SellerVo vo) { //회원가입
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
	public boolean sellerLogin(String si_id,String si_pwd) { // 사업자 로그인
		Connection con=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con=JDBC.getCon();
			pstmt=con.prepareStatement("select * from seller_infomation where si_id=? and si_pwd=?");
			pstmt.setString(1, si_id);
			pstmt.setString(2, si_pwd);
			rs=pstmt.executeQuery();
			return rs.next();
		}catch(SQLException s) {
			s.printStackTrace();
			return false;
		}finally {
			JDBC.close(con,pstmt,rs);
		}
	}
	
	// 아이디 찾기
	public String sellerFindId(String si_num, String si_phone, String si_email) {	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBC.getCon();
			String sql = "SELECT SI_ID FROM SELLER_INFOMATION WHERE SI_NUM=? AND SI_PHONE=? AND SI_EMAIL=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, si_num);
			pstmt.setString(2, si_phone);
			pstmt.setString(3, si_email);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString("si_id");
			}
			return null;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			JDBC.close(con, pstmt, rs);
		}
	}

	// 비밀번호 찾기
	public String sellerFindPwd(String si_num, String si_email) {	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBC.getCon();
			String sql = "SELECT SI_PWD FROM SELLER_INFOMATION WHERE SI_NUM=? AND SI_EMAIL=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, si_num);	
			pstmt.setString(3, si_email);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString("si_pwd");
			}
			return null;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			JDBC.close(con, pstmt, rs);
		}
	}
	
	// 삭제기능
	public int sellerDelete(String Si_id,String Si_pwd) {
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
	public int sellerUpdate(SellerVo vo) {
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
	
	
	// 판매자 상품 리스트
	public ArrayList<ProductVo> productList(String si_id){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ProductVo> list = new ArrayList<ProductVo>();
		try {
			con = JDBC.getCon();
			String sql = "SELECT PI.PI_NUM, PI.PI_NAME, PI.PI_PRICE, PD.PD_SIZE, PD.PD_COLOR, PD.PD_COUNT, PP_TITLE"
					+ " FROM SELLER_INFOMATION SI, PRODUCT_INFOMATION PI, PRODUCT_PHOTO PP, PRODUCT_DETAIL PD"
					+ " WHERE SI.SI_ID = ? AND SI.SI_ID = PI.SI_ID"
					+ " ORDER BY PI.PI_NUM ASC";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "si_id");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int pi_num = rs.getInt("pi_num");
				String pi_name = rs.getString("pi_name");
				int pi_price = rs.getInt("pi_price");
				String pd_size = rs.getString("pd_size");
				String pd_color = rs.getString("pd_color");
				int pd_count = rs.getInt("pd_count");
				String pp_title = rs.getString("pp_title");
				ProductVo vo = new ProductVo(pi_num, null, pi_name, pi_price, 0, null, null, pd_size, pd_color, pd_count, pp_title);
				list.add(vo);
			}
			return list;
		} catch(SQLException se) {
			se.printStackTrace();
			return null;
		}
	}
	
}



