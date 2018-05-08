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
	
	
	public int selectRegionBoardCount(Connection conn) {
		int count = -1;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		//String query = prop.getProperty("selectAll");
		String query = "SELECT COUNT(*) AS cnt FROM BOARD_REGION";
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
	
	public List<RegionBoard> selectAll(Connection conn, int cPage, int numPerPage) {
		List<RegionBoard> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		//String query = prop.getProperty("selectAll");
		String query = "SELECT V.* FROM ( SELECT ROWNUM AS RNUM, V.* FROM( SELECT * FROM BOARD_REGION ORDER BY BOARD_REGION_DATE DESC) V ) V WHERE RNUM BETWEEN ? AND ?";
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
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


	
}
