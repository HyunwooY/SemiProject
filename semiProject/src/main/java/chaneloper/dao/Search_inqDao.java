package chaneloper.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import chaneloper.vo.Inquiry_historyVo;
import db.JDBC;

public class Search_inqDao {
	private static Search_inqDao instance=new Search_inqDao();
	private Search_inqDao() {}
	public static Search_inqDao getInstance() {
		return instance;
	}

	public int getCount(int pi_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBC.getCon();
			String sql="select NVL(count(IH_NUM),0) from INQUIRY_HISTORY where PI_NUM = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, pi_num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			return -1;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			JDBC.close(con, pstmt, rs);
		}		
	}
	public ArrayList<Inquiry_historyVo>  list(int startRow,int endRow,int pi_num){		
		String	sql= "select * from "
					+ "("
					+ "    select aa.*,rownum rnum from"
					+ "    ("
					+ "	      select * from INQUIRY_HISTORY where PI_NUM = ? "
					+ "	      order by IH_NUM desc"
					+ "    )aa"
					+ ")"
					+ "where rnum>=? and rnum<=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			con=JDBC.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, pi_num);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs=pstmt.executeQuery();
			ArrayList<Inquiry_historyVo> list=new ArrayList<Inquiry_historyVo> ();
			int i = 0;
			while(rs.next()) {
				
				int IH_NUM=rs.getInt("IH_NUM");
				String MI_ID=rs.getString("MI_ID");
				String IH_TITLE=rs.getString("IH_TITLE");
				String IH_QUESTION=rs.getString("IH_QUESTION");
				String IH_ANSWER = rs.getString("IH_ANSWER");
				Inquiry_historyVo vo = new Inquiry_historyVo(IH_NUM,MI_ID,pi_num,IH_TITLE,IH_QUESTION,IH_ANSWER);
				list.add(vo);
			}
			return list;
		}catch(SQLException s) {
			s.printStackTrace();
			return null;
		}finally {
			JDBC.close(con, pstmt, rs);
		}
	}
}
