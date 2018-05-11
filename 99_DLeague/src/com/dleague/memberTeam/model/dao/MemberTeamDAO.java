package com.dleague.memberTeam.model.dao;

import static com.dleague.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.dleague.memberTeam.model.vo.Activity;
import com.dleague.memberTeam.model.vo.Team;
import com.dleague.memberTeam.model.vo.TeamMember;


public class MemberTeamDAO {
	private Properties prop = new Properties();
	public MemberTeamDAO() {
		String fileName = MemberTeamDAO.class.getResource("/sql/memberTeam/team-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public List<Team> teamSearch(Connection conn, String teamName) {
		List<Team> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("teamNameSearch");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, teamName);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			
			while(rset.next()) {
				Team t = new Team();
				t.setTeamName(rset.getString("teamName"));
				t.setRegionCode(rset.getString("regionCode"));
				t.setCapTain(rset.getString("capTain"));
				t.setTeamLogo(rset.getString("teamLogo"));
				t.setIntroduce(rset.getString("introduce"));
				t.setFoundingDate(rset.getDate("foundingDate"));
				t.setStatus(rset.getString("status"));
				
				list.add(t);
			}
			/*System.out.println("DAO="+list);*/
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	public List<TeamMember> teamMemberSearch(Connection conn, String teamName) {
		List<TeamMember> memberList = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("TeamMemberSearch");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, teamName);
			
			rset = pstmt.executeQuery();
			
			memberList = new ArrayList<>();
			
			while(rset.next()) {
				TeamMember tm = new TeamMember();
				tm.setRnum(rset.getInt("rnum"));
				tm.setTeamName(rset.getString("teamname"));
				tm.setUserId(rset.getString("userid"));
				tm.setGrade(rset.getString("grade"));
				tm.setT_EnrollDate(rset.getDate("t_enrolldate"));
				tm.setRegionCode(rset.getString("regioncode"));
				
				memberList.add(tm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return memberList;
	}
	public List<Activity> activityListSearch(Connection conn, String teamName) {
		List<Activity> activityList = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("activityListSearch");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, teamName);
			pstmt.setString(2, teamName);
			
			rset = pstmt.executeQuery();
			
			activityList = new ArrayList<>();
			
			while(rset.next()) {
				Activity a = new Activity();
				a.setActivity_No(rset.getInt("activity_no"));
				a.setHome(rset.getString("home"));
				a.setAway(rset.getString("away"));
				a.setPlace(rset.getString("place"));
				a.setActivityDate(rset.getDate("activitydate"));
				a.setResult(rset.getString("result"));
				
				activityList.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return activityList;
	}
}