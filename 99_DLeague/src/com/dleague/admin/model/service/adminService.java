package com.dleague.admin.model.service;

import java.sql.Connection;
import java.util.List;

import com.dleague.admin.model.dao.adminDAO;
import com.dleague.member.model.vo.Member;
import com.dleague.memberTeam.model.vo.TeamRegister;
import com.dleague.search.model.dao.TeamDAO;
import com.dleague.search.model.vo.Team;

import static com.dleague.common.JDBCTemplate.*;

public class adminService {

	public List<Member> MemberList() {
		Connection conn = getConnection();
		List<Member> list = new adminDAO().MemberList(conn);
		close(conn);
		return list;
	}

	public int selectMemberCount() {
		Connection conn = getConnection();
		int totalMember = new adminDAO().selectMemberCount(conn);
		close(conn);
		return totalMember;
	}

	public List<Member> selectMemberList(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Member> list = new adminDAO().selectMemberList(conn, cPage, numPerPage);
		close(conn);
		return list;
	}

	public int selectUserIdMemberCount(String searchName) {
		Connection conn = getConnection();
		int totalMember = new adminDAO().selectUserIdMemberCount(conn,searchName);
		close(conn);
		return totalMember;
	}

	public List<Member> selectUserIdMemberList(int cPage, int numPerPage, String searchName) {
		Connection conn = getConnection();
		List<Member> list = new adminDAO().selectUserIdMemberList(conn, cPage, numPerPage,searchName);
		close(conn);
		return list;
	}

	public int selectUserNameMemberCount(String searchName) {
		Connection conn = getConnection();
		int totalMember = new adminDAO().selectUserNameMemberCount(conn,searchName);
		close(conn);
		return totalMember;
	}

	public List<Member> selectUserNameMemberList(int cPage, int numPerPage, String searchName) {
		Connection conn = getConnection();
		List<Member> list = new adminDAO().selectUserNameMemberList(conn, cPage, numPerPage,searchName);
		close(conn);
		return list;
	}

	public List<Member> userView(String userId) {
		Connection conn = getConnection();
		List<Member> list = new adminDAO().userView(conn,userId);
		close(conn);
		return list;
	}

	public List<String> selectByUserId(String searchName) {
		Connection conn = getConnection();
		List<String> list = new adminDAO().selectByUserId(conn, searchName);
		close(conn);
		return list;
	}

	public List<String> selectByUserName(String searchName) {
		Connection conn = getConnection();
		List<String> list = new adminDAO().selectByUserName(conn, searchName);
		close(conn);
		return list;
	}

	public int selectTeamCount(String searchName) {
		Connection conn = getConnection();
		int totalMember = new adminDAO().selectTeamCount(conn,searchName);
		close(conn);
		return totalMember;
	}

	public List<Team> selectTeamList(int cPage, int numPerPage, String searchName) {
		Connection conn = getConnection();
		List<Team> list = new adminDAO().selectTeamList(conn, cPage, numPerPage,searchName);
		close(conn);
		return list;
	}

	public List<String> selectByTeamName(String searchName) {
		Connection conn = getConnection();
		List<String> list = new adminDAO().selectByTeamName(conn, searchName);
		close(conn);
		return list;
	}

	public int acceptTeamCount() {
		Connection conn = getConnection();
		int totalMember = new adminDAO().acceptTeamCount(conn);
		close(conn);
		return totalMember;
	}

	public List<TeamRegister> acceptTeamList(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<TeamRegister> list = new adminDAO().acceptTeamList(conn, cPage, numPerPage);
		close(conn);
		return list;
	}

	public List<TeamRegister> acceptTeam(String acceptNo) {
		Connection conn = getConnection();
		List<TeamRegister> list = new adminDAO().acceptTeam(conn, acceptNo);
		close(conn);
		return list;
	}

}
