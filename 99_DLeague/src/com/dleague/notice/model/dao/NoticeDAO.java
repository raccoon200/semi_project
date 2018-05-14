package com.dleague.notice.model.dao;

import static com.dleague.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.dleague.board.model.dao.BoardDAO;
import com.dleague.board.model.vo.RegionBoard;
import com.dleague.notice.model.vo.Notice;

public class NoticeDAO {
	Properties prop = new Properties();
	
	public NoticeDAO() {
		String fileName = NoticeDAO.class.getResource("/sql/notice/notice-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public List<Notice> selectAll(Connection conn, int cPage, int numPerPage) {
		List<Notice> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectAll");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Notice notice = new Notice(); 
				notice.setNotice_no(rset.getInt("notice_no"));
				notice.setNotice_title(rset.getString("notice_title"));
				notice.setNotice_writer(rset.getString("notice_writer"));
				notice.setNotice_content(rset.getString("notice_content"));
				notice.setNotice_date(rset.getDate("notice_date"));
				notice.setOriginal_file_name(rset.getString("original_file_name"));
				notice.setRenamed_file_name(rset.getString("renamed_file_name"));
				list.add(notice);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public List<Notice> selectSearchNoticeTitle(Connection conn, int cPage, int numPerPage, String searchValue) {
		List<Notice> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectSearchTitle");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchValue+"%");
			pstmt.setInt(2, (cPage-1)*numPerPage+1);
			pstmt.setInt(3, cPage*numPerPage);
			
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Notice notice = new Notice(); 
				notice.setNotice_no(rset.getInt("notice_no"));
				notice.setNotice_title(rset.getString("notice_title"));
				notice.setNotice_writer(rset.getString("notice_writer"));
				notice.setNotice_content(rset.getString("notice_content"));
				notice.setNotice_date(rset.getDate("notice_date"));
				notice.setOriginal_file_name(rset.getString("original_file_name"));
				notice.setRenamed_file_name(rset.getString("renamed_file_name"));
				list.add(notice);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	public int selectNoticeCount(Connection conn) {
		int result = -1;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectNoticeCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("cnt");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}
	public int selectNoticeCountBySearch(Connection conn, String searchValue) {
		int result = -1;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectNoticeCountBySearch");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchValue+"%");
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("cnt");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}
}
