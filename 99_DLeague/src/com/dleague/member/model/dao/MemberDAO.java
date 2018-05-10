package com.dleague.member.model.dao;

import static com.dleague.common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import com.dleague.member.model.vo.Member;

public class MemberDAO {
private Properties prop = new Properties();
	
	public MemberDAO() {
		URL fileUrl = MemberDAO.class.getResource("/sql/member/member-query.properties");
		String fileName = fileUrl.getPath();//절대주소를 String타입으로 리턴
		System.out.println("fileName@MemberDAO="+fileName);
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int loginCheck(Connection conn, String userId, String password) {
		int result = -1;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("loginCheck");
		
		try {
			//1.미완성쿼리를 가지고 객체생성
			pstmt = conn.prepareStatement(query);
			//2.쿼리문에 변수대입
			pstmt.setString(1, userId);
			pstmt.setString(2, password);
			pstmt.setString(3, userId);
			//3.쿼리실행
			rset = pstmt.executeQuery();
			//4.결과를 result에 담기
			if(rset.next()) {
				result = rset.getInt("login_check");
			}
			System.out.println("result@MemberDAO.loginCheck="+result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public Member selectOne(Connection conn, String userId) {
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectOne");
		try {
			//1.미완성쿼리객체생성
			pstmt = conn.prepareStatement(query);
			//2.쿼리 완성
			pstmt.setString(1,userId);
			//3.쿼리 실행
			rset = pstmt.executeQuery();
			//4.rset 데이터를 m에 대입
			if(rset.next()) {
				m = new Member();
				m.setUserId(rset.getString("userid"));
				m.setPassword(rset.getString("password"));
				
				m.setUserName(rset.getString("username"));
				m.setRegioncode(rset.getString("regioncode"));
				m.setPhone(rset.getString("phone"));
				m.setEmail(rset.getString("email"));
				m.setBirthday(rset.getString("birthday"));
				m.setTeamname(rset.getString("teamname"));
				m.setProfile(rset.getString("profile"));
				m.setGrade(rset.getString("grade"));
				m.setPhoto(rset.getString("photo"));
				m.setEnrolldate(rset.getString("enrolldate"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
	}

	public int passwordCheck(Connection conn, String userId, String birthday) {
		int result = -1;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("passwordCheck");
		
		try {
			//1.미완성쿼리를 가지고 객체생성
			pstmt = conn.prepareStatement(query);
			//2.쿼리문에 변수대입
			pstmt.setString(1, userId);
			pstmt.setString(2, birthday);
			pstmt.setString(3, userId);
			//3.쿼리실행
			rset = pstmt.executeQuery();
			//4.결과를 result에 담기
			if(rset.next()) {
				result = rset.getInt("passwordCheck");
			}
			System.out.println("result@MemberDAO.password_check="+result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int passwordUpdate(Connection conn, String userId, String password) {
		int result = 0;
		String query = prop.getProperty("passwordUpdate");
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, password);
			pstmt.setString(2, userId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	public int memberInfoUpdate(Connection conn, Member member) {
	      int result = 0;
	      String query = prop.getProperty("memberInfoUpdate");
	      PreparedStatement pstmt = null;
	      try {
	         //sssssss
	         pstmt = conn.prepareStatement(query);
	         pstmt.setString(1, member.getPassword());
	         pstmt.setString(2, member.getUserName());
	         pstmt.setString(3, member.getRegioncode());
	         pstmt.setString(4, member.getPhone());
	         pstmt.setString(5, member.getEmail());
	         pstmt.setString(6, member.getBirthday());
	         pstmt.setString(7, member.getTeamname());
	         pstmt.setString(8, member.getProfile());
	         pstmt.setString(9, member.getGrade());
	         SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd"); 
	         //연경이 바보
	         pstmt.setDate(10, sdf.parse(member.getEnrolldate()));
	         pstmt.setString(11, member.getPhoto());
	         pstmt.setString(12, member.getUserId());
	         result = pstmt.executeUpdate();
	         System.out.println(result);
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(pstmt);
	      }
	      return result;
	   }


	public int insertMember(Connection conn, Member member) {
int result = 0;
PreparedStatement pstmt = null;
String query = prop.getProperty("insertMember");

try {
	pstmt = conn.prepareStatement(query);
	pstmt.setString(1,  member.getUserId());
	pstmt.setString(2,  member.getPassword());
	pstmt.setString(3,  member.getBirthday());
pstmt.setString(4,  member.getPhone());
pstmt.setString(5,  member.getEmail());
pstmt.setString(6,  member.getRegioncode());
pstmt.setString(7,  member.getProfile());

result = pstmt.executeUpdate();

	} catch (SQLException e) {
		e.printStackTrace();
	}
return result;
	}
}
		