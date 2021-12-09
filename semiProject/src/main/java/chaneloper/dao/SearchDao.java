package chaneloper.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import chaneloper.vo.ProductVo;
import db.JDBC;

public class SearchDao {
	public ArrayList<ProductVo> search_product(String keyword, String classification, String sort){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ProductVo> list = new ArrayList<ProductVo>();
		String sql = "";
		try {
			con = JDBC.getCon();
			if(true) {
				sql = "SELECT a.PI_NUM ,a.PI_NAME,a.PI_PRICE, b.PD_COLOR,c.PP_TITLE, d.t_name FROM PRODUCT_INFOMATION a"
						+ "INNER JOIN PRODUCT_DETAIL b ON(a.PI_NUM = b.PI_NUM)"
						+ "INNER JOIN PRODUCT_PHOTO c ON(a.PI_NUM = c.PI_NUM)"
						+ "INNER JOIN TAG d ON(a.PI_NUM = d.PI_NUM)"
						+ "where a.PI_NAME like "+"%"+keyword+"%"
						+ "order by a.PI_DATE";
			}
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVo vo = new ProductVo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				list.add(vo);
			}
			return list;
		}catch(SQLException se){
			se.printStackTrace();
			return null;
		}finally {
			JDBC.close(con, pstmt, rs);
		}
	}
}
