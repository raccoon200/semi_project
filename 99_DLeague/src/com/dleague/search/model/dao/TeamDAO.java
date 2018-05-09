package com.dleague.search.model.dao;

import static com.dleague.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

import com.dleague.search.model.vo.Team;
import com.dleague.search.model.dao.TeamDAO;

public class TeamDAO {
	private Properties prop = new Properties();
	public TeamDAO() {
		String fileName = TeamDAO.class.getResource("/sql/team/team-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Team> selectList(Connection conn) {
		List<Team> list = new ArrayList<Team>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
	
		return list;
	}

	public Hashtable<String, Integer> MemberCount(Connection conn) {
		Hashtable<String,Integer> ht = new Hashtable<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("MemberCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ht.put(rset.getString("teamname"), rset.getInt("cnt"));
			}
			/*System.out.println("hashTableTeamDAO="+ht);*/
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
	
		return ht;
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

	public List<Team> selectMemberList(Connection conn, int cPage, int numPerPage) {
		List<Team> list = null;
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
			
			list = new ArrayList<Team>();
			while(rset.next()) {
				Team t = new Team();
				t.setTeamName(rset.getString("teamName"));
				t.setRegionCode(rset.getString("regionCode"));
				t.setCapTain(rset.getString("capTain"));
				t.setTeamLogo(rset.getString("teamLogo"));
				t.setIntroduce(rset.getString("introduce"));
				t.setFoundingDate(rset.getDate("foundingDate"));
				t.setStatus(rset.getString("status"));
				t.setRnum(rset.getInt("rnum"));
				
				list.add(t);
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

	public List<String> selectByName(Connection conn, String searchName) {
		List<String> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectByName");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchName+"%");
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			while(rset.next()) {
				list.add(rset.getString("teamname"));
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

	public List<Team> selectChoiceList(Connection conn, int cPage, int numPerPage, String selectCode,
			String searchName) {
		List<Team> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectChoiceList");
		
		try {
			pstmt=conn.prepareStatement(query);
			//공식2 시작 rownum과 마지막 rownum을 구하는 공식
			pstmt.setString(1, selectCode);
			pstmt.setString(2, "%"+searchName+"%");
			pstmt.setInt(3, numPerPage*(cPage-1)+1);
			pstmt.setInt(4, numPerPage*cPage);
			/*System.out.println(numPerPage*(cPage-1)+1);
			System.out.println(numPerPage*cPage);*/
			rset=pstmt.executeQuery();
			
			list = new ArrayList<Team>();
			while(rset.next()) {
				Team t = new Team();
				t.setTeamName(rset.getString("teamName"));
				t.setRegionCode(rset.getString("regionCode"));
				t.setCapTain(rset.getString("capTain"));
				t.setTeamLogo(rset.getString("teamLogo"));
				t.setIntroduce(rset.getString("introduce"));
				t.setFoundingDate(rset.getDate("foundingDate"));
				t.setStatus(rset.getString("status"));
				t.setRnum(rset.getInt("rnum"));
				
				list.add(t);
			}
			/*System.out.println("list@AdminDAO.selectMemberList="+list);*/
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int selectMemberCount(Connection conn, String selectCode, String searchName) {
		int totalMember = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectOneTeamCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, selectCode);
			pstmt.setString(2, "%"+searchName+"%");
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

	public List<Team> teaSearch(Connection conn, String teamName) {
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
				list.add(rset.getString("teamname"));
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

}
