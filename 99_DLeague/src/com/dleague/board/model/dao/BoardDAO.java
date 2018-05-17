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

import com.dleague.board.model.vo.Complain;
import com.dleague.board.model.vo.FreeBoard;
import com.dleague.board.model.vo.FreeBoardComment;
import com.dleague.board.model.vo.RegionBoard;
import com.dleague.board.model.vo.RegionBoardComment;

import static com.dleague.common.JDBCTemplate.*;


public class BoardDAO {
	Properties prop = new Properties();
	
	public BoardDAO() {
		String fileName = BoardDAO.class.getResource("/sql/board/board-query.properties").getPath();
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


	public int selectRecentRegionBoardNo(Connection conn) {
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
			String boardRegionCommentRef = regionBoardComment.getBoard_region_comment_ref()==0?null:String.valueOf(regionBoardComment.getBoard_region_comment_ref());
			
			pstmt= conn.prepareStatement(query);
			pstmt.setInt(1, regionBoardComment.getBoard_region_comment_level());
			pstmt.setString(2, regionBoardComment.getBoard_region_comment_writer());
			pstmt.setString(3, regionBoardComment.getBoard_region_comment_content());
			pstmt.setInt(4, regionBoardComment.getBoard_region_ref());
			pstmt.setString(5, boardRegionCommentRef);
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}


	public List<RegionBoardComment> selectRegionCommentAll(Connection conn, int no) {
		List<RegionBoardComment> regionbcList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectRegionCommentAll");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				RegionBoardComment bc = new RegionBoardComment();
				bc.setBoard_region_comment_no(rset.getInt("board_region_comment_no"));
				bc.setBoard_region_comment_level(rset.getInt("board_region_comment_level"));
				bc.setBoard_region_comment_writer(rset.getString("board_region_comment_writer"));
				bc.setBoard_region_comment_content(rset.getString("board_region_comment_content"));
				bc.setBoard_region_ref(rset.getInt("board_region_ref"));
				bc.setBoard_region_comment_ref(rset.getInt("board_region_comment_ref"));
				bc.setBoard_region_comment_date(rset.getDate("board_region_comment_date"));
				regionbcList.add(bc);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return regionbcList;
	}


	public int updateRegionBoard(Connection conn, RegionBoard board) {
		int result = -1;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("updateRegionBoard");
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getBoard_region_title());
			pstmt.setString(2, board.getBoard_regioncode());
			pstmt.setString(3, board.getBoard_region_content());
			pstmt.setString(4, board.getOriginal_file_name());
			pstmt.setString(5, board.getRenamed_file_name());
			pstmt.setInt(6, board.getBoard_region_no());
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	public int deleteRegionBoard(Connection conn, int no) {
		int result = -1;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("deleteRegionBoard");
		
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


	public int deleteRegionBoardComment(Connection conn, int no, int del) {
		int result = -1;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("deleteRegionBoardComment");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			pstmt.setInt(2, del);
			result = pstmt.executeUpdate();	
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}


	public List<FreeBoard> selectFreeAll(Connection conn, int cPage, int numPerPage) {
		List<FreeBoard> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectFreeAll");
		//String query = "SELECT V.* FROM ( SELECT ROWNUM AS RNUM, V.* FROM( SELECT * FROM BOARD_REGION ORDER BY BOARD_REGION_DATE DESC) V ) V WHERE RNUM BETWEEN ? AND ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				FreeBoard board = new FreeBoard(); 
				board.setBoard_free_no(rset.getInt("board_free_no"));
				board.setBoard_free_title(rset.getString("board_free_title"));
				board.setBoard_free_writer(rset.getString("board_free_writer"));
				board.setBoard_free_date(rset.getDate("board_free_date"));
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


	public List<FreeBoard> selectSearchFreeTitle(Connection conn, int cPage, int numPerPage, String searchValue) {
		List<FreeBoard> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectSearchFreeTitle");
		//String query = "SELECT V.* FROM ( SELECT ROWNUM AS RNUM, V.* FROM( SELECT * FROM BOARD_REGION ORDER BY BOARD_REGION_DATE DESC) V ) V WHERE RNUM BETWEEN ? AND ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchValue+"%");
			pstmt.setInt(2, (cPage-1)*numPerPage+1);
			pstmt.setInt(3, cPage*numPerPage);
			
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				FreeBoard board = new FreeBoard(); 
				board.setBoard_free_no(rset.getInt("board_free_no"));
				board.setBoard_free_title(rset.getString("board_free_title"));
				board.setBoard_free_writer(rset.getString("board_free_writer"));
				board.setBoard_free_date(rset.getDate("board_free_date"));
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


	public List<FreeBoard> selectSearchFreeId(Connection conn, int cPage, int numPerPage, String searchValue) {
		List<FreeBoard> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectSearchFreeId");
		//String query = "SELECT V.* FROM ( SELECT ROWNUM AS RNUM, V.* FROM( SELECT * FROM BOARD_REGION ORDER BY BOARD_REGION_DATE DESC) V ) V WHERE RNUM BETWEEN ? AND ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, searchValue);
			pstmt.setInt(2, (cPage-1)*numPerPage+1);
			pstmt.setInt(3, cPage*numPerPage);
			
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				FreeBoard board = new FreeBoard(); 
				board.setBoard_free_no(rset.getInt("board_free_no"));
				board.setBoard_free_title(rset.getString("board_free_title"));
				board.setBoard_free_writer(rset.getString("board_free_writer"));
				board.setBoard_free_date(rset.getDate("board_free_date"));
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


	public int selectFreeBoardCount(Connection conn) {
		int count = -1;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectFreeBoardCount");
		try {
			pstmt = conn.prepareStatement(query);
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


	public int selectFreeBoardCountByTitle(Connection conn, String searchValue) {
		int count = -1;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectFreeBoardCountByTitle");
	
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchValue+"%");
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


	public int selectFreeBoardCountById(Connection conn, String searchValue) {
		int count = -1;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectFreeBoardCountById");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, searchValue);
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


	public int insertFreeBoard(Connection conn, FreeBoard board) {
		int result = -1;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertFreeBoard");
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getBoard_free_title());
			pstmt.setString(2, board.getBoard_free_writer());
			pstmt.setString(3, board.getBoard_free_content());
			pstmt.setString(4, board.getOriginal_file_name());
			pstmt.setString(5, board.getRenamed_file_name());
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	public int selectFreeBoardNo(Connection conn) {
		int result = -1;
		PreparedStatement pstmt= null;
		ResultSet rset = null;
		String query = prop.getProperty("selectRecentFreeBoardNo");
		
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


	public int increaseFreeCount(Connection conn, int no) {
		int result = -1;
		PreparedStatement pstmt= null;
		String query = prop.getProperty("increaseFreeCount");
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


	public FreeBoard selectFreeBoardOne(Connection conn, int no) {
		FreeBoard board = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectFreeBoardOne");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				board = new FreeBoard(); 
				board.setBoard_free_no(rset.getInt("board_free_no"));
				board.setBoard_free_title(rset.getString("board_free_title"));
				board.setBoard_free_writer(rset.getString("board_free_writer"));
				board.setBoard_free_date(rset.getDate("board_free_date"));
				board.setBoard_free_content(rset.getString("board_free_content"));
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


	public List<FreeBoardComment> selectFreeCommentAll(Connection conn, int no) {
		List<FreeBoardComment> freebcList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectFreeCommentAll");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				FreeBoardComment bc = new FreeBoardComment();
				bc.setBoard_free_comment_no(rset.getInt("board_free_comment_no"));
				bc.setBoard_free_comment_level(rset.getInt("board_free_comment_level"));
				bc.setBoard_free_comment_writer(rset.getString("board_free_comment_writer"));
				bc.setBoard_free_comment_content(rset.getString("board_free_comment_content"));
				bc.setBoard_free_ref(rset.getInt("board_free_ref"));
				bc.setBoard_free_comment_ref(rset.getInt("board_free_comment_ref"));
				bc.setBoard_free_comment_date(rset.getDate("board_free_comment_date"));
				freebcList.add(bc);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return freebcList;
	}


	public int updateFreeBoard(Connection conn, FreeBoard board) {
		int result = -1;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("updateFreeBoard");
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getBoard_free_title());
			pstmt.setString(2, board.getBoard_free_content());
			pstmt.setString(3, board.getOriginal_file_name());
			pstmt.setString(4, board.getRenamed_file_name());
			pstmt.setInt(5, board.getBoard_free_no());
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	public int deleteFreeBoard(Connection conn, int no) {
		int result = -1;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("deleteFreeBoard");
		
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


	public int insertFreeBoardComment(Connection conn, FreeBoardComment freeBoardComment) {
		int result = -1;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertFreeBoardComment");
		
		try {
			String boardFreeCommentRef = freeBoardComment.getBoard_free_comment_ref()==0?null:String.valueOf(freeBoardComment.getBoard_free_comment_ref());
			
			pstmt= conn.prepareStatement(query);
			pstmt.setInt(1, freeBoardComment.getBoard_free_comment_level());
			pstmt.setString(2, freeBoardComment.getBoard_free_comment_writer());
			pstmt.setString(3, freeBoardComment.getBoard_free_comment_content());
			pstmt.setInt(4, freeBoardComment.getBoard_free_ref());
			pstmt.setString(5, boardFreeCommentRef);
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}


	public int deleteFreeBoardComment(Connection conn, int no, int del) {
		int result = -1;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("deleteFreeBoardComment");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			pstmt.setInt(2, del);
			result = pstmt.executeUpdate();	
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}


	public List<Complain> selectComplainAll(Connection conn, int cPage, int numPerPage) {
		List<Complain> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectComplainAll");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Complain complainBoard = new Complain();
				complainBoard.setComplain_no(rset.getInt("complain_no"));
				complainBoard.setComplain_title(rset.getString("complain_title"));
				complainBoard.setComplain_writer(rset.getString("complain_writer"));
				complainBoard.setComplain_date(rset.getDate("complain_date"));
				complainBoard.setComplain_content(rset.getString("complain_content"));
				complainBoard.setC_userId(rset.getString("c_userid"));
				complainBoard.setC_teamname(rset.getString("c_teamname"));
				complainBoard.setComplain_type(rset.getString("complain_type"));
				complainBoard.setResult(rset.getString("result"));
				complainBoard.setResult_Date(rset.getDate("result_date"));
				list.add(complainBoard);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}


	public List<Complain> selectComplainTitle(Connection conn, int cPage, int numPerPage, String searchValue) {
		List<Complain> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectComplainTitle");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchValue+"%");
			pstmt.setInt(2, (cPage-1)*numPerPage+1);
			pstmt.setInt(3, cPage*numPerPage);
			
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Complain complainBoard = new Complain();
				complainBoard.setComplain_no(rset.getInt("complain_no"));
				complainBoard.setComplain_title(rset.getString("complain_title"));
				complainBoard.setComplain_writer(rset.getString("complain_writer"));
				complainBoard.setComplain_date(rset.getDate("complain_date"));
				complainBoard.setComplain_content(rset.getString("complain_content"));
				complainBoard.setC_userId(rset.getString("c_userid"));
				complainBoard.setC_teamname(rset.getString("c_teamname"));
				complainBoard.setComplain_type(rset.getString("complain_type"));
				complainBoard.setResult(rset.getString("result"));
				complainBoard.setResult_Date(rset.getDate("result_date"));
				list.add(complainBoard);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public List<Complain> selectComplainWriter(Connection conn, int cPage, int numPerPage, String searchValue) {
		List<Complain> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectComplainWriter");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, searchValue);
			pstmt.setInt(2, (cPage-1)*numPerPage+1);
			pstmt.setInt(3, cPage*numPerPage);
			
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Complain complainBoard = new Complain();
				complainBoard.setComplain_no(rset.getInt("complain_no"));
				complainBoard.setComplain_title(rset.getString("complain_title"));
				complainBoard.setComplain_writer(rset.getString("complain_writer"));
				complainBoard.setComplain_date(rset.getDate("complain_date"));
				complainBoard.setComplain_content(rset.getString("complain_content"));
				complainBoard.setC_userId(rset.getString("c_userid"));
				complainBoard.setC_teamname(rset.getString("c_teamname"));
				complainBoard.setComplain_type(rset.getString("complain_type"));
				complainBoard.setResult(rset.getString("result"));
				complainBoard.setResult_Date(rset.getDate("result_date"));
				list.add(complainBoard);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public List<Complain> selectComplainC_UserId(Connection conn, int cPage, int numPerPage, String searchValue) {
		List<Complain> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectComplainC_UserId");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, searchValue);
			pstmt.setInt(2, (cPage-1)*numPerPage+1);
			pstmt.setInt(3, cPage*numPerPage);
			
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Complain complainBoard = new Complain();
				complainBoard.setComplain_no(rset.getInt("complain_no"));
				complainBoard.setComplain_title(rset.getString("complain_title"));
				complainBoard.setComplain_writer(rset.getString("complain_writer"));
				complainBoard.setComplain_date(rset.getDate("complain_date"));
				complainBoard.setComplain_content(rset.getString("complain_content"));
				complainBoard.setC_userId(rset.getString("c_userid"));
				complainBoard.setC_teamname(rset.getString("c_teamname"));
				complainBoard.setComplain_type(rset.getString("complain_type"));
				complainBoard.setResult(rset.getString("result"));
				complainBoard.setResult_Date(rset.getDate("result_date"));
				list.add(complainBoard);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	public List<Complain> selectComplainC_TeamName(Connection conn, int cPage, int numPerPage, String searchValue) {
		List<Complain> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectComplainC_TeamName");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, searchValue);
			pstmt.setInt(2, (cPage-1)*numPerPage+1);
			pstmt.setInt(3, cPage*numPerPage);
			
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Complain complainBoard = new Complain();
				complainBoard.setComplain_no(rset.getInt("complain_no"));
				complainBoard.setComplain_title(rset.getString("complain_title"));
				complainBoard.setComplain_writer(rset.getString("complain_writer"));
				complainBoard.setComplain_date(rset.getDate("complain_date"));
				complainBoard.setComplain_content(rset.getString("complain_content"));
				complainBoard.setC_userId(rset.getString("c_userid"));
				complainBoard.setC_teamname(rset.getString("c_teamname"));
				complainBoard.setComplain_type(rset.getString("complain_type"));
				complainBoard.setResult(rset.getString("result"));
				complainBoard.setResult_Date(rset.getDate("result_date"));
				list.add(complainBoard);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}


	public int selectComplainAllCount(Connection conn) {
		int count = -1;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectComplainAllCount");
		try {
			pstmt = conn.prepareStatement(query);
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
	public int selectComplainTitleCount(Connection conn, String searchValue) {
		int count = -1;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectComplainTitleCount");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchValue+"%");
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
	public int selectComplainWriterCount(Connection conn, String searchValue) {
		int count = -1;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectComplainWriterCount");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, searchValue);
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
	public int selectComplainC_UserIdCount(Connection conn, String searchValue) {
		int count = -1;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectComplainC_UserIdCount");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, searchValue);
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
	public int selectComplainC_TeamNameCount(Connection conn, String searchValue) {
		int count = -1;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectComplainC_TeamNameCount");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, searchValue);
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


	public Complain selectComplainBoardOne(Connection conn, int no) {
		Complain complainBoard = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectComplainBoardOne");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,  no);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				complainBoard = new Complain();
				complainBoard.setComplain_no(rset.getInt("complain_no"));
				complainBoard.setComplain_title(rset.getString("complain_title"));
				complainBoard.setComplain_writer(rset.getString("complain_writer"));
				complainBoard.setComplain_date(rset.getDate("complain_date"));
				complainBoard.setComplain_content(rset.getString("complain_content"));
				complainBoard.setC_userId(rset.getString("c_userid"));
				complainBoard.setC_teamname(rset.getString("c_teamname"));
				complainBoard.setComplain_type(rset.getString("complain_type"));
				complainBoard.setResult(rset.getString("result"));
				complainBoard.setResult_Date(rset.getDate("result_date"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return complainBoard;
	}


	public int insertComplain(Connection conn, Complain complain) {
		int result = -1;
		PreparedStatement pstmt = null;
		String query = "";
		if("c_userid".equals(complain.getComplain_type())) 
			query = prop.getProperty("insertComplainU");
		else 
			query = prop.getProperty("insertComplainT");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, complain.getComplain_title());
			pstmt.setString(2, complain.getComplain_writer());
			pstmt.setString(3, complain.getComplain_content());
			if("c_userid".equals(complain.getComplain_type())) 
				pstmt.setString(4, complain.getC_userId());
			else
				pstmt.setString(4,  complain.getC_teamname());
			pstmt.setString(5, complain.getComplain_type());
		
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}


	public int selectRecentComplainNo(Connection conn) {
		int count = -1;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectRecentComplainNo");
		try {
			pstmt = conn.prepareStatement(query);
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

	
	
}
