package com.bit2015.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bit2015.mysite.vo.MemberVo;

public class MemberDao {
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
	
	public MemberVo get(String email, String password){
		MemberVo vo = null;
		
		try{
			Connection conn = getConnection();
			
			String sql = "SELECT NO, NAME, EMAIL "
					      + "FROM MEMBER "
					      + "WHERE EMAIL = ? "
					      + "AND PASSWORD=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
				
				vo = new MemberVo();

				vo.setNo(rs.getLong(1));
				vo.setName(rs.getString(2));
				vo.setEmail(rs.getString(3));
			}
			
		}catch(SQLException ex){
			System.out.println("SQL Error:" +ex);
		}
		return vo;
	}
	
	public MemberVo get(Long no){
		MemberVo vo = null;
		
		return vo;
	}
	
	
	public void insert(MemberVo vo){
	
		Connection conn = null;
		
		try{
			conn = getConnection();
			
			String sql="INSERT INTO MEMBER(NO,NAME,EMAIL,PASSWORD,GENDER)"
					             + " VALUES(MEMBER_NO_SEQ.NEXTVAL, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getPassword());
			pstmt.setString(4, vo.getGender());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
		}catch(SQLException ex){
			System.out.println("sql error:" +ex);
		}
		
	}
	
	public void update(MemberVo vo){
		try{
			Connection conn = getConnection();
			
			String sql = "UPDATE MEMBER SET NAME = ?, EMAIL=?, PASSWORD=?, GENDER=? WHERE NO = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getPassword());
			pstmt.setString(4, vo.getGender());
			pstmt.setLong(5, vo.getNo());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
		}catch(SQLException ex){
			System.out.println("SQL Erorr: "+ex);
		}
	}
	
	
}
