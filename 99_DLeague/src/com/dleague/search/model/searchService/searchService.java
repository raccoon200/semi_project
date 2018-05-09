package com.dleague.search.model.searchService;

import static com.dleague.common.JDBCTemplate.close;
import static com.dleague.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.Hashtable;
import java.util.List;

import com.dleague.search.model.dao.TeamDAO;
import com.dleague.search.model.vo.Team;


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

	public List<String> selectByName(String searchName) {
		Connection conn = getConnection();
		List<String> list = new TeamDAO().selectByName(conn, searchName);
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


}