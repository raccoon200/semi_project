package com.dleague.memberTeam.model.service;

import static com.dleague.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.dleague.memberTeam.model.dao.MemberTeamDAO;
import com.dleague.memberTeam.model.vo.Activity;
import com.dleague.memberTeam.model.vo.Team;
import com.dleague.memberTeam.model.vo.TeamMember;



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
		return memberList;
	}

	public List<Activity> activityListSearch(String teamName) {
		Connection conn = getConnection();
		List<Activity> activityList = new MemberTeamDAO().activityListSearch(conn,teamName);
		return activityList;
	}
	
	
	
}