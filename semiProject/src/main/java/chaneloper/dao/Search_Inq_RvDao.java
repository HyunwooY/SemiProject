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
import chaneloper.vo.Search_ReviewVo;
import chaneloper.vo.Search_ReviewptVo;
import db.JDBC;

public class Search_Inq_RvDao {
	private static Search_Inq_RvDao instance=new Search_Inq_RvDao();
	private Search_Inq_RvDao() {}
	public static Search_Inq_RvDao getInstance() {
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
	
	public ArrayList<String> getqa(String mi_id, int pi_num, String title) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<String> list = new ArrayList<String>();
		try {
			con=JDBC.getCon();
			String sql="select * from INQUIRY_HISTORY where PI_NUM = ? and mi_id=? and ih_title=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, pi_num);
			pstmt.setString(2, mi_id);
			pstmt.setString(3, title);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				list.add(rs.getString("ih_question"));
				if(rs.getString("ih_answer")==null) {
					list.add("답변 준비중 입니다.");
				}else {
					list.add(rs.getString("ih_answer"));
				}
				
				list.add(title);
			}
			return list;
		}catch(SQLException s) {
			s.printStackTrace();
			return null;
		}finally {
			JDBC.close(con, pstmt, rs);
		}		
	}
	
	public int delqa(String mi_id, int pi_num, String title) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JDBC.getCon();
			String sql="delete from INQUIRY_HISTORY where PI_NUM = ? and mi_id=? and ih_title=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, pi_num);
			pstmt.setString(2, mi_id);
			pstmt.setString(3, title);
			return pstmt.executeUpdate();
			
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			JDBC.close(con, pstmt, null);
		}		
	}
	
	public int altqa(String mi_id, int pi_num, String title, String p3_q) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JDBC.getCon();
			String sql="update INQUIRY_HISTORY set ih_question=? where PI_NUM = ? and mi_id=? and ih_title=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, p3_q);
			pstmt.setInt(2, pi_num);
			pstmt.setString(3, mi_id);
			pstmt.setString(4, title);
			
			return pstmt.executeUpdate();
			
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			JDBC.close(con, pstmt, null);
		}		
	}
	
	public int insertqna(String mi_id, int pi_num, String title, String p3_q) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JDBC.getCon();
			String sql="INSERT INTO INQUIRY_HISTORY VALUES(IH_SEQ.nextval, ?, ?, ?, ?,'답변 준비중 입니다.')";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mi_id);
			pstmt.setInt(2, pi_num);
			pstmt.setString(3, title);
			pstmt.setString(4, p3_q);
			
			return pstmt.executeUpdate();
			
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			JDBC.close(con, pstmt, null);
		}		
	}
	
	public ArrayList<Search_ReviewVo> getrv(int pi_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		try {
			con=JDBC.getCon();
			String sql="SELECT ph.ph_num, ph.MI_ID ,r.R_HIT,r.R_DATE , r.R_TITLE,r.R_CONTENT,r.R_NUM FROM REVIEW r ,PURCHASE_HISTORY ph WHERE r.PH_NUM =ph.PH_NUM AND ph.pi_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, pi_num);
			ArrayList<Search_ReviewVo> list = new ArrayList<Search_ReviewVo>();
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Search_ReviewVo vo = new Search_ReviewVo(rs.getInt("ph_num"), rs.getString("MI_ID"), rs.getInt("R_HIT"), rs.getDate("R_DATE"), rs.getString("R_TITLE"),rs.getString("R_CONTENT"),rs.getInt("R_NUM"));
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
	
	public ArrayList<Search_ReviewptVo> getpt() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		try {
			con=JDBC.getCon();
			String sql="select rp.rp_title,rp.r_num FROM REVIEW r , REVIEW_PHOTO rp WHERE r.R_NUM =rp.R_NUM";
			pstmt=con.prepareStatement(sql);
			ArrayList<Search_ReviewptVo> list = new ArrayList<Search_ReviewptVo>();
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Search_ReviewptVo vo = new Search_ReviewptVo(rs.getInt("r_num"),rs.getString("rp_title"));
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
