package com.dleague.member.model.dao;

import static com.dleague.common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.dleague.member.model.vo.Member;
import com.dleague.memberTeam.model.vo.TeamRegister;

public class MemberDAO {
   private Properties prop = new Properties();
   
   public MemberDAO() {
      URL fileUrl = MemberDAO.class.getResource("/sql/member/member-query.properties");
      String fileName = fileUrl.getPath();//절대주소를 String타입으로 리턴
      //System.out.println("fileName@MemberDAO="+fileName);
      
      try {
         prop.load(new FileReader(fileName));
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   
   public int loginCheck(Connection conn, String userId, String password) {
      int result = -1;
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      
      String query = prop.getProperty("loginCheck");
      
      try {
         //1.미완성쿼리를 가지고 객체생성
         pstmt = conn.prepareStatement(query);
         //2.쿼리문에 변수대입
         pstmt.setString(1, userId);
         pstmt.setString(2, password);
         pstmt.setString(3, userId);
         //3.쿼리실행
         rset = pstmt.executeQuery();
         //4.결과를 result에 담기
         if(rset.next()) {
            result = rset.getInt("login_check");
         }
         //System.out.println("result@MemberDAO.loginCheck="+result);
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(rset);
         close(pstmt);
      }
      
      return result;
   }

   public Member selectOne(Connection conn, String userId) {
      Member m = null;
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      String query = prop.getProperty("selectOne");
      try {
         //1.미완성쿼리객체생성
         pstmt = conn.prepareStatement(query);
         //2.쿼리 완성
         pstmt.setString(1,userId);
         //3.쿼리 실행
         rset = pstmt.executeQuery();
         //4.rset 데이터를 m에 대입
         if(rset.next()) {
            m = new Member();
            m.setUserId(rset.getString("userid"));
            m.setPassword(rset.getString("password"));
            
            m.setUserName(rset.getString("username"));
            m.setRegioncode(rset.getString("regioncode"));
            m.setPhone(rset.getString("phone"));
            m.setEmail(rset.getString("email"));
            m.setBirthday(rset.getString("birthday"));
            m.setTeamname(rset.getString("teamname"));
            m.setProfile(rset.getString("profile"));
            m.setGrade(rset.getString("grade"));
            m.setPhoto(rset.getString("photo"));
            m.setEnrolldate(rset.getDate("enrolldate"));
            
         }
      } catch(SQLException e) {
         e.printStackTrace();
      } finally {
         close(rset);
         close(pstmt);
      }
      
      return m;
   }

   public int passwordCheck(Connection conn, String userId, String birthday) {
      int result = -1;
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      
      String query = prop.getProperty("passwordCheck");
      
      try {
         //1.미완성쿼리를 가지고 객체생성
         pstmt = conn.prepareStatement(query);
         //2.쿼리문에 변수대입
         pstmt.setString(1, userId);
         pstmt.setString(2, birthday);
         pstmt.setString(3, userId);
         //3.쿼리실행
         rset = pstmt.executeQuery();
         //4.결과를 result에 담기
         if(rset.next()) {
            result = rset.getInt("passwordCheck");
         }
         //System.out.println("result@MemberDAO.password_check="+result);
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(rset);
         close(pstmt);
      }
      
      return result;
   }

   public int passwordUpdate(Connection conn, String userId, String password) {
      int result = 0;
      String query = prop.getProperty("passwordUpdate");
      PreparedStatement pstmt = null;
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setString(1, password);
         pstmt.setString(2, userId);
         result = pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
      }
      return result;
   }
   public int memberInfoUpdate(Connection conn, Member member) {
         int result = 0;
         String query = prop.getProperty("memberInfoUpdate");
         PreparedStatement pstmt = null;
         try {
            
            pstmt = conn.prepareStatement(query);
   /*         pstmt.setString(1, member.getPassword());*/
            pstmt.setString(1, member.getUserName());
            pstmt.setString(2, member.getRegioncode());
            pstmt.setString(3, member.getPhone());
            pstmt.setString(4, member.getEmail());
            pstmt.setString(5, member.getBirthday());
            /*pstmt.setString(7, member.getTeamname());*/
            pstmt.setString(6, member.getProfile());
            pstmt.setString(7, member.getGrade());
            
            pstmt.setDate(8, member.getEnrolldate());
            pstmt.setString(9, member.getPhoto());
            pstmt.setString(10, member.getUserId());
           // System.out.println(member.getTeamname());
           // System.out.println(member);
            result = pstmt.executeUpdate();
           // System.out.println("MemberDAO@memberinfoUpdate"+member);
         } catch (SQLException e) {
            e.printStackTrace();
         } 
       finally {
            close(pstmt);
         }
         return result;
      }

	public int insertMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertMember");
/*		System.out.println(member);
*/		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,  member.getUserId());
			pstmt.setString(2,  member.getPassword());
			pstmt.setString(3, member.getUserName());
			pstmt.setString(4,  member.getRegioncode());
			pstmt.setString(5,  member.getPhone());
			pstmt.setString(6,  member.getEmail());
			pstmt.setString(7,  member.getProfile());
			pstmt.setString(8, member.getPhoto());
			pstmt.setString(9,  member.getBirthday());
		
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		}
		
	public int selectMemberCount(Connection conn, String teamName) {
		int totalMember = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectMemberCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, teamName);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				totalMember = rset.getInt("cnt");
			}
			//System.out.println("totalMember@MemberDAO="+totalMember);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return totalMember;
	}

   public int memberTeamIn(Connection conn, String userId, String teamName, String msg) {
      int result = 0;
      PreparedStatement pstmt = null;
      String query = prop.getProperty("memberTeamIn");
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setString(1, userId);
         pstmt.setString(2, teamName);
         pstmt.setString(3, msg);
         result = pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
      }
      return result;
   }

   public int memberTeamInCount(Connection conn, String userId, String teamName) {
      int cnt = 0;
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      String query = prop.getProperty("memberTeamInCount");
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setString(1, userId);
         pstmt.setString(2, teamName);
         rset = pstmt.executeQuery();
         if(rset.next()) {
            cnt = rset.getInt("cnt");
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(rset);
         close(pstmt);
      }
      return cnt;
   }

public int memberOut(Connection conn, String userId) {
	int result = 0;
	PreparedStatement pstmt = null;
	String query = prop.getProperty("memberOut");
	try {
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, userId);
		result = pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(pstmt);
	}
	return result;

}

public List<Member> selectMemberList(Connection conn, int cPage, int numPerPage, String teamName) {
	List<Member> list = null;
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	Member m = null;
	String query = prop.getProperty("selectMemberListByPaging");
	
	try {
		pstmt=conn.prepareStatement(query);
		//페이징
		pstmt.setString(1, teamName);
		pstmt.setInt(2, numPerPage*(cPage-1)+1);
		pstmt.setInt(3, numPerPage*cPage);
		/*System.out.println(numPerPage*(cPage-1)+1);
		System.out.println(numPerPage*cPage);*/
		rset=pstmt.executeQuery();
		
		list = new ArrayList<Member>();
		while(rset.next()) {
			m = new Member();
			m.setUserId(rset.getString("userid"));
			m.setUserName(rset.getString("username"));
			m.setPhone(rset.getString("phone"));
			m.setEmail(rset.getString("email"));
			m.setBirthday(rset.getString("birthday"));
			m.setProfile(rset.getString("profile"));
			m.setGrade(rset.getString("grade"));
			m.setRnum(rset.getInt("rnum"));			
			list.add(m);
		}
		//System.out.println("list@MemberDAO.selectMemberList="+list);
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
	return list;
	}
}
      