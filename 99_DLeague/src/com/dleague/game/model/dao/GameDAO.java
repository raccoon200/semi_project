package com.dleague.game.model.dao;

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

import com.dleague.game.model.vo.Game;
import com.dleague.search.model.vo.Activity;
import com.dleague.search.model.vo.Team;
public class GameDAO {
	Properties prop = new Properties();
	
	public GameDAO() {
		String fileName = GameDAO.class.getResource("/sql/game/game-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public int insertGame(Connection conn, Game g) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertGame");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, g.getHome());
			pstmt.setString(2, g.getGameDateString().substring(0, g.getGameDateString().lastIndexOf(" ")));
			pstmt.setString(3, "yyyy\"년\" mm\"월\" dd\"일\"");
			pstmt.setString(4, g.getPlace());
			pstmt.setString(5, g.getStartTime());
			pstmt.setString(6, g.getGameContent());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	public int getGameCountByTeamName(Connection conn, String teamname) {
		int cnt = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("getGameCountByTeamName");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, teamname);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				cnt = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}
	public List<Game> selectListByTeamName(Connection conn, String teamname) {
		List<Game> list = new ArrayList<Game>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectListByTeamName");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, teamname);
			pstmt.setString(2, teamname);			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Game g = new Game();
				g.setGameNo(rset.getInt("game_no"));
				g.setHome(rset.getString("home"));
				g.setAway(rset.getString("away"));
				g.setGameDate(rset.getDate("gamedate"));
				g.setGameRegDate(rset.getDate("game_reg_date"));
				g.setPlace(rset.getString("place"));
				g.setStartTime(rset.getString("start_time"));
				g.setGameContent(rset.getString("game_content"));
				g.setStatus(rset.getString("status"));
				g.setHomeLogo(rset.getString("homelogo"));
				g.setAwayLogo(rset.getString("awaylogo"));
				
				list.add(g);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	public Game selectOneGame(Connection conn, int no) {
		Game g = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectOneGame");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				g = new Game();
				g.setGameNo(rset.getInt("game_no"));
				g.setHome(rset.getString("home"));
				g.setAway(rset.getString("away"));
				g.setGameDate(rset.getDate("gamedate"));
				g.setGameRegDate(rset.getDate("game_reg_date"));
				g.setPlace(rset.getString("place"));
				g.setStartTime(rset.getString("start_time"));
				g.setGameContent(rset.getString("game_content"));
				g.setStatus(rset.getString("status"));
				g.setHomeLogo(rset.getString("homelogo"));
				g.setAwayLogo(rset.getString("awaylogo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return g;
	}
	public Activity selectOneWithResult(Connection conn, int no) {
		Activity a = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectOneWithResult");
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				a = new Activity();
				a.setActivity_No(rset.getInt("activity_no"));
				a.setHome(rset.getString("home"));
				a.setHomeLogo(rset.getString("homelogo"));
				a.setAway(rset.getString("away"));
				a.setAwayLogo(rset.getString("awaylogo"));
				a.setPlace(rset.getString("place"));
				a.setActivityDate(rset.getDate("activitydate"));
				a.setResult(rset.getString("result"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return a;
	}
	public Team selectTeamByTeamName(Connection conn, String teamname) {
		Team t = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectTeamByTeamName");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, teamname);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				t = new Team();
				t.setTeamName(rset.getString("teamName"));
				t.setRegionCode(rset.getString("regionCode"));
				t.setCapTain(rset.getString("capTain"));
				t.setTeamLogo(rset.getString("teamLogo"));
				t.setIntroduce(rset.getString("introduce"));
				t.setFoundingDate(rset.getDate("foundingDate"));
				t.setStatus(rset.getString("status"));
			}
			/*System.out.println("DAO="+list);*/
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return t;
	}
	public int waitTeamCheck(Connection conn, String teamName, int gameNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("waitTeamCheck");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, teamName);
			pstmt.setInt(2, gameNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			result = -1;
			e.printStackTrace();
		}
		return result;
	}
	public int insertWaitTeam(Connection conn, String teamName, int gameNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertWaitTeam");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, teamName);
			pstmt.setInt(2, gameNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
