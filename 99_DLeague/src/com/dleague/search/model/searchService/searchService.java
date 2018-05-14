package com.dleague.search.model.searchService;

import static com.dleague.common.JDBCTemplate.close;
import static com.dleague.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.Hashtable;
import java.util.List;

import com.dleague.game.model.vo.Game;
import com.dleague.search.model.dao.TeamDAO;
import com.dleague.search.model.vo.Activity;
import com.dleague.search.model.vo.Team;
import com.dleague.search.model.vo.TeamMember;


public class searchService {

	public List<Team> selectList() {
		Connection conn = getConnection();
		List<Team> list = new TeamDAO().selectList(conn);
		close(conn);
		return list;
	}

	public Hashtable<String,Integer> MemberCount() {
		Connection conn = getConnection();
		Hashtable<String, Integer> ht = new TeamDAO().MemberCount(conn);
		return ht;
	}

	public int selectMemberCount() {
		Connection conn = getConnection();
		int totalMember = new TeamDAO().selectMemberCount(conn);
		close(conn);
		return totalMember;
	}

	public List<Team> selectMemberList(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Team> list = new TeamDAO().selectMemberList(conn, cPage, numPerPage);
		close(conn);
		return list;
	}

	public List<String> selectByName(String searchName, String selectCode) {
		Connection conn = getConnection();
		List<String> list = new TeamDAO().selectByName(conn, searchName,selectCode);
		close(conn);
		return list;
	}

	public List<Team> selectChoiceList(int cPage, int numPerPage, String selectCode, String searchName) {
		Connection conn = getConnection();
		List<Team> list = new TeamDAO().selectChoiceList(conn, cPage, numPerPage, selectCode, searchName);
		close(conn);
		return list;
	}

	public int selectMemberCount(String selectCode, String searchName) {
		Connection conn = getConnection();
		int totalMember = new TeamDAO().selectMemberCount(conn, selectCode, searchName);
		close(conn);
		return totalMember;
	}

	public List<Team> teamSearch(String teamName) {
		Connection conn = getConnection();
		List<Team> list = new TeamDAO().teamSearch(conn,teamName);
		close(conn);
		return list;
	}

	public List<TeamMember> teamMemberSearch(String teamName) {
		Connection conn = getConnection();
		List<TeamMember> memberList = new TeamDAO().teamMemberSearch(conn, teamName);
		return memberList;
	}

	public List<Activity> activityListSearch(String teamName) {
		Connection conn = getConnection();
		List<Activity> activityList = new TeamDAO().activityListSearch(conn,teamName);
		return activityList;
	}

	/*public List<Game> gameSearchList() {
		Connection conn = getConnection();
		List<Game> gameSearchList = new TeamDAO().gameSearchList(conn);
		return gameSearchList;
	}*/

	public int selectGameCount() {
		Connection conn = getConnection();
		int totalGame = new TeamDAO().selectGameCount(conn);
		close(conn);
		return totalGame;
	}

	public List<Game> selectGameList(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Game> gameList = new TeamDAO().selectGameList(conn, cPage, numPerPage);
		close(conn);
		return gameList;
	}

	public List<Game> selectGameList(int cPage, int numPerPage, String gameDate) {
		Connection conn = getConnection();
		List<Game> gameList = new TeamDAO().selectGameList(conn, cPage, numPerPage,gameDate);
		close(conn);
		return gameList;
	}

}
