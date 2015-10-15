package com.bit2015.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bit2015.mysite.vo.BoardVo;



public class BoardDao {
	
	private Connection getConnection() throws SQLException {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
			connection = DriverManager.getConnection(dbURL, "webdb", "webdb");

		} catch (ClassNotFoundException e) {

			System.out.println("connection error:" + e);
		}
		return connection;
	}

	public void insert(BoardVo vo) {
		try {

			Connection connection = getConnection();

			String sql = "INSERT INTO BOARD (BOARD_NO,"
					                     + " TITLE,"
					                     + " CONTENT,"
					                     + " MEMBER_NO,"
					                     + " VIEW_CNT,"
					                     + " REG_DATE)"
					              + " VALUES(BOARD_NO_SEQ.NEXTVAL,"
					                     + " ?,"
					                     + " ?,"
					                     + " ?,"
					                     + " 0,"
					                     + " SYSDATE)";

			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getContent());
			ps.setInt(3, vo.getMemberNo());
			
			ps.executeUpdate();

			ps.close();
			connection.close();

		} catch (SQLException e) {
			System.out.println("SQL error:" + e);
		}
	}

	public List<BoardVo> getList() {
		List<BoardVo> list = new ArrayList<BoardVo>();

		try {
			Connection connection = getConnection();

			Statement st = connection.createStatement();

			String sql = "SELECT B.BOARD_NO,"
					         + " B.TITLE,"
					         + " B.CONTENT,"
					         + " B.MEMBER_NO,"
					         + " M.NAME,"
					         + " B.VIEW_CNT,"
					         + " TO_CHAR( B.REG_DATE, 'YYYY-MM-DD HH24:MI:SS') AS regDate"
					    + " FROM BOARD B, MEMBER M"
					   + " WHERE B.MEMBER_NO = M.NO"
				    + " ORDER BY regDate DESC";

			
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				
				BoardVo vo2 = new BoardVo();
				

				vo2.setBoardNo(rs.getInt(1));
				vo2.setTitle(rs.getString(2));
				vo2.setContent(rs.getString(3));
				vo2.setMemberNo(rs.getInt(4));
				vo2.setMemberName(rs.getString(5));
				vo2.setViewCnt(rs.getInt(6));
				vo2.setRegDate(rs.getString(7));
				
				list.add(vo2);
			}

			rs.close();
			st.close();
			connection.close();

		} catch (SQLException e) {
			System.out.println("SQL error:" + e);
		}
		return list;
	}
	
	public List<BoardVo> getList(BoardVo vo){
		
		List<BoardVo> list = new ArrayList<BoardVo>();
		
		try {
			Connection connection = getConnection();

			String sql = "SELECT *"
					+ " FROM BOARD"
					+ " WHERE BOARD_NO = ?"
			     + " ORDER BY REG_DATE DESC";
			
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setInt(1, vo.getBoardNo());
			
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				
				BoardVo vo2 = new BoardVo();
				

				vo2.setBoardNo(rs.getInt(1));
				vo2.setTitle(rs.getString(2));
				vo2.setContent(rs.getString(3));
				vo2.setMemberNo(rs.getInt(4));
				vo2.setViewCnt(rs.getInt(5));
				vo2.setRegDate(rs.getString(6));
				
				list.add(vo2);
			}

			rs.close();
			ps.close();
			connection.close();

		} catch (SQLException e) {
			System.out.println("SQL error:" + e);
		}
		return list;
		
	}
	
	public void delete(BoardVo vo){		
		try{
			
			Connection connection = getConnection();
			
			String sql = "delete from BOARD where board_no = ?";

			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, vo.getBoardNo());
			
			ps.executeUpdate();
			
			ps.close();
			connection.close();
			
			
		}catch(SQLException ex){
			System.out.println("SQL error:" + ex );
			
		}
	
	}
	
	public void update(BoardVo vo){
		try{
			Connection connection = getConnection();
			
			String sql = "UPDATE BOARD"
				         + " SET TITLE = ?,"
				             + " CONTENT = ?"
				       + " WHERE BOARD_NO = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getContent());
			ps.setInt(3, vo.getBoardNo());
			
			ps.executeUpdate();
			
			ps.close();
			connection.close();
			
		}catch(SQLException ex){
			System.out.println("SQL error: + ex");
		}
	}
	
	public void viewCntUpdate(BoardVo vo){
		try{
			Connection connection = getConnection();
			
			String sql = "UPDATE BOARD SET VIEW_CNT = VIEW_CNT +1 WHERE BOARD_NO = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, vo.getBoardNo());
			
			ps.executeUpdate();
			
			ps.close();
			connection.close();
			
		}catch(SQLException ex){
			System.out.println("SQL error: + ex");
		}
		
	}
	

}
