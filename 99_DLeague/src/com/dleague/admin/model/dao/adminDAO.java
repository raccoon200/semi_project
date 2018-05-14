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

}
