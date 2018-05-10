package com.dleague.board.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

import com.dleague.board.model.dao.BoardDAO;
import com.dleague.board.model.vo.RegionBoard;
import com.dleague.board.model.vo.RegionBoardComment;

import static com.dleague.common.JDBCTemplate.*;

public class BoardService {

	public List<RegionBoard> selectAll(int cPage, int numPerPage, String regionCode, String searchType, String searchValue) {;
		Connection conn = getConnection();
		List<RegionBoard> list= null;
		if(searchValue==null) {
			list = new BoardDAO().selectAll(conn, cPage, numPerPage, regionCode);
		}else {
			if(searchType.equals("title"))
				list = new BoardDAO().selectSearchTitle(conn, cPage, numPerPage, regionCode, searchValue);
			else
				list= new BoardDAO().selectSearchId(conn, cPage, numPerPage, regionCode, searchValue);
		}
		close(conn);
		return list;
	}
	public int selectRegionBoardCount(String regionCode, String searchType, String searchValue) {
		Connection conn = getConnection();
		int count = -1;
		if(searchValue==null) {
			count = new BoardDAO().selectRegionBoardCount(conn, regionCode);
		}else {
			if(searchType.equals("title"))
				count = new BoardDAO().selectRegionBoardCountByTitle(conn, regionCode, searchValue);
			else
				count = new BoardDAO().selectRegionBoardCountById(conn, regionCode, searchValue);
		}
		close(conn);
		return count;
	}
	public RegionBoard selectRegionBoardOne(int no) {
		Connection conn = getConnection();
		RegionBoard board = new BoardDAO().selectRegionBoardOne(conn, no);
		close(conn);
		return board;
	}
	public int insertRegionBoard(RegionBoard board) {
		Connection conn = getConnection();
		int result = new BoardDAO().insertRegionBoard(conn, board);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	public int selectRecentRegionBoardNo() {
		Connection conn = getConnection();
		int result = new BoardDAO().selectRegionBoardNo(conn);
		close(conn);
		return result;
	}
	public int increaseRegionCount(int no) {
		Connection conn= getConnection();
		int result = new BoardDAO().increaseRegionCount(conn, no);
		close(conn);
		return result;
		
	}
	public int insertRegionBoardComment(RegionBoardComment regionBoardComment) {
		Connection conn = getConnection();
		int result = new BoardDAO().insertRegionBoardComment(conn, regionBoardComment);
		close(conn);
		return result;
	}

}
