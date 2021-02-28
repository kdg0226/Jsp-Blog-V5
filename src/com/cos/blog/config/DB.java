package com.cos.blog.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class DB {
	
	public static Connection getConnection() {
		try {
			
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/TestDB");
			Connection conn = ds.getConnection();
			
			return conn;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			conn.close();
			pstmt.close();
			if(rs != null)	rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}