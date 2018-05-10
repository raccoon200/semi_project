package com.dleague.board.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import com.dleague.board.model.vo.RegionBoard;
import com.dleague.board.model.vo.RegionBoardComment;

import static com.dleague.common.JDBCTemplate.*;


public class BoardDAO {
	Properties prop = new Properties();
	
	public BoardDAO() {
		String fileName = BoardDAO.class.getResource("/sql/board/board-query.properties").getPath();
		System.out.println("fileName : "+fileName);
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public int selectRegionBoardCount(Connection conn, String regionCode) {
		int count = -1;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectRegionBoardCount");
		//String query = "SELECT COUNT(*) AS cnt FROM BOARD_REGION";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, regionCode);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				count = rset.getInt("cnt");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return count;
	}
	
	public List<RegionBoard> selectAll(Connection conn, int cPage, int numPerPage, String regionCode) {
		List<RegionBoard> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectAll");
		//String query = "SELECT V.* FROM ( SELECT ROWNUM AS RNUM, V.* FROM( SELECT * FROM BOARD_REGION ORDER BY BOARD_REGION_DATE DESC) V ) V WHERE RNUM BETWEEN ? AND ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, regionCode);
			pstmt.setInt(2, (cPage-1)*numPerPage+1);
			pstmt.setInt(3, cPage*numPerPage);
			
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				RegionBoard board = new RegionBoard(); 
				board.setBoard_region_no(rset.getInt("board_region_no"));
				board.setBoard_region_title(rset.getString("board_region_title"));
				board.setBoard_region_writer(rset.getString("board_region_writer"));
				board.setBoard_regioncode(rset.getString("board_regioncode"));
				board.setBoard_region_date(rset.getDate("board_region_date"));
				board.setOriginal_file_name(rset.getString("original_file_name"));
				board.setRenamed_file_name(rset.getString("renamed_file_name"));
				board.setCount(rset.getInt("count"));
				list.add(board);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}


	public RegionBoard selectRegionBoardOne(Connection conn, int no) {
		RegionBoard board = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectRegionBoardOne");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				board = new RegionBoard(); 
				board.setBoard_region_no(rset.getInt("board_region_no"));
				board.setBoard_region_title(rset.getString("board_region_title"));
				board.setBoard_region_writer(rset.getString("board_region_writer"));
				board.setBoard_regioncode(rset.getString("board_regioncode"));
				board.setBoard_region_date(rset.getDate("board_region_date"));
				board.setBoard_region_content(rset.getString("board_region_content"));
				board.setOriginal_file_name(rset.getString("original_file_name"));
				board.setRenamed_file_name(rset.getString("renamed_file_name"));
				board.setCount(rset.getInt("count"));
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
		
		return board;
	}


	public int insertRegionBoard(Connection conn, RegionBoard board) {
		int result = -1;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertRegionBoard");
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getBoard_region_title());
			pstmt.setString(2, board.getBoard_region_writer());
			pstmt.setString(3, board.getBoard_regioncode());
			pstmt.setString(4, board.getBoard_region_content());
			pstmt.setString(5, board.getOriginal_file_name());
			pstmt.setString(6, board.getRenamed_file_name());
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	public int selectRegionBoardNo(Connection conn) {
		int result = -1;
		PreparedStatement pstmt= null;
		ResultSet rset = null;
		String query = prop.getProperty("selectRecentRegionBoardNo");
		
		try {
			pstmt =conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("no");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}


	public List<RegionBoard> selectSearchTitle(Connection conn, int cPage, int numPerPage, String regionCode,
			String searchValue) {
		List<RegionBoard> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectSearchTitle");
		//String query = "SELECT V.* FROM ( SELECT ROWNUM AS RNUM, V.* FROM( SELECT * FROM BOARD_REGION ORDER BY BOARD_REGION_DATE DESC) V ) V WHERE RNUM BETWEEN ? AND ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, regionCode);
			pstmt.setString(2, "%"+searchValue+"%");
			pstmt.setInt(3, (cPage-1)*numPerPage+1);
			pstmt.setInt(4, cPage*numPerPage);
			
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				RegionBoard board = new RegionBoard(); 
				board.setBoard_region_no(rset.getInt("board_region_no"));
				board.setBoard_region_title(rset.getString("board_region_title"));
				board.setBoard_region_writer(rset.getString("board_region_writer"));
				board.setBoard_regioncode(rset.getString("board_regioncode"));
				board.setBoard_region_date(rset.getDate("board_region_date"));
				board.setOriginal_file_name(rset.getString("original_file_name"));
				board.setRenamed_file_name(rset.getString("renamed_file_name"));
				board.setCount(rset.getInt("count"));
				list.add(board);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	

	public List<RegionBoard> selectSearchId(Connection conn, int cPage, int numPerPage, String regionCode, 
			String searchValue) {
		List<RegionBoard> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectSearchId");
		//String query = "SELECT V.* FROM ( SELECT ROWNUM AS RNUM, V.* FROM( SELECT * FROM BOARD_REGION ORDER BY BOARD_REGION_DATE DESC) V ) V WHERE RNUM BETWEEN ? AND ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, regionCode);
			pstmt.setString(2, searchValue);
			pstmt.setInt(3, (cPage-1)*numPerPage+1);
			pstmt.setInt(4, cPage*numPerPage);
			
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				RegionBoard board = new RegionBoard(); 
				board.setBoard_region_no(rset.getInt("board_region_no"));
				board.setBoard_region_title(rset.getString("board_region_title"));
				board.setBoard_region_writer(rset.getString("board_region_writer"));
				board.setBoard_regioncode(rset.getString("board_regioncode"));
				board.setBoard_region_date(rset.getDate("board_region_date"));
				board.setOriginal_file_name(rset.getString("original_file_name"));
				board.setRenamed_file_name(rset.getString("renamed_file_name"));
				board.setCount(rset.getInt("count"));
				list.add(board);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}


	public int selectRegionBoardCountByTitle(Connection conn, String regionCode, String searchValue) {
		int count = -1;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectRegionBoardCountByTitle");
		//String query = "SELECT COUNT(*) AS cnt FROM BOARD_REGION";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, regionCode);
			pstmt.setString(2, "%"+searchValue+"%");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				count = rset.getInt("cnt");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return count;
	}
	public int selectRegionBoardCountById(Connection conn, String regionCode, String searchValue) {
		int count = -1;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectRegionBoardCountById");
		//String query = "SELECT COUNT(*) AS cnt FROM BOARD_REGION";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, regionCode);
			pstmt.setString(2, searchValue);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				count = rset.getInt("cnt");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return count;
	}


	public int increaseRegionCount(Connection conn, int no) {
		int result = -1;
		PreparedStatement pstmt= null;
		String query = prop.getProperty("increaseRegionCount");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}


	public int insertRegionBoardComment(Connection conn, RegionBoardComment regionBoardComment) {
		int result = -1;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertRegionBoardComment");
		
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setInt(1, regionBoardComment.getBoard_region_comment_level());
			pstmt.setString(2, regionBoardComment.getBoard_region_comment_writer());
			pstmt.setString(1, regionBoardComment.getBoard_region_comment_content());
			pstmt.setInt(3, regionBoardComment.getBoard_region_ref());
			pstmt.setInt(4, regionBoardComment.getBoard_region_comment_ref());
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
}
