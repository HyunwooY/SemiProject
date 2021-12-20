package chaneloper.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import chaneloper.vo.NoticeVo;
import db.JDBC;

public class NoticeDao {
	private static NoticeDao instance = new NoticeDao();
	
	public static NoticeDao getInstance() {
		return instance;
	}
		public int NoticeInsert(NoticeVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = JDBC.getCon();
			String sql = "INSERT INTO NOTICE VALUESE(NOTICE_SEQ.NEXTVAL,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getN_context());
			
			return pstmt.executeUpdate();
		} catch(SQLException se) {
			se.printStackTrace();
			return -1;
		} finally {
			JDBC.close(con, pstmt, null);
		}
		}
		public NoticeVo select(int num){
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;		
			try {
				con=JDBC.getCon();
				String sql="select * from Notice where n_num=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, num);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					String n_context = rs.getString("n_context");
					
					NoticeVo vo = new NoticeVo(num,n_context );
					return vo;
				}	
				return null;
			}catch(SQLException se) {
				se.printStackTrace();
				return null;
			}finally {
				JDBC.close(con, pstmt, rs);
			}
		}
		public int getCount() {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = JDBC.getCon();
				String sql = "SELECT NVL(count(n_num),0) cnt from notice";
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

public ArrayList<NoticeVo> list(int startRow, int endRow){
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
		String sql = "select * from "
				+ "("
				+ "		select n.*, rownum rnum from"
				+ "	    ("
				+ "        select * from notice order by n_num desc"
				+ "     ) n"
				+ ") where rnum>=? and rnum<=?";
		con = JDBC.getCon();
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, startRow);
		pstmt.setInt(2, endRow);
		rs = pstmt.executeQuery();
		ArrayList<NoticeVo> list = new ArrayList<NoticeVo>();
		while(rs.next()) {
			int n_num = rs.getInt("n_num");
			String n_context = rs.getString("n_context");
			NoticeVo vo = new NoticeVo(n_num,n_context );
			System.out.println(vo);
			list.add(vo);
			System.out.println(list);
		}
		return list;
	} catch(SQLException se) {
		se.printStackTrace();
		return null;
	} finally{
		JDBC.close(con, pstmt, rs);
	}
}
}