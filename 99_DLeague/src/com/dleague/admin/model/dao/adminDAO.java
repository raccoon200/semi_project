package com.dleague.admin.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.dleague.member.model.vo.Member;
import com.dleague.search.model.vo.Team;

import static com.dleague.common.JDBCTemplate.close;

public class adminDAO {
	private Properties prop = new Properties();
	public adminDAO() {
		String fileName = adminDAO.class.getResource("/sql/admin/admin-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Member> MemberList(Connection conn) {
		List<Member> list = new ArrayList<Member>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("allMemberList");
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member m = new Member();
				m.setUserId(rset.getString("userid"));
				m.setPassword(rset.getString("password"));
				m.setUserName(rset.getString("username"));
				m.setRegioncode(rset.getString("regioncode"));
				m.setPhone(rset.getString("phone"));
				m.setEmail(rset.getString("email"));
				m.setTeamname(rset.getString("teamname"));
				m.setProfile(rset.getString("profile"));
				m.setGrade(rset.getString("grade"));
				m.setPhoto(rset.getString("photo"));
				m.setEnrolldate(rset.getDate("enrolldate"));
				m.setBirthday(rset.getString("birthday"));

				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
	
		return list;
	}

	public int selectMemberCount(Connection conn) {
		int totalMember = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectMemberCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				totalMember = rset.getInt("cnt");
			}
//			System.out.println("totalMember@AdminDAO="+totalMember);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return totalMember;
	}

	public List<Member> selectMemberList(Connection conn, int cPage, int numPerPage) {
		List<Member> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectMemberListByPaging");
		
		try {
			pstmt=conn.prepareStatement(query);
			//공식2 시작 rownum과 마지막 rownum을 구하는 공식
			pstmt.setInt(1, numPerPage*(cPage-1)+1);
			pstmt.setInt(2, numPerPage*cPage);
			/*System.out.println(numPerPage*(cPage-1)+1);
			System.out.println(numPerPage*cPage);*/
			rset=pstmt.executeQuery();
			
			list = new ArrayList<Member>();
			while(rset.next()) {
				Member m = new Member();
				m.setUserId(rset.getString("userid"));
				m.setPassword(rset.getString("password"));
				m.setUserName(rset.getString("username"));
				m.setRegioncode(rset.getString("regioncode"));
				m.setPhone(rset.getString("phone"));
				m.setEmail(rset.getString("email"));
				m.setTeamname(rset.getString("teamname"));
				m.setProfile(rset.getString("profile"));
				m.setGrade(rset.getString("grade"));
				m.setPhoto(rset.getString("photo"));
				m.setEnrolldate(rset.getDate("enrolldate"));
				m.setBirthday(rset.getString("birthday"));
				m.setRnum(rset.getInt("rnum"));

				list.add(m);
			}
//			System.out.println("list@AdminDAO.selectMemberList="+list);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}


}
