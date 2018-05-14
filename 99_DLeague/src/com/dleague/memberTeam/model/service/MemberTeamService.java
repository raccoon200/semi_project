package com.dleague.memberTeam.model.service;

import static com.dleague.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.dleague.memberTeam.model.dao.MemberTeamDAO;
import com.dleague.memberTeam.model.vo.Activity;
import com.dleague.memberTeam.model.vo.Team;
import com.dleague.memberTeam.model.vo.TeamMember;
import com.dleague.memberTeam.model.vo.TeamRegister;



public class MemberTeamService {

	public List<Team> teamSearch(String teamName) {
		Connection conn = getConnection();
		List<Team> list = new MemberTeamDAO().teamSearch(conn,teamName);
		close(conn);
		return list;
	}

	public List<TeamMember> teamMemberSearch(String teamName) {
		Connection conn = getConnection();
		List<TeamMember> memberList = new MemberTeamDAO().teamMemberSearch(conn, teamName);
		close(conn);
		return memberList;
	}

	public List<Activity> activityListSearch(String teamName) {
		Connection conn = getConnection();
		List<Activity> activityList = new MemberTeamDAO().activityListSearch(conn,teamName);
		close(conn);
		return activityList;
	}

	public int memberTeamOut(String userId) {
		Connection conn = getConnection();
		MemberTeamDAO memberDAO = new MemberTeamDAO();
		int result = memberDAO.memberTeamOut(conn, userId);
		memberDAO.memberTeamDelete(conn, userId);
		
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public int insertTeamRegist(TeamRegister team) {
		Connection conn = getConnection();
		int result = new MemberTeamDAO().insertTeamRegist(conn, team);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	
	
}
