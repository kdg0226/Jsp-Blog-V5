package com.cos.blog.domain.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cos.blog.config.DB;
import com.cos.blog.domain.user.dto.JoinReqDto;

public class UserDao {

	
	public int save(JoinReqDto dto) { //회원가입
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO USER(username, password, email, address, userRole, createDate) VALUES(?, ?, ?, ?, 'USER', NOW())";
		
		try {
			conn = DB.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getUsername());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getAddress());
			
			int result = pstmt.executeUpdate();
			
			return result;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DB.close(conn, pstmt, null);
		}
		
		return -1;
	}
	
	public void update() { //회원수정
		
	}
	
	public void usernameCheck() { //아이디 중복체크
		
	}
	
	public int findByUserName(String username) { // 회원정보보기
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM USER WHERE username = ?";
		
		try {
			conn = DB.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return 1;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DB.close(conn, pstmt, rs);
		}
		
		return -1;
	}
}
