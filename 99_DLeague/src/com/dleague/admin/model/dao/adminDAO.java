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
import com.dleague.memberTeam.model.vo.TeamRegister;
import com.dleague.search.model.vo.Team;

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

	public List<Member> selectMemberList(Connection conn, int cPage, int numPerPage) {
		List<Member> list = null;
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
			
			list = new ArrayList<Member>();
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
				m.setRnum(rset.getInt("rnum"));

				list.add(m);
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

	public int selectUserIdMemberCount(Connection conn, String searchName) {
		int totalMember = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectUserIdMemberCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchName+"%");
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

	public List<Member> selectUserIdMemberList(Connection conn, int cPage, int numPerPage, String searchName) {
		List<Member> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectUserIdMemberListByPaging");
		
		try {
			pstmt=conn.prepareStatement(query);
			//공식2 시작 rownum과 마지막 rownum을 구하는 공식
			pstmt.setString(1, "%"+searchName+"%");
			pstmt.setInt(2, numPerPage*(cPage-1)+1);
			pstmt.setInt(3, numPerPage*cPage);
			/*System.out.println(numPerPage*(cPage-1)+1);
			System.out.println(numPerPage*cPage);*/
			rset=pstmt.executeQuery();
			
			list = new ArrayList<Member>();
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
				m.setRnum(rset.getInt("rnum"));

				list.add(m);
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

	public int selectUserNameMemberCount(Connection conn, String searchName) {
		int totalMember = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectUserNameMemberCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchName+"%");
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

	public List<Member> selectUserNameMemberList(Connection conn, int cPage, int numPerPage, String searchName) {
		List<Member> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectUserNameMemberListByPaging");
		
		try {
			pstmt=conn.prepareStatement(query);
			//공식2 시작 rownum과 마지막 rownum을 구하는 공식
			pstmt.setString(1, "%"+searchName+"%");
			pstmt.setInt(2, numPerPage*(cPage-1)+1);
			pstmt.setInt(3, numPerPage*cPage);
			/*System.out.println(numPerPage*(cPage-1)+1);
			System.out.println(numPerPage*cPage);*/
			rset=pstmt.executeQuery();
			
			list = new ArrayList<Member>();
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
				m.setRnum(rset.getInt("rnum"));

				list.add(m);
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

	public List<Member> userView(Connection conn, String userId) {
		List<Member> list = new ArrayList<Member>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("userView");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
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

	public List<String> selectByUserId(Connection conn, String searchName) {
		List<String> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectByUserId");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchName+"%");
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			while(rset.next()) {
				list.add(rset.getString("userid"));
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

	public List<String> selectByUserName(Connection conn, String searchName) {
		List<String> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectByUserName");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchName+"%");
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			while(rset.next()) {
				list.add(rset.getString("username"));
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

	public int selectTeamCount(Connection conn, String searchName) {
		int totalMember = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectTeamCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			if(searchName!=null) {
				pstmt.setString(1,"%"+searchName+"%");
			}else {
				pstmt.setString(1,"%"+"%");
			}
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

	public List<Team> selectTeamList(Connection conn, int cPage, int numPerPage, String searchName) {
		List<Team> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectTeamListByPaging");
		
		try {
			pstmt=conn.prepareStatement(query);
			//공식2 시작 rownum과 마지막 rownum을 구하는 공식
			if(searchName!=null) {
				pstmt.setString(1, "%"+searchName+"%");
			}else {
				pstmt.setString(1, "%"+"%");				
			}
			pstmt.setInt(2, numPerPage*(cPage-1)+1);
			pstmt.setInt(3, numPerPage*cPage);
			/*System.out.println(numPerPage*(cPage-1)+1);
			System.out.println(numPerPage*cPage);*/
			rset=pstmt.executeQuery();
			
			list = new ArrayList<Team>();
			while(rset.next()) {
				Team t = new Team();
				t.setTeamName(rset.getString("teamname"));
				t.setRegionCode(rset.getString("regioncode"));
				t.setCapTain(rset.getString("captain"));
				t.setTeamLogo(rset.getString("teamlogo"));
				t.setIntroduce(rset.getString("introduce"));
				t.setFoundingDate(rset.getDate("foundingdate"));
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

	public List<String> selectByTeamName(Connection conn, String searchName) {
		List<String> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectByTeamName");
		
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

	public int acceptTeamCount(Connection conn) {
		int totalMember = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("acceptTeamCount");
		
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

	public List<TeamRegister> acceptTeamList(Connection conn, int cPage, int numPerPage) {
		List<TeamRegister> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("acceptTeamListByPaging");
		
		try {
			pstmt=conn.prepareStatement(query);
			//공식2 시작 rownum과 마지막 rownum을 구하는 공식
			pstmt.setInt(1, numPerPage*(cPage-1)+1);
			pstmt.setInt(2, numPerPage*cPage);
			/*System.out.println(numPerPage*(cPage-1)+1);
			System.out.println(numPerPage*cPage);*/
			rset=pstmt.executeQuery();
			
			list = new ArrayList<TeamRegister>();
			while(rset.next()) {
				TeamRegister tr = new TeamRegister();
				tr.setTeam_register_no(rset.getInt("team_register_no"));
				tr.setTeamName(rset.getString("teamname"));
				tr.setT_register_writer(rset.getString("t_register_writer"));
				tr.setRegionCode(rset.getString("regioncode"));
				tr.setTeamLogo(rset.getString("teamlogo"));
				tr.setIntroduce(rset.getString("introduce"));
				tr.setRegister_msg(rset.getString("register_msg"));
				tr.setRegister_date(rset.getDate("register_date"));
				tr.setStatus(rset.getString("status"));
				tr.setRnum(rset.getInt("rnum"));
				
				list.add(tr);
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

	public List<TeamRegister> acceptTeam(Connection conn, String acceptNo) {
		List<TeamRegister> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("acceptTeam");
		
		try {
			pstmt=conn.prepareStatement(query);
			
			pstmt.setString(1, acceptNo);
			/*System.out.println(numPerPage*(cPage-1)+1);
			System.out.println(numPerPage*cPage);*/
			rset=pstmt.executeQuery();
			
			list = new ArrayList<TeamRegister>();
			while(rset.next()) {
				TeamRegister tr = new TeamRegister();
				tr.setTeam_register_no(rset.getInt("team_register_no"));
				tr.setTeamName(rset.getString("teamname"));
				tr.setT_register_writer(rset.getString("t_register_writer"));
				tr.setRegionCode(rset.getString("regioncode"));
				tr.setTeamLogo(rset.getString("teamlogo"));
				tr.setIntroduce(rset.getString("introduce"));
				tr.setRegister_msg(rset.getString("register_msg"));
				tr.setRegister_date(rset.getDate("register_date"));
				tr.setStatus(rset.getString("status"));
				tr.setRnum(rset.getInt("rnum"));
				
				list.add(tr);
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

}
