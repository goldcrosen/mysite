package com.bit2015.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bit2015.mysite.vo.GuestBookVo;

public class GuestbookDao {

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

	public void insert(GuestBookVo vo) {
		try {

			Connection connection = getConnection();

			String sql = "insert into GUESTBOOK values(guestbook_seq.nextval,?,?,?, SYSDATE)";

			PreparedStatement pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getMessage());
			pstmt.executeUpdate();

			pstmt.close();
			connection.close();

		} catch (SQLException e) {
			System.out.println("SQL error:" + e);
		}
	}

	public List<GuestBookVo> getList() {
		List<GuestBookVo> list = new ArrayList<GuestBookVo>();

		try {
			Connection connection = getConnection();

			Statement stmt = connection.createStatement();

			String sql = "select * from GUESTBOOK order by NO desc";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				String message = rs.getString(4);
				String date = rs.getString(5);

				GuestBookVo vo = new GuestBookVo();

				vo.setNo(no);
				vo.setName(name);
				vo.setPassword(password);
				vo.setMessage(message);
				vo.setDate(date);

				list.add(vo);
			}

			rs.close();
			stmt.close();
			connection.close();

		} catch (SQLException e) {
			System.out.println("SQL error:" + e);
		}
		return list;
	}
	
	public void delete(GuestBookVo vo){		
		try{
			
			Connection connection = getConnection();
			
			String sql = "delete from GUESTBOOK where no = ? and password =?";

			PreparedStatement pstmt = connection.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getNo());
			pstmt.setString(2, vo.getPassword());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			connection.close();
			
			
		}catch(SQLException ex){
			System.out.println("SQL error:" + ex );
			
		}
	
	}

}
