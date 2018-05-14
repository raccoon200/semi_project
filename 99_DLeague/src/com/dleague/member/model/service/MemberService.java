package com.dleague.member.model.service;

import static com.dleague.common.JDBCTemplate.*;


import java.sql.Connection;
import java.util.List;

import com.dleague.member.model.dao.MemberDAO;
import com.dleague.member.model.vo.Member;
import com.dleague.memberTeam.model.vo.Team;


public class MemberService {
	//로그인처리를 위한 상수선언
	public static final int LOGIN_OK = 1;
	public static final int WRONG_PASSWORD = 0;
	public static final int ID_NOT_EXIST = -1;
	
	public static final int CHECK_OK = 1;
	public static final int WRONG_BIRTHDAY = 0;
	public static final int WRONG_ID = -1;
	
	public int loginCheck(String userId, String password) {
		Connection conn = getConnection();
		int result = new MemberDAO().loginCheck(conn, userId, password);
		close(conn);
		return result;
	}
	public Member selectOne(String userId) {
		Connection conn = getConnection();
		Member m = new MemberDAO().selectOne(conn, userId);
		close(conn);
		return m;
	}
	public int passwordCheck(String userId, String birthday) {
		Connection conn = getConnection();
		int result = new MemberDAO().passwordCheck(conn, userId, birthday);
		close(conn);
		return result;
	}
	public int passwordUpdate(String userId, String password) {
		Connection conn = getConnection();
		int result = new MemberDAO().passwordUpdate(conn, userId, password);
		close(conn);
		if(result>0) commit(conn);
		else rollback(conn);
		return result;
	}
	public int insertMember(Member member) {
		Connection conn = getConnection();
		int result = new MemberDAO().insertMember(conn, member);
		if(result > 0)
			commit(conn);
		else 
			rollback(conn);
		close(conn);
		return result;
	}
	
		
	public int memberInfoUpdate(Member member) {
		Connection conn = getConnection();
		int result = new MemberDAO().memberInfoUpdate(conn, member);
		close(conn);
		if(result>0) commit(conn);
		else rollback(conn);
		return result;
	}
	public int selectMemberCount(String teamName) {
		Connection conn = getConnection();
		int totalMember = new MemberDAO().selectMemberCount(conn, teamName);
		close(conn);
		return totalMember;
	}
	
	public List<Member> selectMemberList(int cPage, int numPerPage, String teamName) {
		Connection conn = getConnection();
		List<Member> list = new MemberDAO().selectMemberList(conn, cPage, numPerPage, teamName);
		close(conn);
		return list;
	}
	
	
}
